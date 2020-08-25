<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/myPage_confirmPw.css" type="text/css">
<link rel="stylesheet" href="css/nav.css" type="text/css">
</head>
<body>
<section>	
	<article>
		<nav>
			<ul id="pageNavi"> 
				<li id="pageNaviTitle"><a href="myPage.me">마이페이지</a></li>
				<li><a href="myPage.me">회원정보수정</a></li>
				<li><a href="listMyBoard.bo">내가 작성한 글</a></li>
				<li><a href="listMyVoluteer.vo">참여 봉사 내역</a></li>
				<li><a href="#">회원 탈퇴</a></li>
			</ul>
		</nav>
		<form id="confirmPwForm" method="post" action="confirmPw.me">
			비밀번호를 입력해주세요.	
			<div >
				<label>비밀번호</label>
				<input type="password" name="inputPw" required><br>
				<button type="submit">확인</button>
			</div>
		</form>
	</article>
</section>
</body>
</html>