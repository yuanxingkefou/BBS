package com.mq;
/**
 * 生成连接数据库的Connection文件
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnect {
    public static Connection acquireConnection() throws ClassNotFoundException,SQLException
    {
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        String url="jdbc:mysql://localhost:3306/db_BBS";
        String user="root";
        String password="067931ma,.";

        connection=DriverManager.getConnection(url,user,password);

        return connection;
    }
}
