package service;

import static DB.DB.*;

import java.sql.*;

import DAO.*;

public class AdminBanService {

	public void Ban(String id) throws Exception {
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);

		int isSuccessMove = dao.MoveUserBan(dao.Selectoneiduser(id));
		if (isSuccessMove > 0) {
			commit(conn);
			close(conn);
		} else {
			rollback(conn);
		}

		int isSuccessDoneMove = dao.BanDoneMove(id);
		if (isSuccessDoneMove > 0) {
			commit(conn);
			close(conn);
		} else {
			rollback(conn);
		}
	}
}
