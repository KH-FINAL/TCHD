<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, board.model.vo.*" %>
<%
	ArrayList<Adopt> aList = (ArrayList<Adopt>)request.getAttribute("aList");
	ArrayList<Files> fList = (ArrayList<Files>)request.getAttribute("fList");
	String userId = (String)request.getAttribute("userId");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/adopt/adopt_list.css?after" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/common/common.css" type="text/css">
</head>
<body>
	<section>
		<form action="<%= request.getContextPath() %>/adoptDetail.bo">
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
						<button class="petButton" name="petSearch" onclick="petSearch();">검색</button>	<!-- 아직 함수 설정 안함 -->
					</li>
					<li>
						<button type="reset" class="petButton" name="petReset">초기화</button>
					</li>
					<li>	
						<% if(userId != null){ %>
							<button type="button" class="petButton" name="petUpDate" onclick="writeForm();">등록</button>				
						<% } else {%> 
							<button type="button" class="petButton" name="petUpDate" onclick="loginForm();">등록</button>	
						<% } %>
					</li>
				</ul>
				<table class="petlSelectInfo">
					<tr class="petCategory">
						<td id="kind" class="petChoice">동물구분</td>
						<td id="gender" class="petChoice">성별</td>
						<td id="size" class="petChoice">크기</td>
<!-- 						<td id="age" class="petChoice">연령</td> -->
					</tr>
					<tr class="petCategory">
						<td id="catDog" class="petKind">개/고양이</td>
						<td id="fm" class="petKind">암컷/수컷</td>
						<td id="sml" class="petKind">대형/중형/소형</td>
<!-- 						<td class="petKind">Puppy/Junior/Adult/Senior</td> -->
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
				</div>
			</div>
		</form>
			<div id="petPicture">		<!-- 동물 사진 영역 -->
			<% if(aList.isEmpty() || fList.isEmpty()){ %>
<%-- 				<% for(int i = 0; i < aList.size(); i++){ %> --%>
<%-- 					<% if(aList.get(i).getAdoptYn().equals("Y")) %> --%>
						등록된 사진이 없습니다.
<%-- 				<% } %> --%>
			<% } else { %>
				<% for(int i = 0; i < aList.size(); i++){ %>
					<% Adopt a = aList.get(i); %>
					<div class="pictureInfo">
						<div class="petPictureInfo">
							<input type="hidden" id="boardNo" name="boNo" value="<%= a.getBoNo() %>"/>
								<% for(int j = 0; j < fList.size(); j++){ %>
									<% Files f = fList.get(j); %>
									<% if(a.getBoNo() == f.getBoNo()){ %>	 
									<img class="pictureForm" src="<%= request.getContextPath() %>/upload_imageFiles/<%= f.getChangeName() %>"/>
									<div class="petInfos"> 
										<div id="petName" class="petInfo"><%= a.getPetName() %></div><br>
										<div id="petKind" class="petInfo"><%= a.getPetKinds() %>(<%= a.getPetCategory() %>)</div><br>
										<div id="petGender" class="petInfo"><%= a.getPetGender() %> (중성화 <%= a.getPetUnigender() %>)</div><br>
										<span id="petAge" class="petInfo"><%= a.getPetAge() %> /</span>
										<span id="petWeight" class="petInfo"><%= a.getPetWeight() %>kg /</span>
										<span id="petColor" class="petInfo"><%= a.getPetColor() %></span> 									
									</div>
									<% } %>
								<% } %>
							</div>
						</div>
					<% } %>
				<% } %>
			</div>
		</div>
			<!-- 페이징 -->
			<div class="paging">
			
				<!-- 이전 페이지 -->
				<a href="adopt.bo?currentPage=<%= currentPage - 1 %>" class="bt" id="beforeBtn">이전 페이지</a>
				<script>
					if(<%= currentPage %> <= 1){
						var before = $('#beforeBtn');
						before.css("visibility", "hidden");
					}
				</script>
				
				<!--  페이지 목록 -->
				<% for(int p = startPage; p <= endPage; p++){ %>
					<% if(p == currentPage){ %>
                		<a href="adopt.bo?currentPage=<%= p %>" class="num on"><%= p %></a>
                	<% } else { %>	
		                <a href="adopt.bo?currentPage=<%= p %>" class="num"><%= p %></a>
		            <% } %>
	            <% } %>
	            
	            <!-- 다음 페이지 -->
                <a href="adopt.bo?currentPage=<%= currentPage + 1 %>" class="num" id="afterBtn">다음 페이지</a>
                <script>
                	if(<%= currentPage %> >= <%= maxPage%>){
                		var after = $('#afterBtn');
                		after.css("visibility", "hidden");
                	}
                </script>
			</div>
	</form>
		<script>
		function writeForm(){
			location.href='<%= request.getContextPath() %>/adoptWriteForm.bo';
		}
		
		function loginForm(){
			swal("회원 전용 서비스", "로그인 후 이용해주시기 바랍니다.", "info")
			.then((ok) => {
				if(ok){
					location.href='<%= request.getContextPath()%>/loginForm.me';
				}
			});
			return;
		}
		
		$(function(){
			$('.pictureInfo').hover(function(){
				$(this).css('cursor', 'pointer');
			});
		});
		
		$(function(){
			$('.petPictureInfo').click(function(){
				var boNo = $(this).find('input').val();
				location.href="<%= request.getContextPath() %>/adoptDetail.bo?boNo="+boNo;
			});
		});
		</script>
	</section>
</body>
</html>