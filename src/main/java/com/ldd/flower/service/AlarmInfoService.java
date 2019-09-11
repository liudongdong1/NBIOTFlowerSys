package com.ldd.flower.service;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.ldd.flower.entity.AlarmInfo;
import com.ldd.flower.service.base.BaseService;

import java.util.List;

/**
 * @Author liudongdong
 * @Date Created in 10:50 2019/9/6
 * @Description
 */
public interface AlarmInfoService extends BaseService<AlarmInfo,Long> {
    List<AlarmInfo> findAlarmInfosByDeviceId(long id);
}
