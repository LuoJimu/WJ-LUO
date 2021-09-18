package com.evan.sanhei.controller;

import com.evan.sanhei.model.ro.ResultFactoryRO;
import com.evan.sanhei.model.ro.ResultRO;
import com.evan.sanhei.model.vo.UserVO;
import com.evan.sanhei.service.Impl.UserServiceImpl;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//import javax.servlet.http.HttpSession;

/**
 * @program: sanhei
 * @description: 登录用户controller
 * @author: Jimu.Luo
 * @create: 2021-01-16 18:44
 **/

@Controller
@Api(tags = "用户登录")
@RestController
@Validated
public class LoginController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @CrossOrigin //解决跨域问题
    @PostMapping(value = "/WJ-LUO/login")
    @ResponseBody
    public ResultRO login(@RequestBody UserVO requestUser) {

        String username = requestUser.getUsername();
        Subject subject = SecurityUtils.getSubject();
//        subject.getSession().setTimeout(10000);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, requestUser.getPassword());
        try {
            //我们只需要调用一句 subject.login(usernamePasswordToken) 就可以执行密码验证
            subject.login(usernamePasswordToken);
            return ResultFactoryRO.buildSuccessResult(username);
        } catch (AuthenticationException e) {
            String message = "账号密码错误";
            return ResultFactoryRO.buildFailResult(message);
        }

    }

    @PostMapping("/WJ-LUO/register")
    @ResponseBody
    public ResultRO register(@RequestBody UserVO userVO) {

        int status = userServiceImpl.register(userVO);
        switch (status) {
            case 0:
                return ResultFactoryRO.buildFailResult("用户名和密码不能为空");
            case 1:
                return ResultFactoryRO.buildSuccessResult("注册成功");
            case 2:
                return ResultFactoryRO.buildFailResult("用户已存在");
        }
        return ResultFactoryRO.buildFailResult("未知错误");
    }

//    20210816注释
 /*   @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public ResultRO login(@RequestBody UserVO requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        if (!Objects.equals("admin", username) || !Objects.equals("123456", requestUser.getPassword())) {
            String message = "账号密码错误";
            System.out.println("test");
            return new ResultRO(400);
        } else {
            return new ResultRO(200);
        }
    }*/

}
