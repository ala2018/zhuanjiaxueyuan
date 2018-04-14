<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.Bean.ArticleBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%ArrayList<ArticleBean> list=(ArrayList<ArticleBean>)session.getAttribute("list");
  ArticleBean  art=list.get(Integer.valueOf(request.getParameter("tindex")).intValue());
%>
<fieldset>
<legend>文章</legend>
<div>
<h4><%=art.getTitle()%></h1>
<div><p>简介</p><%=art.getContents()%></div>
</div>
<div><p>时间:<%=art.getDate()%></p></div>
</fieldset>
</body>
</html>