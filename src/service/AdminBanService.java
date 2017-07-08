package service;

import static DB.DB.close;
import static DB.DB.commit;
import static DB.DB.getConnection;

import java.sql.Connection;

import DAO.DAO;

public class AdminBanService {

	public void Ban(String id) throws Exception {
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);

		dao.MoveUserBan(dao.Selectoneiduser(id));
		dao.BanDoneMove(id);
		commit(conn);
		close(conn);
	}
}
