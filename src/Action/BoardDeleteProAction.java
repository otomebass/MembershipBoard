package Action;   

import java.io.*;

import javax.servlet.http.*;

import org.eclipse.jdt.internal.compiler.parser.*;

import VO.*;
import service.*;

public class BoardDeleteProAction implements Action {

	@Override
	public Path execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Path path = null;
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int page = Integer.parseInt(request.getParameter("page"));
		BoardDeleteProService boardDeleteProService = new BoardDeleteProService();
		String password = request.getParameter("password");
		HttpSession session = (HttpSession) request.getSession();
		String loginUser = (String) session.getAttribute("userPwd");
 
		if (!password.equals(loginUser)) {
			String pwChk = "pwFalse";
			request.setAttribute("pwChk", pwChk);
			path = new Path();
			path.setPath("boardDetail.do?pwChk=" + pwChk);
		} else {  
			boolean isDeleteSuccess = boardDeleteProService.deleteArticle(boardNo);

			if (!isDeleteSuccess) {
				String pwChk = "deleteFalse";
				request.setAttribute("pwChk", pwChk);
				path = new Path();
				path.setPath("boardDetail.do?pwChk=" + pwChk);
			} else {
				path = new Path();
				path.setRedirect(true);
				path.setPath("boardList.do?page=" + page + "&sort=boardList");
			}
		}

		return path;
	}

}
