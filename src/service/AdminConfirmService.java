package service;

import static DB.DB.close;
import static DB.DB.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import DAO.DAO;
import VO.NewUser;

public class AdminConfirmService {

	public ArrayList<NewUser> confirm() throws Exception{
		ArrayList<NewUser> newuser = null;
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);
		newuser = dao.confirmview();
		close(conn);
		return newuser;
	}
}
  