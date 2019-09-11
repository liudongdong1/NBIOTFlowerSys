package com.ldd.flower.service.impl;

import com.ldd.flower.entity.Flower;
import com.ldd.flower.repository.FlowerRepository;
import com.ldd.flower.service.FlowerService;
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
 * @Date Created in 15:39 2019/9/6
 * @Description
 */
@Service("flowerService")
public class FlowerServiceImpl implements FlowerService {
    @Autowired
    private FlowerRepository flowerRepository;


    @Override
    public List<Flower> findFlowersByName(String name) {
        return flowerRepository.findFlowersByName(name);
    }

    @Override
    public List<Flower> findFlowersByType(String type) {
        return flowerRepository.findFlowersByType(type);

    }
    @Override
    public List<Flower> findAll() {
        return flowerRepository.findAll();
    }

    @Override
    public List<Flower> findAll(Sort sort) {
        return flowerRepository.findAll(sort);
    }

    @Override
    public List<Flower> findAll(Iterable<Long> longs) {
        return flowerRepository.findAllById(longs);
    }

    @Override
    public Flower findById(Long aLong) {
        return flowerRepository.findFlowerById(aLong);
    }

    @Override
    public <S extends Flower> List<S> save(Iterable<S> entities) {
        return flowerRepository.saveAll(entities);
    }

    @Override
    public <S extends Flower> S saveAndFlush(S entity) {
        if(entity.getCreatedate()==null)
            entity.setCreatedate(new Date());
        return flowerRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends Flower> void delete(S entity) {
        flowerRepository.delete(entity);
    }

    @Override
    public void deleteInBatch(Iterable<Flower> entities) {
        flowerRepository.deleteInBatch(entities);
    }

    @Override
    public <S extends Flower> List<S> findAll(Example<S> example) {
        return flowerRepository.findAll(example);
    }

    @Override
    public <S extends Flower> List<S> findAll(Example<S> example, Sort sort) {
        return flowerRepository.findAll(example,sort);
    }

    @Override
    public Page<Flower> findAll(Pageable pageable) {
        return flowerRepository.findAll(pageable);
    }

    @Override
    public boolean exitById(Long aLong) {
        return flowerRepository.existsById(aLong);
    }
}
