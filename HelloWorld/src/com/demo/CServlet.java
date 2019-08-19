package com.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 本例子讲的是Servlet的第三种实现方式
 */
public class CServlet extends HttpServlet
{
    
    //用来请求get请求
    /**
     * HttpServletRequest: 请求
     * HttpServletResponse: 响应
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        System.out.println("doGet ... ");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username:"+username+"   password:"+password);
        
        resp.getWriter().write("doGet Success!");
    }
    
    
    //用来接收post请求
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        System.out.println("doPost ... ");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username:"+username+"   password:"+password);
        
        resp.getWriter().write("doPost Success!");
    }
}
