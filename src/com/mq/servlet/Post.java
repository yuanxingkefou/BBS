package com.mq.servlet;

import com.mq.Dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Post extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out=response.getWriter();

        String title=request.getParameter("title");
        String content=request.getParameter("content");
        String userId=(String)request.getSession().getAttribute("userId");
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        String time=sdf.format(date);

        String sql="insert into tb_title(title,content,user,time) values(?,?,?,?)";

        Object[] o=new Object[4];

        o[0]=title;
        o[1]=content;
        o[2]=userId;
        o[3]=time;

        Dao dao=new Dao();

        int num=dao.insert(sql,o);

        if(num==1)
        {
            response.sendRedirect("./jsp/list.jsp");
        }
        else
        {
            response.sendRedirect("./html/error.html");
        }
    }
}
