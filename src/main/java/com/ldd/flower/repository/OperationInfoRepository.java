package com.ldd.flower.repository;

import com.ldd.flower.entity.OperationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author liudongdong
 * @Date Created in 10:01 2019/9/6
 * @Description
 */
public interface OperationInfoRepository extends JpaRepository<OperationInfo,Long> {
    List<OperationInfo> findOperationInfosByDeviceid(long id);
    List<OperationInfo>findOperationInfosByUserid(long id);
    OperationInfo findOperationInfoById(long id);
}
