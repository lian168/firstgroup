package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �����ӽ�������λ�ȡServlet�ĵ����ò���  ��  ȫ�����ò���
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
        
        //��ȡ�ֲ����ò���
        String username = getServletConfig().getInitParameter("USERNAME");
        String password = getServletConfig().getInitParameter("PASSWORD");
        
        PrintWriter out = response.getWriter();
        
        out.write("<h1>�ֲ�����</h1>");
        out.write("username--->"+username+"<br/>");
        out.write("password--->"+password+"<br/>");
        
        
        //���ȫ�ֲ���
        //ServletContext Servlet�������Ļ�����������Ŀ�о�һ��
        ServletContext context = getServletContext();
        String jdbc_driver = context.getInitParameter("JDBC_DRIVER");
        String jdbc_url = context.getInitParameter("JDBC_URL");
        
        out.write("<h1>ȫ�ֲ���</h1>");
        out.write("jdbc_driver--->"+jdbc_driver+"<br/>");
        out.write("jdbc_url--->"+jdbc_url+"<br/>");
        
        out.flush();
        out.close();
    }

}
