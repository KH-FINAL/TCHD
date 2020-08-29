<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, board.model.vo.*, member.model.vo.Member"  %>    
<%
	@SuppressWarnings("unchecked")
	ArrayList<Questions> Qlist = (ArrayList<Questions>)request.getAttribute("Qlist");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	Member loginUser = (Member)session.getAttribute("loginUser");
	String msg = (String)session.getAttribute("msg");
	
	
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>    
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
                        <th width="100px">번호</th>
                        <th width="150px">분류</th>
                        <th width="450px">제목</th>
                        <th width="100px">작성자</th>
                        <th width="100px">조회수</th>
                        <th width="100px">날짜</th>
                    </tr>
                </thead>
				 <% if(Qlist.isEmpty()){ %>
		            <tr>
		               <td colspan="6">조회된 리스트가 없습니다.</td>
		            </tr>
		            <% } else{ %>
		         	   <% for(Questions q : Qlist){ %>
		         	   <tr>
			         	   <td class="td_boNo">
			         	   	<input type="hidden" value="<%= q.getBoNo()%>">
			         	   <%= q.getBoNo() %>
			         	   </td>
			         	   <td><%= q.getCateName() %></td>
			         	   <td class="tet">
			         	   	<a href="<%= q.getBoTitle() %>/detail.qu"><%= q.getBoTitle() %></a>
			         	   </td>
			         	   <td><%= q.getMemId() %></td>
			         	   <td><%= q.getBoCount() %></td>
			         	   <td><%= q.getBoDate() %></td>
			         	</tr>   
				        <% } %>
				   <% } %>
            </table>
            
  			<div id="wrtie_button_div">
  				<% if(loginUser!=null){ %>
         		<button id="write_button" onClick="goWrite()">글쓰기</button>
      			<% } else {%> 
      			<button id="write_button" onClick="goLogin()">글쓰기</button>
      			<% } %>
      		</div>
            
            
            <!-- 페이징 -->    
			<div class="paging">
			
				<!-- 이전 페이지 -->
	         	<a href="list.qu?currentPage=<%= currentPage - 1 %>" class="bt" id="beforeBtn">이전 페이지</a>
		         	<script>
		        	if(<%= currentPage %> <= 1){
		        		var before = $('#beforeBtn');
		        		before.css("visibility","hidden");
		        	}
		       		</script>

		   	    <!-- 페이지 목록 -->
        		<% for(int p = startPage; p <= endPage; p++){ %>
	        		<% if(p == currentPage){ %>  
	        			<a href="list.qu?currentPage=<%= p %>" class="num on"><%= p %></a>
	        		<% } else { %>
	        			<a href="list.qu?currentPage=<%= p %>" class="num"><%= p %></a>
	        		<% } %>
       			 <% } %>
		   	    
		   	    
		   	    <!-- 다음 페이지 -->
		   	    <a href="list.qu?currentPage=<%=currentPage + 1%>" class="bt" id="afterBtn">다음 페이지</a>
				 <script>
		        	if(<%= currentPage %> >= <%= maxPage %>){
		        		var after = $('#afterBtn');
		        		after.css("visibility", "hidden");
		        	}
		        </script>    		  
    		</div>
    	
    	<script>	
        function goWrite(){
			location.href="<%= request.getContextPath() %>/writeForm.qu";
		}
		
		function goLogin(){

			window.alert("로그인 후 이용해주시기 바랍니다.");
			location.href="<%= request.getContextPath() %>/loginForm.me";
		}
		</script>
        </section>
	<script>
  	$(function(){
  		$('td').mouseenter(function(){zzz
   			$(this).parent().css({'background':'#eee', 'cursor':'pointer', 'text-decoration':'underline'});
   		}).mouseout(function(){
   			$(this).parent().css({'background': 'none', 'text-decoration':'none'});
   		}).click(function(){
   			var bId = $(this).parent().children().children('input').val();
   			
   		});
   	});
   </script>
 </body>
</html>
