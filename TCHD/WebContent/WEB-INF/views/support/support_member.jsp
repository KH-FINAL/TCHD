<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/support/support_member.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/common/common.css" type="text/css">
</head>
<body>
	<section>
		<div class="title">후원하기</div>
		<div class="main_div">
			<div class="sub_div">
				<table>
					<tbody>
						<tr>
							<td id="step">STEP1.<br>후원금 선택
							</td>
							<td id="step">STEP2.<br>후원금 결제
							</td>
						</tr>
						<tr>
							<td id="step_content">
								<select name="price" id="price_control">
									<option value="10000">1만원</option>
									<option value="30000">3만원</option>
									<option value="50000">5만원</option>
									<option value="100000">10만원</option>
									<option value="직접입력">직접입력</option>
								</select>
							</td>
							<td>
								<div class="checkbox">
									<input type="checkbox" id="payment">
									<span id="payment2">&nbsp;&nbsp;무통장 입금 (국민 626401-01-412935)</span>
								</div>
							</td>
						</tr>
					</tbody>
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