<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/common.css" type="text/css">
<link rel="stylesheet" href="css/notice_write.css" type="text/css">
<script>
$(function(){
	
})

</script>
</head>
<body>
 <section>
      <div id="ment">공지사항</div>
      
      <div id="write_all_div">
      	<form method="post" action="write.no" encType="multipart/form-data" onsubmit="return validate();">
         <div id="write_div">
            <table id="write_table">
               <tr>
                  <th><span class="ment_box">게시판 선택</span></th>
                  <td>
                     <select id="select_board" name="selectBoard">
                        <option value="공지사항">공지사항</option>
                        <option value="문의사항">문의사항</option>
                        <option value="봉시게시판">봉사게시판</option>
                        <option value="입양게시판">입양게시판</option>
                     </select>
                  </td>
               </tr>
               <tr>
                  <th><span class="ment_box">제목</span></th>
                  <td>
                     <input type="text" id="input_title" name="input_title">
                  </td>
               </tr>
               <tr>
                  <th><span class="ment_box">첨부파일</span></th>
                  <td>
                     <div class="file_box" id="file_div">
                        <label id="file_label" for="ex_file">파일선택</label>
                        <input type="file" id="ex_file" name="input_file" accept=".png, .jpg">
                        <span>&nbsp;&nbsp;&nbsp;&nbsp;이미지파일(PNG, JPG)만 첨부 가능합니다.</span>
                     </div>
                  </td>
               </tr>
               <tr>
                  <th id="td_content"><br>내용</th>
                  <td>
                     <textarea id="write_contents" name="input_content" rows="25" cols="110"></textarea>
                  </td>
               </tr>
            </table>
         </div>
         <div id="buttons_div">
            <button id="cancel_button" type="reset">취소</button>
            <button id="enrollment_button" type="submit">등록</button>
         </div>
         </form>
      </div>
      
     <script type="text/javascript">
      $('#ex_file').focus(function(){
         $(':focus').blur();     
      })
      
      function validate(){
		var title=$('#input_title');
		var content=$('#write_contents');
	
		if(title.val().trim().length<1){
			swal("","제목을 입력해주세요","info");
			title.focus();
			return false;
		}
		if(content.val().trim().length<1){
			swal("","내용을 입력해주세요","info");
			content.focus();
			return false;
		}
		
		/* var form = $('form')[0];
		var formData = new FormData(form);
		
		$.ajax({
			url: "list.no",
			type: "post",
			data: formData,
			success: function(data){
				console.log(data);
				if(data=="success"){
					swal("공지사항 등록","공지사항 작성에 성공하였습니다.","success")
					.then((ok)=>{
						if(ok){
							location.href="list.no";
						}
					});
				}
			},
			error: function(data){
				alert("ajax 에러 발생")
			} */
			return true;
		});
	};
   </script>
   </section>

</body>
</html>