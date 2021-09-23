package com.company.controller; /**
 * @ClassName ${NAME}
 * @company 公司
 * @version 1.0
 * @Description TODO
 * @createTime 2021年09月23日 22:12:12
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author 苏东坡
 */
@WebServlet(name = "TwoServlet", value = "/TwoServlet")
public class TwoServlet extends HttpServlet {
    public TwoServlet(){
        System.out.println("TwoServlet访问时创建实例对象");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TwoServlet do run");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
