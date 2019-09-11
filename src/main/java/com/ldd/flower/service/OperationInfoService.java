package com.ldd.flower.service;

import com.ldd.flower.entity.OperationInfo;
import com.ldd.flower.service.base.BaseService;

import java.util.List;

/**
 * @Author liudongdong
 * @Date Created in 10:14 2019/9/6
 * @Description
 */
public interface OperationInfoService extends BaseService<OperationInfo,Long> {
    List<OperationInfo> findOperationInfosByDeviceid(long id);
    List<OperationInfo>findOperationInfosByUserid(long id);
}
