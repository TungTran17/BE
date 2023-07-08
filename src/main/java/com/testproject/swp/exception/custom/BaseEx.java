package com.testproject.swp.exception.custom;

import java.util.HashMap;
import java.util.Map;

import com.testproject.swp.model.customer.CustomError;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseEx extends Exception {
    Map<String, CustomError> error;

    public BaseEx(CustomError customError) {
        this.error = new HashMap<String, CustomError>();
        this.error.put("error", customError);
    }
}
