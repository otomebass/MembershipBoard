package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.Path;
import service.AdminConfirmOkService;

public class AdminConfirmOk implements Action {

	@Override
	public Path execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Path path = new Path();
		
		String id = request.getParameter("id");
		AdminConfirmOkService acok = new AdminConfirmOkService();
		acok.ConfirmOk(id);
		
		path.setPath("/AdminConfirmUser.do"); 
		return path;
	}

}
