<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body{background-image: url("images/back01.jpg");}
#memberoutForm{
  position: absolute; 
  top:300px;left:800px;
  width:400px;
  border: 1px solid orange;
}
ul{list-style-type: none;}
.kh01{
    width:100px; height:50px;
}
.reset{
   font-size: 25px;
}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<div id="memberoutForm">
<form action="../memberDelete.mb" method="get">
<ul>
   <li><label for="패스워드">패스워드</label>
       <input type="password" name="pw" required="required" autofocus="autofocus" placeholder="탈퇴할패스워드입력">
   </li>
   <li><input type="image" src="../images/submit.jpg" class="kh01"></li>
   
</ul>
</form>
</div>
</body>
</html>