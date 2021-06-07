package com.oa.service;

import com.oa.dao.EmployeeDao;
import com.oa.entity.Employee;
import com.oa.utils.MybatisUtils;

public class EmployeeService {
    public Employee selectById(Long employeeId){
        Employee employee = (Employee) MybatisUtils.executeQuery(sqlSession -> {
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            return employeeDao.selectById(employeeId);
        });
        return employee;
    }
}
