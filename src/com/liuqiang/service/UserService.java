package com.liuqiang.service;

import com.liuqiang.pojo.User;

public interface UserService {
    /**
     * 注册用户
     * @param user  用户
     * @return
     */
    public User registUser(User user);

    /**
     * 用户登陆
     * @param user 用户
     * @return 返回null 说明登录失败，有值则登录成功
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username 用户名
     * @return 返回true表示用户名已存在，false表示该用户名可使用
     */
    public boolean existsUserName(String username);

    /**
     * 跟据用户id显示评论者是哪个用户
     * @param Id
     * @return
     */
    public User queryByUserId(Integer Id);

    /**
     * 根据用户名修改密码
     * @param id
     * @param password
     */
    public void updateUserPassword(Integer id, String password);
}
