package com.imooc.passbook.security;

import com.imooc.passbook.constant.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <h1>权限拦截器</h1>
 */
@Component
public class AuthCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) throws Exception {

        String token = httpServletRequest.getHeader(Constants.TOKEN_STRING);

        if (StringUtils.isEmpty(token)) {
            throw new Exception("Header miss " + Constants.TOKEN_STRING + "!");
        }

        if (!token.equals(Constants.TOKEN)) {
            throw new Exception("Header's " + Constants.TOKEN_STRING + "mistake!");
        }

        AccessContext.setToken(token);

        return true;
    }
    /***
     * 处理http请求之前执行, http中没有含有token信息， 如只有token key对应的字符串不对，则认为是非法请求。这里所有的都用了同一个token value。
     * AccessContext 是一个静态单例类， 而且继承了ThreadLocal 用于存储数据， 其它的线程不能共享到其数据
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }
    /***
     * 抛出异常不执行
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        AccessContext.clearAccessKey();
    }
    /***
     * 即使抛出异常也执行
     */
}
