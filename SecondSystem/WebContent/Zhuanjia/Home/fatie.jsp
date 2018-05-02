<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.Bean.UserBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#biaoti{
    color:rgb(255,255,255);
    font-size:40px;
    position: absolute;
    top:60px;
    left:400px;
}
#img1
{
position:absolute;
top:0px;
right:0px;
bottom:0px;
}
#hyzx {
    margin-left:20px;
    line-height:30px;
    background-color:#ffffff;
    height:420px;
    width:600px;
    float:left;
    padding:5px;
    border:1px solid #000;	      
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布帖子</title>
</head>
<body>
<div>
<form action="pubilshforum" method="post">
<fieldset>
<legend>发帖</legend>
<ul>
  <li>选择帖子分类
        <select name="Classification">
              <option value="数学" >数学</option>
               <option value="物理" >物理</option>
               <option value="文学" >文学</option>
                <option value="经济" >经济</option>
                <option value="教育" >教育</option>
        </select>
<br>
<br>
<li>主题
<input type="text" name="title" style="width:750px" value="">
</li>
</ul>
<br>
<br>
<textarea name="contents" style="font-size:20px;height:400px;width:1000px">内容</textarea>
<br>
<input type="text" name="author" style="display:none;width:800px" value=<%=request.getParameter("user")%>>
<input type="submit" value="发表" style="margin-left:900px;height:25px;width:70px;font-size:20px">
</fieldset>
</form>
</div>
</body>
</html>