package com.ldd.flower.repository;

import com.ldd.flower.entity.SensorInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Author liudongdong
 * @Date Created in 10:00 2019/9/6
 * @Description
 */
@Repository
public interface SensorInfoRepository extends JpaRepository<SensorInfo,Long> {
    SensorInfo findSensorInfoById(long id);
    List<SensorInfo> findSensorInfosByMonitorid(long id);
    List<SensorInfo> findSensorInfosByType(String type);
    List<SensorInfo> findSensorInfosByCreatedateAfter(Date date);
    List<SensorInfo> findSensorInfosByCreatedateBetween(Date begin,Date end);

}
