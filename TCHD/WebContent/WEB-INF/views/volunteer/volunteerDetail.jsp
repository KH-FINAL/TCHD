<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.model.vo.*, board.model.vo.Volunteer, member.model.vo.Member" %>
<% 
	Volunteer v = (Volunteer)request.getAttribute("volunteer");
	Member loginUser = (Member)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/volunteer_detail.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/common.css" type="text/css">
</head>
<body>
	<section>
		<div class="title">봉사게시판</div>

		<div class="main_div">
			<div class="sub_div">
				<div class="board_head">
					<h1 div class = "vol_board_title"><%= v.getBoTitle() %></h1>
					<h4 div class = "vol_board_writer"><%= v.getMemId() %>&nbsp;&nbsp;|&nbsp;&nbsp;<%= v.getBoDate() %>&nbsp;&nbsp;|&nbsp;&nbsp;<%= v.getBoCount() %></h4>
				<!-- <div id="vol_board_title">산 아래 달봉이네 보호소 미용봉사</div>
				<hr class="hr">
				<div id="vol_board_writer">작성자&nbsp;&nbsp;|&nbsp;&nbsp;2020/08/01&nbsp;&nbsp;|&nbsp;&nbsp;240</div>
				<hr class="hr"> -->
				</div>
				
				<div class="vol_img_div">
					<img id="vol_img"
						src="/Users/duddldi/Desktop/EclipseHome/4_Front_workspace/함께하묘 행복하개/WebContent/images/봉사게시판 사진첨부 예시.jpeg">
				</div>
				<div class="content_table">
					<table>
						<tr>
							<td>
								<div id="table_title">봉사일시</div>
							</td>
						</tr>
						<tr>
							<td>
								<div id="table_content">
									<%= v.getVoDate() %>
									<!-- 2020년 8월 10일 월요일<br> 오전 10시 -->
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div id="table_title">봉사지</div>
							</td>
						</tr>
						<tr>
							<td>
								<div id="table_content">경기 수원시 영통구</div>
							</td>
						</tr>
						<tr>
							<td>
								<div id="table_title">모집기간</div>
							</td>
						</tr>
						<tr>
							<td>
								<div id="table_content"><%= v.getBoDate() %> ~ <%= v.getVoDate() %></div>
							</td>
						</tr>
						<tr>
							<td>
								<div id="table_title">모집인원</div>
							</td>
						</tr>
						<tr>
							<td>
								<div id="table_content"><%= v.getVoMaxmember() %></div>
							</td>
						</tr>
					</table>
				</div>
				<div id="content">
					<%= v.getVoComment() %>
				</div>
			
			</div>
			<div id="apply_div">
				<button type="button" id="apply_button" onclick="">신청하기</button>
			</div>
			<div class="list_div">
				<input type="button" class="go" value="목록보기">
				<div class="text_align_right">
				<!-- 글쓴 사람만 수정삭제버튼 보이게. -->
				<% if(v.getMemId().equals(loginUser.getMem_id()) && loginUser != null) { %>
				<input type="button" class="go" value="수정하기">
				<% } %>
				</div>
			</div>
			<hr class="hr">
			<!-- <div id="list_div">
					<button type="button" id="list_button" onclick="">이전</button>
					<button type="button" id="list_button" onclick="">목록</button>
					<button type="button" id="list_button" onclick="">다음</button>
					<button type="button" id="edit">수정</button>
				</div> -->
			<div class="comment_div">
				<input type="text" placeholder="댓글을 작성하려면 로그인 해주세요.">
				<input type="submit" value="등록">
			</div>
			<hr class="hr">
			<div class="comment_list">
				<div class="comment_list_bottom">
					<span id="id">dog01</span><br>
					<span id="date">2020.07.28</span><br>
					<span id="content">달봉이네 친구들 더 멋있어지겠어요 ^^ ~</span>
				</div>
				<div class="comment_list_bottom">
					<span id="id">cat02</span><br>
					<span id="date">2020.07.29</span><br>
					<span id="content">달봉이 최고 ! 모두 마음이 이뻐요 ~ ㅎ</span>
					<span id="writer_button_right">
						<input type="button" id="comment_writer_button" value="수정">
						<input type="button" id="comment_writer_button" value="삭제">
					</span>
				</div>
				<!-- <table class="commnet_table">
					<tr>
						<td class="comment_width">아이디1</td>
					</tr>
					<tr>
						<td id="comment_date">2020.07.28</td>
					</tr>
					<tr>
						<td>달봉이네 친구들 더 멋있어지겠어요 ^^ ~</td>
					</tr>
					<tr>
						<td>아이디2</td>
					</tr>
					<tr>
						<td id="comment_date">2020.07.29</td>
					</tr>
					<tr>
						<td>달봉이 최고 !</td>
						<td>
							<input type="button" id="comment_writer_button" value="수정">
							<input type="button" id="comment_writer_button" value="삭제">
						</td>
					</tr>
				</table> -->
			</div>
			<hr class="hr">
		</div>
	</section>
</body>
</html>