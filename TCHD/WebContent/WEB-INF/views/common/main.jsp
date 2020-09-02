<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/common/main.css" type="text/css">
</head>
<body>
 	<section>	
		<div id="article1"><img src="images/picture1.png"></div>
		<div id="article2"><img src="images/picture2.png"></div>
		<div id="notice">
			<table>
				<thead>
					<tr class="notice_tr">
						<th class="notice_th">공지사항</th>
						<th class="notice_th">날짜</th>
					</tr>
				</thead>
				<tbody id="notice_tbody">
					
				</tbody>			
			</table>
		</div>
		<p class="clear"></p>
		<div id="article3"><img src="images/picture3.png"></div>
	</section>
	<script>
		$(function(){
			$.ajax({
				url:  'main.no',
				success: function(data){
					console.log(data);
					if(data!=null){
						var tbody = $("#notice_tbody");
						
						for(var i=0; i<data.length; i++){
							var input="<tr><td id='noticeTitle' onclick='goNotice("+ data[i].boNo+");'> ["+data[i].noticeSubject+"] " +data[i].boTitle+
							"</td><td id='noticeDate'>"+data[i].boDate+"</td></tr>";
							tbody.append(input);
						}						
					}else{
						var input="<tr><td id='noticeTitle' >등록된 공지사항이 없습니다.</td><td id='noticeDate'></td></tr>";
						tbody.append(input);
						
					}
				},
				error: function(data){
					alert("ajax 에러 발생");
				}
			});
			
		});
		function goNotice(boNo){
			location.href="detail.no?bNo="+boNo;
		};
	</script>
</body>
</html>