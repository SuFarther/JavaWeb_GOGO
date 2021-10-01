package com.company.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName OneListener
 * @company 公司
 * @Description ServletContextAttributeListener接口
 *
 *       1)作用：通过这个接口合法的检测全局作用域对象共享数据变化时刻
 *
 * 		 2）监听事件处理方法：
 *
 * 		         public void contextAdd():在全局作用域对象添加共享数据
 * 				 public void contextReplaced():在全局作用域对象更新共享数据
 * 				 public void contextRemove():在全局作用域对象删除共享数据
 *
 *      6.全局作用域对象共享数据变化时刻
 *
 *           ServletContext application = request.getServletContext();
 *
 * 				 application.setAttribute("key1",100); //新增共享数据
 *
 * 				 application.setAttribute("key1",200); //更新共享数据
 *
 * 				 application.removeAttribute("key1");  //删除共享数据
 * @createTime 2021年10月02日 04:01:01
 */
public class OneListener implements ServletContextAttributeListener {


    /**
     * 在全局作用域对象添加共享数据
     * @param scae
     */
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("在全局作用域对象添加共享数据");
    }


    /**
     * 在全局作用域对象删除共享数据
     * @param scae
     */
    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println("在全局作用域对象删除共享数据");
    }

    /**
     * 在全局作用域对象更新共享数据
     * @param scae
     */
    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("在全局作用域对象更新共享数据");
    }
}
