<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.Member"%>
<%
    Member loginUser = (Member)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<link href="css/support/support_list.css" rel="stylesheet" type="text/css">
</head>
<body>
	<section>
		<div id="ment">후원 내역</div>

		<div id="main_div">
			<div>
				<div id="search_div">
					<input type="month" id="search_button">
<!-- 					<script>
						$('#search_month').val() = new Date().toISOString().slice(0, 7);
					</script> -->
				</div>
				<div id="support_list_div">
					<table id="support_list_table">
						<tr>
							<th>번호</th>
							<th>날짜</th>
							<th>금액</th>
						</tr>
						<tr>
							<td>1</td>
							<td>2020/08/01</td>
							<td>10,000</td>
						</tr>
						<tr>
							<td>2</td>
							<td>2020/08/05</td>
							<td>50,000</td>
						</tr>
						<tr>
							<td>3</td>
							<td>2020/08/10</td>
							<td>100,000</td>
						</tr>
					</table>
				</div>
			</div>
			<div id="total_price">
				<span>총 후원 금액 </span>
				<span id="total_price_won">0</span>
				<span>원</span>
			</div>
		</div>
	</section>
</body>
</html>