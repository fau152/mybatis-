package com.colin.dao;

import com.colin.pojo.User;
import junit.framework.TestCase;

public class UserDaoTest extends TestCase {
    UserDao userDao = new UserDao();

    public void testInsertUser() {
        userDao.insertUser(new User(9,"ddd","abc123"));
    }

    public void testInsertUserMap(){
        userDao.insertUserMap(6,"aaa","aaa");
    }

    public void testDeleteUserById() {
        userDao.deleteUser(6);
    }

    public void testUpdateUser(){
        userDao.updateUser(new User(5,"huihui","aaaa"));
    }

    public void testSelectUserById(){
        userDao.selectUserById(5);
    }

    public void testSelectUserList() {
        userDao.selectUserList();
    }

}