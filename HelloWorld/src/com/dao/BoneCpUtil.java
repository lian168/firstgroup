package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jolbox.bonecp.BoneCPDataSource;

/**
 * BoneCP是一个快速，开源的数据库连接池。
 * 帮你管理数据连接让你的应用程序能更快速地访问数据库。比C3P0/DBCP连接池快25倍
 * 
 * 使用方法：
 *  导入jar包：bonecp-xxx.jar  slf4j-api-xxx.jar  slf4j-jdk14-xxx.jar guava-xx.jar
 */
public class BoneCpUtil
{
    public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/mydb";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    
    public static final BoneCPDataSource pool = new BoneCPDataSource();
    
    static
    {
        pool.setDriverClass(DRIVER_NAME);
        pool.setJdbcUrl(URL);
        pool.setUser(USER);
        pool.setPassword(PASSWORD);
    }
    
    //得到连接
    public static Connection getConnection() throws SQLException
    {
        return pool.getConnection();
    }
    
    public static void main(String[] args)
    {
        Connection conn;
        try
        {
            //2.得到数据库的连接
            conn = getConnection();
            
            System.out.println("是否连接成功："+(conn!=null));
            //3.得到PreparedStatement对象    执行指令对象
            String sql = "select * from emp where sal>=? and sal<=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            
            //填充参数
            pst.setDouble(1, 2000);
            pst.setDouble(2, 3000);
            
            //4.执行sql语句
            ResultSet rSet = pst.executeQuery();
            
            while(rSet.next())
            {
                long empno = rSet.getLong("empno");
                String ename = rSet.getString("ename");
                String job = rSet.getString("job");
                double sal = rSet.getDouble("sal");
                System.out.println(empno+"  "+ename+"  "+job+"  "+sal);
            }
            
            //5.关闭
            rSet.close();
            pst.close();
            conn.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
     
    }
}
