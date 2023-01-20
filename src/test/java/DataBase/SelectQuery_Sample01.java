package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQuery_Sample01 {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
		//Steps:1 Register to the database//
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//steps 2: connection to the database
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45","root","root");
		System.out.println("database is connected");
		
		//steps 3:create query statement//
		Statement state = con.createStatement();
		String query = "select * from studentInfo";
		
		//step 4:execute the query//
		ResultSet result = state.executeQuery(query);
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			//steps 5: close the connection
			con.close();
			System.out.println("database is closed");
			
		}
	

	}

}
