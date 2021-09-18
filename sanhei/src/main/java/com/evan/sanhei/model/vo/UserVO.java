package com.evan.sanhei.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;

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
    /* 1、生成表最大id，oracle不支持该方式
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    2、oracle"序列(sequence)"的机制生成主键,前提是数据库已经建序列，序列名：TEST_ID_SEQ
    @SequenceGenerator：name属性表示该表主键生成策略的名称，它被引用在@GeneratedValue中设置的“generator”值中。
                          sequenceName属性表示生成策略用到的数据库序列名称。
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="id")
    @SequenceGenerator(name="id", sequenceName="TEST_ID_SEQ") */

    //20210917这种方式可以直接取tsequence表里为tuser的序列生成策略，类似func_nextid函数
    @GeneratedValue(strategy = GenerationType.TABLE, generator="id")
    @TableGenerator(
            name="id",
            table="tsequence",
            pkColumnName = "NAME",
            pkColumnValue = "TUSER",
            valueColumnName = "ID",
            initialValue = 1,
            allocationSize = 1
    )

    @Column(name = "id")
    int id;
    @Column(name = "userid")
    String username;
    @Column(name = "password")
    String password;

    @ApiModelProperty(value = "加密加盐")
    private String salt;

    @ApiModelProperty(value = "用户姓名",example = "罗三黑")
    private String name;

    @ApiModelProperty(value = "电话",example = "18808080101")
    private String phone;

    @ApiModelProperty(value = "邮箱",example = "1778883442@qq.com")
    @Email(message = "请输入正确的邮箱")
    private String email;

    @ApiModelProperty(value = "允许登录1:是;2:否",example = "1")
    private int enabled;

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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
