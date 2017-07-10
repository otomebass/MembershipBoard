package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO;
import VO.NewUser;
import VO.Path;
import service.NewUserService;

public class NewUserAction implements Action {

	@Override
	public Path execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Path path = null;

		NewUser newuser = new NewUser();

		newuser.setName(request.getParameter("name"));
		newuser.setId(request.getParameter("id"));
		newuser.setPwd(request.getParameter("pwd"));
		newuser.setAddr(request.getParameter("addr"));
		newuser.setEmail(request.getParameter("email"));
		newuser.setWho(request.getParameter("who"));

		NewUserService newuserservice = new NewUserService();
		int isJoinSuccess = newuserservice.insert(newuser);

		if (isJoinSuccess > 0) {
			path = new Path();
			path.setPath("/index.jsp?pwChk=join");
		} else {
			path = new Path();
			path.setPath("/index.jsp?pwChk=joinFalse");
		}

		return path;
	}

}
