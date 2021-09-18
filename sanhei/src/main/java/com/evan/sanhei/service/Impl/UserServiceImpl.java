package com.evan.sanhei.service.Impl;

import com.evan.sanhei.dao.UserDAO;
import com.evan.sanhei.model.vo.UserVO;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

/**
 * @program: WJ-LUO
 * @description: 登录
 * @author: Jimu.Luo
 * @create: 2021-08-31 10:35
 **/

@Service
public class UserServiceImpl {

    @Autowired
    UserDAO userDAO;

    //判断是否存在该用户名
    public boolean isExist(String username) {
        UserVO userVO = getByName(username);
        return null!=userVO;
    }

    //findByUsername，就是通过 username 字段查询到对应的行，并返回给 User 类
    public UserVO getByName(String username) {
        return userDAO.findByUsername(username);
    }

    //通过用户名及密码查询到对应的行，并返回给 User 类
    public UserVO get(String username, String password){
        return userDAO.getByUsernameAndPassword(username, password);
    }

    public void add(UserVO userVO) {
        userDAO.save(userVO);
    }

    //用户注册20210916
    public int register(UserVO userVO) {
        String username = userVO.getUsername();
        String name = userVO.getName();
        String phone = userVO.getPhone();
        String email = userVO.getEmail();
        String password = userVO.getPassword();

        username = HtmlUtils.htmlEscape(username);
        userVO.setUsername(username);
        name = HtmlUtils.htmlEscape(name);
        userVO.setName(name);
        phone = HtmlUtils.htmlEscape(phone);
        userVO.setPhone(phone);
        email = HtmlUtils.htmlEscape(email);
        userVO.setEmail(email);
//        userVO.setEnabled(true);

        if (username.equals("") || password.equals("")) {
            return 0;
        }
        boolean exist = isExist(username);
        if (exist) {
            return 2;
        }
        // 生成盐,默认长度 16 位
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        // 设置 hash 算法迭代次数
        int times = 2;
        // 得到 hash 后的密码
        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();
        // 存储用户信息，包括 salt 与 hash 后的密码
        userVO.setSalt(salt);
        userVO.setPassword(encodedPassword);

        userDAO.save(userVO);
        return 1;
    }

}
