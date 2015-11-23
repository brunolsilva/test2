package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Teste3 {
	public static void main(String[] args) throws SQLException {
		PreparedStatement stmt = null;
		Connection conn = null;
		String query = "update product set name = ? where id = ?";
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja", "root", "123");
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(query);
			stmt.setString(1, "olar");
			stmt.setInt(2, 3);
			System.out.println(stmt.executeUpdate());
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if(conn != null) {
				conn.rollback();
			}
		} finally {
			if(conn != null) {
				conn.close();
			}
			conn.setAutoCommit(true);
		}
	}
}