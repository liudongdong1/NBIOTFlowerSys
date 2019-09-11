package com.ldd.flower.repository;

import com.ldd.flower.entity.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author liudongdong
 * @Date Created in 10:03 2019/9/6
 * @Description
 */
@Repository
public interface FlowerRepository extends JpaRepository<Flower,Long> {
    Flower findFlowerById(long id);
    List<Flower> findFlowersByName(String name);
    List<Flower> findFlowersByType(String type);
}
