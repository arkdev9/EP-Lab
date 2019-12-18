import java.sql.*;
import java.util.*;

class InsertPrepared {
	public static void main(String args[]) throws Exception {
		int eid = 0;
		String ename = new String();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Employee Id:");
		while (sc.hasNextInt())
			eid = sc.nextInt();
		System.out.println("Enter Employee Name:");
		ename = sc.next();
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "root");

		PreparedStatement stmt = con.prepareStatement("insert into emp values(?,?)");
		stmt.setInt(1, eid);// 1 specifies the first parameter in the query
		stmt.setString(2, ename);

		int i = stmt.executeUpdate();
		System.out.println(i + " records inserted");

		con.close();
		sc.close();
	}
}