package service;

import static DB.DB.*;

import java.sql.*;

import DAO.*;
import VO.*;

public class LoginService {

	public User getLoginUser(String id, String pwd) {
		DAO dao = DAO.getInstance();
		Connection conn = getConnection();
		dao.setConnection(conn);
		User loginUser = dao.selectLoginUser(id, pwd);
		close(conn);
		return loginUser;
	}
}
