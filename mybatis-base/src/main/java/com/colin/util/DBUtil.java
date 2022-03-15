package com.colin.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public class DBUtil {
    public static SqlSession getSqlSession() throws IOException {
        //1. 读取主配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        //2. 获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3. openSession获取SqlSession
        //openSession不给参数默认是false，表示需要手动提交
        return sqlSessionFactory.openSession();
    }

    public static void closeResource(Closeable... closeables){
        for (Closeable closeable : closeables) {
            if (null != closeable) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
