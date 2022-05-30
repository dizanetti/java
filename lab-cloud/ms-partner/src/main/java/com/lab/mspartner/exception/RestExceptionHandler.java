package com.lab.mspartner.exception;

import com.lab.mspartner.model.ErroResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String ERROR_LABEL = "Error: ";

    @ExceptionHandler(PartnerNotFoundException.class)
    public ResponseEntity<Void> partnerNotFound(Exception ex) {
        log.warn("Partner not found: ", ex);

        HttpHeaders headers = new HttpHeaders();
        headers.add("reason", ex.getMessage());
        return new ResponseEntity<>(null, headers, NO_CONTENT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResponse> internalServerError(Exception ex) {
        log.error(ERROR_LABEL, ex);

        ErroResponse error = new ErroResponse();
        error.setTimestamp(LocalDateTime.now());
        error.setErro(ex.getMessage());
        error.setStatus(INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<>(error, INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PartnerException.class)
    public ResponseEntity<ErroResponse> partnerServiceError(Exception ex) {
        log.error(ERROR_LABEL, ex);

        ErroResponse error = new ErroResponse();
        error.setTimestamp(LocalDateTime.now());
        error.setErro(ex.getMessage());
        error.setStatus(INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<>(error, INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        log.error(ERROR_LABEL, ex);

        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }

        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }

        return handleExceptionInternal(ex, errors, headers, BAD_REQUEST, request);
    }
}
