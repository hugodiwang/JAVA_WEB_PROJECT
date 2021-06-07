package com.oa.controller;

import com.oa.entity.Department;
import com.oa.entity.Employee;
import com.oa.entity.Node;
import com.oa.entity.User;
import com.oa.service.DepartmentService;
import com.oa.service.EmployeeService;
import com.oa.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet", urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    private UserService userService = new UserService();
    private EmployeeService employeeService = new EmployeeService();
    private DepartmentService departmentService = new DepartmentService();
    /**
     * find the node of the current user
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("login_user");
        Employee employee = employeeService.selectById(user.getUserId());
        Department department = departmentService.selectById(employee.getDepartmentId());
        List<Node> list = (List<Node>) userService.selectNodeByUserId(user.getUserId());
        request.setAttribute("node_list", list);
        session.setAttribute("current_employee", employee);
        session.setAttribute("current_department", department);
        request.getRequestDispatcher("/index.ftl").forward(request, response);

    }

}
