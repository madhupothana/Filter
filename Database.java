package filterpack;

import java.sql.*;

public class Database {
	public boolean check(String name, String eno) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Class.forName("org.postgresql.Driver");
		conn = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training", "plf_training_admin",
				"pff123");
		PreparedStatement stat = conn.prepareStatement("select * from MadEmp where name=? and eno=?;");
		stat.setString(1, name);
		stat.setString(2, eno);
		ResultSet rs = stat.executeQuery();
		int n=0;
		while (rs.next()) {
			n=n+1;
		}
		if(n!=0) {
			return true;
		}
		else {
			return false;
		}
	}
}
