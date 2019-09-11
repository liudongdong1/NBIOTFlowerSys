package com.ldd.flower.repository;

import com.ldd.flower.entity.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author liudongdong
 * @Date Created in 10:04 2019/9/6
 * @Description
 */
@Repository
public interface MonitorRepository extends JpaRepository<Monitor,Long> {
    Monitor findMonitorById(long id);
    List<Monitor> findMonitorsByStates(boolean state);
    List<Monitor> findMonitorsByUserid(long id);
    Monitor findMonitorByName(String name);
}
