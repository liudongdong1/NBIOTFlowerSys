package com.ldd.flower.controller;

import com.alibaba.fastjson.JSONObject;
import com.ldd.flower.entity.Flower;
import com.ldd.flower.service.FlowerService;
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
 * @Date Created in 22:38 2019/9/8
 * @Description
 */
@Controller
public class FlowerController {
    private Logger logger=Logger.getLogger("FlowerController");
    @Autowired
    private FlowerService flowerService;

    /**
     * 花卉大全
     * */
    @RequestMapping(value = "/resourselist")
    public String flowerResourseList(){
        return "flower/resourselist";
    }

    /**
     * 花卉dairylist
     * */
    @RequestMapping(value = "/dairylist")
    public String flowerdairyList(){
        return "flower/dairy/list";
    }


    /**
     * 警告记录信息controller
     * */
    @RequestMapping(value = "/flower/list")
    public ModelAndView flowerList(HttpServletRequest request, @RequestParam(value="name",required = false) String name, @RequestParam(value="type",required = false) String type)
    {
        logger.info("/flower/list:"+name+" flowerType: "+type);
        List<Flower>flowers=new ArrayList<>();
        if(name!=null){
            flowers=flowerService.findFlowersByName(name);
        }
        if(type!=null) {
            flowers=flowerService.findFlowersByType(type);
        }else{
            flowers.clear();
            flowers=flowerService.findAll();
        }
        logger.info("/flower/list: flowers size="+flowers.size());
        ModelAndView modelAndView=new ModelAndView("flower/planted/list");
        modelAndView.addObject("flowers",flowers);
        return modelAndView;
    }
    @RequestMapping(value = "/flower/floweradd")
    public String flowerAddPage(){
        return "flower/planted/add";
    }

    @RequestMapping(value = "/flower/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject delFlower(@PathVariable Long id){
        JSONObject json=new JSONObject();
        /**
         * userService.deleteUserById(这个函数有问题)；可能不存在
         * */
        logger.info("/flower/{id}_delete: id="+id);
        Flower flower=flowerService.findById(id);
        logger.info("/flower/{id}_delete: flower="+flower.toString());
        if(flower!=null)
        {
            flowerService.delete(flower);
            json.put("message","操作成功");
        }
        else{
            json.put("message","操作失败");
        }
        return json;
    }
    @RequestMapping(value = "/flower/{id}",method = RequestMethod.GET)
    public String flowerEdit(@PathVariable Long id,HttpServletRequest request){
        logger.info("flowerEdit:id="+id);
        request.setAttribute("flower",flowerService.findById(id));
        return "flower/planted/edit";
    }
    @RequestMapping(value = "/flowershow/{id}",method = RequestMethod.GET)
    public String flowerShow(@PathVariable Long id,HttpServletRequest request){
        logger.info("flowerShow_get:id="+id);
        request.setAttribute("flower",flowerService.findById(id));
        return "flower/planted/show";
    }
    @RequestMapping(value = "/flower",method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject flowerUpdate(@RequestBody Flower flower){
        JSONObject json=new JSONObject();
        Flower flower1= flowerService.saveAndFlush(flower);
        if(flower1!=null)
            json.put("message","添加成功");
        else
            json.put("message","操作失败");
        return json;
    }
    @RequestMapping(value = "/flower",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject flowerAdd(@RequestBody Flower flower){
        JSONObject json=new JSONObject();
        Flower flower1= flowerService.saveAndFlush(flower);
        if(flower1!=null)
            json.put("message","添加成功");
        else
            json.put("message","操作失败");
        return json;
    }
}
