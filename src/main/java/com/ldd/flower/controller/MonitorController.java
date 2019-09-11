package com.ldd.flower.controller;

import com.alibaba.fastjson.JSONObject;
import com.ldd.flower.entity.Monitor;
import com.ldd.flower.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @Author liudongdong
 * @Date Created in 23:37 2019/9/8
 * @Description
 */
@Controller
public class MonitorController {
    private Logger logger=Logger.getLogger("MonitorController");
    @Autowired
    private MonitorService monitorService;
    /**
     * 登陆首页
     * */
    @RequestMapping(value = "/index")
    public String index()
    {
        return "index";
    }

    /**
     * 一个项目信息具体展示
     * */
    @RequestMapping(value = {"/monitorsingle"})
    public ModelAndView monitorSinglePage(){
        ModelAndView modelAndView=new ModelAndView("monitor/show");
        return modelAndView;
    }


    /**
     * 警告记录信息controller
     * */
    @RequestMapping(value = "/monitor/list")
    public ModelAndView monitorList(HttpServletRequest request, @RequestParam(value="name",required = false) String name, @RequestParam(value="userid",required = false) Long userid)
    {
        logger.info("/monitor/list:"+name+" userid: "+userid);
        List<Monitor> monitors=new ArrayList<>();
        if(name!=null){
            monitors.add(monitorService.findMonitorByName(name));
        }
        if(userid!=null) {
            monitors=monitorService.findMonitorsByUserid(userid);
        }else{
            monitors.clear();
            monitors=monitorService.findAll();
        }
        logger.info("/monitor/list: monitors size="+monitors.size());
        ModelAndView modelAndView=new ModelAndView("monitor/list");
        modelAndView.addObject("monitors",monitors);
        return modelAndView;
    }
    @RequestMapping(value = "/monitor/monitoradd")
    public String monitorAddPage(){
        return "monitor/add";
    }

    @RequestMapping(value = "/monitor/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject delMonitor(@PathVariable Long id){
        JSONObject json=new JSONObject();
        /**
         * userService.deleteUserById(这个函数有问题)；可能不存在
         * */
        logger.info("/monitor/{id}_delete: id="+id);
        Monitor monitor=monitorService.findById(id);
        logger.info("/monitor/{id}_delete: monitor="+monitor.toString());
        if(monitor!=null)
        {
            monitorService.delete(monitor);
            json.put("message","操作成功");
        }
        else{
            json.put("message","操作失败");
        }
        return json;
    }
    @RequestMapping(value = "/monitor/{id}",method = RequestMethod.GET)
    public String monitorEdit(@PathVariable Long id,HttpServletRequest request){
        logger.info("monitorEdit:id="+id);
        request.setAttribute("monitor",monitorService.findById(id));
        return "monitor/edit";
    }
    @RequestMapping(value = "/monitorshow/{id}",method = RequestMethod.GET)
    public String monitorShow(@PathVariable Long id,HttpServletRequest request){
        logger.info("monitorShow_get:id="+id);
        request.setAttribute("monitor",monitorService.findById(id));
        return "monitor/show";
    }
    @RequestMapping(value = "/monitor",method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject monitorUpdate(@RequestBody Monitor monitor){
        JSONObject json=new JSONObject();
        Monitor monitor1= monitorService.saveAndFlush(monitor);
        if(monitor1!=null)
            json.put("message","添加成功");
        else
            json.put("message","操作失败");
        return json;
    }
    @RequestMapping(value = "/monitor",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject monitorAdd(@RequestBody Monitor monitor){
        JSONObject json=new JSONObject();
        Monitor monitor1= monitorService.saveAndFlush(monitor);
        if(monitor1!=null)
            json.put("message","添加成功");
        else
            json.put("message","操作失败");
        return json;
    }

}
