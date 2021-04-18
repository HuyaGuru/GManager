package TheFiles;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DataBaseUpdate {
	static public int update(String Table_Name, String ID, String Col_Name, String New_Data) {
		Connection Con;
		int status = 0;
		try {
			Con = DataBaseConnect.getConnect();
			PreparedStatement updQuery = Con
					.prepareStatement("update " + Table_Name + " set " + Col_Name + " = ? where ID = ?");
			updQuery.setString(1, New_Data);
			updQuery.setString(2, ID);
			status = updQuery.executeUpdate();
			Con.close();
		} catch (Exception e) {
			System.out.println("Something wrong at DataBaseUpdate!! : " + e);
		}
		return status;

	}

}
