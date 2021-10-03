package com.company.dao;

import com.company.entity.Users;
import com.company.util.JdbcUtil;


import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName UserDao
 * @company 公司
 * @Description User数据库操作类
 * @createTime 2021年09月25日 21:02:02
 */
public class UserDao {

    private JdbcUtil util = new JdbcUtil();

    /**
     * 用户注册
     * JDBC规范中,Connection创建与销毁最浪费时间
     * @param user
     * @return result
     */
    public int add(Users user, HttpServletRequest request) {
        String sql = "INSERT INTO users(userName,password,sex,email) VALUES(?,?,?,?)";
        PreparedStatement ps = util.createStatement(sql,request);
        int result = 0;
        try {
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getSex());
            ps.setString(4, user.getEmail());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.close(request);
        }
        return result;
    }

    //查询所有用户信息
    public List findAll() {
        String sql = "SELECT * FROM users";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        List userList = new ArrayList();
        try {
           rs = ps.executeQuery();
           while (rs.next()){
               int userId = rs.getInt("userId");
               String userName = rs.getString("userName");
               String password = rs.getString("password");
               String sex = rs.getString("sex");
               String email = rs.getString("email");
               Users users = new Users(userId,userName,password,sex,email);
               userList.add(users);
           }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.close(rs);
        }
        return userList;
    }


    /**
     * 根据用户编号删除用户信息
     * @param userId
     * @return  userId
     */
    public int delete(String userId){
        String sql = "DELETE FROM users WHERE userId = ?";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {
            ps.setInt(1,Integer.valueOf(userId));
            result = ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            util.close();
        }
        return  result;
    }


    /**
     * 登陆验证
     */
    public int login(String userName,String password){
        String sql = "SELECT count(*) FROM users WHERE userName = ? AND password = ?";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs =  null;
        int result = 0;
        try{
           ps.setString(1,userName);
           ps.setString(2,password);
           rs = ps.executeQuery();
           while (rs.next()){
               result = rs.getInt("count(*)");
           }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            util.close(rs);
        }
        return result;
    }
}
