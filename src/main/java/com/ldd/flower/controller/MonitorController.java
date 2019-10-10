package com.ldd.flower.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ldd.flower.entity.Monitor;
import com.ldd.flower.service.MonitorService;
import com.ldd.flower.util.JsonResult;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
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
    private Queue<Integer> temperature = new LinkedList<>();
    private Queue<Integer> humidity = new LinkedList<>();
    private Queue<Integer> luminance = new LinkedList<>();
    /**
     * 登陆首页
     * */
    @RequestMapping(value = "/index")
    public String index()
    {
        return "index";
    }
    /**
     * 刷新网页传感器数据值
     * */
    @RequestMapping(value="/update")
    @ResponseBody
    public JsonResult updateSensor(HttpServletRequest request, HttpServletResponse response)
    {
       /* ModelAndView modelAndView=new ModelAndView("index");
        Random random=new Random();
        Integer temp=random.nextInt(100);
        modelAndView.addObject("temperture",temp);
        modelAndView.addObject("Humity",temp);
        modelAndView.addObject("Humity",temp);
        modelAndView.addObject("moisture",temp);
        return modelAndView;*/
        JsonResult jsonResult=JsonResult.ok();
        Random random=new Random();
        Integer temp=random.nextInt(100);
        jsonResult.put("temperture",temp);
        jsonResult.put("Humity",temp);
        jsonResult.put("Light",temp);
        jsonResult.put("moisture",temp);
        return jsonResult;
    }
    /**
     * 一个项目信息具体展示
     * */
    @RequestMapping(value = {"/monitorsingle"})
    public ModelAndView monitorSinglePage(){
        ModelAndView modelAndView=new ModelAndView("index");
        return modelAndView;
    }
    /**
     * 用于接受华为云平台上传的数据
     * */
    @RequestMapping(value = "/receive.html",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public JsonResult receive(HttpServletRequest request, HttpServletResponse response){
        response.setStatus(200);
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
            StringBuffer sb = new StringBuffer("");
            String temp;
            while ((temp = br.readLine()) != null){
                sb.append(temp);
            }
            //logger.info("recieve info"+sb.toString());
            br.close();
            temp=sb.toString();
            JSONObject jsonObject = JSON.parseObject(temp).getJSONObject("service").getJSONObject("data");
            logger.info(jsonObject.toJSONString());
            if(jsonObject.containsKey("luminance")) {
                logger.info("luninance"+jsonObject.getInteger("luminance"));
                if (luminance.size()<100)
                    luminance.add(jsonObject.getInteger("luminance"));
                else{
                    luminance.poll();
                    luminance.add(jsonObject.getInteger("luminance"));
                }
            }
            if(jsonObject.containsKey("temperature")) {
                logger.info(" " + jsonObject.getInteger("temperature") + "  " + jsonObject.getInteger("humidity"));
                if(humidity.size()<100)
                    humidity.add(jsonObject.getInteger("humidity"));
                else{
                    humidity.poll();
                    humidity.add(jsonObject.getInteger("humidity"));
                }
                if(temperature.size()<100)
                    temperature.add(jsonObject.getInteger("temperature"));
                else{
                    temperature.poll();
                    temperature.add(jsonObject.getInteger("temperature"));
                }
            }
            logger.info("data:"+sb.toString());
            sb.delete(0,sb.length());

        }catch (Exception e){
            e.printStackTrace();
        }
        JsonResult jsonResult=JsonResult.ok();
        jsonResult.put("temperture",temperature.peek());
        jsonResult.put("Humity",humidity.peek());
        jsonResult.put("Light",luminance.peek());
        jsonResult.put("moisture",60);
        return jsonResult;
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
