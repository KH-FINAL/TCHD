<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
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
                	                	<tr>
                        <td>8</td>
                        <td>회원정보</td>
                        <td class="tit">
                            <a href="./questionsDetail.html">휴게실에서라면먹게해주세요</a>
                        </td>
                        <td>수지니즈</td>
                        <td>50</td>
                        <td>2020-08-03</td>
                    </tr>
                    <tr>
                        <td>7</td>
                        <td>회원정보</td>
                        <td class="tit">
                            <a>kh전자렌지놔주세요.</a>
                        </td>
                        <td>나나나</td>
                        <td>2020-08-03</td>
                        <td>111</td>
                    </tr>
                    <tr>
                        <td>6</td>
                        <td>봉사게시판</td>
                        <td class="tit">
                            <a>화장실핸드타올놔주세요</a>
                        </td>
                        <td>신우쌤짱</td>
                        <td>2020-08-03</td>
                        <td>111</td>
                    </tr>
                    <tr>
                        <td>6</td>
                        <td>회원정보</td>
                        <td class="tit">
                            <a>배달음식먹게해주세요</a>
                        </td>
                        <td>새콤달콤</td>
                        <td>2020-08-03</td>
                        <td>111</td>
                    </tr>
                    <tr>
                        <td>5</td>
                        <td>입양게시판</td>
                        <td class="tit">
                            <a >커피온탭 맛있다</a>
                        </td>
                        <td>기현조장쓰</td>
                        <td>2020-08-01</td>
                        <td>222</td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td>후원게시판</td>
                        <td class="tit">
                            <a>뢰벤돈까스 강남맛집임</a>
                        </td>
                        <td>서영쓰</td>
                        <td>2019-11-02</td>
                        <td>333</td>
                    </tr>
 
                    <tr>
                        <td>3</td>
                        <td>봉사게시판</td>
                        <td class="tit">
                            <a>신우쌤은 스무살</a>
                        </td>
                        <td>신우쌤짱</td>
                        <td>2020-08-03</td>
                        <td>111</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>입양게시판</td>
                        <td class="tit">
                            <a>고양이 나만 없다.</a>
                        </td>
                        <td>미경반장쓰</td>
                        <td>2020-08-01</td>
                        <td>222</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>회원정보</td>
                        <td class="tit">
                            <a>강아지는 귀엽다.</a>
                        </td>
                        <td>엑셀시오르</td>
                        <td>2019-10-28</td>
                        <td>222</td>
                    </tr>
				
                </tbody>
            </table>
            
  			<div id="wrtie_button_div">
         		<button id="write_button" onClick="location.href='./questionsWrite.html'">글쓰기</button>
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
