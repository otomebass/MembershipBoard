package Action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO;
import VO.NewUser;
import VO.Path;
import service.AdminConfirmService;

public class AdminConfirmUserAction implements Action {

	@Override
	public Path execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Path path = new Path();
		path.setPath("/board/AdminConfirmUser.jsp");
		
		int page = 1; 
		int limit = 10;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		
		AdminConfirmService acs = new AdminConfirmService();
		request.setAttribute("newuser", acs.confirm());
		return path;
	}

}   
    