package com.oa.controller;

import com.alibaba.fastjson.JSON;
import com.oa.entity.User;
import com.oa.service.UserService;
import com.oa.service.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet", urlPatterns= "/check_login")
public class LoginServlet extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(LoginServlet.class);
    private UserService userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Map<String, Object> result = new HashMap<>();
        try {
            User user = userService.checkLogin(username, password);
            //成功以后用了ajax传json,window.location是一个新的request, 故要把user存在session里面
            HttpSession session = request.getSession();
            session.setAttribute("login_user", user);
            result.put("code", 0);
            result.put("message", "success");
            result.put("redirect_url","/index");
        }catch(BusinessException e){
            logger.error(e.getMessage(), e);
            result.put("code", e.getCode());
            result.put("message", e.getMessage());
            result.put("redirect_url","");
        }catch(Exception e){
            logger.error(e.getMessage(), e);
            result.put("code", e.getClass().getSimpleName());
            result.put("message", e.getMessage());
            result.put("redirect_url","");
        }
        String json =  JSON.toJSONString(result);
        response.getWriter().println(json);
    }
}
