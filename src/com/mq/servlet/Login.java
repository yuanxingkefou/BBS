package com.mq.servlet;

import com.mq.Dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out=response.getWriter();

        String userId=request.getParameter("userId");
        String password=request.getParameter("password");

        if(userId==""||userId==null||userId.length()>20)
            out.println("用户名不能为空或者长度超过20位！！！<br>" +
                    "<a href='index.jsp'>重新登陆</a>");
        else if(password==null||password==null||password.length()>20)
            out.println("密码不能为空或者长度超过20位！！！<br>" +
                    "<a href='index.jsp'>重新登陆</a>");
        else
        {
            String sql="select * from tb_userlist where userId=? and password=?";

            Object[] o=new Object[2];

            o[0]=userId;
            o[1]=password;

            Dao d=new Dao();

            ResultSet rs=d.identity(sql,o);

            try {
                if(rs.next()==true)
                {
                    //通过会话管理保持登陆状态
                    request.getSession().setAttribute("userId",userId);
                    response.sendRedirect("./jsp/success.jsp");
                }
                else
                    response.sendRedirect("./jsp/failure.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
