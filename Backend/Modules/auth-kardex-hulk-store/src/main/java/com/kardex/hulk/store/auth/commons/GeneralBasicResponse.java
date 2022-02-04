package com.kardex.hulk.store.auth.commons;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Data
@Component
public class GeneralBasicResponse {

    private int code;
    private String message;
    private int httpStatus;
    private Object data;

    public ResponseEntity<Object> buildResponseEntity(Integer code, String message, int httpStatusCode,HttpStatus httpStatus, @Nullable Object data ) {
        GeneralBasicResponse response = new GeneralBasicResponse();
        response.setCode(code);
        response.setMessage(message);
        response.setHttpStatus(httpStatusCode);
        response.setData(data);
        return new ResponseEntity<Object>(response,httpStatus);
    }


}
