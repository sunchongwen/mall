package com.imooc.mall.service;

import com.imooc.mall.dao.UserMapper;
import com.imooc.mall.enums.RoleEnum;
import com.imooc.mall.pojo.User;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

import static com.imooc.mall.enums.ResponseEnum.*;

@Slf4j
@Service
public class IUserServiceImp implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public ResponseVo<User> register(User user){
        user.setRole(RoleEnum.CUSTOMER.getCode());
        int countByUsername = userMapper.countByUsername(user.getUsername());
        if (countByUsername>0) {
//            return USER_EXIST;
            return ResponseVo.error(USER_EXIST); }
        int countByEmail = userMapper.countByEmail(user.getEmail());
        if (countByEmail>0) { return ResponseVo.error(EMAIL_EXIST); }
        int insertSelective = userMapper.insertSelective(user);
        if (insertSelective==0) { return ResponseVo.error(ERROR); }
        return ResponseVo.success();
    }
    @Override
    public ResponseVo<User> login(String username,String password) {
        User user = userMapper.selectByUsername(username);
        if (user==null) {
            return ResponseVo.error(USERNAME_ERROR_OR_PASSWORD_ERROR);
        }
        String md5DigestAsHexPassword = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        if(user.getPassword().equalsIgnoreCase(md5DigestAsHexPassword)){
            return ResponseVo.error(USERNAME_ERROR_OR_PASSWORD_ERROR);
        }
        return ResponseVo.success(user);
    }
}
