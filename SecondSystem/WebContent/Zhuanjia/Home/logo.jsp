<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.Bean.ZhuanjiaBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
    height:420px;
    width:200px;
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
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id=all>
<img src="./Image/bg_night.jpg" width="1600" height="350" />
<div id=biaoti>
<p> Welcome to SecondSystem!专家页面</p>

</div>
<div id="左栏">
<ul>
<div id="wd">
<h3>问答平台</h3>
<ul>
<li><a href=/SecondSystem/wentiliulan.jsp>平台入口</a></li>
</ul>
</div>
<div id="tl">
<h3>学术交流平台</h3>
<ul>
<li><a href= >发表文章</a></li>
<li><a href= >发起讨论</a></li>
<li><a href=/SecondSystem/tieziliulan.jsp>平台入口</a></li>
<li><a href=/SecondSystem/tieziliulan.jsp>推介个人研究成果</a></li>
</ul>
</div>
<div>
<form action="Savefile" method="post" enctype="multipart/form-data">
上传文件:<input id="file" type="file"  name="file" />
      <input type="submit" value="上传" /> ${result} 
</form>
下载:<a href="Downaction?filename=AV.mp4">AV.mp4</a> ${errorResult} 
</div>
</ul>

</div>

<div id=sousuo>
<form id=ss  action="Zhuanjiamessage" method="get">
<select>
  <option value ="行业资讯">行业资讯</option>
  <option value ="企业资讯">企业资讯</option>
  <option value ="专家资讯">专家资讯</option>
</select>
<input type="text" name="zixunsousuo" style="width:800px">
<input type="submit" name="搜索" value=搜索 style="width:50px">
</form>
</div>


<iframe id="jieguo" src="show.jsp" style="width:1100px">

</iframe>
</div>
</body>
</html>