package board.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;


/**
 * Servlet implementation class QuestionsListServlet
 */
@WebServlet(urlPatterns="/list.qu", name="QuestionsListFormServlet")
public class QuestionsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionsListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService qService = new BoardService(); //레퍼런스 변수에 담음
		
		int listCount;		//총 게시글 개수
		int currentPage;	//현재 페이지
		int pageLimit;		//한 페이지에서 표시될 페이징 수
		int boardLimit;		//한 페이지에서 보일 게시글 최대 개수
		int maxPage;		//전체 페이지 중 가장 마지막 페이지
		int startPage;		//페이징 된 페이지 중 시작페이지
		int endPage;		//페이징 된 페이지 중 마지막페이지
		
		listCount = qService.getListCount();
		System.out.println(listCount);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
