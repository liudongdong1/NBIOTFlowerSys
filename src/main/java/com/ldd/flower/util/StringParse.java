package com.ldd.flower.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author liudongdong
 * @Date Created in 11:40 2019/10/10
 * @Description
 */

/* data:{"notifyType":"deviceDataChanged","deviceId":"5bb30588-a154-4d08-b471-fed2ad3ea616","gatewayId":"5bb30588-a154-4d08-b471-fed2ad3ea616","requestId":null,"service":{"serviceId":"Sensor","serviceType":"Sensor","data":{"humidity":530,"temperature":210},"eventTime":"20191010T033842Z"}}
         2019-10-10 11:38:58.876  INFO 9771 --- [io-8088-exec-10] LoginInterceptior                        : /receive.html
         2019-10-10 11:38:58.877  INFO 9771 --- [io-8088-exec-10] MonitorController                       : data:{"notifyType":"deviceDataChanged","deviceId":"5bb30588-a154-4d08-b471-fed2ad3ea616","gatewayId":"5bb30588-a154-4d08-b471-fed2ad3ea616","requestId":null,"service":{"serviceId":"Sensor","serviceType":"Sensor","data":{"humidity":530,"temperature":210},"eventTime":"20191010T033857
*/

public class StringParse {
    public static String temp="{\"notifyType\":\"deviceDataChanged\",\"deviceId\":\"5bb30588-a154-4d08-b471-fed2ad3ea616\",\"gatewayId\":\"5bb30588-a154-4d08-b471-fed2ad3ea616\",\"requestId\":null,\"service\":{\"serviceId\":\"Sensor\",\"serviceType\":\"Sensor\",\"data\":{\"luminance\":165},\"eventTime\":\"20191010T033928Z\"}}\n";
    public static String temp1="{\"notifyType\":\"deviceDataChanged\",\"deviceId\":\"5bb30588-a154-4d08-b471-fed2ad3ea616\",\"gatewayId\":\"5bb30588-a154-4d08-b471-fed2ad3ea616\",\"requestId\":null,\"service\":{\"serviceId\":\"Sensor\",\"serviceType\":\"Sensor\",\"data\":{\"humidity\":530,\"temperature\":210},\"eventTime\":\"20191010T033928Z\"}}\n";
    public static void main(String args[]){

        Queue<Integer> luminance = new LinkedList<>();
        for(Integer i=0;i<100;i++){
            if(luminance.size()<10){
                luminance.add(i);
            }
            else{
                luminance.poll();
                luminance.add(i);
            }
            System.out.println(luminance.peek());
        }
        for(Integer integer:luminance)
            System.out.print(" , "+integer);
        //真正接收到的数据
        //String test = "{\"notifyType\":\"deviceDataChanged\",\"deviceId\":\"5043ce98-8255-4008-925b-9afb68713d37\",\"gatewayId\":\"5043ce98-8255-4008-925b-9afb68713d37\",\"requestId\":null,\"service\":{\"serviceId\":\"Sensor\",\"serviceType\":\"Sensor\",\"data\":{\"X\":1,\"Y\":0,\"Z\":-2},\"eventTime\":\"20190725T123507Z\"}}";
        //temp=test.split("\\{")[3];
      /*  JSONObject jsonObject = JSON.parseObject(temp).getJSONObject("service").getJSONObject("data");
        System.out.println(jsonObject.toJSONString());
        if(jsonObject.containsKey("luminance"))
            System.out.println(jsonObject.getBigInteger("luminance"));
        if(jsonObject.containsKey("temperature"))
            System.out.println(" "+jsonObject.getInteger("temperature")+"  "+jsonObject.getInteger("humidity"));*/
       /* temp=temp.split("\\{")[3];
        String time=temp.split("\\}")[1];
        time=time.split(":")[1];
        time=time.replace("\"", "");
        temp=temp.split("\\}")[0];
        String[] str=temp.split(",");*/
    }
}
