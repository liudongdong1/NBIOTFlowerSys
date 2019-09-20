package com.ldd.flower.controller;

import com.alibaba.fastjson.JSONObject;
import com.ldd.flower.entity.AlarmInfo;
import com.ldd.flower.entity.Device;
import com.ldd.flower.entity.AlarmInfo;
import com.ldd.flower.service.AlarmInfoService;
import com.ldd.flower.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @Author liudongdong
 * @Date Created in 21:35 2019/9/8
 * @Description
 */
@Controller
public class AlarmController {
    private Logger logger=Logger.getLogger("AlarmController");
    private Device device;
    @Autowired
    private AlarmInfoService alarmInfoService;
    @Autowired
    private DeviceService deviceService;

    /**
     * 警告记录信息controller
     * */
    @RequestMapping(value = "/alarm/list")
    public ModelAndView alarmInfoList(HttpServletRequest request, @RequestParam(value="deviceId",required = false) Long deviceId, @RequestParam(value="id",required = false) Long id)
    {
        logger.info("/alarm/list:"+id+" deviceId: "+deviceId);
        List<AlarmInfo>alarmInfos=new ArrayList<>();
        if(deviceId!=null){
            device=deviceService.findById(deviceId);
            if(device!=null)
                request.setAttribute("devicename",device.getDevicename());
            alarmInfos=alarmInfoService.findAlarmInfosByDeviceId(deviceId);
        }
        if(id!=null) {
            alarmInfos.add(alarmInfoService.findById(id));
        }else{
            alarmInfos.clear();
            alarmInfos=alarmInfoService.findAll();
        }
        /**
         *  request.setAttribute("myusername",username);
         *         request.setAttribute("myrole",role);
         *         request.setAttribute("users",userList);
         *  可能应为传入之过大，导致 alarmInfo变为字符串
         *  #error re For "#list" list source: Expected a sequence or collection, but this has evaluated to a string (wrapper: f.t.SimpleScalar):
         * */
        logger.info("/alarm/list: alarmInfos size="+alarmInfos.size());
        logger.info("alarminfo一个记录信息为："+alarmInfos.get(0).toString());
        ModelAndView modelAndView=new ModelAndView("history/alarm/list");
        modelAndView.addObject("alarms",alarmInfos);
        return modelAndView;
    }
    @RequestMapping(value = "/alarm/alarmInfoadd")
    public String alarmAddPage(){
        return "history/alarm/add";
    }

    @RequestMapping(value = "/alarm/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject delalarm(@PathVariable Long id){
        JSONObject json=new JSONObject();
        /**
         * userService.deleteUserById(这个函数有问题)；可能不存在
         * */
        logger.info("/alarmInfo/{id}_delete: id="+id);
        AlarmInfo alarmInfo=alarmInfoService.findById(id);
        logger.info("/alarmInfo/{id}_delete: alarmInfo="+alarmInfo.toString());
        if(alarmInfo!=null)
        {
            alarmInfoService.delete(alarmInfo);
            json.put("message","操作成功");
        }
        else{
            json.put("message","操作失败");
        }
        return json;
    }
    @RequestMapping(value = "/alarm/{id}",method = RequestMethod.GET)
    public String alarmInfoEdit(@PathVariable Long id,HttpServletRequest request){
        logger.info("alarmEdit:id="+id);
        request.setAttribute("alarmInfo",alarmInfoService.findById(id));
        return "history/alarm/edit";
    }
    @RequestMapping(value = "/alarmshow/{id}",method = RequestMethod.GET)
    public String alarmInfoShow(@PathVariable Long id,HttpServletRequest request){
        logger.info("alarmInfoShow_get:id="+id);
        request.setAttribute("alarmInfo",alarmInfoService.findById(id));
        return "history/alarm/show";
    }
    @RequestMapping(value = "/alarm",method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject alarmUpdate(@RequestBody AlarmInfo alarmInfo){
        JSONObject json=new JSONObject();
        AlarmInfo alarmInfo1= alarmInfoService.saveAndFlush(alarmInfo);
        if(alarmInfo1!=null)
            json.put("message","添加成功");
        else
            json.put("message","操作失败");
        return json;
    }
    @RequestMapping(value = "/alarm",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject alarmAdd(@RequestBody AlarmInfo alarmInfo){
        JSONObject json=new JSONObject();
        AlarmInfo alarmInfo1= alarmInfoService.saveAndFlush(alarmInfo);
        if(alarmInfo1!=null)
            json.put("message","添加成功");
        else
            json.put("message","操作失败");
        return json;
    }

}
