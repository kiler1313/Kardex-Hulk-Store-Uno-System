package com.kardex.hulk.store.auth.commons;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Slf4j
public class UtilHelper {

    private static final ObjectMapper jsonMapper = new ObjectMapper();

    private UtilHelper() {
        super();
    }

    /**
     * Impresión de inicio de log
     * @param operation
     * @param request
     */
    public static void printStartLog(@NotNull String operation, @NotNull String request) {
        log.info("");
        log.info("{} - Start", operation);
        log.info("{} - Request: {}", operation, request);
    }

    /**
     * Impresión de final de log
     * @param operation
     * @param time
     */
    public static void printEndLog(@NotNull String operation, long time) {
        log.info("{} - Tiempo de ejecución: {} milisegundos", operation, time);
        log.info("{} - End", operation);
        log.info("");
    }

    /**
     * Impresión del Log (Inicio)
     * @param correlationId
     * @param operation
     * @param time
     * @param request
     * @param activeTime
     */
    public static void logInitMethod(String correlationId, String operation, StopWatch time, Object request, boolean activeTime) {
        log.info(Constants.LOG_LINE);
        if (activeTime || time.isStopped()) {
            time.start();
        }
        try {
            UtilHelper.printStartLog(operation, UtilHelper.securityLog(request));
        } catch (JsonProcessingException var7) {
            log.error("Error imprimiendo el request");
        }

    }

    /**
     * Imprensión del Log (Final)
     * @param correlationId
     * @param operation
     * @param time
     * @param response
     * @param stopTime
     */
    public static void logEndMethod(String correlationId, String operation, StopWatch time, Object response, boolean stopTime) {
        if (stopTime) {
            time.stop();
        }
        long tiempo = time.getTime(TimeUnit.MILLISECONDS);
        try {
            log.info("{} Response content: {}", operation, UtilHelper.securityLog(response));
            UtilHelper.printEndLog(operation, tiempo);
            log.info(Constants.LOG_LINE);
        } catch (JsonProcessingException var9) {
            log.error("Error imprimiendo el response");
        }

    }

    /**
     * Impresión de log de Error
     * @param correlationId
     * @param operation
     * @param time
     * @param response
     */
    public static void logEndMethodError(String correlationId, String operation, StopWatch time, Object response) {
        try {
            time.stop();
            long tiempo = time.getTime(TimeUnit.MILLISECONDS);
            log.error("{} Response content: {}", operation, UtilHelper.securityLog(response));
            UtilHelper.printEndLog(operation, tiempo);
            log.error(Constants.LOG_LINE);
        } catch (Exception var7) {
            log.error("Error imprimiendo el error response");
        }

    }

    /**
     * Modificación de campos seguros para no mostrar en el log
     * @param data
     * @return
     * @throws JsonProcessingException
     */
    private static String securityLog(Object data) throws JsonProcessingException {
        return UtilHelper.printIgnore(UtilHelper.jsonMapper.writeValueAsString(data), new String[]{"password", "pass", "Password", "Authorization", "otp", "pin", "token", "Token"});
    }

    /**
     * Utilitario para ignorar campos importantes en el log
     * @param jsonString
     * @param tags
     * @return
     */
    public static String printIgnore(@NotNull String jsonString, String... tags) {
        if (StringUtils.isEmpty(jsonString)) return jsonString;

        jsonString = jsonString.replaceAll("(\r\n|\n|\r|\t)", "");

        if (tags == null) return jsonString;

        for (String s : tags) {
            jsonString = jsonString.replaceAll(("\"").concat(s).concat("(\\\\)?\"[:]([^,|^}]*)"), ("\"").concat(s).concat("\":\"****\""));
        }

        return jsonString;
    }

    /**
     * Utilitario para crear la respuesta de los productos consultados
     * @param object
     * @return
     */
    public static ResponseEntity<Object> utilCreateResponseQueryProducts(Object object)
    {
        ResponseEntity<Object> response = null;
        if (!Objects.isNull(object))
        {
            response = new GeneralBasicResponse().buildResponseEntity(StatusMessages.HTTP_SEND_OK.getStatusCode(),
                    StatusMessages.HTTP_SEND_OK.getDescriptionCode(),
                    StatusMessages.HTTP_SEND_OK.getHttpStatusCode().value(), HttpStatus.OK, object);
        }
        else
        {
            response = new GeneralBasicResponse().buildResponseEntity(StatusMessages.HTTP_STATUS_NOT_FOUND.getStatusCode(),
                    StatusMessages.HTTP_STATUS_NOT_FOUND.getDescriptionCode(),
                    StatusMessages.HTTP_STATUS_NOT_FOUND.getHttpStatusCode().value(), HttpStatus.BAD_REQUEST, null);
        }
        return response;
    }
}
