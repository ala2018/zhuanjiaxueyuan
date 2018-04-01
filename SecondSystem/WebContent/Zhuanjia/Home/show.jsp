<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.Bean.ZhuanjiaBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>show</title>
</head>
<body>
<p>专家用户表</p>
	<table width="80%" border="1">
<tr>
   <td>专家账号</td>
   <td>名字</td>
   <td>性别</td>
   <td>注册日期</td>
</tr>	
	<%
	ArrayList<ZhuanjiaBean> zjlist=(ArrayList<ZhuanjiaBean>)session.getAttribute("zjlist");
	//ArrayList<ArrayList<String>> zjlist=(ArrayList<ArrayList<String>>)session.getAttribute("zjlist");
	int i;
	for(i=0;i<zjlist.size();i++){
	%>
       <tr>
	    <td><%=zjlist.get(i).getZhuanjia_user() %></td>
	   <td><%=zjlist.get(i).getZhuanjia_name()%></td>
	     <td><%=zjlist.get(i).getZhuanjia_sex()%></td>
	    <td><%=zjlist.get(i).getZhuanjia_logindate()%></td>
	  </tr>

	 
	<% } %>
	</table>

</body>
</html>