package com.ldd.flower.service;

import com.ldd.flower.entity.Device;
import com.ldd.flower.service.base.BaseService;

import java.util.List;

/**
 * @Author liudongdong
 * @Date Created in 10:09 2019/9/6
 * @Description
 */
public interface DeviceService extends BaseService<Device,Long> {
    public List<Device> findByName(String name);

}
