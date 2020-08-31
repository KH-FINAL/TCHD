<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.Member" %>
<%
	String userPhone = (String)request.getAttribute("userPhone");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/common.css" type="text/css">
<link rel="stylesheet" href="css/adopt_write.css" type="text/css">
</head>
<body>
	<section>
		<div id="ment">보호동물 게시글 등록</div>
   		<form action="<%= request.getContextPath() %>/adoptInsert.bo" method="post" encType="multipart/form-data" onsubmit="return checkSubmit();">			
   		<div id="area">
   			<div id="picture">
   				<table id="pictureTable">
					<tr>
						<th>대표 사진</th>
						<td id="space1"> </td>
						<td colspan="3">
							<div id="titleImgArea" class="pictureArea">
								<img id="titleImg"/>
							</div>
						</td>
						<td id="space2"> </td>
						<th>내용 사진</th>
						<td id="space3"> </td>
						<td>
							<div id="contentImgArea1" class="pictureArea">
								<img id="contentImg1"/>
							</div>
						</td>
						<td>
							<div id="contentImgArea2" class="pictureArea">
								<img id="contentImg2"/>
							</div>
						</td>
						<td>
							<div id="contentImgArea3" class="pictureArea">
								<img id="contentImg3"/>
							</div>
						</td>
					</tr>
				</table>
			</div>
				<table id="firstTable">
					<tr>
						<td class="firstTd"><span>*</span> 구분 </td>
						<td id="kindTd" class="secondTd"><input type="checkbox" id="dog" name="petKind" value="DOG"/> 개 
							<input type="checkbox" id="cat" name="petKind" value="CAT"/> 고양이
						</td>
						<td class="firstTd"><span>*</span> 성별 </td>
						<td id="genderTd" class="secondTd"><input type="checkbox" name="petGender" value="F"/> 암컷 
							<input type="checkbox" name="petGender" value="M"/> 수컷
							<input type="checkbox" name="unigender"/> 중성화
						</td>
						<td class="firstTd"><span>*</span> 크기 </td>
						<td id="sizeTd" class="secondTd">
							<select name="petSize">	<!-- ---------- 이 상태면 등록 안되게 기능 걸기 -->
								<option value="0"> ------------</option>
								<option value="S">소형</option>
								<option value="M">중형</option>
								<option value="L">대형</option>
							</select>
						</td>
						<td class="firstTd"><span>*</span> 연령 </td>
						<td id="ageTd" class="secondTd">
							<select name="petAge">	<!-- ---------- 이 상태면 등록 안되게 기능 걸기 -->
								<option value="0"> ---------------------</option>
								<option value="PUPPY">Puppy(~ 6개월)</option>
								<option value="JUNIOR">Junior(7개월 ~ 2살)</option>
								<option value="ADULT">Adult(3살 ~ 8살)</option>
								<option value="SENIOR">Senior(9살 ~)</option>
							</select>
						</td>
						<td>
							<input type="text" id="ageDetail" name="petAgeDetail" placeholder="ex. 3개월, 1살" required/>
						</td>
					</tr>
				</table> 
				<table id="secondTable" class="tables">
					<tr>
						<td class="firstTd">
							<span>*</span> 동물이름 :
						</td>
						<td class="secondTd">
							<input class="answer" name="petName" required/> 
						</td>
					</tr>
					<tr>
						<td class="firstTd">
							<span>*</span> 종류(품종) :
						</td>
						<td class="secondTd">
							<input class="answer" name="petCategory" required/>
						</td>
					</tr>
					<tr>
						<td class="firstTd">
							<span>*</span> 몸무게(kg) :
						</td>
						<td class="secondTd">		<!-- 사용자가 숫자만 입력 ==> 기본 0.0kg -->
							<input type="text" class="answer" name="petWeight" placeholder=" ex. 0.0kg" required/>
						</td>
					</tr>
					<tr>
						<td class="firstTd">
							<span>*</span> 색깔 :
						</td>
						<td class="secondTd">
							<input class="answer" name="petColor" required/>
						</td>
					</tr>
				</table>
				<table id="thirdTable" class="tables">
					<tr>
						<td class="firstTd">
							   연락처 :
						</td>
						<td class="secondTd">		<!-- 마이페이지에서 받아오기 -->	
							<input type="tel" id="phone" class="answer" name="phone" value="<%= userPhone %>" readonly/>
						</td>
					</tr>
					<tr>
						<td class="firstTd">
							<span>*</span> 구조일시 :
						</td>
						<td class="secondTd">	
							<input class="answer" type="date" name="rescue" required/>
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
					<div>하고 싶은 말 : </div><textarea id="lastAnswer" name="lastMent"></textarea>
					<span id="counter">0</span>/100
				</div> 
	   		</div>
	   		<div id="fileArea">	<!-- 파일 업로드 부분 -->
	   			<input type="file" id="thumbnailImg1" multiple="multiple" name="thumbnailImg1" onchange="LoadImg(this,1)"/>
	   			<input type="file" id="thumbnailImg2" multiple="multiple" name="thumbnailImg2" onchange="LoadImg(this,2)"/>
	   			<input type="file" id="thumbnailImg3" multiple="multiple" name="thumbnailImg3" onchange="LoadImg(this,3)"/>
	   			<input type="file" id="thumbnailImg4" multiple="multiple" name="thumbnailImg4" onchange="LoadImg(this,4)"/>
	   		</div>
	   	<script>
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
		<div id="buttonArea">
	   		<button id="cancelButton" class="buttons" onclick="location.href='<%= request.getContextPath() %>/adopt.bo'">취소</button>
	   		<button id="okButton" type="submit" class="buttons">확인</button>
	   	</div>
   	<script>
   	var size = $('#sizeTd').chidren('select option:selected').val();
   	var age = $('#ageTd').chidren('select option:selected').val();
   	if(size == 0){
	   	swal("", "사이즈를 선택해주세요.", "info");
	   	return false;
   	}
   	
   	if(age == 0){
	   	swal("", "나이를 선택해주세요.", "info");
	   	return false;
   	}
   	
   	if($('#sizeTd').chidren('select option').is(":selected")){
   		swal("", "사이즈 선택", "info");	
   	}
   	
   		function checkSubmit(){
//    			if($('#dog').is("checked") == false || $('#cat').is("checked") == false){
//    				swal("", "동물을 선택해주세요.", "info");
// //    				$(this).focus();
//    				return false;
//    			}
		return true;
   		}
   	</script>
   	</form>
	</section>
</body>
</html>









