package com.evan.sanhei.dao;

import com.evan.sanhei.model.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserDAO extends JpaRepository<UserVO,Integer> {

    //findByUsername，就是通过 username 字段查询到对应的行，并返回给 User 类
    UserVO findByUsername(String userid);
    //通过用户名及密码查询到对应的行，并返回给 User 类
    UserVO getByUsernameAndPassword(String userid,String password);

}
