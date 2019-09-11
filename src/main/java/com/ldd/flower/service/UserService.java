package com.ldd.flower.service;

import com.ldd.flower.entity.User;
import com.ldd.flower.service.base.BaseService;

import java.util.List;

/**
 * @Author liudongdong
 * @Date Created in 14:39 2019/9/5
 * @Description
 */

public interface UserService extends BaseService<User,Long> {
    User updateUser(User user);
    User findByUsername(String username);
    public String login(User user);
    List<User> findUsersByRole(String role);
    String deleteUserById(long id);
}
