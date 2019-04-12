<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/3/30
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
import="com.mq.Dao,java.util.*,java.sql.*" %>
<html>
<head>
    <%
        String userId=(String)session.getAttribute("userId");
    %>
    <title>帖子列表</title>
</head>
<body>
<%
    if(userId!=null){
%>
<div style="width: 740px">
    <div>
        <span style="size:12px;color:#00F;width:100px;float: left">
            欢迎你：<%=userId%></span>
        <span style='float: left'>|</span>
        <span style="width: 80px;float: left">
            <a href="logout.jsp">安全退出</a>
        </span>
    </div>
</div>
<%--进行是否登陆状态的判定，如果未登陆就显示注册与登陆的链接--%>
<%
    }
    else
    {

        out.print("<div style=\"width: 748\">\n" +
                "    <span align=\"left\">\n" +
                "        <a href=\"../html/register.html\">注册</a>\n" +
                "        -----------\n" +
                "        <a href=\"../index.jsp\">登陆</a>\n" +
                "    </span>\n" +
                "</div>");
    }
%>
<br>
<br>
<font color="blue" size="2px">主题列表</font>
<div style="width:720px;">
    <%
        Dao dao=new Dao();
        String sql="select * from tb_title order by time";
        ResultSet rs=dao.select(sql);
        //设置每页显示的记录数量
        int pageSize=5;
        //设置默认显示第几页
        int curPage=1;
        //总页数
        int countPage=0;

        curPage=Integer.parseInt(request.getParameter("page")==null?"1":request.getParameter("page"));
        int i=0;

        out.print("<div style='background-color: #3399CC;border-bottom: 1px solid #000; width: 740px;'>\n" +
                "    <span style='border-right: 1px solid #000;width: 50px;float: left;color: #C00'>编号：</span>\n" +
                "    <span style='border-right: 1px solid #000;width: 150px;float: left;color: #C00'>主题：</span>\n" +
                "    <span style='border-right: 1px solid #000;width: 340px;float:left;color: #C00'>内容：</span>\n" +
                "    <span style='border-right: 1px solid #000;width: 80px;float: left;color: #C00'>发表人：</span>\n" +
                "    <span style='width: 100px;float:left;color: #C00'>发表时间：</span>\n" +
                "</div>\n" +
                "<br>");

        while(rs.next())
        {
            i++;
            if(i>(curPage-1)*pageSize&&i<=curPage*pageSize)
            {
                String id=rs.getString("id");
                String title=rs.getString("title");
                String content=rs.getString("content");
                String user=rs.getString("user");
                String time=rs.getString("time");

                out.print("<div style='background-color: #CCC;border-bottom: 1px solid #000; width: 740px;'>" +
                        "    <span style='border-right: 1px solid #000;width: 50px;float: left;color: #C00'>"+i+"</span>" +
                        "    <span style='border-right: 1px solid #000;width: 150px;float:left;'><a href=reply.jsp?id="+id+">"+title+"</a></span>" +
                        "    <span style='border-right: 1px solid #000;width: 340px;float: left;'>"+content+"</span>" +
                        "    <span style='border-right: 1px solid #000;width: 80px;float: left;'>"+user+"</span>" +
                        "    <span style='width: 100px;float:left;color: #C00'>"+time.substring(0,10)+"</span>" +
                        "</div>" +
                        "<br>");

            }
        }
        countPage=(i+pageSize-1)/pageSize;
    %>
</div>
<br>
<br>
 <div style="clear:both;text-align: center">
     <a href="list.jsp?page=1">首页</a>
     <% if(curPage!=1){ %>
     <span>
         <a href="list.jsp?page=<%=curPage-1%>">上一页</a>
     </span>
     <%}%>
     <% if(curPage!=countPage){ %>
     <span>
         <a href="list.jsp?page=<%=curPage+1%>">下一页</a>
     </span>
     <% } %>
     <span>
         <a href="list.jsp?page=<%=countPage%>">尾页</a>
     </span>
</div>
<%
    rs.close();
%>
<br><br>
<div style="clear:both;text-align: right;">
    <span>
        <form name=form1 action="post.jsp" method="post">
            <input type="submit" value="发表新主题"/>
        </form>
    </span>
</div>
</body>
</html>
