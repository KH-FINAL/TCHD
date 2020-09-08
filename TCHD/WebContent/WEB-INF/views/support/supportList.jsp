<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.Member"%>
<%
    String supNo = (String)request.getAttribute("supNo");
	System.out.println("list.jsp_supNo : " + supNo);
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
				<div id="search_date_div">
					<input type="month" id="input_search_date">
					<script>
						var date = new Date().toISOString().slice(0, 7);
// 						$("#input_search_date").html(date);
// 						console.log($("#input_search_date").html());
					</script>
				</div>
				<div id="support_list_div">
					<table id="support_list_table">
						<tr>
							<th>번호</th>
							<th>날짜</th>
							<th>금액</th>
						</tr>
					<% if(supNo == null){ %>
						<%-- 회원 (로그인) --%>
						<tr>
							<td>1</td>
							<td>2020/08/01</td>
							<td>10,000</td>
						</tr>
					<% }else{ %>
						<%-- 비회원 --%>
						<tr>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					<% } %>
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