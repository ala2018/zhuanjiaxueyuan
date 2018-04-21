<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#zuolan {
    line-height:30px;
    background-color:#eeeeee;
     position: absolute;
    width:200px;
    top:400px;
    float:left;
    padding:5px;
    border:1px solid #000;	      
}
#zhuneirong {
    line-height:30px;
     position: absolute;
    height:420px;
    width:1000px;
    top:350px;
    float:left;    
    left:300px; 
}
#biaoti{
    color:rgb(255,255,255);
    font-size:40px;
    position: absolute;
    top:125px;
    left:620px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<img src="./Image/bg_night.jpg"  width="1400px" height="350px">
<div id=biaoti>
<p>论坛平台</p>
</div>
<div id=zuolan>
<li><a href=./wendapingtai.jsp >问答平台</a></li>
<li><a href=./show.jsp >论坛中心</a></li>
<li><a href=./personHome.jsp >个人中心</a></li>
</div>
<div id=zhuneirong>

<fieldset style="width:900px">
<legend>aaa</legend>
<div>
<input type="text" name="title" style="width:800px" readonly value=aaa>
<br>
<br>
<textarea name="contents" style="font-size:20px;height:200px;width:800px" readonly>aaa</textarea>
<br>
<input type="text" style=display:none name="author" style="width:800px" value="郭襄">
</div>
<p>作者aaa</p>
<p>文章分类aaa</p>
</fieldset>
<h3>用户回复</h3>
<!-- 循环 -->
<div>
<fieldset style="width:900px">
<legend>aaa</legend>
<div>
<textarea style="font-size:20px;height:200px;width:800px" readonly>aaa</textarea>
<br>
<input type="text" style=display:none style="width:800px" value="郭襄">
</div>
<p>用户名aaa</p>
</fieldset>
</div>
<div>
<fieldset style="width:900px">
<form action="fabiaohuifu" method="post">
<fieldset>
<legend>发表回复</legend>
<textarea style="font-size:20px;height:200px;width:800px">内容</textarea>
<br>
<p>用户名：<input type="text" style="height:30px;width:140px;font-size:20px" style="width:800px"><p>
<input type="submit" value="发表" style="height:55px;width:140px;font-size:20px"></fieldset>
</form>
</fieldset>
</div>

</div>
</body>
</html>