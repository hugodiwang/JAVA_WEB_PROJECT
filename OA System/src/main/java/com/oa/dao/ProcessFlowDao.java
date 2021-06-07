package com.oa.dao;

import com.oa.entity.LeaveForm;
import com.oa.entity.ProcessFlow;

import java.util.List;

public interface ProcessFlowDao {
    public void insert(ProcessFlow processFlow);
    public List<ProcessFlow> selectByFormId(Long formId);
    public void update(ProcessFlow processFlow);
}
