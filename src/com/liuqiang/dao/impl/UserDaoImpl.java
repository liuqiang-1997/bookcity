package com.liuqiang.dao.impl;


import com.liuqiang.dao.UserDao;
import com.liuqiang.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryByUserName(String username) {
        String sql = "select id,username,password,email from t_user where username = ?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username,password,email) values(?,?,?)";
        return update(sql,user.getUsername(),user.getpassword(),user.getEmail());
    }

    @Override
    public User queryByUserNameAndPassword(String username, String password) {
        String sql = "select id,username,password,email from t_user where username = ? and password = ?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public User queryByUserId(Integer id) {
        String sql = "select id,username,password from t_user where id = ?";
        return queryForOne(User.class,sql,id);
    }

    @Override
    public int updateUserPassword(Integer id, String password) {
       String sql =  "update t_user set password = ? where id = ?";
       return update(sql,password,id);
    }
}

