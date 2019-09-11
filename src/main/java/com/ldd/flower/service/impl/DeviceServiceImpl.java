package com.ldd.flower.service.impl;

import com.ldd.flower.entity.Device;
import com.ldd.flower.repository.DeviceRepository;
import com.ldd.flower.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author liudongdong
 * @Date Created in 10:15 2019/9/6
 * @Description
 */
@Service("deviceService")
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;
    @Override
    public List<Device> findByName(String name) {
        return deviceRepository.findDeviceByDevicename(name);
    }

    @Override
    public List<Device> findAll() {
        return deviceRepository.findAll();
    }

    @Override
    public List<Device> findAll(Sort sort) {
        return deviceRepository.findAll(sort);
    }

    @Override
    public List<Device> findAll(Iterable<Long> longs) {
        return deviceRepository.findAllById(longs);
    }

    @Override
    public Device findById(Long aLong) {
        return deviceRepository.findDeviceById(aLong);
    }

    @Override
    public <S extends Device> List<S> save(Iterable<S> entities) {

        return deviceRepository.saveAll(entities);
    }

    @Override
    public <S extends Device> S saveAndFlush(S entity) {
        if(entity.getCreatedate()==null)
            entity.setCreatedate(new Date());
        return deviceRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends Device> void delete(S entity) {
        deviceRepository.delete(entity);
    }

    @Override
    public void deleteInBatch(Iterable<Device> entities) {
        deviceRepository.deleteInBatch(entities);
    }

    @Override
    public <S extends Device> List<S> findAll(Example<S> example) {
        return deviceRepository.findAll(example);
    }

    @Override
    public <S extends Device> List<S> findAll(Example<S> example, Sort sort) {
        return deviceRepository.findAll(example,sort);
    }

    @Override
    public Page<Device> findAll(Pageable pageable) {
        return deviceRepository.findAll(pageable);
    }

    @Override
    public boolean exitById(Long aLong) {
        return deviceRepository.existsById(aLong);
    }
}
