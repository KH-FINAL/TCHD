<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<link rel="stylesheet" href="css/questions_list.css" type="text/css">
<meta charset="UTF-8">
<body>
	<section>
		<div id = "ment" class="board_list_wrap">문의게시판</div>
		<table class="board_list">
                <caption>게시판 목록</caption>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>분류</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>조회수</th>
                        <th>날짜</th>
                    </tr>
                </thead>
                <tbody>
                
                	<% for(int i=0; i<10; i++){ %>
                
                	<tr>
                        <td><%=i+1%></td>
                        <td>회원정보</td>
                        <td class="tit">
                            <a href="./questionsDetail.jsp">휴게실에서라면먹게해주세요</a>
                        </td>
                        <td>수지니즈</td>
                        <td>50</td>
                        <td>2020-08-03</td>
                    </tr>
                    
                    <% } %>
				
                </tbody>
            </table>
            
  			<div id="wrtie_button_div">
         		<button id="write_button" onClick="location.href='./questionsWrite.jsp'">글쓰기</button>
      		</div>
                
			<div class="paging">
         	<a href="#" class="bt">이전 페이지</a>
      	    <a href="#" class="num on">1</a>
     	    <a href="#" class="num">2</a>
    	     <a href="#" class="num">3</a>
    	     <a href="#" class="bt">다음 페이지</a>
    		  </div>
        	
        </section>

 </body>
</html>
