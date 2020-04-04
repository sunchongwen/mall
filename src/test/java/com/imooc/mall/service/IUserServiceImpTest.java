package com.imooc.mall.service;

import com.imooc.mall.MallApplicationTests;
import com.imooc.mall.enums.RoleEnum;
import com.imooc.mall.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class IUserServiceImpTest extends MallApplicationTests {
    @Autowired
    private IUserService iUserService;



    @Test
    public void register() {
        User user =new User("test6","123456","5556766@qq.com", RoleEnum.CUSTOMER.getCode());

        iUserService.register(user);

    }
}