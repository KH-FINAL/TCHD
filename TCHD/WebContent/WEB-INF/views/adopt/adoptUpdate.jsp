<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, member.model.vo.Member, board.model.vo.*"%>
<%
// 	int bNo = (int)request.getAttribute("bNo");
	String userPhone = (String)request.getAttribute("userPhone");
	Adopt a = (Adopt)request.getAttribute("adopt");
	String rescue = (String)request.getAttribute("rescue");
	ArrayList<Files> fileList = (ArrayList<Files>)request.getAttribute("fileList");
// 	Files thumbnailImg = fileList.get(0);
	
// 	Files contentImg1 = fileList.get(1);
// 	Files contentImg2 = fileList.get(2);
// 	Files contentImg3 = fileList.get(3);
	
// 	String contentImg = (String)request.getAttribute("contentImg");
	String prr[] = a.getPetAge().split("/");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/adopt/adopt_update.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/common/common.css" type="text/css">
</head>
<body>
<section>
   	<form action="<%= request.getContextPath() %>/adoptUpdate.bo" method="post" encType="multipart/form-data" onsubmit="return checkSubmit();">
   		<div id="ment">보호동물 게시글 수정</div>
   		<div id="area">
   			<div id="picture">
   				<table id="pictureTable">
					<tr>
						<th>대표 사진<input type="hidden" name="boNo" value="<%= a.getBoNo() %>"/></th>
						<td id="space1"> </td>
						<td colspan="3">
							<div id="titleImgArea" class="pictureArea">
								<% for(int i = 0; i < fileList.size(); i++){ %>
								<input type="hidden" name="fileList" value="<%= fileList.get(i) %>"/>
								<% } %>
								<img id="titleImg" src="<%= request.getContextPath() %>/upload_imageFiles/<%= fileList.get(0).getChangeName() %>"/>
							</div>
						</td>
						<td id="space2"> </td>
						<th>내용 사진</th>
						<td id="space3"> </td>
						<td>
<%-- 							<% for(int i = 1; i < fileList.size(); i++){ %> --%>
							<div id="contentImgArea1" class="pictureArea">
								<img id="contentImg1" src="<%= request.getContextPath() %>/upload_imageFiles/<%= fileList.get(1).getChangeName() %>"/>
							</div>
<%-- 							<% } %> --%>
						</td>
						<td>
							<div id="contentImgArea2" class="pictureArea">
								<img id="contentImg2" src="<%= request.getContextPath() %>/upload_imageFiles/<%= fileList.get(2).getChangeName() %>"/>
							</div>
						</td>
						<td>
							<div id="contentImgArea3" class="pictureArea">
								<img id="contentImg3" src="<%= request.getContextPath() %>/upload_imageFiles/<%= fileList.get(3).getChangeName() %>"/>
							</div>
						</td>
					</tr>
				</table>
			</div>
			<table id="firstTable">
				<tr>
					<td class="firstTd"> 구분 </td>
					<td id="kindTd" class="secondTd">
<!-- 						<input type="checkbox" name="petKind" value="DOG" onclick="return false;"/> 개  -->
<!-- 						<input type="checkbox" name="petKind" value="CAT" onclick="return false;"/> 고양이 -->
						<div id="petKind">
							<img name="petKind" src="./images/chkbox.png" width="12px" height="12px"/><input type="hidden" name="petKind" value="<%= a.getPetKinds() %>"/> <%= a.getPetKinds() %>
						</div> 
					</td>
					<td class="firstTd"> 성별 </td>
					<td id="genderTd" class="secondTd">
<!-- 						<input type="checkbox" name="petGender" value="F" onclick="return false;"/> 암컷  -->
<!-- 						<input type="checkbox" name="petGender" value="M" onclick="return false;"/> 수컷 -->
						<div id="petGender">
							<img name="petGender" src="./images/chkbox.png" width="12px" height="12px"/><input type="hidden" name="petGender" value="<%= a.getPetGender() %>"/> <%= a.getPetGender() %>
							<input type="checkbox" name="unigender" value="<%= a.getPetUnigender()%>"/> 중성화
						</div> 
					</td>
					<td class="firstTd"> 크기 </td>
					<td id="sizeTd" class="secondTd">
						<select id="petSizes" name="petSize">	<!-- ---------- 이 상태면 등록 안되게 기능 걸기 -->
							<option value="0"> ------------</option>	
							<option value="S">소형(S)</option>
							<option value="M">중형(M)</option>
							<option value="L">대형(L)</option>
						</select>
					</td>
					<td class="firstTd"><span>*</span> 연령 </td>
					<td id="ageTd" class="secondTd">
						<select id="petAge" name="petAge">	
							<option value="0"> ---------------------</option>
							<option value="Puppy">Puppy(~ 6개월)</option>
							<option value="Junior">Junior(7개월 ~ 2살)</option>
							<option value="Adult">Adult(3살 ~ 8살)</option>
							<option value="Senior">Senior(9살 ~)</option>
						</select>
					</td>
					<td id="ageTd2">
						<input type="text" id="ageDetail" name="petAgeDetail" placeholder="숫자" required/>
						<select id="detailAges" name="detailAge">
							<option value="개월">개월</option>
							<option value="살">살</option>
						</select>
					</td>
				</tr>
			</table> 
			<table id="secondTable" class="tables">
				<tr>
					<td class="firstTd">
						<span>*</span> 동물이름 :
					</td>
					<td class="secondTd">
						<input class="answer" name="petName" value="<%= a.getPetName() %>" required/> 
					</td>
				</tr>
				<tr>
					<td class="firstTd">
						<span>*</span> 종류(품종) :
					</td>
					<td class="secondTd">
						<input class="answer" name="petCategory" value="<%= a.getPetCategory() %>" required/>
					</td>
				</tr>
				<tr>
					<td class="firstTd">
						<span>*</span> 몸무게(kg) :
					</td>
					<td class="secondTd">		<!-- 사용자가 숫자만 입력 ==> 기본 0.0kg -->
						<input class="answer" name="petWeight" placeholder=" ex. 0.0kg" value="<%= a.getPetWeight() %>" required>
					</td>
				</tr>
				<tr>
					<td class="firstTd">
						<span>*</span> 색깔 :
					</td>
					<td class="secondTd">
						<input class="answer" name="petColor" value="<%= a.getPetColor() %>" required>
					</td>
				</tr>
			</table>  	
			<table id="thirdTable" class="tables">
				<tr>
					<td class="firstTd">
						 연락처 :
					</td>
					<td class="secondTd">			
						<input type="tel" id="phone" class="answer" name="phone" value="<%= userPhone %>" readonly/>
					</td>
				</tr>
				<tr>
					<td class="firstTd">
						  구조일시 :
					</td>
					<td class="secondTd">		<!-- 사용자가 숫자만 입력 ==> 기본 0.0kg -->
						<input class="answer" type="text" name="rescue" value="<%= rescue %>" readonly/>
					</td>
				</tr>
				
				<tr>
						<td class="firstTd">
						</td>
					</tr>
					<tr>
						<td class="secondTd">
						</td>
					</tr>
			</table> 
			<div id="last">
				<div>하고 싶은 말 : s</div><textarea id="lastAnswer" name="lastMent"><%= a.getPetComment() %></textarea>
				<span id="counter">0</span>/100
			</div> 
   		</div>
   		<div id="fileArea">	<!-- 파일 업로드 부분 -->
	   			<input type="file" id="thumbnailImg1" multiple="multiple" name="thumbnailImg" onchange="LoadImg(this,1)"/>
	   			<input type="file" id="thumbnailImg2" multiple="multiple" name="thumbnailImg1" onchange="LoadImg(this,2)"/>
	   			<input type="file" id="thumbnailImg3" multiple="multiple" name="thumbnailImg2" onchange="LoadImg(this,3)"/>
	   			<input type="file" id="thumbnailImg4" multiple="multiple" name="thumbnailImg3" onchange="LoadImg(this,4)"/>
	   		</div>
	   	<script>
		// insert 당시 입력했던 값 가져옴
		// $("input[name=search_value]")
		// $(tag_name[name=name])
		$('input[name=unigender]').val("<%= a.getPetUnigender() %>");
		$('#petSizes').val("<%= a.getPetSize() %>");
		$('#petAge').val("<%= prr[0].substring(0) %>");		
		$('#ageDetail').val("<%= Integer.parseInt(prr[1].substring(0, 2)) %>");
		$('#detailAges').val("<%= prr[1].substring(2) %>");		   	
		// 크기 선택 안되게 함   --> 입력 당시 값으로 고정
		$('#petSizes option').not(":selected").attr("disabled", "disabled");
// ----------------------------------------------------------------------------------------------------------------------------	   	

	   	
// -------------------------------------------------------------------------	   	
	   	
		 // 입력 당시 썼던 글자수 가져옴
	   		$(document).ready(function(){
	   			$('#lastAnswer').val().lenght
	   				$('#counter').text($(this).val().length);
	   				$('#counter').css('color', 'black');
	   		});
	   	// 하고 싶은 말 글자 수 카운트 및 글자 수 제한
			$('#lastAnswer').keyup(function(e){
				$('#counter').text($(this).val().length);
				if($(this).val().length >= 100){
					$(this).val($(this).val().substring(0, 100));
					$('#counter').css('color', 'red');
				} else {
					$('#counter').css('color', 'black');
				}
	   		});
	   	
// -----------------------------------------------------------------------------------	   	
	   	// 사진 업로드 시 자리 지정
	   		$(function(){
	   			$("#fileArea").hide();
	   			
	   			$("#titleImgArea").click(function(){
	   				$("#thumbnailImg1").click();
	   			});
	   			$("#contentImgArea1").click(function(){
	   				$("#thumbnailImg2").click();
	   			});
	   			$("#contentImgArea2").click(function(){
	   				$("#thumbnailImg3").click();
	   			});
	   			$("#contentImgArea3").click(function(){
	   				$("#thumbnailImg4").click();
	   			});
	   		});
	   		
	   		// 이미지 업로드 함수
	   		function LoadImg(value, num){
	   			if(value.files && value.files[0]){
	   				var reader = new FileReader();
	   				
	   				reader.onload = function(e){
	   					switch(num){
	   					case 1:
	   						$('#titleImg').attr("src", e.target.result);
	   						break;
	   					case 2:
	   						$('#contentImg1').attr("src", e.target.result);
	   						break;
	   					case 3:
	   						$('#contentImg2').attr("src", e.target.result);
	   						break;
	   					case 4:
	   						$('#contentImg3').attr("src", e.target.result);
	   						break;
	   					}
	   				}
	   				
	   				reader.readAsDataURL(value.files[0]);
	   			}
	   		}
	   		
   		</script>
   		
   		<div id="buttonArea">	<!-- 취소하기 : action의 영향 안 받음 -->
   			<button id="cancelButton" class="buttons" type="reset" onclick="location.href='<%= request.getContextPath() %>/adoptDetail.bo?boNo=<%= a.getBoNo() %>'">취소</button>
	   		<button id="okButton" type="submit" class="buttons">수정</button>
	   	</div>
 			<script>
				function okayButton(){
					swal("게시글 수정", "상세페이지로 이동합니다", "info")
					.then((ok) => {
						if(ok){
							location.href='<%= request.getContextPath() %>/adoptUpdate.bo';
						}
					});
					return;				
				}
				
				
				
				function checkSubmit(){
					return true;
				}
	   		</script>
	</form>   	
</section>
</body>
</html>