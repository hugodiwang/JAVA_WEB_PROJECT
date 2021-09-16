package com.imooc.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>创建商户响应对象</h1>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantsResponse {

    /** 商户 id: 创建失败则为 -1
     * 没有返回给上回 errorcode 是为了不暴露给商户 出现错误， 这里用的是log
     * 也可以返回 errorcode 然后前端处理
     * */
    private Integer id;
}
