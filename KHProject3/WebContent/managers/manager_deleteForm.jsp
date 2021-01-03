<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.kh01{
   width:100px; height:70px;
}
#managerDelete{
   border: 1px solid blue;
   border-radius: 20px;
   width:500px; 
}
ul{list-style-type: none;}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<h1>관리자삭제</h1>
<div id="managerDelete">
<form action="../managerDelete.do" method="get">
<ul>
   <li><label for="삭제이름">삭제이름</label>
       <input type="text" name="irum">
   </li>
   <li><input type="image" src="../images/delete.png" class="kh01">
   </li>
</ul>
</form>
</div>
</body>
</html>