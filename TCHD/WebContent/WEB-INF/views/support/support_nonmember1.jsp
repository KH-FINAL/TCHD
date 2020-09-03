<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/support/support_nonmember1.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/common/common.css" type="text/css">
</head>
<body>
	<section>
		<div class="title">후원하기</div>
		<div class="main_div">
			<div class="sub_div">
				<table>
					<tr class="step">
						<td class="step" id="step_main">STEP1.<br>후원금 선택
						</td>
						<td class="step" id="step_sub">STEP2.<br>후원자 정보 입력
						</td>
						<td class="step" id="step_sub">STEP3.<br>후원금 결제
						</td>
						<td class="step" id="step_sub">STEP4.<br>후원 완료
						</td>
					</tr>
					<tr>
						<td></td>
						<td class="step_content">
							<span id="step_content_1">일시후원</span>
						</td>
						<td class="step_content" id="step_content_2">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<select name="price" class="price_control">
								<option value="10000">1만원</option>
								<option value="30000">3만원</option>
								<option value="50000">5만원</option>
								<option value="100000">10만원</option>
								<option value="직접입력">직접입력</option>
							</select>
						</td>
						<td></td>
					</tr>
				</table>
				<div id="total_price">
					후원금액 합계 <span id="total_price_won">10,000</span> 원
				</div>

			</div>
			<div class="vol_content_footer">
				<button type="button" class="vol_next" onclick="">다음</button>
			</div>
		</div>
	</section>
</body>
</html>