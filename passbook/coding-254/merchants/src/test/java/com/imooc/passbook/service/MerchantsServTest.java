package com.imooc.passbook.service;

import com.alibaba.fastjson.JSON;
import com.imooc.passbook.vo.CreateMerchantsRequest;
import com.imooc.passbook.vo.PassTemplate;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <h1>商户服务测试类</h1>
 *
 *@SpringBootTest
 *配置名称	说明
 *value	指定配置属性
 *properties	指定配置属性，和value意义相同
 *classes	指定配置类，等同于@ContextConfiguration中的class，若没有显示指定，将查找嵌套的@Configuration类，然后返回到SpringBootConfiguration搜索配置
 *webEnvironment	指定web环境，可选值有：MOCK、RANDOM_PORT、DEFINED_PORT、NONE
 *
 * MOCK	此值为默认值，该类型提供一个mock环境，此时内嵌的服务（servlet容器）并没有真正启动，也不会监听web端口。
 * RANDOM_PORT	启动一个真实的web服务，监听一个随机端口。
 * DEFINED_PORT	启动一个真实的web服务，监听一个定义好的端口（从配置中读取）。
 * NONE	启动一个非web的ApplicationContext，既不提供mock环境，也不提供真是的web服务。
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MerchantsServTest {

    @Autowired
    private IMerchantsServ merchantsServ;

    /**
     * {"data":{"id":7},"errorCode":0,"errorMsg":""}
     * {"data":{"id":8},"errorCode":0,"errorMsg":""}
     * */
    @Test
//    @Transactional // 在test下加这个注解， 默认执行test后 回滚不添加数据
    public void testCreateMerchantServ() {

        CreateMerchantsRequest request = new CreateMerchantsRequest();
        request.setName("慕课");
        request.setLogoUrl("www.imooc.com");
        request.setBusinessLicenseUrl("www.imooc.com");
        request.setPhone("1234567890");
        request.setAddress("北京市");

        System.out.println(JSON.toJSONString(merchantsServ.createMerchants(request)));
    }

    /**
     * {"data":{"address":"北京市",
     * "businessLicenseUrl":"www.imooc.com","id":9,"isAudit":false,
     * "logoUrl":"www.imooc.com",
     * "name":"慕课","phone":"1234567890"},"errorCode":0,"errorMsg":""}
     * */
    @Test
    public void testBuildMerchantsInfoById() {

        System.out.println(JSON.toJSONString(merchantsServ.buildMerchantsInfoById(9)));
    }

    /**
     * DropPassTemplates: {"background":2,"desc":"详情: 慕课",
     * "end":1528202373202,"hasToken":false,"id":9,"limit":10000,
     * "start":1527338373202,"summary":"简介: 慕课","title":"title: 慕课"}
     * */
    @Test
    public void testDropPassTemplate() {

        PassTemplate passTemplate = new PassTemplate();
        passTemplate.setId(9);
        passTemplate.setTitle("慕课-1");
        passTemplate.setSummary("简介: 慕课");
        passTemplate.setDesc("详情: 慕课");
        passTemplate.setLimit(10000L);
        passTemplate.setHasToken(false);
        passTemplate.setBackground(2);
        passTemplate.setStart(DateUtils.addDays(new Date(), -10));
        passTemplate.setEnd(DateUtils.addDays(new Date(), 10));

        System.out.println(JSON.toJSONString(
                merchantsServ.dropPassTemplate(passTemplate)
        ));
    }
}
