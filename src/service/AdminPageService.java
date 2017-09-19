package service;

import static DB.DB.*;

import java.sql.Connection;

import DAO.DAO;

public class AdminPageService {

	public int waituser() throws Exception {
		int i = 0;

		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);

		i = dao.countuser();
		close(conn);
		return i;
	}

	public int manageuser() throws Exception {
		int j = 0;

		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);

		j = dao.countmanageuser();
		close(conn);
		return j;
	}

	public int managereject() throws Exception {
		int k = 0;

		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);

		k = dao.countmanagereject();
		close(conn);
		return k;
	}
}
