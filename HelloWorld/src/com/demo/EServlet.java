package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 本例子讲的是Servlet的线程安全问题
 * 
 * Servlet是单实例的，同时支持多个多线程访问，所以它是线程不安全的。
 * 
 * 怎么解决？
 *  尽量使用局部变量，不要使用全局变量（除了可以共享的相同的数据以外）
 */
public class EServlet extends HttpServlet
{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        int i = 0;
        int j = 1/i;
        i++;
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        //输出
        out.write("this--->"+this+"<br/>");
        out.write("i---->"+i);
        
        out.flush();
        out.close();
    }

}
