import java.sql.*;

class MysqlCon {
	public static void main(String args[]) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from city");

		while (rs.next())
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));

		con.close();

	}
}