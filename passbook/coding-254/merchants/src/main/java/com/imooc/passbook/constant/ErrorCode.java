package com.imooc.passbook.constant;

/**
 * <h2>错误码枚举定义</h2>
 */
public enum ErrorCode {

    SUCCESS(0, ""),
    DUPLICATE_NAME(1, "merchant name exists"),
    EMPTY_LOGO(2, "merchant's logo is null"),
    EMPTY_BUSINESS_LICENSE(3, "merchant's license is null"),
    ERROR_PHONE(4, "merchant's phone is invalid"),
    EMPTY_ADDRESS(5, "merchant's address is null"),
    MERCHANTS_NOT_EXIST(6, "merchant does not exist");

    /** 错误码 */
    private Integer code;

    /** 错误描述 */
    private String desc;

    ErrorCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
