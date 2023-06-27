package com.testproject.swp.exception.custom;

import com.testproject.swp.model.mapper.CustomError;

public class CustomNotFoundEx extends BaseEx {

    public CustomNotFoundEx(CustomError customError) {
        super(customError);
    }
}
