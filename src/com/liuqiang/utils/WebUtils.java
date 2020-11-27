package com.liuqiang.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;


public class WebUtils {
    /**
     * 将web页面的所有请求参数通过map的方式都注入到user对象中
     * @param
     * @param
     */
//    public static void copyParamToBean(HttpServletRequest req, Object bean){
    // HttpServletRequest在Dao层和service层不能使用,map类型适用于web层和service层以及Dao层
//    public static Object copyParamToBean(Map value, Object bean){
    // 使用泛型进一步优化
    public static <T> T copyParamToBean(Map value, T bean){

        try {
            System.out.println("注入之前"+bean);
            BeanUtils.populate(bean,value);
            System.out.println("注入之后"+bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将请求参数中字符串转换为int类型
     * @param strInt
     * @param dafaultValue
     * @return
     */
    public static int parseInts(String strInt,int dafaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return dafaultValue;
    }
}
