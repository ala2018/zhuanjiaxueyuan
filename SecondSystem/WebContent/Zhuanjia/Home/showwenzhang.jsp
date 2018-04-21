<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.Bean.ArticleBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
$(function(){
var mydiv=$("#mydiv");
var mydiv_resize=function(){
$(mydiv).css("width",$(window).width());
$(mydiv).css("height",$(window).height());
};
mydiv_resize();
$(window).resize(function(){
mydiv_resize();
});
});
</script>
</head>
<body>
<div style="width:1400px;">
<%ArrayList<ArticleBean> list=(ArrayList<ArticleBean>)session.getAttribute("list");
  ArticleBean  art=list.get(Integer.valueOf(request.getParameter("tindex")).intValue());
  String hre="Downarticle?filename="+art.getId();
%>
<fieldset  style="width:1380px;border:4px solid blue;">
<legend>文章</legend>
<div style="width:1380px;border:2px solid red;" >
<h4 align="center"><%=art.getTitle()%></h4>
<p align="center"><a href="" ><%="作者:"+art.getAuthor()%></a></p>
<%String c=art.getContents().replaceAll(" ","&nbsp");
  c=c.replaceAll("\r\n","<br>");%>
<div><%=c%></div>
<div><p>时间:<%=art.getDate()%> <a style="float:right;margin-right:50px" href=<%=hre%> >下载文章</a> ${errorResult} </p></div>
</div>
</fieldset>
</div>
</body>
</html>
