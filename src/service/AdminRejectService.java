package service;

import static DB.DB.close;
import static DB.DB.commit;
import static DB.DB.getConnection;

import java.sql.Connection;

import DAO.DAO;

public class AdminRejectService {

	public void Reject(String id) throws Exception {
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);

		dao.MoveRejectUser(dao.SelectOneid(id));
		dao.DoneMove(id);

		commit(conn);
		close(conn);
	}
}
