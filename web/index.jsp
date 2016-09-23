<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/23
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
      <form action="MessageControl?action=add" method="post">
          标题<input type="text" name="title" id="title">
          内容<textarea cols="10" rows="10" name="content"></textarea>

          <input type="submit" value="提交">
      </form>


      <a href="MessageControl?action=show">查询所有信息</a>
  </body>
</html>
