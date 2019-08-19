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
 * 本例子讲的是如何在Web项目中获取资源文件的路径
 */
public class FServlet extends HttpServlet
{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        //1.利用 ServletContext 来获取文件的路径
        //ServletContext context = getServletContext();
        //getServletContext().getRealPath 得到是WebRoot的路径
        //得到文件的路径
        String path = getServletContext().getRealPath("/WEB-INF/classes/com/demo/a.txt");
        //以IO流的形式返回资源
        InputStream in = getServletContext().getResourceAsStream("/WEB-INF/classes/com/demo/a.txt");
       /* byte[] buf = new byte[1024];
        int len = in.read(buf);
        out.write(new String(buf,0,len));*/
        out.println("<br/>getServletContext().getRealPath()---->"+path);
        out.write("<br/>");
        out.write("<br/>");
        
        //2.利用Class对象获取资源的路径
        /**
         *  不加 / :得到的是当前路径
         *  加 / :得到是 classes
         */
        String myPath1 = FServlet.class.getResource("a.txt").getPath();
        myPath1 = URLDecoder.decode(myPath1);
        String myPath2 = FServlet.class.getResource("/com/demo/a.txt").getPath();
        myPath2 = URLDecoder.decode(myPath2);
        out.println("<br/>this.getClass().getResource('').getPath()---->"+myPath1);
        out.println("<br/>this.getClass().getResource('/').getPath()---->"+myPath2);
        
        //以输入流的形式返回资源文件
        //InputStream inputStream = FServlet.class.getResourceAsStream(name)
        
        out.write("<br/>");
        out.write("<br/>");
        
       
        out.flush();
        out.close();
    }

}
