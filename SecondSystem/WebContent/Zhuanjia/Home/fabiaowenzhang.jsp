<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#左栏 {
    line-height:30px;
    background-color:#eeeeee;
    height:420px;
    width:200px;
    float:left;
    padding:5px;
    border:1px solid #000;	      
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
<title>提问</title>
</head>
<body>
<img src="./Image/bg_night.jpg" width="1400" height="350" />
<div>
<div>
<div id="左栏">
<ul>
<div id=zx>
<h3>资讯中心</h3>
<ul>
<li><a href=/SecondSystem/zhuyemian.jsp>行业资讯</a></li>
<li><a href=/SecondSystem/qiyezhixun.jsp>企业资讯</a></li>
<li><a href=/SecondSystem/zhuanjiazixun.jsp>专家资讯</a></li>
</ul>
</div>
<div id="wd">
<h3>问答平台</h3>
<ul>
<li><a href=/SecondSystem/fatie.jsp>提问</a></li>
<li><a href=/SecondSystem/wentiliulan.jsp>浏览</a></li>
</ul>
</div>
<div id="tl">
<h3>讨论平台</h3>
<ul>
<li><a href=/SecondSystem/tiwen.jsp>提出论题</a></li>
<li><a href=/SecondSystem/tieziliulan.jsp>浏览</a></li>
</ul>
</div>
</ul>
</div>
</div>
<div>
<form action="pubilsharticle" method="post">
<fieldset>
<legend>发表文章</legend>
<input type="text" name="zixunsousuo" style="width:800px" value="题目">
<br>
<br>
<textarea style="font-size:20px;height:200px;width:800px">内容</textarea>
<br>
<input type="submit" value="发表" style="height:55px;width:140px;font-size:20px"></fieldset>
</form>
</div>
</div>
</body>
</html>