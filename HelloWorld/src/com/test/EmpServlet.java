package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Emp;
import com.service.EmpService;

public class EmpServlet extends HttpServlet
{

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=utf-8");
        
        try
        {
            //得到查询参数
            String ename = request.getParameter("ename");
            String job = request.getParameter("job");
            System.out.println("ename:"+ename+"  job:"+job);
            Emp emp = new Emp();
            emp.setEname(ename);
            emp.setJob(job);
            
            //调用服务层查询
            EmpService service = new EmpService();
            List<Emp> empList = service.queryEmpList(emp);
            
            PrintWriter out = response.getWriter();
            
            out.write("<table border='1px' width='500px'>");
            for(Emp e:empList)
            {
                out.write("<tr>");
                    out.write("<td>"+e.getEmpNO()+"</td>");
                    out.write("<td>"+e.getEname()+"</td>");
                    out.write("<td>"+e.getJob()+"</td>");
                    out.write("<td>"+e.getSal()+"</td>");
                    out.write("<td>"+e.getHireDate()+"</td>");
                out.write("</tr>");
            }
            out.write("</table>");
            
            out.flush();
            out.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        
       
    }

}
