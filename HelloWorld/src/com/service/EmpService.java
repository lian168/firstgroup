package com.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.bean.Emp;
import com.dao.DBUtil;

public class EmpService
{
    public List<Emp> queryEmpList(Emp e) throws SQLException
    {
        List<Emp> list = new ArrayList<Emp>();
        
        DBUtil dbUtil = new DBUtil();
        
        //组装SQL语句
        StringBuilder sb = new StringBuilder("select * from emp e where 1=1 ");
        if(StringUtils.isNotEmpty(e.getEname()))
        {
            sb.append(" and ename like '%"+e.getEname()+"%'");
        }
        if(StringUtils.isNotEmpty(e.getJob()))
        {
            sb.append(" and job = '"+e.getJob()+"'");
        }
        sb.append(" order by sal desc");
        
        ResultSet rSet = dbUtil.executeQuery(sb.toString());
        while(rSet.next())
        {
            Integer empno = rSet.getInt("empno");
            String ename = rSet.getString("ename");
            String job = rSet.getString("job");
            BigDecimal sal = rSet.getBigDecimal("sal");
            //System.out.println(empno+"  "+ename+"  "+job+"  "+sal);
            Date hireDate = rSet.getDate("hiredate");
            
            Emp emp = new Emp(empno, ename, job, hireDate, sal);
            list.add(emp);
        }
        
        return list;
    }
    
    //添加
    public int addEmp(Emp e) throws SQLException
    {
        DBUtil dbUtil = new DBUtil();
        
        //组装SQL语句
        StringBuilder sb = new StringBuilder("insert into emp(ename,job,hiredate,sal,deptno)values(?,?,?,?,?)");
        
        int count = dbUtil.executeUpdate(sb.toString(), e.getEname(),e.getJob(),e.getHireDate(),e.getSal(),e.getDeptno());
        
        
        return count;
    }
}
