<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/support/support_nonmember2.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/common/common.css" type="text/css">
</head>
<body>
	<section>
		<div class="title">후원하기</div>
		<div class="main_div">
			<div class="sub_div">
				<div class="step_table">
					<table>
						<tr class="step">
							<td class="step" id="step_sub">STEP1.<br>후원금 선택
							</td>
							<td class="step" id="step_main">STEP2.<br>후원자 정보 입력
							</td>
							<td class="step" id="step_sub">STEP3.<br>후원금 결제
							</td>
							<td class="step" id="step_sub">STEP4.<br>후원 완료
							</td>
						</tr>
					</table>
				</div>
				<div class="vol_information_title">
					후원자 정보&nbsp;&nbsp;&nbsp;
					<button type="button">기존 후원자 로그인 ▶</button>
					<button type="button">후원자 아이디 생성하기 ▶</button>
				</div>
				<div class="vol_information_comment">
					<span id="star">*</span> 표시는 필수 입력 항목입니다. 반드시 입력해 주세요.
				</div>
				<div class="vol_information_table">
					<table>
						<tr>
							<th><span>아이디</span> <span id="star">*</span></th>
							<td><input type="text"></td>
						</tr>
						<tr>
							<th><span>생년월일</span> <span id="star">*</span></th>
							<td><input type="date"></td>
						</tr>
						<tr>
							<th><span>연락처</span> <span id="star">*</span></th>
							<td><input type="tel"></td>
						</tr>
						<tr>
							<th><span>이메일</span> <span id="star">*</span></th>
							<td><input type="email"></td>
						</tr>
						<tr>
							<th><span>주소</span> <span>(선택)</span></th>
							<td>
								<table class="address_search">
									<tbody>
										<tr>
											<td>
												<input type="text" id="zip_No" name="zip_No" readonly>
												<input type="button" value="주소검색" onclick="goPopup();">
											</td>
										</tr>
										<tr>
											<td><input type="text" id="roadAddrPart1"></td>
										</tr>
										<tr>
											<td>
												<input type="text" id="addrDetail" value="">
												<input type="text" id="roadAddrPart2" value="">
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="vol_content_footer">
				<button type="button" class="vol_next" onclick="">다음</button>
			</div>
		</div>
	</section>
</body>
</html>