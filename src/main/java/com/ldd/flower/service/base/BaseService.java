package com.ldd.flower.service.base;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;

/**
 * @Author liudongdong
 * @Date Created in 14:48 2019/9/5
 * @Description
 */
public interface BaseService <T, ID extends Serializable> {

    List<T> findAll();

    List<T> findAll(Sort sort);

    List<T> findAll(Iterable<ID> ids);

    T findById(ID id);

    <S extends T> List<S> save(Iterable<S> entities);

    <S extends T> S saveAndFlush(S entity);

    <S extends T> void delete(S entity);

    void deleteInBatch(Iterable<T> entities);

    <S extends T> List<S> findAll(Example<S> example);

    <S extends T> List<S> findAll(Example<S> example, Sort sort);

    Page<T> findAll(Pageable pageable);

    boolean exitById(ID id);
}
