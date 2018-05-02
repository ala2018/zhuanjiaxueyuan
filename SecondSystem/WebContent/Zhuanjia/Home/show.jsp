<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.Bean.ArticleBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
#img1{
  position:absolute;
  top:0px;
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
        top:0px;
    width:1150px;
    margin-left:230px;
    border:1px solid #000000;	      
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
a.wenzhangbiaoti{text-decoration:none;
    background-color:#F0F8FF;
}
a.zuozhe{text-decoration:none;
    background-color:#F0FFF0;
}
a.fenlei{text-decoration:none;
    background-color:#F0FFF0;
}
</style>
<script type="text/javascript">
var page=1;
function addpage(){
	if(page<1000){
	page++;
	getArticle();
	}
	else
		alert("已经是最后一页");
}
function subpage(){
	if(page>0){
	page--;
	getArticle();
	}
	else{
		alert("已经是第一页");
	}
}
function getArticle()
{   
	if(false)
	      {window.alert("未登录，拉取信息失败！");}
	else
		{var url="Allarticlemessage?page="+page;
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
		    	document.getElementById("showarticle").innerHTML=htm+"<div class='showpage'><p><span id='uppage'><a href='' class='yang' onclick='subpage();return false'>上一页</a></span ><span id='nextpage'><a href='' class='yang' onclick='addpage();return false'>下一页</a></span></p></div>";

			}
		}else
		{
		        // alert("请求出现错误!");	
		}
	}
	
</script>
<title>浏览文章</title>
</head>
<body>
<img id=img1 src="./Image/222.jpg" width="1200" height="500">
<div id="all" >	
   <div id="showarticle" class="show">
	<%
	int i=0;
	String hre="";
	ArrayList<ArticleBean> list=(ArrayList<ArticleBean>)session.getAttribute("list");
	//ArrayList<ArrayList<String>> zjlist=(ArrayList<ArrayList<String>>)session.getAttribute("zjlist");
    for(ArticleBean art:list){
    	hre="showwenzhang.jsp?tindex="+i;
    	i++;
	%>

   <fieldset style="border:3px solid blue;">
     <legend>文章</legend>
     <div style="border:1px solid red;">
        <h4><a class="wenzhangbiaoti" href=<%=hre%>><%=art.getTitle()%></a></h4>
        <p><a class="zuozhe" href="" ><%="作者:"+art.getAuthor()%></a></p>
        <p><a class="fenlei" href=""><%="文章分类:"+art.getClassification()%></a></p>
        <div>
           <p>简介</p><%=art.getContents().substring(0,100)+"..."%>
         </div>
     </div>
     <div><p>时间:<%=art.getDate()%></p></div>
   </fieldset>
	<%}%>
	  <div class="showpage">
      <p><span id="uppage"><a href="" class="yang" onclick="subpage();return false">上一页</a></span >
         <span id="nextpage"><a href="" class="yang" onclick="addpage();return false">下一页</a></span></p>
   </div>
	</div>

</div>
</body>
</html>