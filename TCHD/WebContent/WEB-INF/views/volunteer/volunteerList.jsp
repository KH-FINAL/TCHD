<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, board.model.vo.Board, board.model.vo.Volunteer" %>
<% ArrayList<Volunteer> list = (ArrayList<Volunteer>)request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/volunteer_list.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/common.css" type="text/css">
</head>
<body>
	<section>
		<div class="title">봉사게시판</div>

		<div class="main_div">
			<div class="sub_div">
				<div class="list_search">
					<select id="search_select">
						<option value="hidden" disabled selected>선택</option>
						<option>지역</option>
						<option>제목</option>
					</select>
						<input type="text" id="search_text" placeholder="">
						<input type="button" id="search_button" value="검색">
				</div>

				<div class="table_div">
					<table id="list_table">
						<tr>
							<th>번호</th>
							<th>지역</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일자</th>
							<th>모집인원</th>
							<th>마감</th>
							<th>조회수</th>
						</tr>
						<% if(list.isEmpty()){ %>
						<tr>
							<td>존재하는 봉사모집이 없습니다.</td>
						</tr>
						<% } else { %>
						<%		for(Volunteer v : list){ %>
						<tr>
							<td><%= v.getBoNo() %></td>					<!-- 게시글번호 -->
							<td><%= v.getVoArea() %></td>				<!-- 봉사지역 -->
							<td class="tit">게시글제목</td>				<!-- 게시글제목 -->
							<td>관리자</td>								<!-- 작성자 : 회원번호로 불러오는 거면 Member VO에서 가져오면 되는 건가? -->
							<td>작성일자</td> 								<!-- 작성일자 -->
							<td>모집인원</td>								<!-- 모집인원 -->
							<td>N</td>									<!-- 마감유무 -->
							<td>조회수</td>  								<!-- 조회수 -->
						</tr>
						<%		} %>
						<% } %>
					</table>
				</div>
			</div>

			<div class="wrtie_button_div">
				<button id="write_button">글쓰기</button>
			</div>
			
			<div class="paging">
				<a href="#" class="bt">이전 페이지</a>
				<a href="#" class="num on">1</a>
				<a href="#" class="num">2</a>
				<a href="#" class="num">3</a>
				<a href="#" class="bt">다음 페이지</a>
			</div>
		</div>
	</section>
</body>
</html>