<%@page import="member.model.vo.Member"%>
<%@page import="board.model.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Notice> noticeList = (ArrayList<Notice>)request.getAttribute("noticeList");
	Member loginUser = (Member)request.getSession().getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/common.css" type="text/css">
<link rel="stylesheet" href="css/notice_list.css" type="text/css">
</head>
<body>
<section>
      <div id="ment">공지사항</div>
      <div id="search_div">
         <input type="text" id="search_input">
         <button id="search_button">검색</button>
      </div>
      <div id="notice_list_div">
         <table id="notice_list_table">
            <tr>
               <th>번호</th>
               <th>제목</th>
               <th>작성자</th>
               <th>작성일자</th>
               <th>조회수</th>
            </tr>
           <%if(noticeList.isEmpty()){ %>
           	<tr>
           		<td colspan="5">조회결과가 없습니다.</td>
           	</tr>
           <%}else{ %>
           	<%for(int i=0; i<noticeList.size();i++){ %>
            <tr class="noticeTr">
               <td><%=noticeList.get(i).getrNum() %><input type="hidden" class="bNo" value='<%=noticeList.get(i).getBoNo() %>'></td>
               <td class="tit">[<%=noticeList.get(i).getNoticeSubject()%>]<%=noticeList.get(i).getBoTitle() %></td>
               <td>관리자</td>
               <td><%=noticeList.get(i).getBoDate() %></td>
               <td><%=noticeList.get(i).getBoCount() %></td>
            </tr>
            <%} %>
           <%} %> 
        
 
         </table>
      </div>
      <div id="wrtie_button_div">
      <%if(loginUser !=null && loginUser.getMem_id().equals("admin")){ %>
         <button id="write_button" onclick="location.href='writeForm.no'">글쓰기</button>
       <%} %>
      </div>
      <div class="paging">
         <a href="#" class="bt">이전 페이지</a>
         <a href="#" class="num on">1</a>
         <a href="#" class="num">2</a>
         <a href="#" class="num">3</a>
         <a href="#" class="bt">다음 페이지</a>
      </div>
   </section>
<script>
$(function(){
	$('.noticeTr').hover(function(){
		$(this).children().css({'cursor':'pointer', 'background':'#eee'});
	}, function(){
		$(this).children().css({'cursor':'none', 'background':'none'});
	}).click(function(){
		var bNo=$(this).find('.bNo').val();
		location.href="detail.no?bNo="+bNo;
	});
	
	
})
</script>
</body>
</html>