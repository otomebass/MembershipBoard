package service;

import static DB.DB.*;
import java.sql.Connection;

import DAO.DAO;

public class AdminConfirmOkService {

	public void ConfirmOk(String id) throws Exception {
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);

		int isSuccessMove = dao.MoveUser(dao.SelectOneid(id));
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
