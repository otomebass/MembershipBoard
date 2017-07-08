package service;

import static DB.DB.*;

import java.sql.*;
import java.util.*;

import DAO.*;
import VO.*;

public class AdminConfirmService {

	public ArrayList<NewUser> confirm() throws Exception{
		ArrayList<NewUser> newuser = null;
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);
		newuser = dao.confirmview();
		close(conn);
		return newuser;
	}
}
 