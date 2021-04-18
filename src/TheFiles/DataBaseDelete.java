package TheFiles;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DataBaseDelete {
	static public int Delete(String Table_Name, String ID) {
		Connection Con;
		int status = 0;
		try {
			Con = DataBaseConnect.getConnect();
			PreparedStatement DelQuery = Con.prepareStatement("delete from " + Table_Name + " where ID = ? ");
			DelQuery.setString(1, ID);
			status = DelQuery.executeUpdate();
			return status;
		} catch (Exception e) {
			System.out.println("Something wrong at DataBaseDelete!! : " + e);
		}
		return status;
	}

}
