package DataBase;

import com.Vtiger.genericUtility.DatabaseUtility;

public class databse {
	
	public static void main(String[] args) throws Throwable {
		DatabaseUtility dLib=new DatabaseUtility();
		dLib.connectionToDB();
		
		String query = "select * from studentInfo";
		String data = dLib.executeQueryandgetdata(query, 1, "sharaun");
		System.out.println(data);
		
		dLib.closeDB();
	}

}
