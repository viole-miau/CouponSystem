package com.nya.mitzi.exception;

import com.nya.mitzi.enum1.ErrorMessage;

public class CategoryException extends Exception {

    public CategoryException(ErrorMessage errorMessage){
        super(errorMessage.getMessage());
    }
}
