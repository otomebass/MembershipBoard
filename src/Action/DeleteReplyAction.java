package Action;

import javax.servlet.http.*;

import VO.*;
import service.*;

public class DeleteReplyAction implements Action {

	@Override
	public Path execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Path path = null;
		path = new Path();

		int pkNo = Integer.parseInt(request.getParameter("pkNo"));
		DeleteReplyService deleteReplyService = new DeleteReplyService();

		boolean isSuccessDelete = deleteReplyService.deleteReply(pkNo);
		if (isSuccessDelete) {
			path.setPath("boardDetail.do?pwChk=successDeleteReply");
		} else {
			path.setPath("boardDetail.do?pwChk=falseDeleteReply");
		}
		return path;
	}

}
