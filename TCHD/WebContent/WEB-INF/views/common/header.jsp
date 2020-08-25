<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.model.vo.Member"%>
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
     
     $('.naviDetail_li').hover(function(){
    	 $(this).find('.menuBar').css("visibility",'visible');
     }, function(){
    	 $(this).find('.menuBar').css("visibility",'hidden');
     })
 });
</script>
</head>
<body>
<header>
	<div id="headDiv">
	<% if(loginUser==null){ %>
		<div id="topBar"><a href="loginForm.me">로그인  </a><span> | </span><a href="joinForm.me">회원가입</a></div>
	<%}else if(loginUser.getMem_id().equals("admin")){ %>
		<div id="topBar"><span>관리자 님 안녕하세요</span><a href="logout.me" id="a_logout">로그아웃  </a><span> | </span><a href="">관리자페이지</a></div>
	<%}else{ %>
		<div id="topBar"><span><%=loginUser.getMem_name()%> 님 안녕하세요 </span><a href="logout.me" id="a_logout">로그아웃  </a><span> | </span><a href="myPage.me">마이페이지</a></div>
	<%} %>
		<div id="topDiv">
			<div id="title"><a href="<%=request.getContextPath() %>"><img alt="로고" src="images/pets(1).png"> 함께하묘 행복하개</a></div>
			<div id="navi">
				<ul class="naviDetail_ul" >
						<li class="naviDetail_li"><a href="#">사이트소개</a></li>
						<li class="naviDetail_li"><a href="#">참여하기</a><ul id="menuBar1" class="menuBar">
								<li><a href="#">입양</a></li>
								<li><a href="#">봉사</a></li>
							</ul>
						</li>
						<li class="naviDetail_li"><a href="#">후원하기</a><ul id="menuBar2" class="menuBar">
								<li><a href="#">후원</a></li>
								<li><a href="#">후원내역 확인</a></li>
							</ul>
						</li>
						<li class="naviDetail_li"><a href="#">정보마당</a><ul id="menuBar3" class="menuBar">
							<li><a href="#">공지사항</a></li>
							<li><a href="#">동물병원</a></li>
						</ul ></li>
						<li class="naviDetail_li"><a href="#">고객센터</a><ul id="menuBar4" class="menuBar">
								<li><a href="#">문의게시판</a></li>
							</ul>
							</li>
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