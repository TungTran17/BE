package com.testproject.swp.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.testproject.swp.exception.custom.CustomBadReqEx;
import com.testproject.swp.exception.custom.CustomNotFoundEx;
import com.testproject.swp.model.customer.CustomError;

@RestControllerAdvice
public class ExHandler {

    @ExceptionHandler(CustomNotFoundEx.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Map<String, CustomError> notFoundEx(CustomNotFoundEx ex) {
        return ex.getError();
    }

    @ExceptionHandler(CustomBadReqEx.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Map<String, CustomError> badReqEx(CustomBadReqEx ex) {
        return ex.getError();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, CustomError> commonException(Exception ex) {
        Map<String, CustomError> map = new HashMap<>();
        map.put("error", CustomError.builder().code("500").message("Something went wrong").build());
        return map;
    }
}
