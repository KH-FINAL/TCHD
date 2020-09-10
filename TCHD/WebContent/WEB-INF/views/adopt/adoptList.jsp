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
			<div id="petSelect">
				<table>
				<tr>
					<td id="imgSpace"></td>
					<td>
						<div id="btn">
							<% if(userId != null){ %>
								<button type="button" class="petButton" name="petUpDate" onclick="writeForm();">+ 등 록</button>				
							<% } else {%> 
								<button type="button" class="petButton" name="petUpDate" onclick="loginForm();">+ 등 록</button>	
							<% } %>
						</div>
					</td>
				</tr>
				</table>
		</div>
			<div id="petPicture">		<!-- 동물 사진 영역 -->
			<% if(aList.isEmpty() || fList.isEmpty()){ %>
					등록된 사진이 없습니다.
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
										<div id="petKind" class="petInfo"><%= a.getPetKinds() %>(<%= a.getPetCategory() %>)</div><div id="petSize" class="petInfo">&nbsp; 크기 : <%= a.getPetSize() %></div><br>
										<div id="petGender" class="petInfo">성별 : <%= a.getPetGender() %> (중성화 <%= a.getPetUnigender() %>)</div><br>
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