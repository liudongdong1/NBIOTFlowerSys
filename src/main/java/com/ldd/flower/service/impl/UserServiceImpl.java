package com.ldd.flower.service.impl;

import com.ldd.flower.entity.User;
import com.ldd.flower.repository.UserRepository;
import com.ldd.flower.service.UserService;
import com.ldd.flower.util.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * @Author liudongdong
 * @Date Created in 14:52 2019/9/5
 * @Description
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private Logger logger= Logger.getLogger("UserServiceImpl");
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordHelper passwordHelper;

    @Override
    public User updateUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public String login(User user) {
        String message="";
        logger.info(user.getUsername());
        User user1=userRepository.findUserByUsername(user.getUsername());
        logger.info(user1.toString());
        if(user1!=null){
            if(!user1.getPassword().equals(user.getPassword())){
                message="密码错误";
            }
            else{
                message="登录成功"+user1.getUsername();
            }
        }
        else{
            message="用户名不存在";
        }
        return message;
    }

    @Override
    public List<User> findUsersByRole(String role) {
        return userRepository.findUsersByRole(role);
    }

    @Override
    public String deleteUserById(long id) {
        userRepository.deleteUserById(id);
        return "删除成功";
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAll(Sort sort) {
        return userRepository.findAll(sort);
    }

    @Override
    public List<User> findAll(Iterable<Long> ids) {
        return userRepository.findAllById(ids);
    }

    @Override
    public User findById(Long aLong) {
        /**
         * findOne(id);这个是老版本api
         * */
        return userRepository.findById(aLong).get();
    }

    @Override
    public <S extends User> List<S> save(Iterable<S> entities) {
        /**
         * Todo 加密权限管理，待完善 finished
         * */
     /*   for(User u:entities) {
            passwordHelper.encryptPassword(u);
            u.setCreate_date(new Date());
        }*/
        return userRepository.saveAll(entities);
    }

    @Override
    public <S extends User> S saveAndFlush(S entity) {
        /**
         * Todo 加密权限管理，待完善 finished
         * */
    /*    passwordHelper.encryptPassword(entity);
        entity.setCreate_date(new Date());*/
        if(entity.getCreate_date()==null)
            entity.setCreate_date(new Date());
        return userRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends User> void delete(S entity) {
        userRepository.delete(entity);
    }

    @Override
    public void deleteInBatch(Iterable<User> entities) {
        userRepository.deleteInBatch(entities);
    }

    @Override
    public <S extends User> List<S> findAll(Example<S> example) {
        return userRepository.findAll(example);
    }

    @Override
    public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
        return userRepository.findAll(example,sort);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public boolean exitById(Long aLong) {
        return userRepository.existsById(aLong);
    }
}
