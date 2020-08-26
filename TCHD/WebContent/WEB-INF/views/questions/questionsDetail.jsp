<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
 	<section>
		<div id = "ment" class="board_list_wrap">문의게시판</div>
		
     	<div class = "board_list_design">
     		<div class = "head_board">
     			<h1 div class = "title_area">로그인이 안되네요~~~</h1>
     			<h4 div class = "info_area">김수지이인 | 2020-08-11 | 50</h4>
     				
     			</div>
     		<div id = "div1" class = "div-color">
				<img src="images/questions(1).png.PNG" width="600px" height="380px"><span>첨부파일 : example.PNG</span>
		  		<br>
				예전에 가입해둔 아이디가 있던 것 같은데 기억이 안납니다. 로그인이 안되네요! ㅆ<br>
				 첨부파일 확인 좀 해주세요~
				
			</div>
     		</div>
			<div id = "hr_line"><hr></div>
			<div class="board_list">
				<div id = "div_head">
					<h3>관리자 답변  <img src="images/supervisor.PNG" width="25px" height="25px"></h3>
				</div>	
				<div id = "div_question">
					<textarea name="content" class="content">안녕하세요. 김수지이인 회원님, 로그인관련 문의 주셨네요!
저희 함께하묘행복하개는 아이디/비밀번호찾기 기능을 제공중에 있으니,
아래 안내해드리는 링크를 참고하시어 사이트 이용에 불편이 없으시길 바랍니다. ♡


아이디/비밀번호 찾기 :::대충 마이페이지 링크 알려주면됨
					</textarea>
					<div id = "notice">*추가 문의사항이 있으실시 해당 페이지 스크릿샷을 첨부로 올려주시면 보다 수월하고 빠른 답변을 받아보실 수 있습니다.*</div>
					
				</div>
				<div class = btn_bottom>		
						<input id="btn_recontent" type="button" class="btn" onClick="location.href='./questionsWrite.html'" value="수정">					
						<input id="btn_delete" type="button" class="btn" onClick="location.href='./questionsList.html'" value="삭제">
						<input id="btn_content" type="button" class="btn" onClick="location.href='./questionsList.html'" value="등록">
				</div>
			</div>
			
			<div class="list_div">
				
					<input type="button" class="btn_list_go" value="목록보기">
				
				<div class="text_align_right">	
					<input type="button" class="btn_list" value="수정하기">
				</div>
			</div>
		</section>
</body>
</html>		