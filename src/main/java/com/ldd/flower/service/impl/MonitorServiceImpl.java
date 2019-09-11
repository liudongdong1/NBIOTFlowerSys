package com.ldd.flower.service.impl;

import com.ldd.flower.entity.Monitor;
import com.ldd.flower.repository.MonitorRepository;
import com.ldd.flower.service.MonitorService;
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
 * @Date Created in 16:12 2019/9/6
 * @Description
 */
@Service("moniterService")
public class MonitorServiceImpl implements MonitorService {
    @Autowired
    private MonitorRepository monitorRepository;

    @Override
    public List<Monitor> findMonitorsByStates(boolean state) {
        return monitorRepository.findMonitorsByStates(state);
    }

    @Override
    public List<Monitor> findMonitorsByUserid(long id) {
        return monitorRepository.findMonitorsByUserid(id);
    }

    @Override
    public Monitor findMonitorByName(String name) {
        return monitorRepository.findMonitorByName(name);
    }


    @Override
    public List<Monitor> findAll() {
        return monitorRepository.findAll();
    }

    @Override
    public List<Monitor> findAll(Sort sort) {
        return monitorRepository.findAll(sort);
    }

    @Override
    public List<Monitor> findAll(Iterable<Long> longs) {
        return monitorRepository.findAllById(longs);
    }

    @Override
    public Monitor findById(Long aLong) {
        return monitorRepository.findMonitorById(aLong);
    }

    @Override
    public <S extends Monitor> List<S> save(Iterable<S> entities) {
        return monitorRepository.saveAll(entities);
    }

    @Override
    public <S extends Monitor> S saveAndFlush(S entity) {
        if(entity.getCreatedate()==null)
            entity.setCreatedate(new Date());
        return monitorRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends Monitor> void delete(S entity) {
        monitorRepository.delete(entity);
    }

    @Override
    public void deleteInBatch(Iterable<Monitor> entities) {
        monitorRepository.deleteInBatch(entities);
    }

    @Override
    public <S extends Monitor> List<S> findAll(Example<S> example) {
        return monitorRepository.findAll(example);
    }

    @Override
    public <S extends Monitor> List<S> findAll(Example<S> example, Sort sort) {
        return monitorRepository.findAll(example,sort);
    }

    @Override
    public Page<Monitor> findAll(Pageable pageable) {
        return monitorRepository.findAll(pageable);
    }

    @Override
    public boolean exitById(Long aLong) {
        return monitorRepository.existsById(aLong);
    }
}
