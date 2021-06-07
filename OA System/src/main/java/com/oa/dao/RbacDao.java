package com.oa.dao;

import com.oa.entity.Node;
import com.oa.utils.MybatisUtils;

import java.util.List;

public class RbacDao {
    public List<Node> selectNodeByUserId(Long userId){
        List<Node> list =  (List<Node>) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectList("rbacmapper.selectNodeByUserId",userId));
        return list;
    }

}
