package DB;

import java.sql.*;

import javax.naming.*;
import javax.sql.*;

public class DB {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/boardProject");
			conn = ds.getConnection();
			conn.setAutoCommit(false);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 

	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void commit(Connection conn) {
		try {
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
