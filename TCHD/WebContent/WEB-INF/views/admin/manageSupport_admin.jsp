<%@page import="board.model.vo.Support"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Support> supportList = (ArrayList<Support>)request.getAttribute("supportList");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/common/nav.css" type="text/css">
<link rel="stylesheet" href="css/member/myPage_listMyBoard.css" type="text/css">
</head>
<body>
<section>	
		<nav>
			<ul id="pageNavi"> 
				<li id="pageNaviTitle"><a href="approveGroupMember.me">관리자 페이지</a></li>
				<li><a href="approveGroupMember.me">사업자(단체) 가입승인</a></li>
				<li><a href="answerQuestionForm.bo">대기중인 문의사항</a></li>
				<li><a href="manageSupport.bo">후원관리</a></li>
			</ul>
		</nav>
		<div id="listMyBoardDiv">
			<div id="listMyBoardTitle">후원관리</div>
			<div id="listMyBoardContent">
				<div id="selectOptionDiv">
					<select id='year'>
						<option value="2019">2019</option>
						<option value="2020">2020</option>
					</select>년
				
					<select id="month">
						<option value="1">01</option>
						<option value="2">02</option>
						<option value="3">03</option>
						<option value="4">04</option>
						<option value="5">05</option>
						<option value="6">06</option>
						<option value="7">07</option>
						<option value="8">08</option>
						<option value="9">09</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
				
					</select>월
				</div>
				<div id="tableMyBoard">
					<table>
						<tr>
							<th>회원아이디</th>
							<th>회원(단체)명</th>
							<th>회원유형</th>
							<th>누적금액</th>
						</tr>
					<% if(supportList.isEmpty()){ %>
						<tr>
							<td colspan="4">조회 결과가 없습니다.</td>
						</tr>
					<%}else{%>
					
					<%} %>
					</table>
					<div  class="paging">
		                <a href="#" class="bt">이전 페이지</a>
		                <a href="#" class="num on">1</a>
		                <a href="#" class="num">2</a>
		                <a href="#" class="num">3</a>
		                <a href="#" class="bt">다음 페이지</a>
            		</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>