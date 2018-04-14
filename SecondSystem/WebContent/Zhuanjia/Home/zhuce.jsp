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
p.yang{
align:center;
}
</style>
<script type="text/javascript">

var httpRequest;
var Verification_code=null ;

//发送请求函数
function sendRequest(url){
   if(window.XMLHttpRequest)//非IE浏览器
   {
       httpRequest = new XMLHttpRequest();
  
   }else if (window.ActiveXObject)//IE浏览器
    {
         httpRequest = new ActiveXObject("Microsoft.XMLHHTTP");

     }
   alert(url);
     httpRequest.open("post",url,true);
     httpRequest.onreadystatechange = processResponse; //指定相应函数
     httpRequest.send(null);

}

//处理返回信息函数
function  processResponse(){
  if(httpRequest.readyState == 4)//判断对象状态
   {
     if (httpRequest.status == 200)
     {
        Verification_code=httpRequest.responseText;
        window.alert(Verification_code);
      }else
          {
             window.alert("请求页面异常");
          }
    }

}

//发送验证码
function mailCheck(){
     
     var usermail =document.getElementById("email").value;
     var url="Mailaction?usermail="+usermail;
     sendRequest(url);

}

function upperCase1()
{
	var x=document.getElementById("accout").value;
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
	var b=document.getElementById("name").value;
	var x=document.getElementById("accout").value;
	var y=document.getElementById("pwd1").value;
	var z=document.getElementById("sex").value;
	var pwd1=document.getElementById("pwd1");
	var pwd2=document.getElementById("pwd2");
	var emailRegex = /^\w+@\w+(\.\w+)+$/;  
	var c=document.getElementById("email").value;
	
	var code =document.getElementById("code").value;
	
	if(pwd1.value ==pwd2.value&&y.length<16&&y.length>1&&x.length<16&&x.length>1&&(z=="男"||z=="女")&&b!=""&&emailRegex.test(c)&& code == Verification_code )
		document.getElementById("zhuce").style.display="block";
	
}
function upperCase5()
{
	var x=document.getElementById("sex").value;
	if(x=="男"||x=="女")
		text5.innerHTML="性别正确";
	else
		text5.innerHTML="重新填写性别";
	
}

function upperCase6()
{
	var emailRegex = /^\w+@\w+(\.\w+)+$/;  
	var x=document.getElementById("email").value;
	if(x == "") {
		text6.innerHTML="格式错误";
    } else 
    	if(!emailRegex.test(x)) {
    	text6.innerHTML="格式错误";
    }
        else
        	text6.innerHTML="格式正确";
	
}
function upperCase7()
{
	var x=document.getElementById("name").value;
	if(x!="")
		text4.innerHTML="格式正确";
	else
		text4.tnnerHTML="您没填写名字";
	
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
<form action="zhuce" method="post"> 
<h2 align="center">用户注册</h2>
<p align="center">用户名：<input type="text" name="accout1" id="accout" onblur="upperCase1()&upperCase4()"></p>
<p id=text1 class="yang">用户名长度小于15字节</p>
<p align="center">输入密码：<input type="password" name="pwd11" id="pwd1"  onblur="upperCase2()&upperCase4()"> </p>
<p id=text2 align="center">请输入密码</p>
<p align="center">重复密码：<input type="password" id="pwd2" onblur="upperCase3()&upperCase4()"> </p>
<p id=text3>确保两次输入的密码一致</p>
<p align="center">姓名：<input type="text" name="name1" id="name"  onblur="upperCase7()&upperCase4()"> </p>
<p id=text4>请输入您的姓名</p>
<p align="center">性别：<input type="text" name="sex1" id="sex"  onblur="upperCase5()&upperCase4()"> </p>
<p id=text5>请输入您的性别</p>
 <p align="center">邮箱：<input type="text" name="email1" id="email" onblur="upperCase6()&upperCase4()"> </p>
<p id=text6>请输入您的邮箱</p> 
 <p align="center">验证码：<input type="text" id="code"  onblur="upperCase4()"  >  <input type ="button" value="发送验证码" onclick ="mailCheck();"  ></p>
<div id=zhuanjiaxueyuanxuanze>
<p align="center">选择用户类别<br>

<input type="radio" name="xuanze" value="专家用户" checked>专家用户
<input type="radio" name="xuanze" value="学员用户">学员用户
</div>
<div id=zhuceanniu>
<input id=zhuce type="submit" value="点击注册"  style=display:none>
</div>
</form> 
</div>
</div>
</body>
</html>