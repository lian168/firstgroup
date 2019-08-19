package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.bean.Emp;
import com.service.EmpService;

public class AddEmpServlet extends HttpServlet
{

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        response.setContentType("text/html;charset=utf-8");
        
        Emp emp = new Emp();
        //��ȡ����
        emp.setEname(request.getParameter("ename"));
        emp.setJob(request.getParameter("job"));
        emp.setSal(new BigDecimal(request.getParameter("sal")));
        //����
        String hiredate = request.getParameter("hiredate");
        if(StringUtils.isNotEmpty(hiredate))
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try
            {
                Date myDate = sdf.parse(hiredate);
                //new java.sql.Date(myDate.getTime()) ��java.util.Date--->java.sql.Date
                emp.setHireDate(new java.sql.Date(myDate.getTime()));
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
        }
        //����
        emp.setDeptno(Integer.valueOf(request.getParameter("deptno")));
        
        //���
        EmpService service = new EmpService();
        try
        {
            service.addEmp(emp);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        
        
        PrintWriter out = response.getWriter();
        out.println("��ӳɹ���");
        out.flush();
        out.close();
    }

}
