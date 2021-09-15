package com.evan.sanhei.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * @program: sanhei
 * @description: 用户入参
 * @author: Jimu.Luo
 * @create: 2021-01-16 18:39
 **/

@Entity
@Table(name = "tuser")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class UserVO{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    int id;
    @Column(name = "userid")
    String username;
    @Column(name = "password")
    String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
