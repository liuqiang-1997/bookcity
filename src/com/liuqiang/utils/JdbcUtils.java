package com.liuqiang.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    private static DruidDataSource dataSourse;
    static{

        try {
            Properties properties = new Properties();
            //读取数据库配置文件
            InputStream inputstream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 从数据流中加载数据
            properties.load(inputstream);
            //创建数据库连接池
            dataSourse = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * 获取数据库连接池中的连接
     * @return 如果返回null，说明获取连接失败，有值说明获取成功
     */
    public static Connection getConnection(){

        Connection conn = null;

        try {
            conn = dataSourse.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭数据库连接，放回数据库连接池
     * @param conn
     */
    public static void close(Connection conn){
        //连接成功则关闭
       if (conn != null){
           try {
               conn.close();
           } catch (SQLException throwables) {
               throwables.printStackTrace();
           }

       }
    }
}
