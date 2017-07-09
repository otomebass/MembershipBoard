package service;

import static DB.DB.*;

import java.sql.*;

import DAO.*;

public class IdCheckService {

	public boolean idCheck(String id) throws Exception {
		int idCheck = 0;
		boolean idCheckNotOk = false;
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);
		idCheck = dao.idCheck(id);

		if (idCheck > 0) {
			idCheckNotOk = true;
			commit(conn);
			close(conn);
		} else {
			rollback(conn);
		}

		return idCheckNotOk;
	}
}
