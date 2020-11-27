package com.liuqiang.test;

import java.lang.reflect.Method;

public class UserServletTest {
    /**
     * 测试使用反射机制来优化ifelse代码
     */


    public void login(){
        System.out.println("这是login功能");
    }
    public void regist(){
        System.out.println("这是regist功能");
    }
    public void updates(){
        System.out.println("这是updates功能");
    }public void delete(){
        System.out.println("这是delete功能");
    }

    public static void main(String[] args) {
        String action = "regist";

        try {
            //通过action业务鉴别字符串，获取相应的业务方法反射对象
            Method method = UserServletTest.class.getDeclaredMethod(action);
            System.out.println(method);
            //调用目标业务方法
            method.invoke(new UserServletTest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
