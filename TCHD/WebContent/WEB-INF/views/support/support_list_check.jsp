<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/support/support_list_check.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/common/common.css" type="text/css">
</head>
<body>
	<section>
		<div class="title">후원하기</div>

		<div class="main_div">
			<div class="sub_div">
				<div class="search">
					<input type="month" id="search_month">
					<script>
						document.getElementById('search_month').value = new Date()
								.toISOString().slice(0, 7);
					</script>
				</div>
				<div class="view_table">
					<table>
						<tr id="table_th">
							<th>번호</th>
							<th>날짜</th>
							<th>금액</th>
						</tr>
						<tr>
							<td>1</td>
							<td>2020/08/01</td>
							<td>10,000</td>
						</tr>
						<tr>
							<td>2</td>
							<td>2020/08/05</td>
							<td>50,000</td>
						</tr>
						<tr>
							<td>3</td>
							<td>2020/08/10</td>
							<td>100,000</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</table>
				</div>
			</div>
			<div class="total" id="total_price">
				8월 누적 후원금액 <span class="total" id="total_price_won">160,000</span>
				원&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
		</div>
	</section>
</body>
</html>