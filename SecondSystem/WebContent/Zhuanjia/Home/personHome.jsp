<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.Bean.UserBean" %>
    <%@ page import="com.Bean.ArticleBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
<style>

#bg{
position: absolute;
top:0px;
left:0px;
width:1200px;
bottom:0px;
  height:1600px;
}
#zuolan {
    line-height:30px;
    background-color:#eeeeee;
     position: absolute;
    height:420px;
    width:220px;
    top:0px;
    float:left;
    padding:5px;
    border:1px solid #000;	      
}


#img1
{
position:absolute;
top:0px;
right:0px;
}
#img2
{
position:absolute;
bottom:0px;
right:0px;
}

div.caidan {
    top:0px;
    background-color:#F0F8FF;
     position: absolute;
    height:20px;
    width:1150px;
    margin-left:230px;
    border:0px solid #000;	      
}
div.show {
     position: absolute;
        top:20px;
    width:1150px;
    margin-left:230px;
    border:1px solid #000000;	      
}

a.yang{text-decoration:none;
    background-color:#F0F8FF;
    position: relative;
    margin-left:20px;
}
div.contentcolor{
border:1px solid red;
}
div.showpage {
    background-color:#F0F8FF;
     position: absolute;
    float:right;
     text-align:right;
    height:35px;
    width:1150px;
    border:1px solid #000000;
     margin-right:20px;	      
}
p.page span{
   	font-weight:bold;
   	float:right;
   	margin-right:20px;
	color:#ff9955;
}
fieldset.showcontent{
    width:1100px;
    border:4px solid blue;
}
</style>
<%UserBean user=(UserBean)session.getAttribute("user"); %>
<title>欢迎<%=user.getName()%>来到个人主页!</title>

<script type="text/javascript">
var http_request;
var page=1;
var userid="";
var username
function inti(id,name){
	userid=id;
	username=name;
	linksocket();
	getmyArticle();
}
function getmyArticle()
{   
	if(userid==""||userid==null)
	      {window.alert("未登录，拉取信息失败！");}
	else
		{var url="getmyArticle?user="+userid+"&page="+page;
		creategetArticle(url);}
}
/*
 * ajax
 */
function creategetArticle(url){
	http_request=false;
	if(window.XMLHttpRequest)
	{
		http_request=new XMLHttpRequest();
	}else if(window.ActiveXObject)
		{
		try{
			http_request=new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e){
			try{
				http_request=ActiveXObject("Microsoft.XMLHTTP");
			}catch(e){
				window.alert("无法创建request对象");
			}
			
		}
		}
	http_request.onreadystatechange=getresult;
	http_request.open("GET",url,true);
	http_request.send(null);
}

/*
 * 回调函数
 */
 function getresult(){
		
		if(http_request.readyState==4)
		{
			if(http_request.status==200)
			{
			var htm=http_request.responseText;
		    	document.getElementById("showArt").innerHTML=htm;

			}
		}else
		{
		        // alert("请求出现错误!");	
		}
	}
	
	function showall(obj){
		var id = obj.id+"d";
		document.getElementById(id).style.display="block";
		obj.style.display="none";
		document.getElementById(obj.id.toUpperCase()).style.display="block";
	}
	
	function rebackall(obj){
		var id = obj.id.toLowerCase();
		document.getElementById(id).style.display="block";
		document.getElementById(id+"d").style.display="none";
		obj.style.display="none";
	}
function addpage(){
	page++;
	getmyArticle();
}
function subpage(){
	page--;
	getmyArticle();
}


var webSocket = null;  
var tryTime = 0;  
function linksocket() {  
	alert("开始建立websocket！");
    initSocket();  
  
    window.onbeforeunload = function () {  
    	alert("失去连接"); 
    };  
} 
  
/** 
 * 初始化websocket，建立连接 
 */  
function initSocket() {  
    if (!window.WebSocket) {  
        alert("您的浏览器不支持websocket！");  
        return false;  
    }  
  
    if (window.location.protocol == 'http:') {
    	webSocket = new WebSocket("ws://127.0.0.1:8080/websocket/" + userid + "/" + username);
    } else {
    	  webSocket = new WebSocket("wss://127.0.0.1:8080/websocket?userId=" + userid + "&username=" + username); 
    }
   
      
    // 收到服务端消息  
    webSocket.onmessage = function (msg) {  
        alert("msg:"+msg);
    	console.log(msg);  
    };  
      
    // 异常  
    webSocket.onerror = function (event) { 
    	alert("onerror event:"+event);
        console.log(event);  
    };  
      
    // 建立连接  
    webSocket.onopen = function (event) { 
    	alert("opopen event:"+event);
        console.log(event);  
    };  
  
    // 断线重连  
    webSocket.onclose = function () {  
        // 重试10次，每次之间间隔10秒  
        if (tryTime < 3) {  
            setTimeout(function () {  
                webSocket = null;  
                tryTime++;  
                initSocket();  
            }, 500);  
        } else {  
            tryTime = 0;  
        }  
    };  
  
}
</script>
</head>
<body onload="inti(use.user.value,use.username.value)">
<form id="use" name="use" action="" method="post" style=display:none>
<p align="center">用户：<input type="text" name="user" id="user" value=<%=user.getUser()%>></p>
<p align="center">用户名：<input type="text" name="username" id="username" value=<%=user.getName()%>></p>
</form>
<img id=img1 src="./Image/222.jpg" width="1200" height="500">
<!-- <img id=img2 src="./Image/111.jpg" width="1200" height="500">-->
<div id=all>
<div id=zuolan>
<img src="./Image/timg.jpg" width=100% height="200" />
<div id=touxianganniu>
<input id=touxiang type="submit" value="点击上传" >
</div>
<div id=chaolianjie     style="margin-left:20px;">
<li><a href="" >个人研究成果</a></li>
<li><a href="" >个人关注</a></li>
<li><a href="" >问答平台</a></li>
<li><a href="logo.jsp" >资讯获取</a></li>
<li><a href= >论坛中心</a></li>
<li><a href=./fabiaowenzhang.jsp?<%="user="+user.getUser()%>>发表文章</a></li>
<li><a href=Zhuanjiamessage >浏览文章</a></li>
</div>
</div>
<div id=caidan class="caidan">
<a class="yang" href="" onclick="getmyArticle();return false">个人文章</a><a class="yang"  href="" onclick="return false">讨论历史</a>
</div>
<div class="show"  id="showArt">

</div>
</div>
</body>
</html>
