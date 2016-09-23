<%@ page import="com.weikun.vo.Message,java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/23
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>test</title>
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
    <style type="text/css">
        body {
            padding: 20px;

        }

    </style>
</head>

<body>


<h2>华语九天榜</h2>
<table class="table table-striped table-bordered table-hover">
    <tr>
        <th>编号</th>
        <th>标题</th>
        <th>内容</th>
        <th>日期</th>
        <th>操作</th>
    </tr>
    <%
        int i=0;
        List<Message> list=(List)request.getAttribute("list");
        for( Message m :list){

            i++;

    %>
    <tr>
        <td><%=i%></td>
        <td><%=m.getTitle()%></td>
        <td><%=m.getContent()%></td>
        <td><%=m.getDate()%></td>

        <td><a href="MessageControl?action=del&id=<%=m.getId()%>">删除</a> </td>
    </tr>
    <%

        }

    %>
</table>


</body>
</html>

