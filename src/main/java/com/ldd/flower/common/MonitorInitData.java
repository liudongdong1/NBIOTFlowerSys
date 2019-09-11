package com.ldd.flower.common;

/**
 * @Author liudongdong
 * @Date Created in 9:55 2019/9/7
 * @Description
 */
public class MonitorInitData {
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
    public static String operateinfo[]={"打开风扇","关闭风扇","打开CO2产生器","关闭CO2产生器","停止喷雾加水","打开喷雾器或水泵","降低遮荫棚","关闭遮荫棚"};
    /**
     * 传感器信息
     * */
    public static String type[]={"光照","湿度","温度","CO2浓度"};



}
