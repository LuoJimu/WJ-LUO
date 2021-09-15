package com.evan.sanhei.service.Impl;

import com.evan.sanhei.dao.UserDAO;
import com.evan.sanhei.model.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
