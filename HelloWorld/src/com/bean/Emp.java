package com.bean;

import java.math.BigDecimal;
import java.sql.Date;

public class Emp
{
    private Integer empNO;
    private String ename;
    private String job;
    private Integer mgr;
    private Date hireDate;
    private BigDecimal sal;
    private BigDecimal comm;
    
    private Integer deptno;
    
    
    
    public Integer getDeptno()
    {
        return deptno;
    }
    public void setDeptno(Integer deptno)
    {
        this.deptno = deptno;
    }
    public Emp(Integer empNO, String ename, String job, Date hireDate,
            BigDecimal sal)
    {
        super();
        this.empNO = empNO;
        this.ename = ename;
        this.job = job;
        this.hireDate = hireDate;
        this.sal = sal;
    }
    public Emp()
    {
        super();
    }
    public Integer getEmpNO()
    {
        return empNO;
    }
    public void setEmpNO(Integer empNO)
    {
        this.empNO = empNO;
    }
    public String getEname()
    {
        return ename;
    }
    public void setEname(String ename)
    {
        this.ename = ename;
    }
    public String getJob()
    {
        return job;
    }
    public void setJob(String job)
    {
        this.job = job;
    }
    public Integer getMgr()
    {
        return mgr;
    }
    public void setMgr(Integer mgr)
    {
        this.mgr = mgr;
    }
    public Date getHireDate()
    {
        return hireDate;
    }
    public void setHireDate(Date hireDate)
    {
        this.hireDate = hireDate;
    }
    public BigDecimal getSal()
    {
        return sal;
    }
    public void setSal(BigDecimal sal)
    {
        this.sal = sal;
    }
    public BigDecimal getComm()
    {
        return comm;
    }
    public void setComm(BigDecimal comm)
    {
        this.comm = comm;
    }
    @Override
    public String toString()
    {
        return "Emp [empNO=" + empNO + ", ename=" + ename + ", job=" + job
                + ", mgr=" + mgr + ", hireDate=" + hireDate + ", sal=" + sal
                + ", comm=" + comm + "]";
    }
    
    
}
