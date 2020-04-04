package com.imooc.mall.enums;

import lombok.Getter;

@Getter
public enum ResponseEnum {
    SUCCESS(0,"SUCCESS"),
    PASSWORD_ERROR(1,"PASSWORD_ERROR"),
    USER_EXIST(2,"USER_EXIST"),
    NEED_LOGIN(10,"NEED_LOGIN"),
    PARAM_ERROR(3,"PARAM_ERROR"),
    EMAIL_EXIST(4,"EMAIL_EXIST"),
    ERROR(-1,"SERVER_ERROR"),
    USERNAME_ERROR_OR_PASSWORD_ERROR(11,"USERNAME_ERROR_OR_PASSWORD_ERROR"),
    ;

    ResponseEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    Integer code;
    String desc;

}
