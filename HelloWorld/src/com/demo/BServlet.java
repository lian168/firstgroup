package com.demo;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 本例子讲的是Servlet的第二种实现方式
 */
public class BServlet extends GenericServlet
{
    @Override
    public void init() throws ServletException
    {
        System.out.println("init...");
    }
    //用来处理用户的请求
    //ServletRequest 表求请求
    //ServletResponse 表求响应
    @Override
    public void service(ServletRequest req, ServletResponse res)
            throws ServletException, IOException
    {
        //设置一下响应的格式及编码 
        res.setContentType("text/html;charset=GBK");
        
        System.out.println("service...");
        //获取浏览器传过来的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username:"+username+"   password:"+password);
        
        //得到输出流（服务器向浏览器发送数据）
        //PrintWriter out = res.getWriter();
        OutputStream out = res.getOutputStream();
        
        //拿用户名和密码去数据库中匹配
        if("admin".equals(username) && "123456".equals(password))
        {
            out.write("<h1>登录成功！</h1>".getBytes());
        }
        else
        {
            out.write("<h1>登录失败！</h1>".getBytes());
        }
        
    }

    @Override
    public void destroy()
    {
        System.out.println("destroy...");
    }
}
