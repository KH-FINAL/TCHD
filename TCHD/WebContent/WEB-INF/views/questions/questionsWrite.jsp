<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>함께하묘 행복하개</title>
     <link rel="stylesheet" href="css/question_write.css">
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


		<div id = "ment" class="board_list_wrap">게시글 작성</div>
		
     	<div id = "board_list_design">
		<table class="board_list">
			<tr>
			<td width="100px"><span id = "span1">*</span><b>분류</b> </td>
			<td width="750px" class="align_left">
			<select name="board" class="btn" size = "1">
			<option value = "bo">회원정보</option>
			<option value = "bo">입양</option>
			<option value = "bo">후원</option>
			<option value = "bo">봉사</option>
			<option value = "bo">유기동물</option>
			<option value = "bo">etc</option>
			<option value = "ze">분류 선택</option>
			</select></td>
			</tr>
		  <tr>
		    <td><span id = "span1">*</span><b>제목</b></td>
		    <td class="align_left">
		    <input type="text" name="title" class="btn" placeholder="제목을 입력해주세요" size="80" ></td>
		  </tr>
		  <tr>
		  	<td><b>비밀번호</b></td>
		  	<td class="align_left">
		  	<input type="password" name="q_password" class="btn" size="10" maxlength="4"> <span>&nbsp;&nbsp;&nbsp;&nbsp;
		  		문의게시판은 비밀글 작성이 가능합니다. 비밀글 작성을 원할 시 숫자 4자리 암호를 작성해주세요.</span>
		  	</td>
		  </tr>	
		   <tr>
		    <td id = "content_file"><b>첨부파일</b></td>
		    <td class="align_left"><div class="filebox">
  					<label for="ex_file">파일 선택</label>
 					 <input type="file" id="ex_file">		
 					 <span>&nbsp;&nbsp;&nbsp;&nbsp;이미지파일(PNG, JPG)만 첨부 가능합니다.</span>
				</div>
			</td>
		  </tr>
		  <tr>
		  <td id ="content_top"><b>내용</b></td>
		    <td><textarea name="content" class="content" cols="110" rows="25"></textarea></td>
		  </tr>
		  <tr>

	
		</table>
		
		</div>
		<div class= "button_center">
			<input name="button_list" type="button" class="btn_no" onClick="location.href='./questionsLust.html'" value="취소">
			<input name="button_content" type="button" class="btn_ok" onClick="location.href='./questionsDetail.html'" value="등록">
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