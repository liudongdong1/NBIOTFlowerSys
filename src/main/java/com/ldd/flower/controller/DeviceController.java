package com.ldd.flower.controller;

import com.alibaba.fastjson.JSONObject;
import com.ldd.flower.entity.Device;
import com.ldd.flower.entity.OperationInfo;
import com.ldd.flower.entity.User;
import com.ldd.flower.service.DeviceService;
import com.ldd.flower.service.OperationInfoService;
import com.ldd.flower.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @Author liudongdong
 * @Date Created in 18:45 2019/9/8
 * @Description
 */
@Controller
public class DeviceController {
    private Logger logger= Logger.getLogger("DeviceController");
    @Autowired
    private OperationInfoService operationInfoService;
    @Autowired
    private UserService userService;
    @Autowired
    private DeviceService deviceService;
    private Device device;
    private User user;
    /**
     * 设备操作记录信息controller
     * */
    @RequestMapping(value = "/operationinfo/list")
    public String optioninfoList(HttpServletRequest request, @RequestParam(value="deviceid",required = false) Long deviceid, @RequestParam(value="userid",required = false) Long userid)
    {
        logger.info("/operationinfo/list:"+userid+" deviceid: "+deviceid);
        List<OperationInfo> operationInfos=new ArrayList<>();
        if(deviceid!=null){
            device=deviceService.findById(deviceid);
            if(deviceid!=null)
                request.setAttribute("devicename",device.getDevicename());
            operationInfos=operationInfoService.findOperationInfosByDeviceid(deviceid);
        }
        if(userid!=null){
            user=userService.findById(userid);
            if(user!=null)
                request.setAttribute("username",user.getUsername());
            operationInfos=operationInfoService.findOperationInfosByUserid(userid);
        }else{
            operationInfos=operationInfoService.findAll();
        }
        request.setAttribute("operations",operationInfos);
        return "user/userop/list";
    }
    @RequestMapping(value = "/operationinfo/optioninfoadd")
    public String operationinfoAdd(){
        return "user/userop/add";
    }

    @RequestMapping(value = "/operationinfo/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject deloperationinfo(@PathVariable Long id){
        JSONObject json=new JSONObject();
        /**
         * userService.deleteUserById(这个函数有问题)；可能不存在
         * */
        logger.info("/optioninfo/{id}_delete: id="+id);
        OperationInfo operationInfo=operationInfoService.findById(id);
        logger.info("/optioninfo/{id}_delete: optioninfo="+operationInfo.toString());
        if(operationInfo!=null)
        {
            operationInfoService.delete(operationInfo);
            json.put("message","操作成功");
        }
        else{
            json.put("message","操作失败");
        }
        return json;
    }
    @RequestMapping(value = "/operationinfo/{id}",method = RequestMethod.GET)
    public String operationInfoEdit(@PathVariable Long id,HttpServletRequest request){
        logger.info("operationinfoEdit:id="+id);
        request.setAttribute("opeartioninfo",operationInfoService.findById(id));
        return "user/userop/edit";
    }
    @RequestMapping(value = "/operationinfoshow/{id}",method = RequestMethod.GET)
    public ModelAndView operationInfoShow(@PathVariable Long id,HttpServletRequest request){
        logger.info("operationInfoShow_get:id="+id);
        OperationInfo operationInfo=operationInfoService.findById(id);
        logger.info("operationInfoShow_get:operationinfo:"+operationInfo.toString());
        ModelAndView modelAndView=new ModelAndView("user/userop/show");
        modelAndView.addObject("operationInfo",operationInfo);
        return modelAndView;
    }
    @RequestMapping(value = "/operationinfo",method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject operationinfoUpdate(@RequestBody OperationInfo operationInfo){
        JSONObject json=new JSONObject();
        OperationInfo operationInfo1= operationInfoService.saveAndFlush(operationInfo);
        if(operationInfo!=null)
            json.put("message","添加成功");
        else
            json.put("message","操作失败");
        return json;
    }
    @RequestMapping(value = "/operationinfo",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject operationinfoAdd(@RequestBody OperationInfo operationInfo){
        JSONObject json=new JSONObject();
        OperationInfo operationInfo1= operationInfoService.saveAndFlush(operationInfo);
        if(operationInfo!=null)
            json.put("message","添加成功");
        else
            json.put("message","操作失败");
        return json;
    }

    /**
     * 下面是：
     *
     * 设备信息管理controller类
     * */
    @RequestMapping(value = "/deviceinfo/list")
    public String deviceList(HttpServletRequest request, @RequestParam(value="id",required = false) Long id, @RequestParam(value="devicename",required = false) String devicename)
    {
        logger.info("/deviceinfo/list:"+id+" deviceid: "+devicename);
        List<Device>devices=new ArrayList<>();
        if(devicename!=null){
            devices=deviceService.findByName(devicename);
        }
        if(id!=null){
            devices.add(deviceService.findById(id));
        }else{
            devices=deviceService.findAll();
        }
        request.setAttribute("devices",devices);
        return "device/deviceinfo/list";
    }
    @RequestMapping(value = "/deviceinfo/deviceinfoadd")
    public String deviceinfoAddpage(){
        return "device/deviceinfo/add";
    }

    @RequestMapping(value = "/deviceinfo/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject deldeviceinfo(@PathVariable Long id){
        JSONObject json=new JSONObject();
        /**
         * userService.deleteUserById(这个函数有问题)；可能不存在
         * */
        logger.info("/deviceinfo/{id}_delete: id="+id);
        Device device=deviceService.findById(id);
        logger.info("/deviceinfo/{id}_delete: deviceinfo="+device.toString());
        if(device!=null)
        {
            deviceService.delete(device);
            json.put("message","操作成功");
        }
        else{
            json.put("message","操作失败");
        }
        return json;
    }
    @RequestMapping(value = "/deviceinfo/{id}",method = RequestMethod.GET)
    public String deviceinfoEdit(@PathVariable Long id,HttpServletRequest request){
        logger.info("deviceinfoEdit:id="+id);
        request.setAttribute("device",deviceService.findById(id));
        return "device/deviceinfo/edit";
    }
    @RequestMapping(value = "/deviceinfoshow/{id}",method = RequestMethod.GET)
    public String deviceinfoShow(@PathVariable Long id,HttpServletRequest request){
        logger.info("deviceinfoShow_get:id="+id);
        request.setAttribute("device",deviceService.findById(id));
        return "device/deviceinfo/show";
    }
    @RequestMapping(value = "/deviceinfo",method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject deviceinfoUpdate(@RequestBody Device device){
        JSONObject json=new JSONObject();
        Device device1=deviceService.saveAndFlush(device);
        if(device1!=null)
            json.put("message","添加成功");
        else
            json.put("message","操作失败");
        return json;
    }
    @RequestMapping(value = "/deviceinfo",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject deviceinfoAdd(@RequestBody Device device){
        JSONObject json=new JSONObject();
        Device device1=deviceService.saveAndFlush(device);
        if(device1!=null)
            json.put("message","添加成功");
        else
            json.put("message","操作失败");
        return json;
    }

}
