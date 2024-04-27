package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JDBC {
		public static void main (String[] args) throws SQLException {
			String url = "jdbc:mysql://localhost:3306/University?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String uname = "root";
			String password = "1234567";
			String query = "Select * from EngineeringStudents where Department = 'ECE';";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				Connection con = DriverManager.getConnection(url, uname, password);
				Statement statement = con.createStatement();
				ResultSet result = statement.executeQuery(query);
				
				while (result.next()) {
					String UniversityData = "";
					for (int i = 1; i <= 6; i++) {
						UniversityData += result.getString(i)+ ";";
					}
					System.out.println(UniversityData);
				}
				
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
}
