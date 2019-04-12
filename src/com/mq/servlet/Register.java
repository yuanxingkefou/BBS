package com.mq.servlet;

import com.mq.Dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset='utf-8'");

        PrintWriter out=response.getWriter();

        String userId=request.getParameter("userId");
        String password=request.getParameter("password");
        String uname=request.getParameter("uname");
        String sex=request.getParameter("sex");
        String phone=request.getParameter("phone");

        if(userId==""||userId==null||userId.length()>8)
            out.println("昵称不能为空或者长度超过8位！！！<br>" +
                    "<a href='register.html'>重新注册</a>");
        if(uname==""||uname==null||uname.length()>20)
            out.println("姓名不能为空或者长度超过20位！！！<br>" +
                    "<a href='register.html'>重新注册</a>");
        if(sex==""||sex==null||sex.length()>2)
            out.println("姓别没有选择！！！<br>" +
                    "<a href='register.html'>重新注册</a>");

        if(phone==""||phone==null||phone.length()>20)
            out.println("电话不能为空或者长度超过11位！！！<br>" +
                    "<a href='register.html'>重新注册</a>");

        String sql1="insert into tb_userInfo(userId,uname,sex,phone) values(?,?,?,?)";
        String sql2="insert into tb_userlist(userId,password) values(?,?)";
        Object[] o1=new Object[4];
        Object[] o2=new Object[2];
        o1[0]=userId;
        o1[1]=uname;
        o1[2]=sex;
        o1[3]=phone;

        o2[0]=userId;
        o2[1]=password;
        Dao rc=new Dao();

        int num1=rc.insert(sql1,o1);
        int num2=rc.insert(sql2,o2);

        try {
            if(num1==1&&num2==1)
            {
                response.sendRedirect("index.jsp");
            }
            else
            {
                response.sendRedirect("./jsp/registerFail.jsp");
            }
        } catch (IOException e) {

        }
    }
}
