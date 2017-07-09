package Action;

import javax.servlet.http.*;

import VO.*;
import service.*;

public class IdCheckAction implements Action {

	@Override
	public Path execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String idCheck = request.getParameter("idCheck");
		Path path;

		IdCheckService idCheckService = new IdCheckService();
		boolean idCheckNotOk = idCheckService.idCheck(idCheck);
		if (idCheckNotOk) {
			path = new Path();
			String pwChk = "idCheckNot";
			request.setAttribute("pwChk", pwChk);
			path.setPath("/board/NewUser.jsp?pwChk=" + pwChk);
		} else {
			path = new Path();
			String pwChk = "idCheckOk";
			request.setAttribute("pwChk", pwChk);
			path.setPath("/board/NewUser.jsp?pwChk=" + pwChk);
		}

		return path;
	}

}
