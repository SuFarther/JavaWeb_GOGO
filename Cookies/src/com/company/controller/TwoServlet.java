package com.company.controller;
/**
 * @author 苏东坡
 * @ClassName TwoServlet
 * @company 公司
 * @version 1.0
 * @Description  逻辑思路拆分
 *  1、返回一次这里逻辑是,通过One创建One创建用户并充值,然后把Cookie写入到响应头
 *  2、之后请求转发页面,将第二个静态页面地址（之前讲到动态Servlet写入到响应体中）
 *  3、这里如果转发的是动态Servlet,则将Servlet里执行结果返回,静态页面的话就直接返回结果(静态页面)
 *  4、浏览器这时候接收到响应包,响应包中Cookie，响应体中有页面并展示
 *  5、这时候在新页面上再选择划卡消费的话，其实就已经是第二次发送请求了
 *  6、再根据所有项,携带新的参数发送到TwoServlet,执行后再返回新的响应
 * @createTime 2021年09月29日 21:52:52
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class TwoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int dumplingsMoney = 30;
        int noodlesMoney = 20;
        int capriceMoney = 15;
        int money = 0,consumption = 0,balance = 0;
        String food,userName=null;
        Cookie[] cookiesArray=null;
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Cookie newCard = null;
        //要取请求参数信息,得到事务类型
        food = request.getParameter("food");

        /**
         * 从OneServlet里面存的Cookie里面的两条数据userName,password封装成响应包重定向到index2.html
         * 在浏览器index2.html就可以把响应包里面的userName,password里面的Cookie数据读取出来,然后循环遍历获取
         */
        cookiesArray = request.getCookies();
        //刷卡消费
        for (Cookie card:cookiesArray){
            String key = card.getName();
            String value = card.getValue();
            if("userName".equals(key)){
                userName = value;
            }else  if("money".equals(key)){
                money = Integer.valueOf(value);
                if("饺子".equals(food)){
                    if(dumplingsMoney > money){
                        out.print("用户 "+userName+" 余额不足,请充值");
                    }else {
                        newCard =  new Cookie("money",(money-dumplingsMoney)+"");
                        newCard.setMaxAge(120);
                        consumption = dumplingsMoney;
                        balance = money - dumplingsMoney;
                    }
                }else  if("面条".equals(food)){
                    if(noodlesMoney > money){
                        out.print("用户 "+userName+" 余额不足,请充值");
                    }else {
                        newCard =  new Cookie("money",(money-noodlesMoney)+"");
                        consumption = noodlesMoney;
                        balance = money - noodlesMoney;
                    }
                }else  if("盖饭".equals(food)){
                    if(capriceMoney > money){
                        out.print("用户 "+userName+" 余额不足,请充值");
                    }else {
                        newCard =  new Cookie("money",(money-capriceMoney)+"");
                        consumption = capriceMoney;
                        balance = money - capriceMoney;
                    }
                }
            }
        }
        //将用户会员卡返还给用户
        response.addCookie(newCard);
        //将消费记录写入到响应
        out.print("用户 "+userName+" 本次消费 "+consumption+" 金额 "+balance);
    }
}
