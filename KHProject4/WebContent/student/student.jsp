<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.kh01{
   width:100px; height:50px;
}
#studentRegister{
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
<h1>학생등록</h1>
<div id="studentRegister">
<form action="../studentRegister.do" method="get">
<ul>
   <li><label for="나이">나이</label>
       <input type="number" name="nai">
   </li>
   <li><label for="이름">이름</label>
       <input type="text" name="irum" size="20">
   </li>
   <li><label for="학번">학번</label>
       <input type="text" name="hakbun" size="20">
   </li>
   <li><input type="image" src="../images/submit.jpg" class="kh01"></li>
</ul>
</form>
</div>
<a href="studentList.jsp">학생전체출력</a>
<a href="../haksaInfo.jsp">학사관리</a>
</body>
</html>