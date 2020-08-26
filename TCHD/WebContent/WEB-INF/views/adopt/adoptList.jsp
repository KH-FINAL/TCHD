<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, board.model.vo.Adopt, board.model.vo.Files" %>
<%
	ArrayList<Adopt> aList = (ArrayList<Adopt>)request.getAttribute("aList");
	ArrayList<Files> fList = (ArrayList<Files>)request.getAttribute("fList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="adopt_list.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="common.css" type="text/css">
</head>
<body>
	<section>
		<div id="ment">입양게시판</div>
		<div id="PageArea">
		<table class="mentArea">
			<tr>
				<td id="ment1" class="mentArea" align="center">입양안내</td>
				<td id="ment2" class="mentArea">가족을 기다리는 동물들, 사지말고 입양하세요.</td>
			</tr>
		</table>
	</div>
		<div id="pet">
		<form>
			<div id="petSelect">
				<ul>
					<li>
						<button class="petButton" name="petSearch">검색</button>
					</li>
					<li>
						<button type="reset" class="petButton" name="petReset">초기화</button>
					</li>
					<li>	
						<button type="button" class="petButton" name="petUpDate" onClick="location.href='./04_입양게시글_등록.html'">등록</button></a>				
					</li>
				</ul>
				<table class="petlSelectInfo">
					<tr class="petCategory">
						<td id="kind" class="petChoice">동물구분</td>
						<td id="gender" class="petChoice">성별</td>
						<td id="size" class="petChoice">크기</td>
						<td id="age" class="petChoice">연령</td>
					</tr>
					<tr class="petCategory">
						<td id="catDog" class="petKind">개/고양이</td>
						<td class="petKind">암컷/수컷</td>
						<td class="petKind">대형/중형/소형</td>
						<td class="petKind">Puppy/Junior/Adult/Senior</td>
					</tr>
				</table>	<!-- 조건 고르는 옵션 -->
				<div id="conditionSelect">
					<select id="condition" class="conditionKind">
						<option id="allSelect" checked>All</option>
						<option id="dogSelect" value="dog">개</option>
						<option id="catSelect" value="cat">고양이</option>
					</select>
					<select id="sCondition" class="conditionKind">
						<option id="allSelect" checked>All</option>
						<option id="catDogGender" value="F">암컷</option>
						<option id="catDogGender" value="M">수컷</option>
					</select>
					<select id="tCondition" class="conditionKind">
						<option id="allSelect" checked>All</option>
						<option id="catDogSize" value=1>대형</option>
						<option id="catDogSize" value=2>중형</option>
						<option id="catDogSize" value=3>소형</option>
					</select>
					<select id="fCondition" class="conditionKind">
						<option id="allSelect" checked>All</option>
						<option id="catDogAge" value="Puppy">Puppy(~ 6개월)</option>
						<option id="catSelect"value="Junior">Junior(7개월 ~ 2살)</option>
						<option id="catSelect" value="Adult">Adult(3살 ~ 8살)</option>
						<option id="catSelect" value="Senior">Senior(9살 ~)</option>
					</select>
				</div>
			</div>
		</form>
			<div id="petPicture">		<!-- 동물 사진 영역 -->
			<% if(aList.isEmpty() || fList.isEmpty()){ %>
				등록된 사진이 없습니다.
			<% } else { %>
				<% for(int i = 0; i < aList.size(); i++){ %>
					<% Adopt a = aList.get(i); %>
						<div class="pictureInfo">
							<div class="petPictureInfo">
							<input type="hidden" value="<%= a.getBoNo() %>"/>
								<% for(int j = 0; j < fList.size(); j++){ %>
									<% Files f = fList.get(j); %>
									<% if(a.getBoNo() == f.getBoNo()){ %>
										<img class="pictureForm" src="<%= request.getContextPath() %>/thumbnail_uploadFiles/<%= f.getChangeName() %>"/>
									<% } %>
								<% } %>
							</div>
							<div id="petName" class="petInfo">이름</div>
							<div id="petKind" class="petInfo">종류(품종)</div>
							<div id="petGender" class="petInfo">성별(중성화유무)</div>
							<span id="petAge" class="petInfo">나이/</span>
							<span id="petWeight">몸무게(kg)/</span> 
							<span id="petColor">색깔</span> 
						</div>
					<% } %>
				<% } %>
			</div>
			<div class="paging">
                <a href="#" class="bt">이전 페이지</a>
                <a href="#" class="num on">1</a>
                <a href="#" class="num">2</a>
                <a href="#" class="num">3</a>
                <a href="#" class="bt">다음 페이지</a>
			</div>
		</div>
	</section>
</body>
</html>