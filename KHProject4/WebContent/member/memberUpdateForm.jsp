<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body{background-image: url(images/back01.jpg)}
ul{list-style-type: none;}
.kh01{
    width:100px; height:50px;
}
#memberUpdateForm{
   position: absolute;
   top:300px;left:600px;
   width:500px;
   border: 1px solid orange;
}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<div id="memberUpdateForm">
<h1>회원아이디수정폼</h1>
<form action="memberUpdateConfirm.mb" method="get">
<ul>
   <li><label for="아이디">아이디</label>
       <input type="text" name="id" autofocus="autofocus" required="required" placeholder="수정할아이디입력">
   </li>
   <li><input type="image" src="images/update.jpg" class="kh01"></li>   
</ul>
</form>
</div>
</body>
</html>