package com.liuqiang.dao;

import com.liuqiang.pojo.User;

public interface UserDao {

    /** 注册操作
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 返回null则用户不存在
     */
    public User queryByUserName(String username);

    /**注册操作
     * 保存用户信息
     * @param user 用户
     * @return 返回-1表示操作失败，其他是sql语句影响的行数
     */
    public int saveUser(User user);

    /**登陆操作
     * 根据用户名和密码查询用户信息
     * @param username 用户名
     * @param password 密码
     * @return 返回null说明密码或用户名有错误
     */
    public User queryByUserNameAndPassword(String username,String password);

    /**查询用户
     * 根据用户id查询用户
     * @param id
     * @return
     */
    public User queryByUserId(Integer id);

    public int updateUserPassword(Integer id,String password);
}
