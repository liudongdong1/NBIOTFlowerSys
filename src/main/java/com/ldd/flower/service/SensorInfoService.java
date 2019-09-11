package com.ldd.flower.service;

import com.ldd.flower.entity.SensorInfo;
import com.ldd.flower.service.base.BaseService;

import java.util.Date;
import java.util.List;

/**
 * @Author liudongdong
 * @Date Created in 15:55 2019/9/6
 * @Description
 */
public interface SensorInfoService extends BaseService<SensorInfo,Long> {

    List<SensorInfo> findSensorInfosByMonitorid(long id);
    List<SensorInfo> findSensorInfosByType(String type);
    List<SensorInfo> findSensorInfosByCreatedateAfter(Date date);
    List<SensorInfo> findSensorInfosByCreatedateBetween(Date begin,Date end);
}
