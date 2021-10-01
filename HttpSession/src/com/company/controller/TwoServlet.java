package com.company.controller;
/**
 * @author 苏东坡
 * @ClassName TwoServlet
 * @company 公司
 * @version 1.0
 * @Description TODO
 * @createTime 2021年10月01日 21:33:33
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、调用请求对象,向Tomcat索要当前在服务端私人储物柜
        HttpSession session = request.getSession();

        //2、将session中所有key读取出来,存放一个枚举对象
        Enumeration  goodsNames = session.getAttributeNames();
        while (goodsNames.hasMoreElements()){
            String goodsName = (String) goodsNames.nextElement();
            int goodsNum = (int) session.getAttribute(goodsName);
            System.out.println("商品名称 "+goodsName+" 商品数量"+goodsNum);
        }
    }
}
