package service;

import static DB.DB.*;

import java.sql.*;

import DAO.*;

public class AdminRejectService {

	public void Reject(String id) throws Exception {
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);

		int isSuccessMove = dao.MoveRejectUser(dao.SelectOneid(id));
		if (isSuccessMove > 0) {
			commit(conn);
			close(conn);
		} else {
			rollback(conn);
		}

		int isSuccessDone = dao.DoneMove(id);
		if (isSuccessDone > 0) {
			commit(conn);
			close(conn);
		} else {
			rollback(conn);
		}
	}
}