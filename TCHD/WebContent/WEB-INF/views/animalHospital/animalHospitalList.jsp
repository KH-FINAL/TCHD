<%@page import="animalHospital.model.vo.AnimalHospital"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<AnimalHospital> hospitalList =(ArrayList<AnimalHospital>)request.getAttribute("hospitalList");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/24hAnimalHospital_list.css" type="text/css">
<script>
$(function(){
	$(".hospitalTr").hover(function(){
		$(this).children().css("cursor","pointer");
		$(this).children().css("text-decoration","underline");
	},function(){
		$(this).children().css("cursor","none");
		$(this).children().css("text-decoration","none");
	});
})
</script>
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
			<%if(hospitalList.isEmpty()){ %>
				<tr>
					<td colspan="4">조회결과가 없습니다.</td>
				</tr>
			<%}else{ %>	
				<%for(AnimalHospital hospital : hospitalList){ %>
				<tr class="hospitalTr" onclick="location.href='hospitalDetail.ho?hosNo=<%=hospital.getHos_no() %>'">
					<td><%= hospital.getHos_no()%></td>
					<td><%= hospital.getHos_name() %></td>
					<td><%= hospital.getHos_phone() %></td>
					<td><%= hospital.getHos_addr() %></td>
				</tr>
				<%} %>
			<% }%>
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