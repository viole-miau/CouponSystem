package com.nya.mitzi.enum1;

import lombok.Getter;

@Getter
public enum ErrorMessage {
    ID_ALREADY_FOUND("id already exist"),
    ID_NOT_EXIST("id not exist"),
    CATEGORY_NAME_EXIST("category name exist"),
    COMPANY_NAME_EXIST("company name exist"),
    COUPON_ALREADY_EXIST("coupon already exist"),
    EMAIL_EXIST("email exist"),
    NAME_NOT_EXIST("name not exist"),
    MISSING_DETAILS("missing details"),
    COMPANY_NOT_EXIST("company not exist"),
    MISSING_COMPANY("missing company"),
    COUPON_PURCHASED_BY_CUSTOMER("coupon purchased by customer"),
    NAME_EXIST("name exists"),
    COUPON_NOT_EXIST("coupon not exist"),
    NO_COUPONS_LEFT("no coupons left"),
    COMPANY_NOT_UNIQUE("company not unique"),
    CUSTOMER_NOT_EXIST("customer not exist"),
    CUSTOMER_NOT_UNIQUE("customer not unique"),
    NAME_MISSING("name missing"), SOMETHING_IS_WRONG("something is wrong");

    private String message;

    ErrorMessage(String message){
        this.message=message;
    }


}
