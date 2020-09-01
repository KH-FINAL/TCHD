<%@page import="board.model.vo.PageInfo"%>
<%@page import="board.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Board> boardList = (ArrayList<Board>)request.getAttribute("boardList");
	int total=0;
	int adopt=0;
	int volunteer=0;
	int comment=0;
	int questions=0;
	if(boardList!=null){
	  	for(Board board : boardList){
	  		if(board.getBoType().equals("입양게시판")){
	  			total+=1; adopt+=1;
	  		}else if(board.getBoType().equals("봉사게시판")){
	  			 total+=1; volunteer+=1;
	  		}else if(board.getBoType().equals("문의사항")){
	  			total+=1; questions+=1; 
	  		}else{
	  			 total+=1; comment+=1;
	  		}
		}
	
	}
	
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
				<li><a href="listMyVolunteer.vo">참여 봉사 내역</a></li>
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
							<%if(board.getBoType()!=null){ %>
								<td><%=board.getBoType() %></td>
								<td class="board2ndTd"><%=board.getBoTitle() %></td>
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