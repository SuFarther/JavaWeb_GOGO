package com.company.entity;

import java.math.BigInteger;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName Users
 * @company 公司
 * @Description Users实体类
 * @createTime 2021年09月25日 11:02:02
 */
public class Users {

    private Integer userId;

    private String userName;

    private String password;

    private String sex;

    private String email;


    public Users() {
    }



    public Users(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Users(Integer userId, String userName, String password, String sex, String email) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.email = email;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
