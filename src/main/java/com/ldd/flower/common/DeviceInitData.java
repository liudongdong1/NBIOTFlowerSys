package com.ldd.flower.common;

import com.ldd.flower.entity.Device;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 * @Author liudongdong
 * @Date Created in 22:57 2019/9/6
 * @Description
 */
public class DeviceInitData{
    private Logger logger= Logger.getLogger("DeviceInitData");
    public static String name[]={"DHT11湿度模块","MQ-4天然气","GY30光照传感器","红外感应模块HC-SR501","烟雾及可燃气体检测模块MQ-2"};
    public static String deviceurl[]={"温湿DHT11.png","MQ-4天然气.jpg","GY30光照传感器.jpg","人体红外线感应模块HC-SR501.jpg","烟雾及可燃气体检测模块MQ-2.png"};
    public static String devicedescription[]={"DHT11数字温湿度传感器是一款含有已校准数字信号输出的温湿度复合传感器。它应用专用的数字模块采集技术和温湿度传感技术，确保产品具有极高的可靠性与卓越的长期稳定性。传感器包括一个电阻式感湿元件和一个NTC测温元件，并与一个高性能8位单片机相连接。因此该产品具有品质卓越、超快响应、抗干扰能力强、性价比极高等优点。每个DHT11传感器都在极为精确的湿度校验室中进行校准。校准系数以程序的形式储存在OTP内存中，传感器内部在检测信号的处理过程中要调用这些校准系数。单线制串行接口，使系统集成变得简易快捷。超小的体积、极低的功耗，信号传输距离可达20米以上，使其成为各类应用甚至最为苛刻的应用场合的最佳选则。产品为4针单排引脚封装。连接方便，特殊封装形式可根据用户需求而提供。",
            "mq-4气体传感器所使用的气敏材料是在清洁空气中电导率较低的二氧化锡(sno2)。当传感器所处环境中存在可燃气体时，传感器的电导率随空气中可燃气体浓度的增加而增大。使用简单的电路即可将电导率的变化转换为与该气体浓度相对应的输出信号。 mq-4气体传感器对甲烷的灵敏度高，对丙烷、丁烷也有较好的灵敏度。这种传感器可检测多种可燃性气体，特别是天然气，是一款适合多种应用的低成本传感器。模块应用：适用于家庭或工厂的甲烷气体，天然气等监测装置，可测试天然气、甲烷 300 to 10000ppm.",
            "环境光传感器 模拟光照强度模块 可见光传感器TEMT6000感应器高灵敏度为 570nm，其具有±60°的较宽半灵敏度角度。尽管该器件对环境光非常敏感，但它可抑制红外线 (IR) 光谱，从而可提供类似“人眼”的更高可见光谱响应性。",
            "HC-SR501是一个红外线感应模块，它依靠特定温度（36-38）的物体运动来判断人体。因此可以作为报警器的关键模块。在关键的地方，如门口，放上这么一个传感器，可以起到防盗的作用。它有两个调节旋钮，一个调节最远探测距离，一个调节延时时间，具体参数如上。当人走过或停留在感应范围中，模块通过D0发送高电平信号。",
            "MQ-2是一个烟雾感应模块，原理是用针对特殊气体或微粒敏感的电阻来判断是否存在可燃气体或烟雾颗粒。输出有两种方式，A0口输出当前特殊气体含量参考值（0-1023），基本上100以下的示数为正常。D0口根据预先设定的参考值的阈值输出高电平或低电平信号。可以作为液化气泄漏的预警装置，也可以作为判断火灾的辅助。"

          };
    public static String facatorys[]={"telesky旗舰店" ,"gopx","CHTBO","ST宇时先锋","C－Lin/欣灵电气"+"TMAZTZ"+"TWIDEC"+"鹰都"+"TQidec"+"freud"+"MIRAN"+"西德宝菲"+"ESPE/意普"+"韩姆"+"巨勒"+"BONDHUS"+"定宸云辉"+"Crosselec/凯诺思"+"森骊照明"};
    /**
     * 初始化只有五个参数值
     * */
    public List<Device> getDevice(int size){
        if(size>5)
            size=5;
        List<Device>devices=new ArrayList<>(size);
        Random random=new Random();
        for(int i=0;i<size;i++){
            Device device=new Device();
            device.setDevicename(name[i]);
            device.setDeviceurl(deviceurl[i]);
            device.setDescription(devicedescription[i]);
            device.setFactory(facatorys[i]);
            device.setPrice(random.nextInt(20)+5);
            device.setCreatedate(new Date());
            devices.add(device);
            logger.info(devices.get(i).toString());

        }
        return devices;
    }
}
