package com.oa.dao;

import com.oa.entity.Employee;
import org.apache.ibatis.annotations.Param;
// namespace与包名一致 id与方法名一致 入出类型一致
// 自动生成 实现类

public interface EmployeeDao {
    public Employee selectById(Long employeeId);
    public Employee selectLeader(@Param("emp")Employee employee);
}
