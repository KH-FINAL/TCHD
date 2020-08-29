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
		<!-- 	<form method="post" action="login.me" onsubmit="return validate();"> -->
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
					<a href="findIdForm.me">아이디 찾기</a>&nbsp;&nbsp;
					<a>|</a>&nbsp;&nbsp;
					<a href="findPwdForm.me">비밀번호 찾기</a>
				</div>
				
				<br><br>
				
				<div id="login_button_div">
					<button id="login_button" onclick="validate();">로그인</button>
				</div>
				
				<br><br>
				
				<div id="login_signUp_div">
					<label>아직 회원이 아니신가요?&nbsp;&nbsp;</label> <a href="joinForm.me">회원가입</a>
					<!-- !!!!!회원가입 링크 설정해야 함!!!!! -->
				</div>
	<!-- 		</form> -->
		</div>
		
		<script>
			function validate(){
				var id = $("#input_id");
				var pwd = $("#input_pw");
				
				if(id.val().trim().length == 0){
					swal("","아이디를 입력해주세요.","info")
					.then((ok)=>{ 
						if(ok){
							id.focus();
						}
					});
					
					//return false;
					return;
				}
				
				if(pwd.val().trim().length == 0){
					swal("","비밀번호를 입력해주세요.","info")
					.then((ok)=>{
						if(ok){
							pwd.focus();
						}
					});
					
					//return false;
					return;
				}
					
				$.ajax({
					url: "login.me",
					type: "post",
					data: {userId:id.val(), userPwd:pwd.val()},
					success: function(data){
						console.log(data);
						if(data==1){
							location.href="<%= request.getContextPath()%>";
						}else{
							swal("로그인 실패","입력한 정보를 가진 회원이 없습니다.","error");
							id.val("");
							pwd.val("");
						}
					},
					error: function(data){
						alert("ajax에러 발생");
					}
				});
			}
		</script>
	</section>
</body>
</html>