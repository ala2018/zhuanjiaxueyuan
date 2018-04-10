<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
#zhucejiemian { 
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
#zhuceanniu {
    left: 100px;
    position: absolute;
}
</style>
<script type="text/javascript">
function upperCase1()
{
	var x=document.getElementById("yhm").value;
	if(x.length<16&&x.length>1)
		text1.innerHTML="用户名合法"; 
	else
	text1.innerHTML="请重新输入用户名";
}
function upperCase2()
{
	var y=document.getElementById("pwd1").value;
	if(y.length<16&&y.length>1)
	text2.innerHTML="密码合法";
	else
	text2.innerHTML="请重新输入密码";
}
function upperCase3()
{
	var pwd1=document.getElementById("pwd1");
	var pwd2=document.getElementById("pwd2");
	if(pwd1.value !=pwd2.value)
		text3.innerHTML="密码不一致";  
	else
		text3.innerHTML="密码一致";
	
}
function upperCase4()
{
	var x=document.getElementById("yhm").value;
	var y=document.getElementById("pwd1").value;
	var pwd1=document.getElementById("pwd1");
	var pwd2=document.getElementById("pwd2");
	if(pwd1.value ==pwd2.value&&y.length<16&&y.length>1&&x.length<16&&x.length>1)
	zhuce.style.display="block";
	
}
</script>
<title>Insert title here</title>
</head>
<body>
<div id=all>
<img src="./Image/bg_night.jpg" width="1600" height="350" />
<div id=biaoti>
<p> Welcome to SecondSystem!Please login in.</p>
</div>
<div id=zhucejiemian>
<!-- <form action="zhuce" method="post"> -->
<h2 align="center">用户注册</h2>
<p align="center">用户名：<input type="text" id="yhm" onblur="upperCase1()&upperCase4()"></p>
<p id=text1>用户名长度小于15字节</p>
<p align="center">输入密码：<input type="password" id="pwd1" onblur="upperCase2()&upperCase4()"> </p>
<p id=text2>密码长度小于15字节，包含英文，数字，符号其中两个</p>
<p align="center">重复密码：<input type="password" id="pwd2" onblur="upperCase3()&upperCase4()"> </p>
<p id=text3>确保两次输入的密码一致</p>
<div id=zhuanjiaxueyuanxuanze>
<p align="center">选择用户类别<br>

<input type="radio" name="xuanze" value="专家用户" checked>专家用户
<input type="radio" name="xuanze" value="学员用户">学员用户
</div>
<div id=zhuceanniu>
<input name=zhuce type="submit" value="点击注册" onclick="upperCase4()" style=display:none>
</div>
<!-- </form> -->
</div>
</div>
</body>
</html>