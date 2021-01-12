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
<form action="../idcheckconfirm.mb" method="get">
<ul>
   <li><label for="전화번호">전화번호</label>
       <input type="text" name="tel" required="required" autofocus="autofocus" placeholder="전화번호입력">
   </li>
   <li><input type="image" src="../images/submit.jpg" class="kh01"></li>
</ul>
</form>
</body>
</html>