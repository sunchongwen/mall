package com.imooc.mall.controller;

import com.imooc.mall.form.UserForm;
import com.imooc.mall.form.UserLoginForm;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IUserServiceImp;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Objects;

import static com.imooc.mall.enums.ResponseEnum.NEED_LOGIN;
import static com.imooc.mall.enums.ResponseEnum.PARAM_ERROR;

@Slf4j
//restcontroller 作用就是任何return 的结果自动转化威json格式返回
@RestController
//requestmapping post和request 都可以
//@RequestMapping("/user")
public class UserController {
//只能post 使用
    @Autowired
    IUserServiceImp iUserServiceImp;
    @PostMapping("/user/register")
    public ResponseVo register(@Valid @RequestBody UserForm userForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.info("注册提交参数有误 {} {}", bindingResult.getFieldError(), Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            return ResponseVo.error(PARAM_ERROR,bindingResult);
        }
        User user =new User();
        BeanUtils.copyProperties(userForm,user);
        return iUserServiceImp.register(user);
    }
    @PostMapping("/user/login")
    public ResponseVo<User> login(@Valid @RequestBody UserLoginForm userLoginForm, BindingResult bindingResult, HttpSession session){
        if(bindingResult.hasErrors()){
            return ResponseVo.error(PARAM_ERROR,bindingResult);
        }
        ResponseVo<User> userResponseVo= iUserServiceImp.login(userLoginForm.getUsername(),userLoginForm.getPassword());
        session.setAttribute("currentUser",userResponseVo.getData());
        return  userResponseVo;
    }
    @GetMapping("/user")
    public ResponseVo<User> userInfo(HttpSession session){
        User currentUser = (User) session.getAttribute("currentUser");
        if(currentUser==null){
            return  ResponseVo.error(NEED_LOGIN);
        }
        return ResponseVo.success(currentUser);
    }

}
