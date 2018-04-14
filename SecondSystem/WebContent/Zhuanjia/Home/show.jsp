<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.Bean.ArticleBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>show</title>
</head>
<body>	
	<%
	ArrayList<ArticleBean> list=(ArrayList<ArticleBean>)session.getAttribute("list");
	//ArrayList<ArrayList<String>> zjlist=(ArrayList<ArrayList<String>>)session.getAttribute("zjlist");
    for(ArticleBean art:list){
	%>

<fieldset>
<legend>文章</legend>
<input type="text" name="title" style="width:800px" value=<%=art.getTitle()%>>
<br>
<br>
<textarea name="contents" style="font-size:20px;height:200px;width:800px"><%=art.getTitle()%></textarea>
<br>
<input type="text" style=display:none name="author" style="width:800px" value="郭襄">
</fieldset>
	 
	<% } %>
	</table>

</body>
</html>