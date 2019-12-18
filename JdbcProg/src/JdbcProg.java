import java.sql.*;
import java.util.Scanner;

class FeetFirst {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test";
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection conn = DriverManager.getConnection(url, "testUser", "testPassword");
        Scanner sc = new Scanner(System.in);

       String choice;
       PreparedStatement addStudentStatement = conn.prepareStatement("insert into organisers values (?, ?, ?)");
       do {
           System.out.println("Enter roll number");
           String rollNumber = sc.nextLine();
           System.out.println("Enter name");
           String name = sc.nextLine();
           System.out.println("Enter batch");
           Integer batch = sc.nextInt();
           sc.nextLine();

           addStudentStatement.setInt(3, batch);
           addStudentStatement.setString(2, name);
           addStudentStatement.setString(1, rollNumber);
           int i = addStudentStatement.executeUpdate();

           System.out.println("Added " + i + " records");
           System.out.println("Do you want to continue?");
           choice = sc.nextLine();
       } while (choice.equals("yes"));

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from organisers");

        System.out.println("Roll Number\tName\t\tBatch");
        while(rs.next()) {
            System.out.println(rs.getString(1) + "\t" +  rs.getString(2) + "\t\t" + rs.getInt(3));
        }

        conn.close();
        sc.close();
        System.out.println("Got it!");
    }
}