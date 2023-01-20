package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQuery_Sample02 {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		int result=0;
		
		try {
		//Steps:1 Register to the database//
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//steps 2: connection to the database
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45","root","root");
		System.out.println("database is connected");
		
		//steps 3:create query statement//
		Statement state = con.createStatement();
	    String query = "insert into studentInfo values('Chethan','Rajajinagar','sql','4'),('Kushi','BTM','Manual','5')";
	    
	    //step 4:execute the query//
	  	result = state.executeUpdate(query);
	}catch(Exception e) {
		
	}finally {
		//handle exception
		if(result==2) {
			System.out.println("StudentInfo inserted succesfully");
		}else {
			System.out.println("StidentInfo is not inserted");
		}
		//steps 5: close the connection
		con.close();
		System.out.println("database is closed");
	}
 }
}
