package com.demo;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * �����ӽ�����Servlet�ĵ�һ�ִ�����ʽ��������������
 * 
 * Servlet:��Server Applet �ļ�ƣ���Ϊ�����С������Ҫ����������ͻ��˵�����������Ӧ��
 * 
 * Servlet�������й���web������tomcat�������У�������������������������
 * 
 * ����һ�η���Servletʱ(���û������Servlet��������������������)��Web��������ͨ������ķ�ʽ�Զ�������Servlet
 * ��ʵ����Ȼ�����init������ֻ�����һ�Σ���Servlet���г�ʼ����������ʹ��Service���������������д���
 * 
 * Servlet���������ڣ�
 * init:��Servlet���г�ʼ���������в���ֻ������һ��
 * service:����ͻ��˵�������Ӧ
 * destroy:����
 * 
 * 
 * Servlet����Ĺ��̣�
 * ��дServlet������web.xml�н���ע��
 * ��Web����������ʱ������ȥ��ȡweb.xml�е�������Ϣ�������û�����ʱ�ͻ����û��������ַ��web.xml�����õ������ַ����ƥ�䣬
 * ���ƥ������ĳ��Servlet�������ͻύ����Ӧ��Servlet���д���
 * 
 * ���ƥ������ĳ��Servlet��Web�������Զ��������Servlet��ʵ�������ҵ���һ��init���������������������󶼽���service��������
 * ...
 */
public class AServlet implements Servlet
{
    private ServletConfig config;
    //��ʼ�� 
    @Override
    public void init(ServletConfig config) throws ServletException
    {
        System.out.println("Servlet init...");
        this.config = config;
    }
    
    //��ȡServlet��������Ϣ
    @Override
    public ServletConfig getServletConfig()
    {
        System.out.println("Servlet getServletConfig...");
        return config;
    }

    //��ȡServlet����Ϣ������˵�������ֵȣ�һ��ûɶ�ã�
    @Override
    public String getServletInfo()
    {
        System.out.println("Servlet getServletInfo...");
        return null;
    }

    //�����û��������Servletʱ�ͻ���ô˷���
    //�������պʹ����û���������������Ӧ
    /*
     * ServletRequest  ��������
     * ServletResponse ������Ӧ
     */
    @Override
    public void service(ServletRequest req, ServletResponse res)
            throws ServletException, IOException
    {
        System.out.println("Servlet service..."+this);
        
        res.getWriter().print("<h1>Ok!</h1>");
    }

    //���û��������ٻ�������ֹͣʱ������ô˷���
    @Override
    public void destroy()
    {
        System.out.println("Servlet destroy...");
    }
}
