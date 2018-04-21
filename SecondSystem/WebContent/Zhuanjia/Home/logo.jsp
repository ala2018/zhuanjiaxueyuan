<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
<style>
#all{
    width:1600px;
}
#ss{
    margin-left:280px;
    margin-top:30px;
    height:50px;
    font-size:20px;
}
#biaoti{
    color:rgb(255,255,255);
    font-size:40px;
    position: absolute;
    top:60px;
    left:450px;
}
#左栏 {
    line-height:30px;
    background-color:#ffccff;
    height:100%;
    width:300px;
    float:left;
    padding:5px;
    top:350px;    
}
#hyzx {
    margin-left:20px;
    line-height:30px;
    background-color:#ffffff;
    width:1100px;
    float:left;
    padding:5px;
}

div.showjieguo {
    background-color:#F0F8FF;
     position: absolute;
        top:400;
    left:320px;
    width:85%;
     min-height:100%;
    border:1px solid #000000;	
}
</style>
<script type="text/javascript" >
function search()
{   
	if(false)
	      {window.alert("未登录，拉取信息失败！");}
	else
		{
		document.getElementById("showsousuo").innerHTML="<p align=\"center\">正在搜索</p>";
		var url="getsearch?key="+document.getElementById("sousuokey").value;
		 window.alert(url);
		createsearch(url);
		}
}
/*
 * ajax
 */
function createsearch(url){
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
	          window.alert(url);
	http_request.onreadystatechange=getsearchresult;
	http_request.open("POST",url,true);
	http_request.send(null);
}

/*
 * 回调函数
 */
 function getsearchresult(){
		
		if(http_request.readyState==4)
		{
			if(http_request.status==200)
			{
				 	
			var htm=http_request.responseText;
		    	document.getElementById("showsousuo").innerHTML=htm;

			}
		}else
		{
		       // alert("请求出现错误!");	
		}
	}
</script>
<title>Welcome to SecondSystem!</title>
</head>
<body>
<div id=all>
<img src="./Image/bg_night.jpg" width="1600" height=400 />
<div id=biaoti>
<p> Welcome to SecondSystem!</p>

</div>
<div id="左栏">
<div id="wd">
<h3>问答平台</h3>
<ul>
<li><a href="">平台入口</a></li>
</ul>
</div>
<div id="tl">
<h3>学术交流平台</h3>
<ul>
<li><a href=fabiaowenzhang.jsp >发表文章</a></li>
<li><a href= >发起讨论</a></li>
<li><a href=/SecondSystem/tieziliulan.jsp>平台入口</a></li>
<li><a href=/SecondSystem/tieziliulan.jsp>推介个人研究成果</a></li>
</ul>
</div>
<div>
<form action="Savefile" method="post" enctype="multipart/form-data">
上传文件:<input id="file" type="file"  name="file" style="width:100%"/>
      <input type="submit" value="上传"  /> ${result} 
</form>
下载:<a href="Downaction?filename=AV.mp4">MV.mp4</a> ${errorResult} 
</div>

</div>

<div id=sousuo>
<select>
  <option value ="行业资讯">行业资讯</option>
  <option value ="企业资讯">企业资讯</option>
  <option value ="专家资讯">专家资讯</option>
</select>
<input id ="sousuokey" type="text" name="zixunsousuo" style="width:800px">
<input type="submit" name="搜索" value=搜索 style="width:50px" onclick="search()">
</div>
<div id="showsousuo" class="showjieguo" >

</div>
</div>
</body>
</html>