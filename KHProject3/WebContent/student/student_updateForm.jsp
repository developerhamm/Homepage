<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.kh01{
   width:100px; height:70px;
}
#studentUpdate{
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
<h1>학생수정</h1>
<div id="studentUpdate">
<form action="../studentUpdate.do" method="get">
<ul>
   <li><label for="수정할이름">수정할이름</label>
       <input type="text" name="irum">
   </li>
   <li><input type="image" src="../images/update.png" class="kh01">
   </li>
</ul>
</form>
&nbsp;&nbsp;&nbsp;<a href="studentList.jsp">학생전체출력</a>
</div>
</body>
</html>