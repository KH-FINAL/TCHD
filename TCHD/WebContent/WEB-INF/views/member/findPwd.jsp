<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/member/find_pwd.css" type="text/css">
</head>
<body>
	<section>
		<div id="pw_find_div">
			<div id="find_button_div">
				<input type="button" class="find_button" value="아이디 찾기" onclick="location.href='findIdForm.me'" style="cursor: pointer">
				<input type="button" class="find_button" value="비밀번호 찾기" disabled>
			</div>
			
			<br>
			
			<div id="pw_find_message">
				<div id="pw_find_title">비밀번호 찾기</div>
				<div>
					비밀번호가 기억나지 않으세요?<br>
					아이디를 입력하시면 가입하신 이메일을 통해 비밀번호 재설정이 가능합니다.<br>
					본인인증 시 입력하시는 정보는 인증 이외의 용도로 사용 또는 저장하지 않습니다.
				</div>
			</div>
			
			<br><br>
			
			<form method="post" action="findPwd.me" onsubmit="return validate();">
				<div id="input_div">
					<input type="text" id="input_id" class="input" name="input_id" placeholder="아이디">
				</div>
				<br>
				<div id="input_button_div">
					<button id="input_button">입력</button>
				</div>
			</form>
		</div>
		
		<script>
		function validate(){
			var id = $("#input_id");
			
			if(id.val().trim().length == 0){
				alert("아이디를 입력해주세요.");
				id.focus();
				
				return false;
			}
			
			return true;
		}
		</script>
	</section>
</body>
</html>