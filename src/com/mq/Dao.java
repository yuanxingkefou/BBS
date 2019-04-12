package com.mq;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 访问数据库的具体方法
 */
public class Dao {
    Connection connection=null;

    public Dao()
    {
        CreateConnect conn=new CreateConnect();

        try {
            connection=conn.acquireConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //执行插入操作
    public int insert(String sql,Object[] o)
    {
        int num=0;

        try {
            PreparedStatement pstmt=connection.prepareStatement(sql);
            for(int i=0;i<o.length;i++)
            {
                pstmt.setObject(i+1,o[i]);
            }
            num=pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库操作出现问题");
        }
       return num;
    }
    //判断身份是否正确
    public ResultSet identity(String sql ,Object[] o)
    {
        ResultSet rs=null;

        try {
            PreparedStatement pstmt=connection.prepareStatement(sql);
            for(int i=0;i<o.length;i++)
            {
                pstmt.setObject(i+1,o[i]);
            }
            rs=pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库操作出错");
        }
        return rs;
    }
    //执行搜索工作
    public ResultSet select(String sql)
    {
        ResultSet rs=null;

        try {
            PreparedStatement pstmt=connection.prepareStatement(sql);
            rs=pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
