package com.demo;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 本例子讲的是Servlet的第一种创建方式和它的生命周期
 * 
 * Servlet:是Server Applet 的简称，称为服务端小程序，主要是用来处理客户端的请求及做出响应。
 * 
 * Servlet它必须托管在web容器（tomcat）中运行，它的生命周期由容器来管理。
 * 
 * 当第一次访问Servlet时(如果没有设置Servlet随着容器的启动而创建)，Web服务器会通过反射的方式自动创建该Servlet
 * 的实例，然后调用init方法（只会调用一次）对Servlet进行初始化，接下来使用Service方法对这个请求进行处理。
 * 
 * Servlet的生命周期：
 * init:对Servlet进行初始化，会运行并且只会运行一次
 * service:处理客户端的请求及响应
 * destroy:销毁
 * 
 * 
 * Servlet请求的过程：
 * 编写Servlet并且在web.xml中进行注册
 * 当Web容器启动的时候它会去读取web.xml中的配置信息，当有用户请求时就会拿用户的请求地址与web.xml中配置的请求地址进行匹配，
 * 如果匹配上了某个Servlet这个请求就会交给对应的Servlet进行处理
 * 
 * 如果匹配上了某个Servlet，Web容器会自动创建这个Servlet的实例，并且调用一次init方法，接下来的所有请求都交给service方法处理
 * ...
 */
public class AServlet implements Servlet
{
    private ServletConfig config;
    //初始化 
    @Override
    public void init(ServletConfig config) throws ServletException
    {
        System.out.println("Servlet init...");
        this.config = config;
    }
    
    //获取Servlet的配置信息
    @Override
    public ServletConfig getServletConfig()
    {
        System.out.println("Servlet getServletConfig...");
        return config;
    }

    //获取Servlet的信息，比如说它的名字等（一般没啥用）
    @Override
    public String getServletInfo()
    {
        System.out.println("Servlet getServletInfo...");
        return null;
    }

    //当有用户请求这个Servlet时就会调用此方法
    //用来接收和处理用户的请求并且做出响应
    /*
     * ServletRequest  代表请求
     * ServletResponse 代表响应
     */
    @Override
    public void service(ServletRequest req, ServletResponse res)
            throws ServletException, IOException
    {
        System.out.println("Servlet service..."+this);
        
        res.getWriter().print("<h1>Ok!</h1>");
    }

    //当用户主动销毁或者容器停止时，会调用此方法
    @Override
    public void destroy()
    {
        System.out.println("Servlet destroy...");
    }
}
