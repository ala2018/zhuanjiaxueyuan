<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.Bean.ZhuanjiaBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
    width:200px;
    top:200px;
    float:left;
    padding:5px;
    border:1px solid #000;	      
}

#biaoti{
    color:rgb(255,255,255);
    font-size:40px;
    position: absolute;
    top:60px;
    left:400px;
}
#gerenjiemian{ 
line-height:30px;
    margin:auto;
    height:420px;
    float:left;
    padding:5px;   
    left: 240px;
    top: 200px;
    position: absolute;
}
#chengguojiesao{ 
line-height:30px;
    margin:auto;
    height:420px;
    float:left;
    padding:5px;   
    left: 240px;
    top: 500px;
    position: absolute;
}
#fabiaotaolun{ 
line-height:30px;
    margin:auto;
    height:420px;
    float:left;
    padding:5px;   
    left: 240px;
    top: 800px;
    position: absolute;
}
#jiejuewenti{ 
line-height:30px;
    margin:auto;
    height:420px;
    float:left;
    padding:5px;   
    left: 240px;
    top: 1100px;
    position: absolute;
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
</style>
<title>Insert title here</title>
</head>

<body>
<div id=bg>
<img id=img1 src="./Image/222.jpg" width="1200" height="500">
<img id=img2 src="./Image/111.jpg" width="1200" height="500">
<div id=all>
<div id=biaoti>
<p> Welcome to 个人界面</p>
</div>
<div id=title>

</div>
<div id=zuolan>
<img src="./Image/timg.jpg" width="200" height="200" />
<div id=touxianganniu>
<input id=touxiang type="submit" value="点击上传" >
</div>
<div id=chaolianjie     style="margin-left:20px;">
<li><a href= >个人研究成果</a></li>
<li><a href= >个人关注</a></li>
<li><a href= >问答平台</a></li>
<li><a href= >论坛中心</a></li>
<li><a href=./fabiaowenzhang.jsp >发表文章</a></li>
<li><a href=Zhuanjiamessage >浏览文章</a></li>
</div>
</div>
<div id=gerenjiemian>
<fieldset style="width:800px">
<legend>个人介绍</legend>
<textarea style="font-size:20px;height:200px;width:700px"></textarea>
<br>
<input type="submit" value="保存" style="height:55px;width:200px;font-size:20px"></fieldset>
</div>
<div id=chengguojiesao>
<fieldset style="width:800px">
<legend>个人成果</legend>
<textarea style="font-size:20px;height:200px;width:700px"></textarea>
<br>
</fieldset>
</div>
<div id=fabiaotaolun>
<fieldset style="width:800px">
<legend>发表过的讨论</legend>
<textarea style="font-size:20px;height:200px;width:700px"></textarea>
<br>
</fieldset>
</div>
<div id=jiejuewenti>
<fieldset style="width:800px">
<legend>解决过的问题</legend>
<textarea style="font-size:20px;height:200px;width:700px"></textarea>
<br>
</fieldset>
</div>
</div>
</div>
</body>
</html>