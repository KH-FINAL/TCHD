<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/24hAnimalHospital_list.css" type="text/css">
</head>
<body>
	<section>
		<div id="ment">24시 동물병원</div>
		
		<div id="info_local_div">
			<div id="info">
				* 지역을 선택하시면 해당 지역에 있는<br>
				&nbsp;&nbsp;24시 동물병원의 정보를 확인하실 수 있습니다.
			</div>
			<div>
				<table id="local_select_table">
					<tr>
						<td>전체보기</td>
						<td>서울특별시</td>
						<td>부산광역시</td>
						<td>대구광역시</td>
						<td>인천광역시</td>
						<td>광주광역시</td>
					</tr>
					<tr>
						<td>대전광역시</td>
						<td>울산광역시</td>
						<td>세종특별자치시</td>
						<td>경기도</td>
						<td>강원도</td>
						<td>충청북도</td>
					</tr>
					<tr>
						<td>충청남도</td>
						<td>전라북도</td>
						<td>전라남도</td>
						<td>경상북도</td>
						<td>경상남도</td>
						<td>제주특별자치도</td>
					</tr>
				</table>
			</div>
		</div>
		<br><br>
		<div id="animal_hospital_div">
			<table id="animal_hospital_table">
				<tr>
					<th>번호</th>
					<th>병원명</th>
					<th>전화번호</th>
					<th>주소</th>
				</tr>
				<tr>
					<td>1</td>
					<td>24시 닥터멍 동물병원</td>
					<td>02-554-7505</td>
					<td>서울특별시 강남구 논현로 515</td>
				</tr>
				<tr>
					<td>2</td>
					<td>24시 삼성 동물 의료센터</td>
					<td>031-206-7512</td>
					<td>경기도 수원시 영통구 덕영대로 1509</td>
				</tr>
				<tr>
					<td>3</td>
					<td>24시 소래 동물병원</td>
					<td>032-438-3227</td>
					<td>
						인천광역시 남동구 소래역남로16번길 75<br>
						더타워상가 C동 1층
					</td>
				</tr>
				<tr>
					<td>4</td>
					<td>의정부 24시 아이유 동물 메디컬센터</td>
					<td>0507-1446-7588</td>
					<td>경기도 의정부시 태평로 52</td>
				</tr>
				<tr>
					<td>5</td>
					<td>24시 튼튼 동물 의료센터</td>
					<td>0507-1320-5277</td>
					<td>
						경기도 하남시 미사강변동로 73<br>
						미사강변 노블레스 115호
					</td>
				</tr>
				<tr>
					<td>6</td>
					<td>24시 지구촌 동물 메디컬센터</td>
					<td>0507-1401-7582</td>
					<td>서울특별시 구로구 구로중앙로31길 30 유성빌딩</td>
				</tr>
			</table>
		</div>
		
		<div class="paging">
			<a href="#" class="bt">이전 페이지</a>
			<a href="#" class="num on">1</a>
			<a href="#" class="num">2</a>
			<a href="#" class="num">3</a>
			<a href="#" class="bt">다음 페이지</a>
		</div>
	</section>
</body>
</html>