package com.ldd.flower.repository;

import com.ldd.flower.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @Author liudongdong
 * @Date Created in 14:17 2019/9/5
 * @Description
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    User findUserByUsername(String name);
    List<User>findUsersByRole(String role);
    void deleteUserById(long id);


  /*  @Modifying
    @Transactional
    @Query("delete from sys_user where userid = ?1")
    int deleteUserById(Long userid) ;*/


}
