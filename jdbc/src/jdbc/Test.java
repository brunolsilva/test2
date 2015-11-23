package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja", "root", "123");
			
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select name from product");
			while(rs.next()) {
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(stmt != null) {
				stmt.close();
			}
		}
	}
}
