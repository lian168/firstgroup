package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �����ӽ�����Servlet���̰߳�ȫ����
 * 
 * Servlet�ǵ�ʵ���ģ�ͬʱ֧�ֶ�����̷߳��ʣ����������̲߳���ȫ�ġ�
 * 
 * ��ô�����
 *  ����ʹ�þֲ���������Ҫʹ��ȫ�ֱ��������˿��Թ������ͬ���������⣩
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
        
        //���
        out.write("this--->"+this+"<br/>");
        out.write("i---->"+i);
        
        out.flush();
        out.close();
    }

}
