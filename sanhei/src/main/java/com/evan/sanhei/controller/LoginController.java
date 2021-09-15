package com.evan.sanhei.controller;

import com.evan.sanhei.model.ro.ResultRO;
import com.evan.sanhei.model.vo.UserVO;
import com.evan.sanhei.service.Impl.UserServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

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

        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        UserVO userVO = userServiceImpl.get(username, requestUser.getPassword());
        if (null == userVO) {
            return new ResultRO(400);
        } else {
            //后端拦截器,但这种拦截器只有在将前后端项目整合在一起时才能生效，而前后端分离的项目实际上不推荐这么做
//            session.setAttribute("user", user);
            return new ResultRO(200);
        }
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
