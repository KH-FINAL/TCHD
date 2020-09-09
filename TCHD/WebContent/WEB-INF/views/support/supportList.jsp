<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="support.model.vo.Support, java.util.ArrayList, board.model.vo.PageInfo"%>
<%
	// 비회원
	String supNo = (String)request.getAttribute("supNo");
	Support support = (Support)request.getAttribute("support");
// 	int nSupPrice = support.getSup_price();
// 	System.out.println("list.jsp_nSupPrice : " + nSupPrice);
// 	String nSupComma = nSupPrice.slice(0, 3) + "," + nSupPrice.slice(3, 6);
// 	System.out.println("list.jsp_nSupComma : " + nSupComma);

	// 회원
	ArrayList<Support> supportList = (ArrayList<Support>)request.getAttribute("supportList");
	int supPriceTotal = 0;
	
	// 페이징
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	int listCount = pi.getListCount();		// 총 게시글 개수
	int currentPage = pi.getCurrentPage();	// 현재 페이지 번호
	int maxPage = pi.getMaxPage();			// 전체 페이지 중 가장 마지막 페이지
	int startPage = pi.getStartPage();		// 페이징 된 페이지 중 시작 페이지
	int endPage = pi.getEndPage();			// 페이징 된 페이지 중 마지막 페이지
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
			<% if(supNo == null){
					for(Support supportMem : supportList){
						int supPrice = supportMem.getSup_price();
						supPriceTotal += supPrice;
					}
			%>
				<%-- 회원 (로그인) --%>
				<span id="total_price_won">
					<%= supPriceTotal %>
				</span>
			<% } else{ %>
				<%-- 비회원 --%>
				<span id="total_price_won">
					<%= support.getSup_price() %>
				</span>
			<% } %>
				<span>원</span>
			</div>
		</div>
		
		<%-- 페이징 --%>
			<div class="paging">
				<%-- 이전 페이지 --%>
				<a href="<%= request.getContextPath() %>/currentPage=<%= currentPage - 1 %>" class="before">&lt;</a>
				
				<% for(int p = startPage; p <= endPage; p++){
						if(p == currentPage){ %>
							<%-- 현재 페이지 --%>
							<a class="choosen"><%= p %></a>
					<%  } else { %>
							<a href="<%= request.getContextPath() %>/supportList.su?currentPage=<%= p %>" class="num" ><%= p %></a>
				<% 		}
				   }%>
				
				<%-- 다음 페이지 --%>
				<a href="<%= request.getContextPath() %>/supportList.su?currentPage=<%= currentPage + 1 %>" class="after">&gt;</a>
				<script>
					if(<%= currentPage %> <= 1 || <%= supportList.isEmpty() %>){
						var before = $(".before");
						before.attr("style", "display:none");
					}
					if(<%= currentPage %> >= <%= maxPage %> || <%= supportList.isEmpty() %>){
						var after = $(".after");
						after.attr("style", "display:none");
					}
				</script>
			</div>
	</section>
</body>
</html>