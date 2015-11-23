package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Teste2 {
	public static void main(String[] args) throws SQLException {
		Statement stmt = null;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja", "root", "123");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			ResultSet result = stmt.executeQuery("select * from product");
			result.moveToInsertRow();
			result.updateInt("delete_flag", 1);
			result.updateString("name", "hello");
			result.updateString("description", "helloss");
			result.updateInt("category_id", 1);
			result.insertRow();
			result.beforeFirst();
			
//			while(result.next()) {
//				String s = result.getString("name");
//				result.updateString("name", s + " oi");
//				result.updateRow();
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(stmt != null) {
				stmt.close();
			}
		}		
	}
}