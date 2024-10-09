package com.nya.mitzi.exception;

import com.nya.mitzi.enum1.ErrorMessage;

public class CouponException extends Exception {
    public CouponException(ErrorMessage errorMessage){
        super(errorMessage.getMessage());
    }
}
