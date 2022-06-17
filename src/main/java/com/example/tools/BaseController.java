package com.example.tools;

import com.alibaba.fastjson.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseController {
    protected static final int PAGE_SIZE=15;

    protected String RespInfo(int code,String info,Object data){
        JSONObject jsonObj=new JSONObject();
        jsonObj.put("code",code);
        jsonObj.put("info",info);
        jsonObj.put("data",data);

        return jsonObj.toJSONString();
    }

    public static String Timestamp2Date(Long timestamp, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date(timestamp*1000));
    }

    public static int DateTime2TimeStamp(String time,String pattern){
        SimpleDateFormat format =  new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            return 0;
        }
        return (int)(date.getTime()/1000);
    }

    public static String JsonResp(int code,String info,Object data){
        JSONObject jsonObj=new JSONObject();
        jsonObj.put("code",code);
        jsonObj.put("info",info);
        jsonObj.put("data",data);

        return jsonObj.toJSONString();
    }

    public static String CreateOrdersn(){
        long ts=System.currentTimeMillis();
        return String.valueOf(ts);
    }
}
