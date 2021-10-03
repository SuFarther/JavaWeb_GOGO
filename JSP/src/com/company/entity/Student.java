package com.company.entity;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName Student
 * @company 公司
 * @Description TODO
 * @createTime 2021年10月02日 21:47:47
 */
public class Student {
    private String sid;
    private String sName;

    public Student(){

    }

    public Student(String sid, String sName) {
        this.sid = sid;
        this.sName = sName;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", sName='" + sName + '\'' +
                '}';
    }
}
