<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="board.model.vo.*, board.model.vo.Volunteer, member.model.vo.Member, java.util.ArrayList, board.model.vo.Comments"%>
<%
	Volunteer v = (Volunteer) request.getAttribute("volunteer");
	Member loginUser = (Member) request.getSession().getAttribute("loginUser");
	int memberNo=0;
	if(loginUser!=null){
		memberNo = loginUser.getMem_no();
	}
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
	/* Member loginUser = (Member)session.getAttribute("loginUser"); */
	/* 비회원도 상세보기 가능하게. */
	/* Member loginUser = (Member)request.getSession().getAttribute("loginUser");
	String writer="";
	if(loginUser!=null){writer=loginUser.getMem_id();} */
	/* 댓글.. */
	ArrayList<Comments> commentsList = (ArrayList<Comments>) request.getAttribute("commentsList");
	/* 이미지 파일 관련 */
	ArrayList<Files> fileList = (ArrayList<Files>) request.getAttribute("file");
	Files file = null;
	if (fileList != null) {
		for (int i = 0; i < fileList.size(); i++) {
			file = fileList.get(i);
		}
	}

	ArrayList applyMemberList = (ArrayList)request.getAttribute("applyMemberList");
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
		<form method="post" action="volunteerUpdateForm.bo">
			<div class="main_div">
				<div class="sub_div">
					<div class="board_head">
						<input type="hidden" name="volBNo" value="<%=v.getBoNo()%>">
						<input type="hidden" name="volCateName"
							value="<%=v.getCateName()%>"> <input type="hidden"
							name="volBoTitle" value="<%=v.getBoTitle()%>"> <input
							type="hidden" name="volMemId" value="<%=v.getMemId()%>">
						<input type="hidden" name="volMemNo" value="<%=v.getMemNo()%>">
						<%
							if (file != null) {
						%>
						<input type="hidden" name="volunteerFileNo"
							value="<%=file.getFileNo()%>">
						<%
							}
						%>
						<input type="hidden" name="boDate" value="<%=v.getBoDate()%>">
						<input type="hidden" name="voArea" value="<%=v.getVoArea()%>">
						<input type="hidden" name="voDate" value="<%=v.getVoDate()%>">
						<input type="hidden" name="voPlace" value="<%=v.getVoPlace()%>">
						<input type="hidden" name="voMaxmember"
							value="<%=v.getVoMaxmember()%>"> <input type="hidden"
							name="voComment" value="<%=v.getVoComment()%>">

						<h1 class="vol_board_title"><%=v.getBoTitle()%></h1>
						<h4 class="vol_board_writer"><%=v.getMemId()%>&nbsp;&nbsp;|&nbsp;&nbsp;<%=v.getBoDate()%>&nbsp;&nbsp;|&nbsp;&nbsp;<%=v.getBoCount()%></h4>
					</div>

					<div class="vol_img_div">
						<div id="img_div">
							<%
								if (file != null) {
							%>
							<img src="upload_imageFiles/<%=file.getChangeName()%>">
						</div>
						<%
							}
						%>
						<%-- <div id="img_div">
					<% if(file!=null){%>
            		<input type="hidden" name="volunteerFileNo" value="<%=file.getFileNo() %>">
            		<%} %>
            		</div> --%>
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
									<div id="table_content"><%=format.format(v.getVoDate())%></div>
								</td>
							</tr>
							<tr>
								<td>
									<div id="table_title">봉사지</div>
								</td>
							</tr>
							<tr>
								<td>
									<div id="table_content"><%=v.getVoPlace()%></div>
								</td>
							</tr>
							<tr>
								<td>
									<div id="table_title">모집기간</div>
								</td>
							</tr>
							<tr>
								<td>
									<div id="table_content">
										<%=v.getBoDate()%> ~ <%=format2.format(v.getVoDate()) %>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div id="table_title">모집인원</div>
								</td>
							</tr>
							<tr>
								<td>
									<div id="table_content"><%=v.getVoApplymember()%> / <%=v.getVoMaxmember()%>명
									</div>
								</td>
							</tr>
						</table>
					</div>
				
					<div id="content"><div id="table_title">설명</div><br><%=v.getVoComment()%></div>

				</div>
				<div id="apply_div">
					<%-- <button type="button" id="apply_button" onclick="location.href='<%= request.getContextPath() %>/volunteerApply.bo'">신청하기</button> --%>
					<%if (loginUser != null) {%>
						<%if (v.getVoDeadline().equals("N") && loginUser.getMem_no()!=v.getMemNo()) {%>
							<input type="button" id="apply_button" value="신청하기" onclick="volApply();" />
						<%}%>
					<%} else {%>
						<%if (v.getVoDeadline().equals("N")) {%>
							<button id="apply_button"  type="button" onclick="goLogin();">신청하기</button>
						<%}	%>
					<%}
					%>
				</div>

				<div class="list_div">
					&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" class="go"
						value="목록보기"
						onclick="location.href='<%=request.getContextPath() %>/volunteerList.bo'">
					<div class="text_align_right">
						<!-- 글쓴 사람만 수정삭제버튼 보이게. -->
						<%
							if (loginUser != null && v.getMemId().equals(loginUser.getMem_id())) {
						%>
						<input type="submit" class="go" value="수정하기"> <input
							type="button" class="go" value="삭제하기" onclick="volDelete();" />
						<%
							}
						%>
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
							<%
								if (commentsList.isEmpty()) {
							%>
							<tr>
								<td colspan="3">댓글이 없습니다.</td>
							</tr>
							<%
								} else {
							%>
							<%
								for (int i = 0; i < commentsList.size(); i++) {
							%>
							<tr>
								<td width="100px"><%=commentsList.get(i).getMemId()%></td>
								<td width="200px"><%=commentsList.get(i).getComDate()%></td>
								<td width="400px"><%=commentsList.get(i).getComContent()%></td>
							</tr>
							<%
								}
							%>
							<%
								}
							%>
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
		</form>

		<%-- 		<script>
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
		</script> --%>

	<script type="text/javascript">
	/* 비회원 신청 안됨 로그인 하러 ~ */
	function goLogin(){
		
		window.alert("로그인 후 이용해주시기 바랍니다.");
		location.href="<%=request.getContextPath()%>/loginForm.me";
	}
	
	/* 신청하기. */
	function volApply(){
		<%
			for(int i=0;i<applyMemberList.size();i++){
				if(loginUser!=null &&(int)applyMemberList.get(i)==loginUser.getMem_no()){%>
					swal("","이미 신청한 봉사입니다.","info");
					return;
				<%}%>	
		<%}%>

		//var result = confirm("해당 봉사를 신청하시겠습니까?");
		var volBNo = <%=v.getBoNo() %>;
		swal({
			text: "해당 봉사를 신청하시겠습니까?",
			icon: "info",
			buttons: true
		})
		.then((ok1) => {
			if(ok1){
				$.ajax({
					url: "volunteerApply.bo",
					data: {volBNo : volBNo},
					success: function(data){
						console.log(data);
						if(data==1){
							swal("","신청이 완료되었습니다.","success")
							.then((ok2) => {
								if(ok2){
									 location.href="volunteerDetail.bo?bNo="+volBNo;
								}
							});
						}else{
							swal("","신청에 실패하였습니다.","error");
						}
					},
					error: function(data){
						alert("ajax 에러 발생");
					}
				});
			}
		});	
	}
	
	/* 글삭제. */
 	function volDelete(){
		var result = confirm("해당 게시글을 삭제하시겠습니까?");
		var volBNo = <%=v.getBoNo()%>;
		
		if(result){
			location.href = "<%=request.getContextPath()%>/volunteerDelete.bo?volBNo=" + volBNo;
			return true;
		} else {
			window.close();
			return false;
		}
	} 

	
<%-- 	function volDelete(){
		var volBNo = <%= v.getBoNo() %>;
		
		swal({
			title: "게시글 삭제",
			text: "게시글을 삭제하시겠습니까?",
			icon: "warning",
			showCancelButton: true
			cancelButtonTex: '아니오'
			confirmButtonText: '예'
			
		}).then(function(){
			swal(
				'해당 게시글이 삭제되었습니다.',
				'success'
			);
		}); --%>
		<%-- .then(((willDelete) => {
			if(willDelete) {
				location.href = "<%= request.getContextPath() %>/volunteerDelete.bo?volBNo=" + volBNo;
				swal("해당 게시글이 삭제되었습니다.", {
					icon: "success",
				});
			} else {
				swal.close();
			}
		}); 
	} --%>
	$(function(){
		$('#addComments').click(function(){
			var loginUser='<%=loginUser%>'
			if(loginUser!='null'){
				<%-- var writer = '<%= loginUser.getMem_id() %>'; --%>
				var memNo = '<%=memberNo%>';
				var bNo = <%=v.getBoNo()%>;
				var content = $('#commentsContent').val();
				
				$.ajax({
					url: 'insertComments.bo',
					data: {memNo:memNo, content:content, bNo:bNo},
					type: 'post',
					success: function(data){
						console.log(data);
						$commentsSelectTable = $('#commentsSelectTable');
						$commentsSelectTable.html("");
						
						for(var key in data){
							var $tr = $('<tr>');
							var $writerTd = $('<td>').text(data[key].memId).css('width', '100px');
							var $dataTd = $('<td>').text(data[key].comDate).css('width', '200px');
							var $contentTd = $('<td>').text(data[key].comContent).css('width', '400px');
					
							$tr.append($writerTd);
							$tr.append($dataTd);
							$tr.append($contentTd);
							$commentsSelectTable.append($tr);
						}
						
						$('#commentsContent').val("");
					},
					error: function(data){
						alert("ajax 에러 발생");
					}
				});
				
			
			}else{
				swal("","로그인 후 이용해주세요.","info");
				return;
			}
			
		})
	})
	
	
	</script>
	</section>

</body>
</html>