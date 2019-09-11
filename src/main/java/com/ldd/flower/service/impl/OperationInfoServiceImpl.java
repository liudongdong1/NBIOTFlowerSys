package com.ldd.flower.service.impl;

import com.ldd.flower.entity.OperationInfo;
import com.ldd.flower.repository.OperationInfoRepository;
import com.ldd.flower.service.OperationInfoService;
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
 * @Date Created in 10:38 2019/9/6
 * @Description
 */
@Service("operationInfoService")
public class OperationInfoServiceImpl implements OperationInfoService {

    @Autowired
    private OperationInfoRepository operationInfoRepository;
    @Override
    public List<OperationInfo> findAll() {
        return operationInfoRepository.findAll();
    }

    @Override
    public List<OperationInfo> findAll(Sort sort) {
        return operationInfoRepository.findAll(sort);
    }

    @Override
    public List<OperationInfo> findAll(Iterable<Long> longs) {
        return operationInfoRepository.findAllById(longs);
    }

    @Override
    public OperationInfo findById(Long aLong) {
        return operationInfoRepository.findOperationInfoById(aLong);
    }

    @Override
    public <S extends OperationInfo> List<S> save(Iterable<S> entities) {
        return operationInfoRepository.saveAll(entities);
    }

    @Override
    public <S extends OperationInfo> S saveAndFlush(S entity) {
        if(entity.getCreatedate()==null)
            entity.setCreatedate(new Date());
        return operationInfoRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends OperationInfo> void delete(S entity) {
        operationInfoRepository.delete(entity);
    }

    @Override
    public void deleteInBatch(Iterable<OperationInfo> entities) {
        operationInfoRepository.deleteInBatch(entities);
    }

    @Override
    public <S extends OperationInfo> List<S> findAll(Example<S> example) {
        return operationInfoRepository.findAll(example);
    }

    @Override
    public <S extends OperationInfo> List<S> findAll(Example<S> example, Sort sort) {
        return operationInfoRepository.findAll(example,sort);
    }

    @Override
    public Page<OperationInfo> findAll(Pageable pageable) {
        return operationInfoRepository.findAll(pageable);
    }

    @Override
    public boolean exitById(Long aLong) {
        return operationInfoRepository.existsById(aLong);
    }

    @Override
    public List<OperationInfo> findOperationInfosByDeviceid(long id) {
        return operationInfoRepository.findOperationInfosByDeviceid(id);
    }

    @Override
    public List<OperationInfo> findOperationInfosByUserid(long id) {
        return findOperationInfosByUserid(id);
    }
}
