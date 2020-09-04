<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/support/support_member.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<section>
		<div class="title">후원하기</div>
		<div class="main_div">
			<div class="sub_div">
				<table>
					<tr>
						<td id="step">STEP1.<br>후원금 선택</td>
						<td id="step">STEP2.<br>결제 방법</td>
					</tr>
					<tr>
						<td id="step_content">
							<select id="price_control" onChange="directFunction(this.value);">
								<option value="1만원">1만원</option>
								<option value="3만원">3만원</option>
								<option value="5만원">5만원</option>
								<option value="10만원">10만원</option>
								<option value="직접입력">직접입력</option>
							</select>
							<span id="input_span" style="display: none;">
								<span>\</span>
								<input type="text" id="input_direct" maxlength="15" onkeyup="addCommas(this.value);">
							</span>
						</td>
						<td>
							<div class="checkbox">
								<input type="checkbox" id="payment">
								<span id="payment2">&nbsp;&nbsp;무통장입금 (국민 626401-01-412935)</span>
							</div>
						</td>
					</tr>
				</table>
				<div id="total_price">
					<span>후원금액 합계 </span>
					<span id="total_price_won">10,000</span>
					<span>원</span>
				</div>
			</div>
			<div class="vol_content_footer">
				<button class="vol_next" onclick="validate();">다음</button>
			</div>
		</div>
		
		<script>
			function directFunction(select){
				if (select == '직접입력') {
					$('#input_span').show();
				} else {
					$('#input_span').hide();
				}
			}
			
			function addCommas(input){
				input = input.replace(/[^0-9]/g,''); // 입력값이 숫자 아님 공백
				input = input.replace(/,/g,''); // ,값 공백처리
				$("#input_direct").val(input.replace(/\B(?=(\d{3})+(?!\d))/g,",")); // 정규식을 이용해 3자리마다 , 추가
			}
			
			// selected된 option이 직접입력이면서, input_direct가 공백인 상태에서 다음 버튼을 누르면 swal창 뜨게해야 함
			function validate(){
				var select = $("#price_control").val();
				var input = $("#input_direct");
				var check = $("#payment");
				
				if(select == "직접입력" && input.val().trim().length == 0){
					swal("","금액을 입력해주세요.","info")
					.then((ok) => {
						if(ok){
							input.focus();
						}
					});
					
					return;
				}
				
				if(check.is(":checked") == false){
					swal("", "결제 방법을 체크해주세요.", "info");
					
					return;
				}
				
				$.ajax({
					url: "supportApply.su",
					type: "post",
					data: {input_direct:input.val()},
					success: function(data){
						console.log(data);
						if(select == "직접입력"){
							if(data == 1){
								swal("후원 신청 완료","","success")
								.then((ok) => {
									if(ok){
										location.href="<%=request.getContextPath()%>";
									}
								});
							} else{
								swal("후원 신청 실패","다시 신청하시기 바랍니다.","error");
							}
						}
					},
					error: function(data){
						alert("ajax에러 발생");
					}
				});
			}
		</script>
	</section>
</body>
</html>