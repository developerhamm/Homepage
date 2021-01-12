<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String pagefile=request.getParameter("page");
if(pagefile==null){
pagefile="kh";
}
    %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
ul{list-style-type: none;}
#news1{
position:absolute;
top:100px; left:550px;
width:300px; height:100px;

/*border:1px solid black;*/ 													
font-size: 15px;
}
#top{
position:absolute;
top:0px; left:500px;
/*border:1px solid red;*/
}
.bottom{
position: absolute;
top:800px; left:500px;
width: 1000px; height:130px;
border:1px solid black;
background-color: skyblue;
}

</style>
<script type="text/javascript">
function kh01(){
window.open("popup.jsp","kh01","width=520, height=580");
}

</script>


<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body onload="kh01()">

<div id= "top">
<jsp:include page="top.jsp"/>
</div>

<div id= "left">
<jsp:include page="left.jsp"/>
</div>

<div id= "center">
<jsp:include page='<%= pagefile+".jsp" %>'/>
</div>

<div class="bottom">
<jsp:include page="bottom.jsp"/>
</div>

</body>
</html>