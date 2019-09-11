package com.ldd.flower.service;

import com.ldd.flower.entity.Monitor;
import com.ldd.flower.service.base.BaseService;

import java.util.List;

/**
 * @Author liudongdong
 * @Date Created in 16:11 2019/9/6
 * @Description
 */
public interface MonitorService extends BaseService<Monitor,Long> {
    List<Monitor> findMonitorsByStates(boolean state);
    List<Monitor> findMonitorsByUserid(long id);
    Monitor findMonitorByName(String name);
}
