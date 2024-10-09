package com.nya.mitzi.exception;
import com.nya.mitzi.enum1.ErrorMessage;

public class CompanyException extends Exception {
    public CompanyException(ErrorMessage errorMessage){
        super(errorMessage.getMessage());
    }
}
