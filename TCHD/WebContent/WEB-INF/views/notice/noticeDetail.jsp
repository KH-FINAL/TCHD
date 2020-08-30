<%@page import="board.model.vo.Notice, board.model.vo.Files,member.model.vo.Member "%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	Notice notice = (Notice)request.getAttribute("notice");
	Files file = (Files)request.getAttribute("file");
	Member loginUser = (Member)request.getSession().getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/common.css" type="text/css">
<link rel="stylesheet" href="css/notice_details.css" type="text/css">
</head>
<body>
 <section>
      <div id="ment">공지사항</div>

      <div id="details_div">
         <div id="title_info_div">
            <div id="notice_title">
               <h1>[<%=notice.getNoticeSubject() %>]<%=notice.getBoTitle() %></h1>
            </div>
            <div id="writer_info">
               <a>관리자</a>
               <a> | </a>
               <a><%=notice.getBoDate() %></a>
               <a> | </a>
               <a><%=notice.getBoCount() %></a>
            </div>
         </div>
         <div id="contents_div">
            <div id="img_div">
            <%if(file!=null){ %>
            <img src="upload_imageFiles/<%=file.getChangeName()%>"></div>
            <%} %>
            <div id="contents"><%=notice.getBoContent() %></div>
         </div>
      </div>
         <div id="button_div">
            <button id="list_view_button" onclick="location.href='list.no'">목록보기</button>
            <%if(loginUser !=null && loginUser.getMem_id().equals("admin")){ %>
            <button id="edit_button" onclick="location.href='update.no?bNo=<%=notice.getBoNo()%>'">수정하기</button>
            <%} %>
         </div>
   </section>

</body>
</html>