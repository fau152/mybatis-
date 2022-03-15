package com.colin.dao;

import com.colin.pojo.User;
import com.colin.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao {
    public void insertUser(User user) {
        //1. 获取SqlSession实例
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtil.getSqlSession();
            //2. 使用sqlsession调用insert方法
            sqlSession.insert("insertUser", user);
            //3. 手动提交
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭资源
            DBUtil.closeResource(sqlSession);
        }
    }

    public void insertUserMap(Integer id,String username,String password){
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("id", id);
        userMap.put("name", username);
        userMap.put("password", password);
        //1. 获取SqlSession实例
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtil.getSqlSession();
            //2. 使用sqlsession调用insert方法
            sqlSession.insert("insertUserMap", userMap);
            //3. 手动提交
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭资源
            DBUtil.closeResource(sqlSession);
        }
    }

    public void deleteUser(Integer id) {
        //1. 获取SqlSession实例
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtil.getSqlSession();
            //2. 使用sqlsession调用delete方法
            sqlSession.delete("deleteUserById", id);
            //3. 手动提交
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭资源
            DBUtil.closeResource(sqlSession);
        }
    }

    public void updateUser(User user) {
        //1. 获取SqlSession实例
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtil.getSqlSession();
            //2. 使用sqlsession调用update方法
            sqlSession.update("updateUser", user);
            //3. 手动提交
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭资源
            DBUtil.closeResource(sqlSession);
        }
    }

    public void selectUserById(Integer id) {
        //1. 获取SqlSession实例
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtil.getSqlSession();
            //2. 使用sqlsession调用selectOne方法
            User user = (User)sqlSession.selectOne("selectUserById", id);
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3. 关闭资源
            DBUtil.closeResource(sqlSession);
        }
    }

    public void selectUserList() {
        //1. 获取SqlSession实例
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtil.getSqlSession();
            //2. 使用sqlsession调用selectList方法
            List<User> list = sqlSession.selectList("selectUserList");
            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3. 关闭资源
            DBUtil.closeResource(sqlSession);
        }
    }
}
