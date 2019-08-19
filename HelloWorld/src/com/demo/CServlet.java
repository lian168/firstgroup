package com.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �����ӽ�����Servlet�ĵ�����ʵ�ַ�ʽ
 */
public class CServlet extends HttpServlet
{
    
    //��������get����
    /**
     * HttpServletRequest: ����
     * HttpServletResponse: ��Ӧ
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
    
    
    //��������post����
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
