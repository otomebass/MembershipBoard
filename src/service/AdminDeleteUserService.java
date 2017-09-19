package service;

import static DB.DB.*;

import java.sql.*;

import DAO.*;

public class AdminDeleteUserService {

	public void DeleteUser(String id) throws Exception {
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);

		int isSuccessDeleteUser = dao.deleteUser(id);

		if (isSuccessDeleteUser > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
	}
}
