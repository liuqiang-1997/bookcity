package com.liuqiang.test;

import com.liuqiang.pojo.User;
import com.liuqiang.service.UserService;
import com.liuqiang.service.impl.userServiceImpl;
import org.junit.Test;

public class UserServiceTest {

    UserService userService = new userServiceImpl();
    @Test
    public void registUser() {
        userService.registUser(new User(null,"kobe","a111111","kb123@qq.com"));
        userService.registUser(new User(null,"rose","a111111","kb123@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"kobe","a111111",null)));
    }

    @Test
    public void existsUserName() {
        if (userService.existsUserName("bryant")){
            System.out.println("用户名已存在");
        }else{
            System.out.println("用户名可用");
        }
    }
    @Test
    public void queryByUserId(){
        User user = userService.queryByUserId(12);
        System.out.println(user);
    }
}