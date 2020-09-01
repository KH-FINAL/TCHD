<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/common/successPage.css" type="text/css">
</head>
<body>
	<section>
		<div id="all_div">
			<b id="message"><%=request.getAttribute("msg") %></b>
			
			<div id="ment_div">
				<p id="ment">그동안 ♡함께하묘 행복하개♡를 이용해주셔서 감사합니다.</p>
				<br>
				<button type="button" id="home_button" onclick="location.href='<%=request.getContextPath()%>'">메인페이지로</button>
			</div>
		</div>
	</section>
</body>
</html>