package com.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * �����ӽ����������Web��Ŀ�л�ȡ��Դ�ļ���·��
 */
public class FServlet extends HttpServlet
{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        //1.���� ServletContext ����ȡ�ļ���·��
        //ServletContext context = getServletContext();
        //getServletContext().getRealPath �õ���WebRoot��·��
        //�õ��ļ���·��
        String path = getServletContext().getRealPath("/WEB-INF/classes/com/demo/a.txt");
        //��IO������ʽ������Դ
        InputStream in = getServletContext().getResourceAsStream("/WEB-INF/classes/com/demo/a.txt");
       /* byte[] buf = new byte[1024];
        int len = in.read(buf);
        out.write(new String(buf,0,len));*/
        out.println("<br/>getServletContext().getRealPath()---->"+path);
        out.write("<br/>");
        out.write("<br/>");
        
        //2.����Class�����ȡ��Դ��·��
        /**
         *  ���� / :�õ����ǵ�ǰ·��
         *  �� / :�õ��� classes
         */
        String myPath1 = FServlet.class.getResource("a.txt").getPath();
        myPath1 = URLDecoder.decode(myPath1);
        String myPath2 = FServlet.class.getResource("/com/demo/a.txt").getPath();
        myPath2 = URLDecoder.decode(myPath2);
        out.println("<br/>this.getClass().getResource('').getPath()---->"+myPath1);
        out.println("<br/>this.getClass().getResource('/').getPath()---->"+myPath2);
        
        //������������ʽ������Դ�ļ�
        //InputStream inputStream = FServlet.class.getResourceAsStream(name)
        
        out.write("<br/>");
        out.write("<br/>");
        
       
        out.flush();
        out.close();
    }

}
