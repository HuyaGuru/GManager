package TheFiles;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnect {
	public static Connection getConnect() {

		Connection Con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "123");
		} catch (Exception e) {
			System.out.println("Something wrong at DataBaseConnect!! : ");
		}
		return Con;
	}
}
