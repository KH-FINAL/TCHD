package board.controller.adopt;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import board.model.service.BoardService;
import board.model.vo.Adopt;
import board.model.vo.Board;
import board.model.vo.Files;
import common.MyFileRenamePolicy;
import member.model.vo.Member;

/**
 * Servlet implementation class AdoptUpdateServlet
 */
@WebServlet(urlPatterns="/adoptUpdate.bo", name="AdoptUpdateServlet")
public class AdoptUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int memNo = ((Member)session.getAttribute("loginUser")).getMem_no();
		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024 * 1024* 10;
			String root = request.getSession().getServletContext().getRealPath("/"); // C:\5_JSPServlet_workspace\TCHD\WebContent\
			String savePath = root + "upload_imageFiles/";	// 파일 저장경로
			
			
			File f = new File(savePath);
			if(!f.exists()) {		// 폴더 없으면 만들고 시작
				f.mkdirs();
			}
		
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize,"UTF-8", new MyFileRenamePolicy());
			
			ArrayList<String> saveFiles = new ArrayList<String>();	 // 바뀐 파일 이름 저장
			ArrayList<String> originFiles = new ArrayList<String>(); // 원본파일 이름 저장
			ArrayList<Files> fList = new ArrayList<Files>();
			Board b = new Board();
			Adopt a = new Adopt();
			
			
			int bNo = Integer.parseInt(multiRequest.getParameter("boNo"));
			
			// insert 했던 입양 동물 정보
			String petKind = multiRequest.getParameter("petKind");		// 동물 구분 체크박스
			String petGender = multiRequest.getParameter("petGender");	// 동물성별 체크박스;
			String unigender = "";
			if(multiRequest.getParameter("unigender") != null) {
				unigender = multiRequest.getParameter("unigender");		// 중성화 여부
			} else {
				unigender = "X";
			}
			String petSize = multiRequest.getParameter("petSize");			// 크기
			String petAge = multiRequest.getParameter("petAge")+ "/" 		// 나이
							+ multiRequest.getParameter("petAgeDetail")
						    + multiRequest.getParameter("detailAge"); 			// 나이
			String petName = multiRequest.getParameter("petName");			// 이름
			String petCategory = multiRequest.getParameter("petCategory");	// 품종
			float petWeight = Float.valueOf(multiRequest.getParameter("petWeight"));	// 무게
			String petColor = multiRequest.getParameter("petColor");		// 색깔
			String rescue = multiRequest.getParameter("rescue");
			String lastMent = multiRequest.getParameter("lastMent");		// 하고 싶은 말
			
			String content = petKind + ", " + petGender + ", " + unigender + ", " + petSize + ", " + petAge + ", " + 
					petName + ", " + petCategory + ", " + petWeight + ", " + petColor + ", " + 
					rescue + ", " + lastMent;
			
//			System.out.println("수정하기 content : " + content);
			
			Enumeration<String> files = multiRequest.getFileNames();	// form에서 전송되는 파일이름 : 글 수정 시 업로드 된 파일 가져오기
			while(files.hasMoreElements()) {
				String name = files.nextElement();	// thumbnailImg(썸네일), thumbnailImg1  ==> 내가 새로 선택한 파일 name태그명
				String updateFile = multiRequest.getFilesystemName(name); // thumbnailImg의 changeName  --> thumbnailImg1의 changeName은 null
				System.out.println("수정하기 파일이름 :"+name);	
				System.out.println("수정하기 파일업데이트 :"+updateFile);
				if(updateFile != null) {	// 사진이 추가됐을 떄??
					saveFiles.add(multiRequest.getFilesystemName(name));	 // 바뀐 파일명
					originFiles.add(multiRequest.getOriginalFileName(name)); // 실제 업로드했던 파일명
				} 
			}
			
			System.out.println("수정하기 썸네일:" + multiRequest.getParameter("thumbnailImg"));	//	null
			System.out.println("수정하기 내용사진:" + multiRequest.getParameter("thumbnailImg1"));// null

			for(int i = 0; i < originFiles.size(); i++) {
				Files ft = new Files();
				ft.setFilePath(savePath);
				ft.setOrignName(originFiles.get(i));
				ft.setChangeName(saveFiles.get(i));
				
				if(i == originFiles.size() -1) {
					ft.setFileLevel(0);
				} else { 
					ft.setFileLevel(1);
				}
				
				fList.add(ft);
			}
			
			System.out.println(saveFiles);	// 썸네일 changeName
			System.out.println(originFiles);// 썸네일 originName

			
			
			b.setBoNo(bNo);
			b.setBoTitle(petName);
			b.setBoContent(content);
			b.setMemNo(memNo);
			
			a.setBoNo(bNo);
			a.setPetName(petName);
			a.setPetKinds(petKind);
			a.setPetCategory(petCategory);
			a.setPetGender(petGender);
			a.setPetUnigender(unigender);
			a.setPetAge(petAge);
			a.setPetWeight(petWeight);
			a.setPetSize(petSize);
			a.setPetColor(petColor);
			a.setRescueDate(rescue);
			a.setPetComment(lastMent);
			
			int result = new BoardService().updateAdopt(b, a, fList);
			
			if(result > 0) {
				request.setAttribute("adopt", a);
				request.setAttribute("fList", fList);
				request.setAttribute("section", "WEB-INF/views/adopt/adoptDetail.jsp");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			} else {
				response.sendRedirect("adoptDetail.bo?boNo=" + bNo);
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
