package Action;

import javax.servlet.http.*;

import VO.*;
import service.*;

public class ReplyProAction implements Action {

	@Override
	public Path execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ReplyBean replyBean(boardNo content name, int boardNo

		Path path = null;
		ReplyBean replyBean = new ReplyBean();
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String page = request.getParameter("page");
		HttpSession session = request.getSession();
		replyBean.setBoardNo(boardNo);
		replyBean.setContent(request.getParameter("replyContent"));
		replyBean.setName((String) session.getAttribute("userName"));
		replyBean.setId((String) session.getAttribute("userId"));
		String boardReply = request.getParameter("boardReply");

		ReplyProService replyProService = new ReplyProService();
		boolean isWriteSuccess = replyProService.registerReply(replyBean, boardNo);

		replyProService.updateReplyCount(boardNo, boardReply);
		if (!isWriteSuccess) {
			String pwChk = "replyWriteFalse";
			request.setAttribute("pwChk", pwChk);
			path = new Path();
			path.setPath("boardDetail.do?pwChk=" + pwChk + "&boardNo=" + boardNo);
		} else {
			path = new Path();
			path.setPath("boardDetail.do?boardNo=" + boardNo);
		}

		return path;
	}

}
