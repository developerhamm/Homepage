<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
  <meta charset="utf-8">
  <title>대구가톨릭대학교</title>
  <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
  <script src="js/jquery.innerfade.js"></script>
  <link href="css/top.css" rel="stylesheet" type="text/css">
 </head>
 <body>
  <div id="ALL">
   <h1><img src="images/kh.png" class="kh"></h1>
   <div class="menu">
    <ul>
     <li><%String id=(String)session.getAttribute("id");
          if(id!=null){
             out.print("<a href=index.jsp?page=haksaInfo>학사소개</a>");
          }else{
        	  out.print("<a href=index.jsp?page=kh onclick=alert('로그인하세요')>학사소개</a>");
          }
          %></li>
     <li><%if(id!=null){ 
           out.print("<a href=boardList.bo>커뮤니티</a>");
           }else{
        	   out.print("<a href=index.jsp?page=kh onclick=alert('로그인하세요')>커뮤니티</a>");
           }
           %>           
           </li>
     <li><a href="mailForm.jsp">자바메일</a></li>
     <li><a href="zoomkh.jsp">KHB반클레스</a></li>
     <li><a href="thumnali.jsp">포트폴리오</a></li>
    </ul>
   </div>
   <div id="homeregister">
      <a href="#">홈|</a>
      <a href="index.jsp?page=member/memberForm">회원가입|</a>
      <% id = (String)session.getAttribute("id"); 
      if(id==null){ %>
      <a href=index.jsp?page=member/loginForm>로그인</a>
      <%} %>
      <div id="idlogin">
      <%
          id=(String)session.getAttribute("id");
          if(id!=null){
        	  out.print(id+"님 환영합니다.<br>");
        	  out.print("<a href=memberLogout.mb>로그아웃</a><br>");
        	  out.print("<a href=memberList.mb>회원목록</a><br>");
        	  out.print("<a href=member/memberoutForm.jsp>회원탈퇴</a><br>");
          }
      %>       
      </div>   
   </div>
  </div>
<!-- 실시간 검색어 -->   
   <div id ="news1">
      <ul id="news">
         <li>
            <a href="#n1">1 자바프로그래밍 </a>
         </li>
         <li>
            <a href="#n2">2 웹프로그래밍</a>
         </li>
         <li>
            <a href="#n3">3 데이터베이스</a>
         </li>
         <li>
            <a href="#n4">4 오라클</a>
         </li>
         <li>
            <a href="#n5">5 MYSQL</a>
         </li>      
      </ul>
   </div>
  <script src="js/top.js"></script>
     </body>
</html>