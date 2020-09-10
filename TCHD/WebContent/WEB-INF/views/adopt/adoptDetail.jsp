<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, board.model.vo.*, member.model.vo.*"%>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
	Adopt adopt = (Adopt)request.getAttribute("adopt");
	if(adopt.getPetComment() == null){
		adopt.setPetComment("");
	}
	String rescue = (String)request.getAttribute("rescue");
	ArrayList<Files> fileList = (ArrayList<Files>)request.getAttribute("fileList");
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
<section>	
	<form action="<%= request.getContextPath() %>/adoptUpdateForm.bo" method="post" onsubmit="return checkSubmit();">
   		<div id="ment">보호동물 정보</div>
   			<div id="picture">
				<img id="thumbnailImg" src="<%= request.getContextPath()%>/upload_imageFiles/<%= fileList.get(0).getChangeName() %>"/>
	   		</div>
	   		<div id="petName">
	   		<p><%= adopt.getPetName() %></p><input type="button" id="listBtn" value="목록 >" onclick="location.href='<%= request.getContextPath() %>/adopt.bo';"/>
	   		<input type="hidden" name="petName" value="<%= adopt.getPetName() %>">
	   		<input type="hidden" id="boardNo" name="boNo" value="<%= adopt.getBoNo() %>">
	   		<hr>
				<div class="petDetail">
		  			<table>
			        	<tr>
			        		<td>종/품종</td>
			        	</tr>
			        	<tr>
			        		<td>성별(중성화여부)</td>
			        	</tr>
			        	<tr>
			        		<td>추정나이</td>
			        	</tr>
			        	<tr>
			        		<td>몸무게</td>
			        	</tr>
			        	<tr>
			        		<td>털색</td>
			        	</tr>
			        	<tr>
			        		<td>구조일시</td>
			        	</tr>
			        	<tr>
			        		<td>하고 싶은 말</td>
			        	</tr>
		           </table>
				</div>
				<div class="petDetail">
					<table>
			        	<tr>
			        		<td>
			        			<input type="hidden" name="petKind" value="<%= adopt.getPetKinds() %>"/><%= adopt.getPetKinds() %>/
			        			<input type="hidden" name="petCategory" value="<%= adopt.getPetCategory() %>"/><%= adopt.getPetCategory() %>
			        		</td>
			        	</tr>
			        	<tr>
			        		<td>
			        			<input type="hidden" name="petGender" value="<%= adopt.getPetGender() %>"/><%= adopt.getPetGender() %>
			        			<input type="hidden" name="unigender" value="<%= adopt.getPetUnigender() %>"/>(<%= adopt.getPetUnigender() %>)
			        		</td>
		        		</tr>
		        		<tr>
			        		<td>
				        		<input type="hidden" name="petAge" value="<%= adopt.getPetAge() %>"/><%= adopt.getPetAge() %>
				        		<input type="hidden" name="petAgeDetail"/>
				        		<input type="hidden" name="detailAge"/>
			        		</td>
		        		</tr>
		        		<tr>
			        		<td>
				        		<input type="hidden" name="petWeight" value="<%= adopt.getPetWeight() %>"/><%= adopt.getPetWeight() %>kg/
				        		<input type="hidden" name="petSize" value="<%= adopt.getPetSize() %>"/><%= adopt.getPetSize() %>
			        		</td>
		        		</tr>
		        		<tr>
			        		<td><input type="hidden" name="petColor" value="<%= adopt.getPetColor() %>"/><%= adopt.getPetColor() %></td>
			        	</tr>
			        	<tr>
			        		<td><input type="hidden" name="rescue" value="<%= rescue %>" /><%= rescue %></td>
			        	</tr>
			        	<tr>
		        			<td><input type="hidden" name="lastMent" value="<%= adopt.getPetComment() %>"><%= adopt.getPetComment() %></td>
		        		</tr>
	        		</table>
				</div>
  				<hr>
  			</div>				
	   		<div id="smallPictures">
	   			<div id="smallPets">		
	   			<% for(int i = 1; i < fileList.size();  i++){ %>
		   				<img id="detailImg" class="smallPicture" src="<%= request.getContextPath() %>/upload_imageFiles/<%= fileList.get(i).getChangeName() %>"/>
				<% } %>
		   			<% for(int i = 0; i < fileList.size();  i++){ %>
		   				<input type="hidden" name="fileList" value="<%= fileList.get(i) %>"/>
	   				<% } %>
   				</div>
   				<% if(loginUser != null && adopt.getId().equals(loginUser.getMem_id())){ %> 
					<input type="button" id="delete" class="threeButton" value="삭제하기"/>
					<input type="submit" id="alter" class="threeButton" value="수정하기" onclick="location.href='<%= request.getContextPath()%>/adoptUpdateForm.bo?boNo=<%= adopt.getBoNo()%>'"/> 
				<% } else { %>
					<input type="button" id="delete" class="threeButton" value="삭제하기" disabled="disabled"/>
					<input type="button" id="alter" class="threeButton" value="수정하기" disabled="disabled"/>
				<% } %>
				<% if(loginUser != null){ %>
					<input type="button" id="apply" class="threeButton" value="입양하기" onclick="location.href='<%= request.getContextPath()%>/adoptApplyForm.bo?boNo=<%= adopt.getBoNo() %>'"/>
				<% } else{ %>
					<input type="button" id="apply" class="threeButton" value="입양하기" onclick="loginForm();"/>
				<% } %>
			</div>
	</form>		
	<script>
		function loginForm(){
			swal("회원 전용 서비스", "로그인 후 이용해주시기 바랍니다.", "info")
			.then((ok) => {
				if(ok){
					location.href='<%= request.getContextPath()%>/loginForm.me';
				}
			});
			return;
		}
		
		$('#delete').on('click', function(){
			var bNo = <%= adopt.getBoNo() %>;
			swal({
				title : '게시글 삭제',
				text : '해당 게시글을 삭제하시겠습니까?',
				icon : 'warning',
				buttons : ["아니오", "예"],
				dangerMode : true,
			}).then((ok) => {		
				if(ok){
					swal({
						title : '삭제 완료', 
						text : '해당 게시글이 삭제되었습니다', 
						icon : 'success'
					}).then((ok) => {
						if(ok){
							location.href = "<%= request.getContextPath() %>/adoptDelete.bo?boNo=" + bNo;	
						}
					});
					
				} else {
					swal.close();
				}
			});
			
			return true;
		});
		
		
	</script>
</section>
</body>
</html>