<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.model.vo.Questions, member.model.vo.Member, board.model.vo.*" %>
<%@page import="java.util.ArrayList"%>
<% Questions q = (Questions)request.getAttribute("qBoard");
	ArrayList<Files> fileList = (ArrayList<Files>)request.getAttribute("file");
	Files file =null;
	if(fileList!=null){
		for(int i=0; i<fileList.size();i++){
			file = fileList.get(i);
		}
	}
	Member loginUser = (Member)request.getSession().getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/questions/questions_detail.css" type="text/css">
</head>
<body>
 	<section><!-- <span>첨부파일 : example.PNG</span> -->
		<div id = "ment" class="board_list_wrap">문의게시판</div>
		
     	<div class = "board_list_design">
     		<div class = "head_board">
     			<h1 div class = "title_area"><%= q.getBoTitle() %></h1>
     			<h4 div class = "info_area"><%= q.getMemId() %> | <%=q.getBoDate() %> | <%=q.getBoCount() %></h4>
     				
     			</div>
     		<div id = "div1" class = "div-color">
				<div id="img_div">
           		 <%if(file!=null){ %>
        		    <img src="upload_imageFiles/<%=file.getChangeName()%>"></div>
        	    <%} %>
        		    <div id="contents"><%=q.getBoContent() %></div>
       			</div>
				
			</div>
     		
			<div id = "hr_line"><hr></div>
			<div class="board_list">
				<div id = "div_head">
					<h3>관리자 답변  <img src="images/supervisor.png" width="25px" height="25px"></h3>
				</div>	
				<div id = "div_question">
					<textarea name="content" class="content">안녕하세요. <%= q.getMemId() %> 회원님, 로그인관련 문의 주셨네요!
저희 함께하묘행복하개는 아이디/비밀번호찾기 기능을 제공중에 있으니,
아래 안내해드리는 링크를 참고하시어 사이트 이용에 불편이 없으시길 바랍니다. ♡


아이디/비밀번호 찾기 :::대충 마이페이지 링크 알려주면됨
					</textarea>
					<div id = "notice">*추가 문의사항이 있으실시 해당 페이지 스크릿샷을 첨부로 올려주시면 보다 수월하고 빠른 답변을 받아보실 수 있습니다.*</div>
					
				</div>
				<div class = btn_bottom>		
						<input id="btn_recontent" type="button" class="btn" onClick="location.href='list.qu'" value="수정">					
						<input id="btn_delete" type="button" class="btn" onClick="location.href='./questionsList.jsp'" value="삭제">
						<input id="btn_content" type="button" class="btn" onClick="location.href='./questionsDetail.jsp'" value="등록">
				</div>
			</div>
			
			<div class="list_div">
				
					<input type="button" class="btn_list_go" value="목록보기" onClick="location.href='list.qu'">
				
				<div class="text_align_right">	
					<input type="button" class="btn_list" value="수정하기" onClick="location.href='list.qu'">
				</div>
			</div>
		</section>
</body>
</html>		