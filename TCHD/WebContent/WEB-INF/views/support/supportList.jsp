<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="support.model.vo.Support, java.util.ArrayList"%>
<%
    String supNo = (String)request.getAttribute("supNo");
	Support support = (Support)request.getAttribute("support");
	ArrayList<Support> supportList = (ArrayList<Support>)request.getAttribute("supportList");
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
							<th>후원 번호</th>
							<th>후원 날짜</th>
							<th>후원금</th>
						</tr>
					<% if(supNo == null){ %>
						<%-- 회원 (로그인) --%>
						<% for(Support supportMem : supportList){ %>
						<tr>
							<td><%= supportMem.getSup_no() %></td>
							<td><%= supportMem.getSup_date() %></td>
							<td><%= supportMem.getSup_price() %></td>
						</tr>
						<% } %>
					<% }else{ %>
						<%-- 비회원 --%>
						<tr>
							<td><%= support.getSup_no() %></td>
							<td><%= support.getSup_date() %></td>
							<td><%= support.getSup_price() %></td>
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