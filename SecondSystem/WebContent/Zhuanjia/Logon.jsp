<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#all{
width:1600px;
}
#biaoti{
    color:rgb(255,255,255);
    font-size:40px;
    position: absolute;
    top:60px;
    left:400px;
}
#denglujiemian { 
line-height:30px;
    margin:auto;
    height:420px;
    width:300px;
    float:left;
    padding:5px;   
    left: 590px;
    top: 350px;
    position: absolute;
}
#anniu {
    left: 100px;
    position: absolute;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SecondSystem</title>
</head>
<body>
<div id=all>
<img src="./Home/Image/bg_night.jpg" width="1600" height="350" />
<div id=biaoti>
<p> Welcome to SecondSystem!Please login in.</p>
</div>
<div id=denglujiemian>
<form action="login" method="post">
<h2 align="center">用户登录</h2>
<p align="center">用户：<input type="text" name="user"></p>
<p align="center">密码：<input type="password" name="pwd"> </p>
<div id=zhuanjiaxueyuanxuanze>
<p align="center">选择用户类别<br>
<input type="radio" name="xuanze" value="专家用户" checked>专家用户
<input type="radio" name="xuanze" value="学员用户">学员用户
</div>
<div id=anniu>
<input name=dl type="submit" value="登录">
&emsp;
<input name=qx type="reset" value="取消">
</div>
</form>
</div>
</div>
</body>
</html>