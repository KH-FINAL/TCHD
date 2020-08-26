<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>함께하묘 행복하개</title>
     <link rel="stylesheet" href="css/question_detail.css">
      <link rel="stylesheet" href="css/common.css">
</head>
<script>
</script>
</head>
<body>
  <header>
	<div id="headDiv">
		<div id="topBar"><a href="">로그인  </a><span> | </span><a href="">회원가입</a></div>
		<div id="topDiv">
			  <div id="title"><a href="index.html"><img alt="로고" src="images/pets(1).PNG"> 함께하묘 행복하개</a></div>
			  <!-- 왼쪽margin 150,   로고 45 , 메뉴바 25 , 게시판 30 -->
			<div id="navi">
				<ul>
						<li>사이트소개</li>
						<li>참여하기</li>
						<li>후원하기</li>
						<li>정보마당</li>
						<li>고객센터</li>
				</ul>
			</div>
		</div>
	</div>
	<div id="headBorder"> </div>
	</header>
	<hr class="clear">
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
           <footer>
			<div id="footDiv"><br>
			행복하묘 함께하개&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;서울시 강남구 역삼동 어쩌구 123 (우)12345 &nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;대표자: 김대표<br><br><br>
			TEL : 02-123-4567 &nbsp;&nbsp;|&nbsp;&nbsp; FAX : 02-345-6789 &nbsp;&nbsp;|&nbsp;&nbsp;EMAIL:abcd@naver.com&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;사업자 등록번호 : 1234-12345<br>
			</div>
		</footer>
		
</body>
</html>		