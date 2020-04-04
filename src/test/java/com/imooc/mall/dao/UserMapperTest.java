package com.imooc.mall.dao;

import com.imooc.mall.MallApplicationTests;
import com.imooc.mall.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.junit.Assert.*;
@Slf4j
public class UserMapperTest extends MallApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectByUsername() {
        int result =userMapper.countByEmail("593091614@qq.com");
        if(result>0){
            log.info("result succesfful");
        }


    }

    @Test
    public void selectByEmail() {
        int result =userMapper.countByUsername("jack");
        if (result>0) {
            log.info("username successfull");
        }
    }

    @Test
    public void testSelectByUsername() {
        User user =userMapper.selectByUsername("jack");
        if (user!=null) {
            String password = user.getPassword();
            log.info(password+"---------petertest");
        }
    }
}