package service;

import static DB.DB.*;

import java.sql.*;

import DAO.*;

public class AdminAllowBanService {

	public void allow(String id) throws Exception {
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);

		int isSuccessMove = dao.movetouser(dao.Selectbanuser(id));
		if (isSuccessMove > 0) {
			commit(conn);			
		} else {
			rollback(conn);
		}

		int isSuccessBan = dao.deleteBan(id);
		if (isSuccessBan > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

	}
}
