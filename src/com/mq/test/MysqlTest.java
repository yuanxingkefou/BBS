package com.mq.test;

import com.mq.Dao;

import java.sql.*;

public class MysqlTest {
    public static void main(String[] args)
    {
        String url="jdbc:mysql://localhost:3306/db_BBS?useSSL=false&useUnicode=true&characterEncoding=utf-8";
        String user="root";
        String password="067931ma,.";
        String sql="insert into tb_userInfo(userId,uname,sex,phone) values(?,?,?,?)";

        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            Connection conn=DriverManager.getConnection(url,user,password);

            PreparedStatement ps=conn.prepareStatement(sql);

            Object[] o=new Object[4];

            String userId="user7";
            String uname="Mary";
            String sex="男";
            String phone="12345546";
            o[0]=userId;
            o[1]=uname;
            o[2]=sex;
            o[3]=phone;

            Dao rc=new Dao();
            int num=rc.insert(sql,o);

            if(num==1)
            {
                System.out.println("插入成功");
            }
            else
                System.out.println("插入失败");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeSql()
    {

    }
}
