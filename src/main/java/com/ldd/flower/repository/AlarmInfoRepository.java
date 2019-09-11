package com.ldd.flower.repository;

import com.ldd.flower.entity.AlarmInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author liudongdong
 * @Date Created in 10:02 2019/9/6
 * @Description
 */
@Repository
public interface AlarmInfoRepository extends JpaRepository<AlarmInfo,Long> {
    List<AlarmInfo> findAlarmInfosByDeviceId(long id);
    AlarmInfo findAlarmInfoById(long id);
}
