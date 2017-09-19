package service;

import static DB.DB.close;
import static DB.DB.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import DAO.DAO;

import VO.User;

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
