<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/find_id.css" type="text/css">
</head>
<body>
	<section>
		<div id="id_find_div">
			<div id="find_button_div">
				<input type="button" class="find_button" value="아이디 찾기" disabled>
				<input type="button" class="find_button" value="비밀번호 찾기" onclick="location.href='findPwdForm.me'" style="cursor: pointer">
			</div>
			
			<br>
			
			<div id="id_find_message">
				<div id="id_find_title">아이디 찾기</div>
				<div>
					아이디가 기억나지 않으세요?<br>
					가입하신 이메일을 입력하시면 아이디를 확인하실 수 있습니다.<br>
					본인인증 시 입력하시는 정보는 인증 이외의 용도로 사용 또는 저장하지 않습니다.
				</div>
			</div>
			
			<br><br>
			
			<form method="post" action="findId.me" onsubmit="return validate();">
				<div id="input_div">
					<input type="text" id="input_name" class="input" name="input_name" placeholder=" 이름">
					<br><br>
					<input type="email" id="input_email" class="input" name="input_email" placeholder=" 이메일">
				</div>
				<br>
				<div id="input_button_div">
					<button id="input_button">입력</button>
				</div>
			</form>
		</div>
		
		<script>
		function validate(){
			var name = $("#input_name");
			var email = $("#input_email");
			
			if(name.val().trim().length == 0){
				alert("이름을 입력해주세요.");
				name.focus();
				
				return false;
			}
			
			if(email.val().trim().length == 0){
				alert("이메일을 입력해주세요.");
				email.focus();
				
				return false;
			}
			
			return true;
		}
		</script>
	</section>
</body>
</html>