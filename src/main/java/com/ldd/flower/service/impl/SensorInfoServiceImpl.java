package com.ldd.flower.service.impl;

import com.ldd.flower.entity.SensorInfo;
import com.ldd.flower.repository.SensorInfoRepository;
import com.ldd.flower.service.SensorInfoService;
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
 * @Date Created in 15:58 2019/9/6
 * @Description
 */
@Service("sensorInforService")
public class SensorInfoServiceImpl implements SensorInfoService {
    @Autowired
    private SensorInfoRepository sensorInfoRepository;


    @Override
    public List<SensorInfo> findSensorInfosByMonitorid(long id) {
        return sensorInfoRepository.findSensorInfosByMonitorid(id);
    }

    @Override
    public List<SensorInfo> findSensorInfosByType(String type) {
        return sensorInfoRepository.findSensorInfosByType(type);
    }

    @Override
    public List<SensorInfo> findSensorInfosByCreatedateAfter(Date date) {
        return sensorInfoRepository.findSensorInfosByCreatedateAfter(date);
    }

    @Override
    public List<SensorInfo> findSensorInfosByCreatedateBetween(Date begin, Date end) {
        return sensorInfoRepository.findSensorInfosByCreatedateBetween(begin,end);
    }

    @Override
    public List<SensorInfo> findAll() {
        return sensorInfoRepository.findAll();
    }

    @Override
    public List<SensorInfo> findAll(Sort sort) {
        return sensorInfoRepository.findAll(sort);
    }

    @Override
    public List<SensorInfo> findAll(Iterable<Long> longs) {
        return sensorInfoRepository.findAllById(longs);
    }

    @Override
    public SensorInfo findById(Long aLong) {
        return sensorInfoRepository.findSensorInfoById(aLong);
    }

    @Override
    public <S extends SensorInfo> List<S> save(Iterable<S> entities) {
        return sensorInfoRepository.saveAll(entities);
    }

    @Override
    public <S extends SensorInfo> S saveAndFlush(S entity) {
        return sensorInfoRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends SensorInfo> void delete(S entity) {
        sensorInfoRepository.delete(entity);
    }

    @Override
    public void deleteInBatch(Iterable<SensorInfo> entities) {
        sensorInfoRepository.deleteInBatch(entities);
    }

    @Override
    public <S extends SensorInfo> List<S> findAll(Example<S> example) {
        return sensorInfoRepository.findAll(example);
    }

    @Override
    public <S extends SensorInfo> List<S> findAll(Example<S> example, Sort sort) {
        return sensorInfoRepository.findAll(example,sort);
    }

    @Override
    public Page<SensorInfo> findAll(Pageable pageable) {
        return sensorInfoRepository.findAll(pageable);
    }

    @Override
    public boolean exitById(Long aLong) {
        return sensorInfoRepository.existsById(aLong);
    }
}
