<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.Bean.ArticleBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>

div.caidan {
    line-height:30px;
    background-color:#F0F8FF;
     position: absolute;
    height:42px;
    width:800px;
    margin-left:210px;
    border:0px solid #000;	      
}
a.wenzhangbiaoti{text-decoration:none;
    background-color:#F0F8FF;
}
a.zuozhe{text-decoration:none;
    background-color:#F0FFF0;
}
a.fenlei{text-decoration:none;
    background-color:#F0FFF0;
}
</style>
<title>show</title>
</head>
<body>	
	<%
	int i=0;
	String hre="";
	ArrayList<ArticleBean> list=(ArrayList<ArticleBean>)session.getAttribute("list");
	//ArrayList<ArrayList<String>> zjlist=(ArrayList<ArrayList<String>>)session.getAttribute("zjlist");
    for(ArticleBean art:list){
    	hre="showwenzhang.jsp?tindex="+i;
    	i++;
	%>

<fieldset style="border:3px solid blue;">
<legend>文章</legend>
<div style="border:1px solid red;">
<h4><a class="wenzhangbiaoti" href=<%=hre%>><%=art.getTitle()%></a></h4>
<p><a class="zuozhe" href="" ><%="作者:"+art.getAuthor()%></a></p>
<p><a class="fenlei" href=""><%="文章分类:"+art.getClassification()%></a></p>
<div><p>简介</p><%=art.getContents().substring(0,100)+"..."%></div>
</div>
<div><p>时间:<%=art.getDate()%></p></div>
</fieldset>
	 
	<% } 
	//session.removeAttribute("list");
	%>

</body>
</html>