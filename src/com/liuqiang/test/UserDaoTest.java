package com.liuqiang.test;

import com.liuqiang.dao.UserDao;
import com.liuqiang.dao.impl.UserDaoImpl;
import com.liuqiang.pojo.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void queryByUserName() {
        UserDao userDao = new UserDaoImpl();
        if(userDao.queryByUserName("admin") == null){
            System.out.println("用户名可用");
        }else{
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void saveUser() {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.saveUser(new User(null,"james","a123456","asd168@qq.com")));
    }

    @Test
    public void queryByUserNameAndPassword() {
        UserDao userDao = new UserDaoImpl();
        if(userDao.queryByUserNameAndPassword("admin","admin123") == null){
            System.out.println("用户名或密码错误，登录失败");
        }else{
            System.out.println("查询成功");
        }
    }
}