package com.testproject.swp.exception.custom;

import com.testproject.swp.model.customer.CustomError;

public class CustomNotFoundEx extends BaseEx {

    public CustomNotFoundEx(CustomError customError) {
        super(customError);
    }
}
