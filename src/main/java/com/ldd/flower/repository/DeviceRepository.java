package com.ldd.flower.repository;

import com.ldd.flower.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author liudongdong
 * @Date Created in 10:06 2019/9/6
 * @Description
 */
public interface DeviceRepository extends JpaRepository<Device,Long> {
    List<Device> findDeviceByDevicename(String name);
    Device findDeviceById(long id);
}
