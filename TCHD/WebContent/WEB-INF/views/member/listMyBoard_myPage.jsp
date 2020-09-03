<%@page import="member.model.vo.Member"%>
<%@page import="java.util.HashMap, board.model.vo.PageInfo, board.model.vo.Board, java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Board> boardList = (ArrayList<Board>)request.getAttribute("boardList");
	HashMap<String, Integer> eachBoardCount = (HashMap<String, Integer>)request.getAttribute("eachBoardCount");
	int total=0;
	int adopt=0;
	int volunteer=0;
	int comment=0;
	int questions=0;
	
	if(eachBoardCount.get("입양게시판")!=null){adopt=eachBoardCount.get("입양게시판");};
	if(eachBoardCount.get("봉사게시판")!=null){volunteer=eachBoardCount.get("봉사게시판");};
	if(eachBoardCount.get("문의사항")!=null){questions=eachBoardCount.get("문의사항");};
	if(eachBoardCount.get("댓글")!=null){comment=eachBoardCount.get("댓글");};
	total=adopt+volunteer+questions+comment;
	
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/common/nav.css" type="text/css">
<link rel="stylesheet" href="css/member/myPage_listMyBoard.css" type="text/css">
<script type="text/javascript">
$(function(){
	
	console.log('<%=boardList%>');
	
	$('.commentTd').click(function(){
		$('#popUpDiv').css("display","block");
	});
	
	$('#popUpCloseBtn').click(function(){
		$('#popUpDiv').css("display","none");
	});
	
	if(<%=currentPage %> <=1){
			var before = $('#beforBtn');
			//before.attr("href","");
			before.css("visibility","hidden");
	}
	if(<%=currentPage %>== <%=maxPage%>){
		var before = $('#nextBtn');
		//before.attr("href","");
		before.css("visibility","hidden");
	}
})

</script>
</head>
<body>
<section>
		<nav>
			<ul id="pageNavi"> 
				<li id="pageNaviTitle"><a href="myPage.me">마이페이지</a></li>
				<li><a href="myPage.me">회원정보수정</a></li>
				<li><a href="listMyBoard.bo">내가 작성한 글</a></li>
				 <%if(((Member)request.getSession().getAttribute("loginUser")).getMem_type().equals("PM")){ %>
					<li><a href="listMyVolunteer.vo">참여 봉사 내역</a></li>
				<%}else{ %>
					<li><a href="listMyVolunteerGm.vo">개설 봉사 내역</a></li>
				<%} %>
				<li><a href="leaveForm.me">회원 탈퇴</a></li>
			</ul>
		</nav>
		<div id="listMyBoardDiv">
			<div id="listMyBoardTitle">내가 작성한 글</div>
			<div id="listMyBoardContent">
				<div id="selectMyBoard">
					<a href="#">전체(<%=listCount %>)</a> |
					<a href="#">입양(<%=adopt %>)</a> |
					<a href="#">봉사(<%=volunteer %>)</a> |
					<a href="#">댓글(<%=comment %>)</a> |
					<a href="#">문의사항(<%=questions %>)</a>
				</div>
				<div id="tableMyBoard">
					<table>
						<tr>
							<th>유형</th>
							<th>제목</th>
							<th>작성일자</th>
						</tr>
					<% if(!boardList.isEmpty()){ %>
					<%	for(Board board : boardList){ %>
						<tr class="boardTr">
							<%if(board.getBoType()!=null){
								String link="";
								if(board.getBoType().equals("입양게시판")){ link="adoptDetail.bo?boNo=";}
								else if(board.getBoType().equals("봉사게시판")){link="volunteerDetail.bo?bNo=";}
								else if(board.getBoType().equals("문의사항")){link="detail.qu?bNo=";}
								%>
								<td><%=board.getBoType() %></td>
								<td class="board2ndTd"  onclick="location.href='<%=link+board.getBoNo()%>'"><%=board.getBoTitle() %></td>
							<%}else{ %>
								<td>댓글<input type="hidden" value="<%=board.getBoNo() %>"></td>
								<td class="board2ndTd commentTd"><%=board.getBoTitle() %></td>
							<%} %>
							<td><%=board.getBoDate()%></td>
						</tr>
						<%} %>
					<%}else{ %>	
						<tr>
							<td colspan="3">조회결과가 없습니다.</td>
						</tr>
					<%} %>
					</table>
					
					
			<div  class="paging">			
			<a href="listMyBoard.bo?currentPage=<%=currentPage-1 %>" class="bt" id="beforBtn">이전 페이지</a>			
			<%for(int p=startPage; p<=maxPage; p++){ %>
	   					<% if(p==currentPage){ %>
	   					 <a href="listMyBoard.bo?currentPage=<%=p %>" class="num on"><%=p %></a>
	   					<%}else{ %>
	   					 <a href="listMyBoard.bo?currentPage=<%=p %>" class="num"><%=p %></a>
	   					<%} %>
	   		<%} %>	
   		  <a href="listMyBoard.bo?currentPage=<%=currentPage+1 %>" class="bt" id="nextBtn">다음 페이지</a>
            </div>					
			
				</div>
			</div>
		</div>
		<div id="popUpDiv">
			<div id="popUpTitle">게시글제목</div>
			<div id="popUpDate">작성일자</div>
			<div id="popUpContent">댓글내용</div>
			<button type="button" id="popUpCloseBtn">닫기</button>
			
		</div>
</section>
</body>
</html>