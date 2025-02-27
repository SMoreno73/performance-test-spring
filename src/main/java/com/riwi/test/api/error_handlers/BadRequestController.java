package com.riwi.test.api.error_handlers;


import com.riwi.test.util.exeptions.IdNotFoundException;
import com.riwi.test.util.exeptions.OptionsAreNull;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.riwi.test.api.dto.errors.BaseErrorResponse;
import com.riwi.test.api.dto.errors.ErrorResponse;
import com.riwi.test.api.dto.errors.ErrorsResponse;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestController {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public BaseErrorResponse handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        return ErrorResponse.builder()
                .message("There is a unique field that cannot be repeated [Survey: title].")
                .status(HttpStatus.BAD_REQUEST.name())
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public BaseErrorResponse handleJsonParseException(HttpMessageNotReadableException ex) {
        return ErrorResponse.builder()
                .message("Check your Json format. " + ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.name())
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public BaseErrorResponse handleIllegalArgumentException(IllegalArgumentException ex) {
        return ErrorResponse.builder()
                .message("Invalid value for enum: " + ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.name())
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
    }

    @ExceptionHandler(OptionsAreNull.class)
    public BaseErrorResponse handleIdNotFound(OptionsAreNull exception) {

        return ErrorResponse.builder()
                .message(exception.getMessage())
                .status(HttpStatus.BAD_REQUEST.name())
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseErrorResponse handleErrors(MethodArgumentNotValidException exception) {
        List<String> errors = new ArrayList<>();

        exception.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));

        return ErrorsResponse.builder()
                .errors(errors)
                .status(HttpStatus.BAD_REQUEST.name())
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
    }
}
