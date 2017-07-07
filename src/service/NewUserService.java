package service;

import static DB.DB.close;
import static DB.DB.getConnection;

import java.sql.Connection;

import DAO.DAO;
import VO.NewUser;

public class NewUserService {

	public void insert(NewUser newuser) throws Exception {
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);
		dao.New(newuser);
		conn.commit();
		close(conn);
	}
}
