<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/leave.css" type="text/css">
<link rel="stylesheet" href="css/nav.css" type="text/css">
</head>
<body>
	<section>
		<nav>
			<ul id="pageNavi">
				<li id="pageNaviTitle"><a href="myPage.me">마이페이지</a></li>
				<li><a href="myPage.me">회원정보수정</a></li>
				<li><a href="listMyBoard.bo">내가 작성한 글</a></li>
				<li><a href="listMyVolunteer.vo">참여 봉사 내역</a></li>
				<li><a href="leaveForm.me">회원 탈퇴</a></li>
			</ul>
		</nav>
		<div id="all_div">
			<div id="ment">회원 탈퇴</div>
			<div id="info">
				탈퇴를 원하시면 비밀번호를 입력해주세요.<br>
				단, 동일한 아이디로 재가입은 불가능합니다.
			</div>
			<form method="post" action="leave.me" onsubmit="return validate();">
				<div id="box_div">
					<div id="input_div">
						<label id="label_pwd">비밀번호</label>
						<input type="password" id="input_pwd" name="input_pwd">
					</div>
					<button id="leave_button">탈퇴</button>
				</div>
			</form>
		</div>
		
		<script>
		function validate(){
			var pwd = $("#input_pwd");
			
			if(pwd.val().trim().length == 0){
				alert("비밀번호를 입력해주세요.");
				pwd.focus();
				
				return false;
			}
			
			return true;
		}
		</script>
	</section>
</body>
</html>