package com.ldd.flower.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author liudongdong
 * @Date Created in 10:56 2019/9/9
 * @Description
 */
@Controller
public class SystemController {
   /**
    * test.html页面调试
    * */
   @RequestMapping(value = "/test")
   public String testPage(){
       return "test";
   }

    /**
     * 传感器参数指标设置
     * */
    @RequestMapping(value = "/sensorSetting")
    public String sensorSettingPage(){
        return "monitor/sensorsetting";
    }


    /**
     * 数据备份
     * */
    @RequestMapping(value = "/datarestore")
    public String dataRestorePage(){
        return "history/restore";
    }
}
