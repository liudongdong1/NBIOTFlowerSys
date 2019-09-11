package com.ldd.flower.service.impl;

import com.ldd.flower.common.UserInitData;
import com.ldd.flower.entity.User;
import com.ldd.flower.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.*;

/**
 * @Author liudongdong
 * @Date Created in 19:42 2019/9/6
 * @Description
 */

@RunWith(SpringJUnit4ClassRunner.class)             //
@SpringBootTest
public class UserServiceImplTest {
    private Logger logger= Logger.getLogger("UserServiceTest");
    @Autowired
    private UserService userService;
    @Test
    public void updateUser() {
        /*id=268, username='张园博', password='123456', salt='123456', role='管理员', tel='1785412884'*/
        User user=userService.findByUsername("刘冬冬");
        logger.info("update_before:"+user.toString());
        user.setAddress("山东省淄博市");
        User user2=userService.updateUser(user);
        logger.info("update_after:"+user2.toString());
        User user1=userService.findById((long) 268);
        logger.info("findByid:"+user.toString());

        assertEquals("123456",userService.findByUsername("张园博").getPassword());
    }


    @Test
    public void findAll() {
        List<User> userList=userService.findAll();
        assertEquals(91,userList.size());
        Pageable pageable = new PageRequest(0,3);
        Page<User> userPage=userService.findAll(pageable);
        for(User temp:userPage)
            logger.info(temp.toString());
    }

    @Test
    public void findById() {

        List<User> userPage=userService.findAll();
        User user=userPage.get(0);
        logger.info("usertoFind:"+userPage.get(0).toString());
        logger.info("id--"+user.getId()+"--");
        User user1=userService.findById(user.getId());
        logger.info("fingbyid_afert"+user1.toString());
        logger.info("findbyname_before:"+user.toString());
        logger.info("id--"+user.getUsername()+"--");
        User user2=userService.findByUsername(user.getUsername());
        logger.info("findBynameAfter:"+user2.toString());
        /*logger.info(user.toString());*/
       /*  assertEquals(" 王博",user.getUsername());*/
    }

    @Test
    public void save() {
        User user=new UserInitData().getUsers(1).get(0);
        logger.info("save_before:"+user.toString());
        String name=user.getUsername();
        User user1=userService.saveAndFlush(user);
        logger.info("save_after:"+user1.toString());
        User user2=userService.findById(user1.getId());
        assertEquals(true,userService.exitById(user2.getId()));
    }

    @Test
    public void saveAndFlush() {
        userService.save(new UserInitData().getUsers(89));
    }

    @Test
    public void delete() {
    }

    @Test
    public void exitById() {
    }
}