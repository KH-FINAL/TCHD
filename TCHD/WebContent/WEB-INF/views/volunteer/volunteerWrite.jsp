<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/volunteer_write.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/common/common.css" type="text/css">
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
//---------------------------------------------------------------------------------------
    $(function(){ // 주소 검색 api.
    	$('.searchAddress').click(function(){
			new daum.Postcode({
				oncomplete: function(data) {
				
				var addr = '';
				
				if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }
				
				// 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('zoneCode').value = data.zonecode;
                document.getElementById("mainAddress").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detailAddress").focus();
                
				}
			}).open();
		});
    });
//---------------------------------------------------------------------------------------
</script>

</head>
<body>
	<section>
		<div class="title">봉사게시판</div>

		<div class="main_div">
			<form method="post" action="volunteerInsert.bo" encType="multipart/form-data">
			<div class="table_div">
				<table class="board_table">
					<!-- <tr>
						<th>게시판 선택 <span id="star">*</span></th>
                  		<td class="board_table_td">
                     		<select class="allbutton" name="selectBoard" required>
                     			<option value="" disabled selected>선택</option>
                       			<option value="회원정보">회원정보</option>
                        		<option value="입양하기">입양하기</option>
                        		<option value="후원관련">후원관련</option>
                        		<option value="봉사하기">봉사하기</option>
                     		</select>
                  		</td>
					</tr> -->
					<tr>
						<th>제목 <span id="star">*</span></th>
						<td class="board_table_td">
							<input type="text" class="allbutton" id="input_title" name="boTitle" required>
						</td>
					</tr>
					<tr>
						<th>지역선택 <span id="star">*</span></th>
						<td class="board_table_td">
							<select class="allbutton" name="voArea" required>
								<option value="" disabled selected>선택</option>
								<option>서울</option>
								<option>부산</option>
								<option>대구</option>
								<option>인천</option>
								<option>광주</option>
								<option>대전</option>
								<option>울산</option>
								<option>세종</option>
								<option>경기</option>
								<option>강원</option>
								<option>충북</option>
								<option>충남</option>
								<option>전북</option>
								<option>전남</option>
								<option>경북</option>
								<option>경남</option>
								<option>제주</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>봉사일시 <span id="star">*</span></th>
						
						<td class="board_table_td">
							<input type="datetime-local" class="allbutton" name="voDate" required>
						</td>
								
					</tr>
					<tr>
						<th>봉사지 <span id="star">*</span></th>
						<td class="board_table_td">
							<input type="text" placeholder="우편번호" class="adress" id="zoneCode" name="zoneCode" readonly required>
							<button type="button"class="searchAddress" id="adress_search">주소 검색</button>
						</td>
					</tr>
					<tr>
						<th></th>
						<td class="board_table_td">
							<input type="text" placeholder="주소" class="adress" id="mainAddress" name="joinAddress" readonly required>
							<input type="text" placeholder="상세주소" class="adress" id="detailAddress" name="joinAddress2" required>
						</td>
					</tr>
					<tr>
						<th>모집인원 <span id="star">*</span></th>
						<td class="board_table_td">
							<input type="text" class="allbutton" name="voMaxmember" required>
						</td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td class="board_table_td">
							<div id="file">
								<label id="file_label" for="ex_file"></label>
								<input type="file" id="ex_file" name="input_file" accept=".png, .jpg">
								<span>&nbsp;&nbsp;&nbsp;&nbsp;이미지파일(PNG, JPG)만 첨부 가능합니다.</span>
							</div>
						</td>
					</tr>
					<tr>
						<th id="td_content"><br>내용 <span id="star">*</span></th>
						<td class="board_table_td">
							<textarea id="textarea" rows="30" cols="110" name="voComment" required></textarea>
						</td>
					</tr>
				</table>
			</div>
			<div class="no_ok_button">
				<input type="button" class="button_no" value="취소" onclick="location.href='javascript:history.go(-1);'">
				<button type="submit" class="button_ok" value="등록">등록</button>
			</div>
			</form>
		</div>	
	</section>
</body>
</html>