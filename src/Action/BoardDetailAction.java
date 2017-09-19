package Action;   

import java.util.*;

import javax.servlet.http.*;

import VO.*;
import service.*;

public class BoardDetailAction implements Action {

	@Override
	public Path execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<ReplyBean> replyList = new ArrayList<ReplyBean>();
		Path path = null;
		String sort="boardList";
		String search="";
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String page = request.getParameter("page");
		BoardDetailService boardDetailService = new BoardDetailService();
		BoardBean article = boardDetailService.getArticle(boardNo);
		replyList = boardDetailService.getReplyList(boardNo);
		int successReplyCount = boardDetailService.getReplyCount(boardNo);
 
		request.setAttribute("replyCount", successReplyCount);
		request.setAttribute("page", page);
		request.setAttribute("article", article);
		request.setAttribute("replyList", replyList);
		
		if (request.getParameter("sort") != null) {
			sort = request.getParameter("sort");
			search = request.getParameter("search");
			request.setAttribute("search", search);
			request.setAttribute("sort", sort);
			path = new Path();
			path.setPath("/board/boardView.jsp");
		}else {			
			path = new Path();
			path.setPath("/board/boardView.jsp");
		}
		
		return path;
	}
 
}
