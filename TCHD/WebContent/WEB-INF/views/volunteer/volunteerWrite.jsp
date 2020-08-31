<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/volunteer_write.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/common.css" type="text/css">
</head>
<body>
	<section>
		<div class="title">봉사게시판</div>

		<div class="main_div">
			<div class="table_div">
				<table class="board_table">
					<tr>
						<th>제목</th>
						<td class="board_table_td">
							<input type="text" class="allbutton">
						</td>
					</tr>
					<tr>
						<th>지역선택 <span id="star">*</span></th>
						<td class="board_table_td">
							<select class="allbutton">
								<option value="hidden" disabled selected>선택</option>
								<option>서울특별시</option>
								<option>경기도</option>
								<option>세종특별자치시</option>
								<option>인천광역시</option>
								<option>광주광역시</option>
								<option>대전광역시</option>
								<option>울산광역시</option>
								<option>부산광역시</option>
								<option>충청남도</option>
								<option>충청남도</option>
								<option>충청북도</option>
								<option>충청남도</option>
								<option>전라북도</option>
								<option>전라남도</option>
								<option>경상북도</option>
								<option>경상남도</option>
								<option>제주특별자치도</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>봉사일시 <span id="star">*</span></th>
						<td class="board_table_td">
							<input type="datetime-local" class="allbutton">
						</td>
					</tr>
					<tr>
						<th>봉사지 <span id="star">*</span></th>
						<td class="board_table_td">
							<input type="text" placeholder="우편번호" class="adress">
							<button type="button" id="adress_search">주소 검색</button>
						</td>
					</tr>
					<tr>
						<th></th>
						<td class="board_table_td">
							<input type="text" placeholder="주소" class="adress" name="joinAddress" readonly>
							<input type="text" placeholder="상세주소" class="adress"
							name="joinAddress2" readonly>
						</td>
					</tr>
					<tr>
						<th>모집인원 <span id="star">*</span></th>
						<td class="board_table_td">
							<input type="text" class="allbutton">
						</td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td class="board_table_td">
							<div id="file">
								<input type="file" name="uploadFile"> * 이미지 파일은 jpg,png만 가능합니다.
							</div>
						</td>
					</tr>
					<tr>
						<th id="td_content"><br>내용</th>
						<td class="board_table_td">
							<textarea id="textarea" rows="30" cols="110"></textarea>
						</td>
					</tr>
				</table>
			</div>
			<div class="no_ok_button">
				<input type="button" class="button_no" value="취소" onclick="location.href='javascript:history.go(-1);'">
				<input type="button" class="button_ok" value="등록" onclick="">
			</div>
		</div>
	</section>
</body>
</html>