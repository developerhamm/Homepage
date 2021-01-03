<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
ul{list-style-type: none;}
.kh01{
    width:100px; height:50px;
}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<form action="../passcheckconfirm.mb" method="get">
<ul>
   <li><label for="패스워드">패스워드</label>
       <input type="text" name="id" autofocus="autofocus" required="required" placeholder="찾을패스워드아이디입력">
   </li>
   <li><input type="image" src="../images/submit.jpg" class="kh01">
   </li>
</ul>
</form>
</body>
</html>