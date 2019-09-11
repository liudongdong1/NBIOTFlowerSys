package com.ldd.flower.service;

import com.ldd.flower.entity.Flower;
import com.ldd.flower.entity.User;
import com.ldd.flower.service.base.BaseService;

import java.util.List;

/**
 * @Author liudongdong
 * @Date Created in 15:37 2019/9/6
 * @Description
 */
public interface FlowerService  extends BaseService<Flower,Long> {
    List<Flower> findFlowersByName(String name);
    List<Flower> findFlowersByType(String type);
}
