package service;

import static DB.DB.*;

import java.sql.*;

import DAO.*;

public class AdminConfirmOkService {

	public void ConfirmOk(String id) throws Exception {
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);
		
		dao.MoveUser(dao.SelectOneid(id));
		dao.DoneMove(id);
		
		commit(conn);
		close(conn);
	}
}
 