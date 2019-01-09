package com.imooc.util;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CommonUtil {
    /**
     * 创建36位的UUID
     * @return
     */
    public static String createUUID(){
        return UUID.randomUUID().toString();
    }

    /**
     * 从字符串中提取数字
     * @param str
     * @return
     */
    public static String getNumberByString(String str){
        //去掉日期中的符号
        str = str.trim();
        String dateInt = "";
        if(!StringUtils.isEmpty(str)){
            for(int i = 0;i < str.length();i++){
                if(str.charAt(i) >= 48 && str.charAt(i) <=57){
                    dateInt += str.charAt(i);
                }
            }
        }
        return dateInt;
    }

    /**
     * 获取n分钟之前(之后)的时间
     * -为之前，+为之后
     * @return
     */
    public static Date getBeforeCurrentDate(int minutes){
        Calendar beforeTime = Calendar.getInstance();
        beforeTime.add(Calendar.MINUTE, minutes);
        return beforeTime.getTime();
    }

    /**
     * 获取当前时间
     * @return
     */
    public static String currentDateTime(SimpleDateFormat format) {
        format.setLenient(false);
        return format.format(new Date());
    }/**
     * 字符串转时间
     * @return
     */
    public static Date strToDate(String dateStr, SimpleDateFormat format) {
        try {
            return format.parse(dateStr);
        } catch (ParseException e) {
            return new Date();
        }
    }

    /**
     * 解析JSON为map
     * @param jsonParam
     * @return
     */
    public static Map<String,Object> parseJsonParam(String jsonParam) {
        Map<String,Object> requestParamMap = JSON.parseObject(jsonParam, HashMap.class);
        return requestParamMap;
    }

    /**
     * 解析JSON为map
     * @param jsonParam
     * @return
     */
    public static Map<String,String> parseJsonParamToString(String jsonParam) {
        Map<String,String> requestParamMap = JSON.parseObject(jsonParam,HashMap.class);
        return requestParamMap;
    }


}
