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
								<option value="10000">1만원</option>
								<option value="30000">3만원</option>
								<option value="50000">5만원</option>
								<option value="100000">10만원</option>
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
					<span id="total_price_won"></span>
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
				input = input.replace(/[^0-9]/g,''); // 숫자만 입력 가능(숫자가 아닌 다른 문자 입력 시 바로 지워짐)
				input = input.replace(/,/g,''); // , 입력하면 바로 지워짐
				$("#input_direct").val(input.replace(/\B(?=(\d{3})+(?!\d))/g,",")); // 정규식을 이용해 3자리마다 , 추가
				var typing = $("#input_direct").val();
				
				console.log("typing : " + typing);
				console.log(typeof(typing));
				if(typing.charAt(0) != 0){
					$("#total_price_won").html(typing);
				} else if(typing.charAt(0) == "0"){
					// 직접입력하는 칸에 첫글자부터 0을 입력하는 경우
					swal("", "올바른 금액을 입력해주세요.", "error")
					.then((ok) => {
						if(ok){
							$("#input_direct").val("");
							$("#input_direct").focus();
						}
					});
				}
				if($("#input_direct").val() == ""){
					// 직접입력하는 칸에 금액을 입력했다가 다 지운 경우
					$("#total_price_won").html("");
				}
			}
			
			$("#payment").change(function(){
				var select = $("#price_control").val();
				var input = $("#input_direct").val();
				
				if($("#payment").is(":checked")){
					if(select != "직접입력"){
						var selectComma = "";
						
						switch(select){
						case "10000": case "30000": case "50000":
							selectComma = select.substring(0, 1) + ",000";
						case "100000":
							selectComma = select.substring(0, 2) + ",000";
						}
						$("#total_price_won").html(selectComma);
					}
				} else{
						$("#total_price_won").html("");
				}
			});
			
			$("#price_control").change(function(){
				$("#total_price_won").html("");
				$("#payment").prop("checked", false);
			});
			
			// selected된 option이 직접입력이면서, input_direct가 공백인 상태에서 다음 버튼을 누르면 swal창 뜨게해야 함
			function validate(){
				var select = $("#price_control").val();
				var input = $("#input_direct");
				var check = $("#payment");
				var totalPrice = $("#total_price_won");
				console.log("select : " + select + " / input : " + input.val());
				if((select == "직접입력" && input.val().trim().length == 0) || input.val().charAt(0) == "0"){
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
					data: {select:select, input_direct:input.val()},
					success: function(result){
						console.log("result : " + result);
						if(result == 1){
							swal("후원 신청 완료","","success")
							.then((ok) => {
								if(ok){
									location.href="<%=request.getContextPath()%>";
								} else{
									location.href="<%=request.getContextPath()%>";
								}
							});
						} else{
							swal("후원 신청 실패","다시 신청하시기 바랍니다.","error");
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