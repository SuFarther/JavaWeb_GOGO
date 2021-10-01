package com.company.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author  苏东坡
 * @version 1.0
 * @ClassName ServletContextListener
 * @company 公司
 * @Description Servlet规范扩展-----------------监听器接口
 * 1.介绍：
 *
 *         1）一组来自于Servlet规范下接口，共有8个接口。在Tomcat存在servlet-api.jar包
 *
 * 	      2）监听器接口需要由开发人员亲自实现，Http服务器提供jar包并没有对应的实现类
 *
 * 	      3）监听器接口用于监控【作用域对象生命周期变化时刻】以及【作用域对象共享数据变化时刻】
 *
 *   2.作用域对象：
 *
 * 	       1）在Servlet规范中，认为在服务端内存中可以在某些条件下为两个Servlet之间提供
 * 	          数据共享方案的对象，被称为【作用域对象】
 *
 *                2）Servlet规范下作用域对象:
 * 	           ServletContext：   全局作用域对象
 * 		   HttpSession   :    会话作用域对象
 * 		   HttpServletRequest:请求作用域对象
 *
 *   3.监听器接口实现类开发规范：三步
 *
 * 	        1）根据监听的实际情况，选择对应监听器接口进行实现
 *
 * 		2）重写监听器接口声明【监听事件处理方法】
 *
 * 		3）在web.xml文件将监听器接口实现类注册到Http服务器
 *
 *         4.ServletContextListener接口：
 *
 * 	        1）作用：通过这个接口合法的检测全局作用域对象被初始化时刻以及被销毁时刻
 *
 * 		2）监听事件处理方法：
 *
 * 		            public void contextInitlized（） ：在全局作用域对象被Http服务器初始化被调用
 *
 * 			    public void contextDestory():      在全局作用域对象被Http服务器销毁时候触发调用
 * @createTime 2021年10月02日 03:37:37
 */
public class OneListener implements ServletContextListener{



    /**
     * 在全局作用域被HTTP服务器被调用
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("恭喜恭喜,来世走一走");
    }

    /**
     * 在全局作用域被HTTP服务器销毁时候触发调用
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("兄弟一路走好,十八年后又是一条好汉");
    }
}
