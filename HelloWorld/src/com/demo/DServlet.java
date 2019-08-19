package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 本例子讲的是如何获取Servlet的的配置参数  和  全局配置参数
 * 
 */
public class DServlet extends HttpServlet
{
    @Override
    public void init() throws ServletException
    {
        System.out.println("DServlet init..............");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        response.setContentType("text/html;charset=utf-8");
        
        //获取局部配置参数
        String username = getServletConfig().getInitParameter("USERNAME");
        String password = getServletConfig().getInitParameter("PASSWORD");
        
        PrintWriter out = response.getWriter();
        
        out.write("<h1>局部参数</h1>");
        out.write("username--->"+username+"<br/>");
        out.write("password--->"+password+"<br/>");
        
        
        //获得全局参数
        //ServletContext Servlet的上下文环境，整个项目中就一个
        ServletContext context = getServletContext();
        String jdbc_driver = context.getInitParameter("JDBC_DRIVER");
        String jdbc_url = context.getInitParameter("JDBC_URL");
        
        out.write("<h1>全局参数</h1>");
        out.write("jdbc_driver--->"+jdbc_driver+"<br/>");
        out.write("jdbc_url--->"+jdbc_url+"<br/>");
        
        out.flush();
        out.close();
    }

}
