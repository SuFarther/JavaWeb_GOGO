package com.company.dao;

import com.company.entity.Question;
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
 * @ClassName QuestionDao
 * @company 公司
 * @Description TODO
 * @createTime 2021年10月03日 14:04:04
 */
public class QuestionDao {

    JdbcUtil util = new JdbcUtil();

    /**
     * 新增试题
     * @param question
     * @return
     */
    public int add(Question question,HttpServletRequest request){
        String sql = "INSERT  INTO question(title,optionA,optionB,optionC,optionD,answer) VALUES(?,?,?,?,?,?)";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try{
            ps.setString(1,question.getTitle());
            ps.setString(2,question.getOptionA());
            ps.setString(3,question.getOptionB());
            ps.setString(4,question.getOptionC());
            ps.setString(5,question.getOptionD());
            ps.setString(6,question.getAnswer());
            result = ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            util.close(request);
        }
        return  result;
    }

    /**
     * 查询所有试题信息
     * @return
     */
    public List findAll(){
        String sql = "SELECT * FROM question";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        List questionList = new ArrayList();
        try {
            rs = ps.executeQuery();
            while (rs.next()){
                Integer questionId  = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
                Question question = new Question(questionId,title,optionA,optionB,optionC,optionD,answer);
                questionList.add(question);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            util.close(rs);
        }
        return questionList;
    }


    /**
     * 删除试题
     * @param questionId
     * @return
     */
     public int delete(String  questionId){
        String sql = "DELETE from question WHERE questionId = ?";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {
            ps.setInt(1,Integer.valueOf(questionId));
            result = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }


    /**
     * 根据试题id查询数据
     */
    public Question getByQuestionId(String questionId){
        String sql = "SELECT * FROM question WHERE questionId = ?";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        Question question = null;
        try {
            ps.setInt(1,Integer.valueOf(questionId));
            rs = ps.executeQuery();
            while (rs.next()){
                Integer quesitonId = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
                question = new Question(quesitonId,title,optionA,optionB,optionC,optionD,answer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            util.close(rs);
        }
        return question;
    }

    /**
     * 试题修改
     * @param question
     * @return
     */
    public int update(Question question){
        String sql = "UPDATE question SET title=?,optionA=?,optionB=?,optionC=?,optionD=?,answer=? WHERE questionId=?";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {
            ps.setString(1,question.getTitle());
            ps.setString(2,question.getOptionA());
            ps.setString(3,question.getOptionB());
            ps.setString(4,question.getOptionC());
            ps.setString(5,question.getOptionD());
            ps.setString(6,question.getAnswer());
            ps.setInt(7,question.getQuestionId());
            result = ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }
}
