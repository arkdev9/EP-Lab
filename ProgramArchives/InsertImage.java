import java.sql.*;
import java.io.*;
import java.util.*;

public class InsertImage {
	public static void main(String[] args) throws Exception {
		String cname = new String();
		String path = new String();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Country Name:");
		cname = sc.next();

		System.out.println("Enter path:");
		path = sc.next();

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "root");

		PreparedStatement ps = con.prepareStatement("insert into Flag values(?,?)");
		ps.setString(1, cname);

		FileInputStream fin = new FileInputStream(path);
		ps.setBinaryStream(2, fin, fin.available());
		int i = ps.executeUpdate();
		System.out.println(i + " records affected");

		con.close();
		sc.close();
	}
}