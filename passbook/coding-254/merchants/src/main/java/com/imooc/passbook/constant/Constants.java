package com.imooc.passbook.constant;

/**
 * <h1>普通(通用)常量定义</h1>
 */
public class Constants {

    /** 商户优惠券投放的 Kafka Topic */
    public static final String TEMPLATE_TOPIC = "merchants-template";

    /** token string header 中的key*/
    public static final String TOKEN_STRING = "token";

    /** token info header 中的value 每个商家不一样 用来做校验*/
    public static final String TOKEN = "imooc-passbook-merchants";
}
