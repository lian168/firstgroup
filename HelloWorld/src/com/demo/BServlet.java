package com.demo;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * �����ӽ�����Servlet�ĵڶ���ʵ�ַ�ʽ
 */
public class BServlet extends GenericServlet
{
    @Override
    public void init() throws ServletException
    {
        System.out.println("init...");
    }
    //���������û�������
    //ServletRequest ��������
    //ServletResponse ������Ӧ
    @Override
    public void service(ServletRequest req, ServletResponse res)
            throws ServletException, IOException
    {
        //����һ����Ӧ�ĸ�ʽ������ 
        res.setContentType("text/html;charset=GBK");
        
        System.out.println("service...");
        //��ȡ������������Ĳ���
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username:"+username+"   password:"+password);
        
        //�õ����������������������������ݣ�
        //PrintWriter out = res.getWriter();
        OutputStream out = res.getOutputStream();
        
        //���û���������ȥ���ݿ���ƥ��
        if("admin".equals(username) && "123456".equals(password))
        {
            out.write("<h1>��¼�ɹ���</h1>".getBytes());
        }
        else
        {
            out.write("<h1>��¼ʧ�ܣ�</h1>".getBytes());
        }
        
    }

    @Override
    public void destroy()
    {
        System.out.println("destroy...");
    }
}
