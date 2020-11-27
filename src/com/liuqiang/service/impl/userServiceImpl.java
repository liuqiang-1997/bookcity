package com.liuqiang.service.impl;

import com.liuqiang.dao.UserDao;
import com.liuqiang.dao.impl.UserDaoImpl;
import com.liuqiang.pojo.User;
import com.liuqiang.service.UserService;

public class userServiceImpl implements UserService {

    //使用Dao持久层操作数据库，实例一个对象
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User registUser(User user) {
        userDao.saveUser(user);
        return user;
    }

    @Override
    public User login(User user) {
        return userDao.queryByUserNameAndPassword(user.getUsername(),user.getpassword());
    }

    @Override
    public boolean existsUserName(String username) {
        if (userDao.queryByUserName(username) == null ){
            //等于null相当于没查到，表示可以使用
            return false;
        }
        return true;
    }

    @Override
    public void updateUserPassword(Integer id, String password) {
        userDao.updateUserPassword(id,password);
    }

    @Override
    public User queryByUserId(Integer Id) {
        return userDao.queryByUserId(Id);
    }
}
