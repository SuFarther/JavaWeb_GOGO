package com.company.listener;

import com.company.util.JdbcUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName OneListener
 * @company 公司
 * @Description 创建一个全局作用域对象监听器,监听数据库连接
 * @createTime 2021年10月02日 10:56:56
 */
public class OneListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JdbcUtil util =  new JdbcUtil();
        Map map = new HashMap();
        for (int i = 0; i <= 20; i++) {
            Connection con = util.getCon();
            System.out.println("在http服务器启动时,创建con"+con);
            //true表示这个通道处于空闲状态,false通道正在被使用
            map.put(con,true);
        }
        //为了在Http服务器运行期间,一直都可以使用20个Connection,将connection保存
        //到全局作用域对象
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("key1",map);

    }

    /**
     * map被销毁
     * 在Http服务器关闭时刻,将全局作用域对象20个Connection销毁
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        Map map = (Map) servletContext.getAttribute("key1");
        Iterator it = map.keySet().iterator();
        while (it.hasNext()){
            Connection con = (Connection) it.next();
            if (con!=null){
                System.out.println("兄弟我先走了"+con);
            }
        }
    }
}
