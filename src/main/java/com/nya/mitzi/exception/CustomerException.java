package com.nya.mitzi.exception;

import com.nya.mitzi.enum1.ErrorMessage;

public class CustomerException extends Exception {
    public CustomerException(ErrorMessage errorMessage){
        super(errorMessage.getMessage());
    }
}
