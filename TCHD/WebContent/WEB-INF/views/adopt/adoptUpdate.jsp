<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.model.vo.*"%>
<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/adopt/adopt_update.css?after" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/common/common.css" type="text/css">
</head>
<body>
<section>
   	<form method="post" onsubmit="return checkSubmit();">
   		<div id="ment">보호동물 게시글 수정</div>
   		<div id="area">
			<table id="firstTable">
				<tr>
					<td class="firstTd"> 구분 </td>
					<td id="kindTd" class="secondTd"><input type="checkbox" name="petKind" value="dog" checked/> 개 
						<input type="checkbox" name="petKind" value="cat"/> 고양이
					</td>
					<td class="firstTd"> 성별 </td>
					<td id="genderTd" class="secondTd"><input type="checkbox" name="petGender" value="F" checked/> 암컷 
						<input type="checkbox" name="petGender" value="M"/> 수컷
						<input type="checkbox" value="Y" checked/> 중성화
					</td>
					<td class="firstTd"> 크기 </td>
					<td id="sizeTd" class="secondTd">
						<select>	<!-- 기본 '크기선택'  ==> 크기선택은 고르는 것에는 없게 만들기! -->
							<option value="small">소형</option>
							<option value="middle">중형</option>
							<option value="large">대형</option>
						</select>
					</td>
					<td class="firstTd"><span>*</span> 연령 </td>
					<td id="ageTd" class="secondTd">
						<select>	<!-- 연령 '연령선택'  ==> 크기선택은 고르는 것에는 없게 만들기! -->
							<option value="puppy">Puppy(~ 6개월)</option>
							<option value="Junior">Junior(7개월 ~ 2살)</option>
							<option value="Adult">Adult(3살 ~ 8살)</option>
							<option value="Senior">Senior(9살 ~)</option>
						</select>
					</td>
				</tr>
				<tr>	<!-- png, jpg만 파일 선택하게 설정 -->
					<td colspan="8" class="secondTd"><span>*</span> <input type="file" value="file" multiple accept=".png, .jpg"/>
				</tr>
			</table> 
			<table id="secondTable" class="tables">
				<tr>
					<td class="firstTd">
						<span>*</span> 동물이름 :
					</td>
					<td class="secondTd">
						<input class="answer"/> 
					</td>
				</tr>
				<tr>
					<td class="firstTd">
						<span>*</span> 종류(품종) :
					</td>
					<td class="secondTd">
						<input class="answer"/>
					</td>
				</tr>
				<tr>
					<td class="firstTd">
						<span>*</span> 몸무게(kg) :
					</td>
					<td class="secondTd">		<!-- 사용자가 숫자만 입력 ==> 기본 0.0kg -->
						<input class="answer" placeholder="0.0kg">
					</td>
				</tr>
				<tr>
					<td class="firstTd">
						<span>*</span> 색깔 :
					</td>
					<td class="secondTd">
						<input class="answer">
					</td>
				</tr>
			</table>  	
			<table id="thirdTable" class="tables">
				<tr>
					<td class="firstTd">
						 연락처 :
					</td>
					<td class="secondTd">			
						<input class="answer" readonly/>
					</td>
				</tr>
				<tr>
					<td class="firstTd">
						<span>*</span> 구조일시 :
					</td>
					<td class="secondTd">		<!-- 사용자가 숫자만 입력 ==> 기본 0.0kg -->
						<input class="answer" type="date">
					</td>
				</tr>
				<tr>
					<td class="firstTd">
						<span>*</span> 색깔 :
					</td>
					<td class="secondTd">
						<input class="answer">
					</td>
				</tr>
			</table> 
			<div id="last">
				<div>하고 싶은 말 : </div><textarea id="lastAnswer"></textarea>
				<span id="counter">0</span>/100
			</div> 
   		</div>
   		<div id="buttonArea">
	   		<button id="cancelButton" class="buttons" onclick="cancelButton();">취소</button>
	   		<button id="okButton" class="buttons" onclick="okayButton();">수정</button>
 			<script>
				function cancelButton(){
					alert('게시글이 수정되지 않았습니다.');
				}
				
				function okayButton(){
					alert('게시글이 수정되었습니다.');				
				}
	   		</script>
	   	</div>
	</form>   	
</section>
</body>
</html>