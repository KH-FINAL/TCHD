<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/login.css" type="text/css">
</head>
<body>
	<section>
		<div id="login_div">
			<form method="post" action="testLogin.me">
				<div id="login_title">Login</div>
				
				<br><br>
				
				<div>
					<label class="login_label">&nbsp;&nbsp;&nbsp;아이디&nbsp;&nbsp;</label>
					<input type="text" id="input_id" class="login_input" name="userId">
				</div>
				
				<br><br>
				
				<div>
					<label class="login_label">비밀번호&nbsp;&nbsp;</label>
					<input type="password" id="input_pw" class="login_input" name="userPwd">
				</div>
				
				<br>
				
				<div id="login_find_div">
					<a href="id_find.html">아이디 찾기</a>&nbsp;&nbsp;
					<a>|</a>&nbsp;&nbsp;
					<a href="password_find.html">비밀번호 찾기</a>
				</div>
				
				<br><br>
				
				<div id="login_button_div">
					<button id="login_button" onclick="login();">로그인</button>
				</div>
				
				<br><br>
				
				<div id="login_signUp_div">
					<label>아직 회원이 아니신가요?&nbsp;&nbsp;</label> <a href="#">회원가입</a>
					<!-- !!!!!회원가입 링크 설정해야 함!!!!! -->
				</div>
			</form>
		</div>
	</section>
</body>
</html>