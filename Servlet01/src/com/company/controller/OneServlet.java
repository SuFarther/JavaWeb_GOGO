package com.company.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName OneServlet
 * @company 公司
 * @Description Servlet规范介绍和Servlet接口实现开发步骤
 * 一、Servlet规范介绍
 * 1、servlet规范来自于JAVAEE规范中的一种
 * 2、作用:
 *  1) 在Servlet规范中,指定[动态资源文件]开发步骤
 *  2）在Servlet规范中,指定Http服务器调用动态资源文件规范
 *  3）在Servlet规范中,指定Http服务器管理动态资源文件实例对象规则
 *
 *  二、Servlet接口实现类
 *  1、Servlet接口来自于Servlet规范下一个接口,这个接口存在Http服务器,提供jar包
 *  2、Tomcat服务器服务器下lib文件有一个Servlet-api.jar存在Servlet接口(javax.Servlet.Servlet接口)
 *  3、Servlet规范中任务,Http服务器能调用的[动态资源文件]必须是一个Servlet接口实现类
 *  例子:
 *   class Student{
 *       //不是动态资源文件,Tomcat无权调用
 *   }
 *   class Teacher implements Servlet{
 *       //合法动态资源文件,Tomcat有权调用
 *       Servlet obj = new Teacher();
 *       obj.doGet();
 *   }
 *
 *   三、Servlet接口实现开发步骤
 *   第一步: 创建一个Java类继承与HttpServlet父类,使之称为一个Servlet接口实现类
 *   第二步：重写HttpServlet父类方法。doGet和doPost
 *         get
 *   浏览器-------->oneServlet.doGet();
 *         get
 *   浏览器-------->oneServlet.doPost();
 *   第三步： 将Servlet接口实现类信息[注册]到Tomcat服务器
 *
 *   [网站]----->[web]----->[WEB-INF]----->web.xml
 *
 *   例子：
 *   子类------》父类-----》A接口
 *   此时 子类也是A接口实现类
 *   抽象类作用: 降低接口实现类对接口实现对程序难度,将接口中不需要使用抽象方法交给抽象类完成,这样接口实现类
 *   只需要对接口需要方法进行重写
 *   Servlet接口:
 *    init geServletConfig geServletInfo destroy-------四个方法对于Servlet接口实现类没用
 *   Service()-----有用
 *   Tomcat根据Servlet规范调用Servlet接口实现类规则:
 *   1、Tomcat有权创建Servlet接口实现类实例对象
 *   Servlet oneServlet = new OneServlet();
 *   2、Tomcat根据实例对象调用Service方法处理当前请求
 *   oneServlet.service() 此时Service方法中的this==oneServlet
 *               extends                      extends                            implements
 *   oneServlet-------->(abstract)HttpServlet-------->(abstract)GenericServlet---------->Servlet接口
 *   init geServletConfig geServletInfo destroy
 *
 *   通过父类决定在何种情况下调用子类中方法------[设计模式] ------模版设计模式
 *
 *   默认导入Tomcat两个包分别为javax.servlet-api-4.0.1.jar管理servlet和jsp-api-2.2.1-b03.jar分别在
 *   tomcat9里面的lib包下面
 * @createTime 2021年09月23日 06:20:20
 */
public class OneServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("OneServlet类针对浏览器发送Get请求方式处理");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("OneServlet类针对浏览器发送Post请求方式处理");
    }
}
