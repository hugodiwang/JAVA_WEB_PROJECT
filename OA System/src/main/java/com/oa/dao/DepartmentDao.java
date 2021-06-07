package com.oa.dao;

import com.oa.entity.Department;

public interface DepartmentDao {
    public Department selectById(Long departmentId);
}
