<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, board.model.vo.*, member.model.vo.*"%>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
	Adopt adopt = (Adopt)request.getAttribute("adopt");
	ArrayList<Files> fileList = (ArrayList<Files>)request.getAttribute("fileList");
	Files thumbnailImg = fileList.get(0);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/adopt/adopt_detail.css?after" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/common/common.css" type="text/css">
</head>
<body>
<section>	<!-- action="<%= request.getContextPath() %>/adoptApplyForm.bo" method="post" -->	<!-- action : 값을 전달(submit)할 곳으로 경로지정 -->
	<form onsubmit="return checkSubmit();">
   		<div id="ment">보호동물 정보</div>
   			<div id="picture">
				<img id="thumbnailImg" src="<%= request.getContextPath()%>/upload_imageFiles/<%= thumbnailImg.getChangeName() %>"/>
				<div id="btn">
					<img id="left" class="switch" src="./images/btnL.PNG">
					<img id="right" class="switch" src="./images/btnR.PNG">
				</div>
	   		</div>
	   		<div id="petName">
	   		<p>송이</p>
	   		<input type="text" id="boardNo" name="boNo" value="<%= adopt.getBoNo() %>">
	   		<hr>
				<div class="petDetail">
		  			<ul>
		  				<li>종/품종</li>
		  				<li>성별(중성화여부)</li>
		  				<li>추정나이</li>
		  				<li>몸무게 / 크기</li>
		  				<li>털색</li>
		  				<li>구조일시</li>
		  			</ul>
				</div>
				<div class="petDetail">
					<ul>
		  				<li><%= adopt.getPetKinds() %> / <%= adopt.getPetCategory() %></li>
		  				<li><%= adopt.getPetGender() %>(<%= adopt.getPetUnigender() %>)</li>
		  				<li><%= adopt.getPetAge() %></li>
		  				<li><%= adopt.getPetWeight() %>kg / <%= adopt.getPetSize() %></li>
		  				<li><%= adopt.getPetColor() %></li>
		  				<li><%= adopt.getPetRescueDate() %></li>
		  			</ul>
				</div>
  				<hr>
  			</div>				
	   		<div id="smallPictures">
	   			<div id="smallPets">
		   			<% for(int i = 1; i < fileList.size();  i++){ %>
		   				<img id="detailImg" class="smallPicture" src="<%= request.getContextPath() %>/upload_imageFiles/<%= fileList.get(i).getChangeName() %>"/>
	   				<% } %>
   				</div>
   				<% if(loginUser != null && adopt.getId().equals(loginUser.getMem_id())){ %> 
					<input type="button" id="delete" class="threeButton" value="삭제하기" onClick="deleteForm();"/>
					<input type="button" id="alter" class="threeButton" value="수정하기" onClick="location.href='<%= request.getContextPath()%>/adoptUpdateForm.bo'"/>
				<% } else { %>
					<input type="button" id="delete" class="threeButton" value="삭제하기" disabled="disabled"/>
					<input type="button" id="alter" class="threeButton" value="수정하기" disabled="disabled"/>
				<% } %>
				<% if(loginUser != null){ %>
					<input type="button" id="apply" class="threeButton" value="입양하기" onClick="location.href='<%= request.getContextPath()%>/adoptApplyForm.bo?bNo=<%= adopt.getBoNo() %>'"/>
				<% } else{ %>
					<input type="button" id="apply" class="threeButton" value="입양하기" onClick="loginForm();"/>
				<% } %>
			</div>
	</form>		
	<script>
		$(function(){				/* jQuery */
			$('.threeButton').hover(function(){
				$(this).css('cursor', 'pointer');				
			}, function(){
				$(this).css('cursor', 'none');
			})
			
			$('.smallPicture').hover(function(){
				$(this).css('cursor', 'pointer');				
			}, function(){
				$(this).css('cursor', 'none');
			})
			
			$('#homePicture').hover(function(){
				$(this).css('cursor', 'pointer');
				$('.switch').show();
			}, function(){
				$(this).css('cursor', 'none');
				$('.switch').hide();
			})
		});
		
// 		var count = 1;
// 		function changePicture(){
// 			var home = document.getElementById('homePicture');
// 			var img1 = document.getElementById('firstPicture');
// 			var img2 = document.getElementById('secondPicture');
// 			var img3 = document.getElementById('thirdPicture');
			
// 			if(count == 1){
// 				home.src = "images/송이1.JPG";
// 			} else if(count == 2){
// 				home.src = "images/송이2.JPG";
// 			} else {
// 				home.src = "images/송이3.JPG";
// 			}
			
// 			count++;
// 		}
		
		function deleteForm(){		
			var result = confirm("해당 게시물을 삭제하시겠습니까?");
			if(result){
				alert("해당 게시물이 삭제되었습니다");
			} else { 
				close.self();
			}
				
				
				
// 			var result = swal("", "해당 게시물을 삭제하시겠습니까?", "info", ["취소", "삭제"]);
// 			if(result){
// 				swal("", "해당 게시물이 삭제되었습니다", "info");
// 				return checkSubmit();
// 			} else {
// 				return checkSubmit();
// 			}
		}
		
		function loginForm(){
			swal("", "로그인 후 이용해주시기 바랍니다.", "info");
			location.href='<%= request.getContextPath()%>/loginForm.me';
		}
	</script>
</section>
</body>
</html>