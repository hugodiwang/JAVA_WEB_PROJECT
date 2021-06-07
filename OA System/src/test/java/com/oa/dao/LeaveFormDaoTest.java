package com.oa.dao;

import com.oa.entity.LeaveForm;
import com.oa.service.LeaveFormService;
import com.oa.utils.MybatisUtils;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import junit.framework.TestCase;
import org.junit.Test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class LeaveFormDaoTest {
    @Test
    public void insertTest(){
        MybatisUtils.executeUpdate(sqlSession -> {
            LeaveFormDao leaveFormDao = sqlSession.getMapper(LeaveFormDao.class);
            LeaveForm leaveForm = new LeaveForm();
            leaveForm.setEmployeeId(2l);
            leaveForm.setFormType(1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date startTime = null;
            Date endTime = null;
            try{
                startTime = sdf.parse("2020-03-24 08:00:00");
                endTime = sdf.parse("2020-03-25 08:00:00");
            }catch(ParseException e){
                e.printStackTrace();
            }
            leaveForm.setReason("marraige");
            leaveForm.setStartTime(startTime);
            leaveForm.setEndTime(endTime);
            leaveForm.setCreateTime(new Date());
            leaveForm.setState("processing");
            leaveFormDao.insert(leaveForm);
            return null;
        });
    }

    @Test
    public void testSelectByParams() {
//        MybatisUtils.executeQuery(sqlSession -> {
//            LeaveFormDao dao = sqlSession.getMapper(LeaveFormDao.class);
//            List<Map> list = dao.selectByParams("process", 7l);
//            System.out.println(list);
//            return list;
//        });
        LeaveFormService leaveFormService = new LeaveFormService();
        List<Map> formList = leaveFormService.getLeaveFormList("process", 7l);
        System.out.println(formList);
    }
}