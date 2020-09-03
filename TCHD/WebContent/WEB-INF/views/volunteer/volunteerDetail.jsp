<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.model.vo.*, board.model.vo.Volunteer, member.model.vo.Member, java.util.ArrayList, board.model.vo.Comments" %>
<%
	Volunteer v = (Volunteer)request.getAttribute("volunteer");
	Member loginUser = (Member)session.getAttribute("loginUser");
	ArrayList<Comments> commentsList = (ArrayList<Comments>)request.getAttribute("commentsList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/volunteer_detail.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/common/common.css" type="text/css">
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
			<div class="commentsArea">
				<div class="comment_div" id="commentsWriteArea">
					<input type="text" placeholder="댓글을 작성하려면 로그인 해주세요." id="commentsContent">
					<input type="button" id="addComments" value="등록">
					<!-- <input type="submit" value="등록" id="addComments"> -->
				</div>
				<hr class="hr">
				<div class="comment_list" id="commentsSelectArea">
					<table id="commentsSelectTable">
						<% if(commentsList.isEmpty()){ %>
						<tr>
							<td colspan="3">댓글이 없습니다.</td>
						</tr>
						<% } else { %>
						<% for(int i = 0; i < commentsList.size(); i++) { %>
						<tr>
							<td width="100px"><%= commentsList.get(i).getMemId() %></td>
							<td width="200px"><%= commentsList.get(i).getComDate() %></td>
							<td width="400px"><%= commentsList.get(i).getComContent() %></td>
						</tr>
						<% } %>
						<% } %>
					</table>
				<%-- <div class="comment_list_bottom">
					<% if(commentsList.isEmpty()) { %>
					<span>댓글이 없습니다.</span>
					<% } else { %>
					<% for(int i = 0; i < commentsList.size(); i++) { %>
					<span id="id"><%= commentsList.get(i).getMemId() %></span><br>
					<span id="date"><%= commentsList.get(i).getComDate() %></span><br>
					<span id="content"><%= commentsList.get(i).getComContent() %></span>
					<% } %>
					<% } %>
				</div> --%>
				</div>
				</div>
				<hr class="hr">
			</div>

		<script>
		$(function(){
			// 댓글 등록 버튼을 눌렀을 때
			$('#addComments').click(function(){
				var writer = '<%= loginUser.getMem_id() %>';
				var bNo = <%= v.getBoNo() %>;
				var content = $('#commentsContent').val();
				
				$.ajax({
					url: 'insertComments.bo',
					data: {writer:memId, content:comContent, bNo:boNo},
					type: 'post',
					success: function(data){
						$commentsTable = $('#commentsSelectTable');
						$commentTable.html("");
						
						for(var key in data){
							var $tr = $('<tr>');
							var $writerTd = $('<td>').text(data[key].memId).css('width', '100px');
							var $dateTd = $('<td>').text(data[key].comDate).css('width', '200px');
							var $contentTd = $('<td>').text(data[key].comContent).css('width', '400px');
							
							$tr.append($writerTd);
							$tr.append($dateTd);
							$tr.append($contentTd);
							$commentsTable.append($tr);
						}
						
						$('$commentsContent').val("");
					}
				});
			});
		});
		</script>

	</section>
</body>
</html>