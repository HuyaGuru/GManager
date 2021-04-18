package TheFiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin {
	public static boolean Authenticate(String password) {
		boolean check = false;
		try {
			Connection con = DataBaseConnect.getConnect();
			PreparedStatement stmt = con.prepareStatement("select * from ADMIN where PASSWORD = '"+password+"'",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet result = stmt.executeQuery();
			check = result.first();
		}catch(Exception e) {
			System.out.println("Something wrong at Admin.Authenticate!! : " + e);
		}
		return check;
	}
	public static int Update(String oldpassword,String newpassword) {
		int check = 0 ;
		try {
			Connection con = DataBaseConnect.getConnect();
			PreparedStatement stmt = con.prepareStatement("update ADMIN set PASSWORD = ? where PASSWORD = ?");
			stmt.setString(1, newpassword);
			stmt.setString(2, oldpassword);
			check = stmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("Something wrong at Admin.Update!! : " + e);
		}
		return check;
	}
}
