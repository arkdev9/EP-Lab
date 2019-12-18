import java.sql.*;

class Record {
	public static void main(String args[]) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "root");

		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery("select * from emp");

		rs.absolute(2);
		System.out.println(rs.getString(1) + " " + rs.getString(2));

		con.close();
	}
}
