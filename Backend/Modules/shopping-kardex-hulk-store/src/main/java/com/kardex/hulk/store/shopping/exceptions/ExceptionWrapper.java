package com.kardex.hulk.store.shopping.exceptions;

import com.kardex.hulk.store.shopping.commons.GeneralBasicResponse;
import com.kardex.hulk.store.shopping.commons.StatusMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExceptionWrapper extends ResponseEntityExceptionHandler {

    @Autowired
    private GeneralBasicResponse generalBasicResponse;


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request){
        log.error(String.format("Se ha presentado el siguiente error: {} con la siguiente traza: {}",ex.getMessage(),ex.getStackTrace().toString()));
        return generalBasicResponse.buildResponseEntity(HttpStatus.BAD_REQUEST.value(),ex.getBindingResult().getAllErrors().get(0).getDefaultMessage(),HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, null);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request){
        log.error(String.format("Se ha presentado el siguiente error: {} con la siguiente traza: {}",ex.getMessage(),ex.getStackTrace().toString()));
        return generalBasicResponse.buildResponseEntity(HttpStatus.BAD_REQUEST.value(), StatusMessages.HTTP_BAD_REQUEST_JSON_STRUCTURE.getDescriptionCode(),HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST, null);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex){
        log.error(String.format("Se ha presentado el siguiente error: {} con la siguiente traza: {}",ex.getMessage(),ex.getStackTrace().toString()));
        return generalBasicResponse.buildResponseEntity(HttpStatus.BAD_REQUEST.value(),StatusMessages.HTTP_BAD_REQUEST.getDescriptionCode(),HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST, null);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    protected ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex) {
        log.error(String.format("Se ha presentado el siguiente error: {} con la siguiente traza: {}",ex.getMessage(),ex.getStackTrace().toString()));
        return generalBasicResponse.buildResponseEntity(HttpStatus.BAD_REQUEST.value(),StatusMessages.HTTP_BAD_REQUEST_EMPTY_DATASET.getDescriptionCode(),HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, null);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex){
        log.error(String.format("Se ha presentado el siguiente error: {} con la siguiente traza: {}",ex.getMessage(),ex.getStackTrace().toString()));
        return generalBasicResponse.buildResponseEntity(HttpStatus.BAD_REQUEST.value(),StatusMessages.HTTP_BAD_REQUEST_DATA_INTEGRITY_VIOLATION.getDescriptionCode(),HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, null);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex){
        log.error(String.format("Se ha presentado el siguiente error: {} con la siguiente traza: {}",ex.getMessage(),ex.getStackTrace().toString()));
        return generalBasicResponse.buildResponseEntity(HttpStatus.BAD_REQUEST.value(),StatusMessages.HTTP_BAD_REQUEST.getDescriptionCode(),HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, null);
    }

    @ExceptionHandler(WebExchangeBindException.class)
    protected ResponseEntity<Object> handleWebExchangeBindException(ConstraintViolationException ex){
        log.error(String.format("Se ha presentado el siguiente error: {} con la siguiente traza: {}",ex.getMessage(),ex.getStackTrace().toString()));
        return generalBasicResponse.buildResponseEntity(HttpStatus.BAD_REQUEST.value(),String.format("Valor invalido en el campo: {}",ex.getMessage()),HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,null);
    }

}