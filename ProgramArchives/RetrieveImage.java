import java.sql.*;
import java.io.*;

public class RetrieveImage {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "root");

		PreparedStatement ps = con.prepareStatement("select * from flag");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {// now on 1st row

			Blob b = rs.getBlob(2);// 2 means 2nd column data
			byte barr[] = b.getBytes(1, (int) b.length());// 1 means first image

			FileOutputStream fout = new FileOutputStream("C:\\Users\\home\\Desktop\\Prof Anil Bantu\\ge1.png");
			fout.write(barr);

			fout.close();
		}
		System.out.println("ok");

		con.close();

	}
}