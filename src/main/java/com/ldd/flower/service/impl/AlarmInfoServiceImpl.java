package com.ldd.flower.service.impl;

import com.ldd.flower.entity.AlarmInfo;
import com.ldd.flower.repository.AlarmInfoRepository;
import com.ldd.flower.service.AlarmInfoService;
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
 * @Date Created in 10:57 2019/9/6
 * @Description
 */
@Service("alarmInfoService")  /*  使用时@Autowired private AlarmInfoService alarmInfoService*/
public class AlarmInfoServiceImpl implements AlarmInfoService {
    @Autowired
    private AlarmInfoRepository alarmInfoRepository;
    @Override
    public List<AlarmInfo> findAlarmInfosByDeviceId(long id) {
        return alarmInfoRepository.findAlarmInfosByDeviceId(id);
    }

    @Override
    public List<AlarmInfo> findAll() {
        return alarmInfoRepository.findAll();
    }

    @Override
    public List<AlarmInfo> findAll(Sort sort) {
        return alarmInfoRepository.findAll(sort);
    }

    @Override
    public List<AlarmInfo> findAll(Iterable<Long> longs) {
        return alarmInfoRepository.findAllById(longs);
    }

    @Override
    public AlarmInfo findById(Long aLong) {
        return alarmInfoRepository.findAlarmInfoById(aLong);
    }

    @Override
    public <S extends AlarmInfo> List<S> save(Iterable<S> entities) {
        return alarmInfoRepository.saveAll(entities);
    }

    @Override
    public <S extends AlarmInfo> S saveAndFlush(S entity) {
        if(entity.getCreatedate()==null)
            entity.setCreatedate(new Date());
        return alarmInfoRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends AlarmInfo> void delete(S entity) {
        alarmInfoRepository.delete(entity);
    }

    @Override
    public void deleteInBatch(Iterable<AlarmInfo> entities) {
        alarmInfoRepository.deleteInBatch(entities);
    }

    @Override
    public <S extends AlarmInfo> List<S> findAll(Example<S> example) {
        return alarmInfoRepository.findAll(example);
    }

    @Override
    public <S extends AlarmInfo> List<S> findAll(Example<S> example, Sort sort) {
        return alarmInfoRepository.findAll(example,sort);
    }

    @Override
    public Page<AlarmInfo> findAll(Pageable pageable) {
        return alarmInfoRepository.findAll(pageable);
    }

    @Override
    public boolean exitById(Long aLong) {
        return alarmInfoRepository.existsById(aLong);
    }
}
