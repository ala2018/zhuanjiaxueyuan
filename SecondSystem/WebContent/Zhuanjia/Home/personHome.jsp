<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.Bean.UserBean" %>
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
    line-height:30px;
    background-color:#F0F8FF;
     position: absolute;
    height:42px;
    width:800px;
    margin-left:210px;
    border:0px solid #000;	      
}
a.yang{text-decoration:none;
    background-color:#F0F8FF;
    position: relative;
    margin-left:20px;
}
</style>
<title>Insert title here</title>
</head>

<body>
<div id=bg>
<img id=img1 src="./Image/222.jpg" width="1200" height="500">
<img id=img2 src="./Image/111.jpg" width="1200" height="500">
<div id=all>
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
<%UserBean user=(UserBean)session.getAttribute("user"); %>
<li><a href=./fabiaowenzhang.jsp?<%="user="+user.getUser()%>>发表文章</a></li>
<li><a href=Zhuanjiamessage >浏览文章</a></li>
</div>
</div>
<div id=caidan class="caidan">
<a href=" " class="yang" >个人文章</a><a href=" " class="yang">历史讨论</a>
</div>
</div>
</div>
</body>
</html>
<script>

</script>