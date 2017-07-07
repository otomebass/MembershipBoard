package Action;

import javax.servlet.http.*;

import VO.*;
import service.*;

public class LoginProAction implements Action {

	@Override
	public Path execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Path path = new Path();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		LoginService loginService = new LoginService();
		User loginUser = loginService.getLoginUser(id, pwd);
		// 성공하면 객체 넘어오고, 실패하면 널
		if (loginUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", id);
			session.setAttribute("userPwd", pwd);
			session.setAttribute("userName", loginUser.getName());
			path.setPath("boardList.do");

		} else {
			String pwChk = "loginFalse";
			request.setAttribute("pwChk", pwChk);
			path.setPath("MainPage.jsp?pwChk=" + pwChk);
		}
		return path;
	}

}
