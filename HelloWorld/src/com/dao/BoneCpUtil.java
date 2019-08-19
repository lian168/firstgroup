package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jolbox.bonecp.BoneCPDataSource;

/**
 * BoneCP��һ�����٣���Դ�����ݿ����ӳء�
 * ��������������������Ӧ�ó����ܸ����ٵط������ݿ⡣��C3P0/DBCP���ӳؿ�25��
 * 
 * ʹ�÷�����
 *  ����jar����bonecp-xxx.jar  slf4j-api-xxx.jar  slf4j-jdk14-xxx.jar guava-xx.jar
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
    
    //�õ�����
    public static Connection getConnection() throws SQLException
    {
        return pool.getConnection();
    }
    
    public static void main(String[] args)
    {
        Connection conn;
        try
        {
            //2.�õ����ݿ������
            conn = getConnection();
            
            System.out.println("�Ƿ����ӳɹ���"+(conn!=null));
            //3.�õ�PreparedStatement����    ִ��ָ�����
            String sql = "select * from emp where sal>=? and sal<=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            
            //������
            pst.setDouble(1, 2000);
            pst.setDouble(2, 3000);
            
            //4.ִ��sql���
            ResultSet rSet = pst.executeQuery();
            
            while(rSet.next())
            {
                long empno = rSet.getLong("empno");
                String ename = rSet.getString("ename");
                String job = rSet.getString("job");
                double sal = rSet.getDouble("sal");
                System.out.println(empno+"  "+ename+"  "+job+"  "+sal);
            }
            
            //5.�ر�
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
