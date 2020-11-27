package com.liuqiang.dao.impl;

import com.liuqiang.utils.JdbcUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 复用代码类，不需要对象实例
 */
public abstract class BaseDao {

    //使用Dbutils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update方法用来执行：insert/update/delete语句
     * @return 返回-1执行失败，返回其他表示影响的行数
     */
    public int update(String sql,Object...args){
        Connection conn = JdbcUtils.getConnection();
        try {
           return queryRunner.update(conn,sql,args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return -1;
    }

    /**
     * 查询返回一个javaBean的sql语句
     * @param type 返回的对象类型
     * @param sql 执行的sql语句
     * @param args sql对应的参数
     * @param <T> 返回类型的泛型
     * @return 失败为null
     */
    public <T> T  queryForOne(Class<T> type,String sql,Object...args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }
    /**
     * 查询返回多个javaBean的sql语句
     * @param type 返回的对象类型
     * @param sql 执行的sql语句
     * @param args sql对应的参数
     * @param <T> 返回类型的泛型
     * @return 失败为null
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object...args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;

    }

    /**
     * 执行返回一行一列的sql语句
     * @param sql 执行的sql语句
     * @param args sql对应的参数值
     * @return 失败为null
     */
    public Object queryForSingleValue(String sql,Object...args){
        Connection conn = JdbcUtils.getConnection();

        try {
            return queryRunner.query(conn,sql,new ScalarHandler(),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }
}
