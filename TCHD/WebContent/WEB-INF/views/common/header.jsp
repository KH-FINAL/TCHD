<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member loginUser=  (Member)request.getSession().getAttribute("loginUser"); // 로그인했을 경우 세션에 아이디 저장
	String confirmPw = (String)request.getSession().getAttribute("confirmPw");
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
/* $(function() {
    $(window).scroll(function() {
        if ($(this).scrollTop() > 800) {
            $('#top_btn').show();
        } else {
            $('#top_btn').hide();
        }
    });
    

});
 */
 $(function(){
	 

 	 $(window).resize(function(){
		if($(window).width()<=1400){
			$("#remoteDiv").hide();
			$('#topBtn').hide();
			
		}else{
			$("#remoteDiv").show();
			$('#topBtn').show();
		} 
	 });
 	 
     $("#top_btn").click(function() {
         $('html, body').animate({
             scrollTop : 0
         }, 400);
     });
	 
 })
</script>
</head>
<body>
<header>
	<div id="headDiv">
	<% if(loginUser==null){ %>
		<div id="topBar"><a href="testLogin.me">로그인  </a><span> | </span><a href="joinForm.me">회원가입</a></div>
	<%}else if(loginUser.getMem_id().equals("admin")){ %>
		<div id="topBar"><span>관리자 님 안녕하세요</span><a href="testLogout.me" id="a_logout">로그아웃  </a><span> | </span><a href="">관리자페이지</a></div>
	<%}else{ %>
		<div id="topBar"><span><%=loginUser.getMem_name()%> 님 안녕하세요 </span><a href="testLogout.me" id="a_logout">로그아웃  </a><span> | </span><a href="myPage.me">마이페이지</a></div>
	<%} %>
		<div id="topDiv">
			<div id="title"><a href="<%=request.getContextPath() %>"><img alt="로고" src="images/pets(1).png"> 함께하묘 행복하개</a></div>
			<div id="navi">
				<ul >
						<li>사이트소개</li>
						<li>참여하기</li>
						<li>후원하기</li>
						<li>정보마당</li>
						<li>고객센터</li>
				</ul>
			</div>
		</div>
	</div>
	
	<div id="remoteDiv">   <!-- 리모컨 -->
		<img src="images/pets(1).png" >
		<img src="images/pets(1).png" >
		<img src="images/pets(1).png" >
		<img src="images/pets(1).png">
	</div>
	<a id="topBtn" href="#"><img src="images/pets(1).png" ></a>
</header>
</body>
</html>