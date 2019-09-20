package com.ldd.flower.controller;

import com.ldd.flower.entity.SensorInfo;
import com.ldd.flower.service.SensorInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * @Author liudongdong
 * @Date Created in 8:51 2019/9/20
 * @Description
 */
@Controller
@RequestMapping(value = "/sensordata")
public class SensorInfoController {
    @Autowired
    private SensorInfoService sensorInfoService;
    private Logger logger= Logger.getLogger("SensorInfoController");

  /*  @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }*/
    @ApiOperation(value = "传感器")
    @RequestMapping(value = "/list")
    public ModelAndView sensorList(){
        //光照，湿度，温度
        ArrayList<SensorInfo>arrayLight= (ArrayList<SensorInfo>) sensorInfoService.findSensorInfosByType("光照");
        ArrayList<SensorInfo>arrayTemperature= (ArrayList<SensorInfo>) sensorInfoService.findSensorInfosByType("温度");
        ArrayList<SensorInfo>arrayHumidity= (ArrayList<SensorInfo>) sensorInfoService.findSensorInfosByType("湿度");
        logger.info("光照个数：" +arrayLight.size()+" 温度个数: "+arrayTemperature.size()+"湿度个数"+arrayHumidity.size()+" 土壤湿度个数:"+arrayHumidity.size() );
        ModelAndView modelAndView=new ModelAndView("/history/sensordata/list");
        modelAndView.addObject("temperature",createData(arrayTemperature));
        modelAndView.addObject("humidity",createData(arrayHumidity));
        modelAndView.addObject("light",createData(arrayLight));
        modelAndView.addObject("T_humidity",createData(arrayHumidity));
        return modelAndView;
    }

    Integer calculateMean(SensorInfo sensorInfo){
        String[]arrayInfo=sensorInfo.getInfo().split(",");
        int sum=0;
        for(int i=0;i<arrayInfo.length;i++)
            sum+=Integer.valueOf(arrayInfo[i]);
        return sum/arrayInfo.length;

    }
    HashMap<String,Integer>createData(ArrayList<SensorInfo>arrayList){
       HashMap<String,Integer>hashMap=new HashMap<>(arrayList.size());
       for(int i=0;i<arrayList.size();i++){
           hashMap.put(String.valueOf(i),calculateMean(arrayList.get(i)));
           logger.info("value:"+hashMap.get(String.valueOf(i)));
       }
       return hashMap;
    }

}
