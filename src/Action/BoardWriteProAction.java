package Action;

import javax.servlet.http.*;

import VO.*;
import service.*;

public class BoardWriteProAction implements Action {

	@Override
	public Path execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Path path = null;
		BoardBean boardBean = new BoardBean();
		String page = request.getParameter("page");
		request.setAttribute("page", page);
		HttpSession session = request.getSession();
		boardBean.setName((String) session.getAttribute("userName"));
		boardBean.setId((String) session.getAttribute("userId"));
		boardBean.setTitle(request.getParameter("title"));
		boardBean.setContent(request.getParameter("content"));

		BoardWriteProService boardWriteProService = new BoardWriteProService();
		boolean isWriteSuccess = boardWriteProService.registerArticle(boardBean);

		if (!isWriteSuccess) {
			String pwChk = "writeFalse";
			request.setAttribute("pwChk", pwChk);
			path = new Path();
			path.setPath("boardWriteForm.do?pwChk=" + pwChk);
		} else {
			path = new Path();
			path.setRedirect(true);
			path.setPath("boardList.do?sort=boardList");
		}
		return path;
	}

}
