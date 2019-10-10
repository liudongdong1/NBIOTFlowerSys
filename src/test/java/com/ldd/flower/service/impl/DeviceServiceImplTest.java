package com.ldd.flower.service.impl;

import com.ldd.flower.common.DeviceInitData;
import com.ldd.flower.common.FlowerInitData;
import com.ldd.flower.common.MonitorInitData;
import com.ldd.flower.common.UserInitData;
import com.ldd.flower.entity.*;
import com.ldd.flower.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;
import java.util.logging.Logger;

import static org.junit.Assert.*;

/**
 * @Author liudongdong
 * @Date Created in 23:42 2019/9/6
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)             //
@SpringBootTest
public class DeviceServiceImplTest {
    /**
     * 监控项目信息  7
     * */
    public static String name[]={"紫菜监控项目","珊瑚花凤梨监控项目","王妃雷神监控项目","捕蝇草监控项目","室内摄像监控项目","总光照控制项目","七姊妹监测项目"};
    public static String location[]={"北苑一公寓","逸夫教学楼","第三教学楼","计算机楼","南九公寓","型食堂","鼎新大讲堂"};
    public static String mark="这里是项目的一些介绍信息，例如温室大棚智能监控系统一般都配备的有环境温湿度监测，通过温度传感器和湿度传感器可以及时了解大棚内的环境情况，监测数据可以通过无线的方式传送至后台！用户可以更加直观的看到数据，可以对数据进行对比分析！同时发现问题可以及时采取措施！比如打开风机通风，灌溉等！";
    public static String version="version 1.1.0";
    private static boolean states[]={true,false};

    /**
     * 预警信息
     * */
    public static int state[]={1,2,3,4,5};
    public static String info[]={"温度过高","温度过低","CO2浓度过高","CO2浓度过高","湿度过高","湿度过低","光照过强","光照过低"};
    /**
     * 用户操作信息
     * */
    public static String operateinfo1[]={"打开风扇","关闭风扇","打开CO2产生器","关闭CO2产生器","停止喷雾加水","打开喷雾器或水泵","降低遮荫棚","关闭遮荫棚"};
    /**
     * 传感器信息
     * */
    public static String type[]={"光照","湿度","温度","CO2浓度"};


    private Random random=new Random();
    private Logger logger= Logger.getLogger("DeviceServiceImpl");

    @Autowired
    private DeviceService deviceService;
    @Autowired
    private FlowerService flowerService;
    @Autowired
    private UserService userService;
    @Autowired
    private MonitorService monitorService;
    @Autowired
    private AlarmInfoService alarmInfoService;
    @Autowired
    private OperationInfoService  operationInfoService;
    @Autowired
    private SensorInfoService sensorInfoService;
    /**
     * 初始化用户表
     * */
    @Test
    public void initUserTable()
    {
        userService.save(new UserInitData().getUsers(89));
    }
    /**
     * 初始化device数据表
     * */
   /* @Test
    public void save() {
        deviceService.save(new DeviceInitData().getDevice(5));
        List<Device> deviceList= deviceService.findAll();
        for(Device device:deviceList)
            logger.info(device.toString());

    }
    *//**
     * 初始化flower数据表
     * *//*
    @Test
    public void initFlowers(){
        flowerService.save(new FlowerInitData().getFlower());
        List<Flower> flowerList= flowerService.findAll();
        for(Flower flower:flowerList)
            logger.info(flower.toString());
    }

    *//**
     *初始化Monitor项目表
     * *//*
    @Test
    public void monitorTable()
    {
        List<User>users=userService.findAll();
        if(users.isEmpty())
            return;
        List<Monitor>monitors=new ArrayList<>(7);
        for(int i=0;i<7;i++){
            Monitor monitor=new Monitor();
            monitor.setCreatedate(new Date());
            monitor.setName(name[i]);
            monitor.setLocation(location[i]);
            monitor.setRemark(mark);
            monitor.setVersion(version);
            monitor.setStates(states[i%2]);
            int choose=(random.nextInt(20)+1);
            if(choose<users.size())
                monitor.setUserid(users.get(choose).getId());
            else monitor.setUserid(users.get(0).getId());
            monitors.add(monitor);
        }
        monitorService.save(monitors);
        monitors.clear();
        monitors=monitorService.findAll();
        logger.info("initMonitorTable: size"+monitors.size());
    }
    *//**
     *初始化alarminfo和operation项目表
     * *//*
    @Test
    public void alarminfoAndOperationTable(){
        int size=100;  //初始化个数
        List<User>users=userService.findAll();
        List<Monitor>monitors=monitorService.findAll();
        List<Device>devices=deviceService.findAll();
        List<OperationInfo>operationInfos=new ArrayList<>(size);
        List<AlarmInfo>alarmInfos=new ArrayList<>(size);
        List<SensorInfo>sensorInfos=new ArrayList<>(size);
        for(int i=0;i<size;i++){
            int monitor_choose=random.nextInt(monitors.size());
            if(monitor_choose>monitors.size())
                monitor_choose=1;
            int device_choose=random.nextInt(devices.size());
            if(device_choose>devices.size())
                device_choose=1;
            int user_choose=random.nextInt(users.size());
            if(user_choose>users.size())
                user_choose=1;
            SensorInfo sensorInfo=new SensorInfo();
            AlarmInfo alarmInfo=new AlarmInfo();
            OperationInfo operationInfo=new OperationInfo();

            sensorInfo.setCreatedate(new Date());
            sensorInfo.setInfo(generateSensorInfo());
            sensorInfo.setMonitorid(monitors.get(monitor_choose).getId());
            sensorInfo.setType(type[random.nextInt(3)]);
            sensorInfos.add(sensorInfo);

            int choose=random.nextInt(8);
            alarmInfo.setAlarminfo(info[choose]);
            alarmInfo.setCreatedate(new Date());
            alarmInfo.setDevices(devices.get(device_choose).getId());
            alarmInfo.setState(state[random.nextInt(4)]);
            alarmInfo.setElsepara("--其他备注信息--");
            alarmInfos.add(alarmInfo);

            operationInfo.setCreatedate(new Date());
            operationInfo.setDeviceid(devices.get(device_choose).getId());
            operationInfo.setOperateinfo(operateinfo1[choose]);
            operationInfo.setOperatereasion(info[choose]);
            operationInfo.setUserid(users.get(user_choose).getId());
            operationInfos.add(operationInfo);

        }
        sensorInfoService.save(sensorInfos);
        operationInfoService.save(operationInfos);
        alarmInfoService.save(alarmInfos);
    }

    *//**
     * 产生传感器数据随即数60个，以","连接，返回字符串
     * *//*
    public String generateSensorInfo(){
        StringBuffer stringBuffer=new StringBuffer("20");
        for(int i=0;i<60;i++)
        {
            stringBuffer.append(random.nextInt(20)+20).append(",");
        }
        return stringBuffer.toString();
    }*/
}