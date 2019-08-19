package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil
{
/*    public static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
    public static final String URL = "jdbc:oracle:thin:@192.168.18.37:1521:orcl";
    public static final String USER = "lian";
    public static final String PASSWORD = "123456";*/
    
  /*  //���ݿ�����
    private Connection conn;
    public DBUtil()
    {
        this.conn = getConnection();
    }*/
    
   /* static
    {
        //1.�������� 
        try
        {
            Class.forName(DRIVER_NAME);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }*/
    
/*    //��ȡ����
    private Connection getConnection()
    {
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return conn;
    }*/
    
    
    //��ѯ
    public ResultSet executeQuery(String sql,Object ... args) throws SQLException
    {
        //�õ�ָ�����
        PreparedStatement pst = BoneCpUtil.getConnection().prepareStatement(sql);
        
        //������
        fillArgs(pst, args);
        
        //ִ��
        ResultSet rSet = pst.executeQuery();
        
        return rSet;
    }


    //�޸�ɾ������
    public int executeUpdate(String sql,Object ... args) throws SQLException
    {
        //�õ�ָ�����
        PreparedStatement pst = BoneCpUtil.getConnection().prepareStatement(sql);
        
        //������
        fillArgs(pst, args);
        
        //ִ��
        int count = pst.executeUpdate();
        
        
        return count;
    }
    
    //������
    private void fillArgs(PreparedStatement pst, Object... args)
            throws SQLException
    {
        for (int i = 0; i < args.length; i++)
        {
            pst.setObject(i+1, args[i]);
        }
    }
    
    //�ر�
  /*  public void close()
    {
        try
        {
            if(conn!=null)
                conn.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }*/
}
