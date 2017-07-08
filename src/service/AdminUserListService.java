package service;

import static DB.DB.*;

import java.sql.*;
import java.util.*;

import DAO.*;
import VO.*;

public class AdminUserListService {

	public ArrayList<User> showuser() throws Exception {

		ArrayList<User> user = null;
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);
		user = dao.AllUser();

		close(conn);
		return user;
	}
}
 