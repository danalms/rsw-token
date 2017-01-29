package com.rsw.token.exception;

import com.rsw.token.domain.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by DAlms on 12/18/16.
 */
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

    @Autowired
    public RestExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(value = {HttpStatusCodeException.class })
    protected ResponseEntity<Object> handleNotFound(HttpStatusCodeException ex, WebRequest request) {
        ErrorResponse response = new ErrorResponse(ex.getStatusCode().getReasonPhrase(), "Response from Auth Service");
        return handleExceptionInternal(ex, response, new HttpHeaders(), ex.getStatusCode(), request);
    }
}
