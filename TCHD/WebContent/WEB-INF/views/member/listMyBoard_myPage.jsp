<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/nav.css" type="text/css">
<link rel="stylesheet" href="css/myPage_listMyBoard.css" type="text/css">
</head>
<body>
<section>
		<nav>
			<ul id="pageNavi"> 
				<li id="pageNaviTitle"><a href="#">마이페이지</a></li>
				<li><a href="#">회원정보수정</a></li>
				<li><a href="#">내가 작성한 글</a></li>
				<li><a href="#">참여 봉사 내역</a></li>
				<li><a href="#">회원 탈퇴</a></li>
			</ul>
		</nav>
		<div id="listMyBoardDiv">
			<div id="listMyBoardTitle">내가 작성한 글</div>
			<div id="listMyBoardContent">
				<div id="selectMyBoard">
					<a href="#">전체(N)</a> |
					<a href="#">입양(N)</a> |
					<a href="#">봉사(N)</a> |
					<a href="#">댓글(N)</a> |
					<a href="#">문의사항(N)</a>
				</div>
				<div id="tableMyBoard">
					<table>
						<tr>
							<th>유형</th>
							<th>제목</th>
							<th>작성일자</th>
						</tr>
						<tr>
							<td>입양</td>
							<td>글제목</td>
							<td>작성일자</td>
						</tr>
						<tr>
							<td>봉사</td>
							<td>글제목</td>
							<td>작성일자</td>
						</tr>
						<tr>
							<td>댓글</td>
							<td>글제목</td>
							<td>작성일자</td>
						</tr>
						<tr>
							<td>문의사항</td>
							<td>글제목</td>
							<td>작성일자</td>
						</tr>
						<tr>
							<td>입양</td>
							<td>글제목</td>
							<td>작성일자</td>
						</tr>
						<tr>
							<td>봉사</td>
							<td>글제목</td>
							<td>작성일자</td>
						</tr>
						<tr>
							<td>댓글</td>
							<td>글제목</td>
							<td>작성일자</td>
						</tr>
						<tr>
							<td>문의사항</td>
							<td>글제목</td>
							<td>작성일자</td>
						</tr>
							<tr>
							<td>댓글</td>
							<td>글제목</td>
							<td>작성일자</td>
						</tr>
						<tr>
							<td>문의사항</td>
							<td>글제목</td>
							<td>작성일자</td>
						</tr>
					</table>
			<div  class="paging">
                <a href="#" class="bt">이전 페이지</a>
                <a href="#" class="num on">1</a>
                <a href="#" class="num">2</a>
                <a href="#" class="num">3</a>
                <a href="#" class="bt">다음 페이지</a>
            </div>
				</div>
			</div>
		</div>
		<div id="popUpDiv">
			<div id="popUpTitle">게시글제목</div>
			<div id="popUpDate">작성일자</div>
			<div id="popUpContent">댓글내용</div>
			<button type="button">닫기</button>
			
		</div>
</section>
</body>
</html>