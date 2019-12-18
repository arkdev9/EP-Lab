import java.sql.*;
import java.util.*;

class InsertPreparedN {
	public static void main(String args[]) throws Exception {
		int eid = 0;
		String ename = new String();
		Scanner sc = new Scanner(System.in);
		do {
			while (sc.hasNextInt()) {
				System.out.println("Enter Employee Id:");
				eid = sc.nextInt();
				System.out.println("Enter Employee Name:");
				ename = sc.next();
			}
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "root");
			PreparedStatement stmt = con.prepareStatement("insert into emp values(?,?)");

			stmt.setInt(1, eid);
			stmt.setString(2, ename);

			int i = stmt.executeUpdate();
			System.out.println(i + " records inserted");

			System.out.println("Do you want to continue: y/n");
			String s = sc.next();
			if (s.startsWith("n")) {
				con.close();
				sc.close();
				break;
			}
		} while (true);
	}
}