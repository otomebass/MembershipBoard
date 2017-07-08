package service;

import static DB.DB.*;

import java.sql.*;

import DAO.*;
import VO.*;

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
 