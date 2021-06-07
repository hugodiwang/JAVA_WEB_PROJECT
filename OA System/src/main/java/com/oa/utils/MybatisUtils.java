package com.oa.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.function.Function;

public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        } catch (IOException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * run sql statement and get return
     * @param func sql statement
     * @return select results
     */
    //lambda implements Function interface, Function<T,R> 一个输入一个输出
    public static Object executeQuery(Function<SqlSession, Object> func) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            Object obj = func.apply(sqlSession);
            return obj;
        }
    }
    //false means commit by hand
    public static Object executeUpdate(Function<SqlSession, Object> func){
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        try {
            Object obj = func.apply(sqlSession);
            sqlSession.commit();
            return obj;
        } catch (RuntimeException e){
          sqlSession.rollback();
          throw e;
        } finally {
            sqlSession.close();
        }
    }

//    public static SqlSession openSession() {
//        // false close auto commit
//        return sqlSessionFactory.openSession(false);
//    }
//
//    public static void closeSession(SqlSession session) {
//        if (session != null)
//            session.close();
//    }
}
