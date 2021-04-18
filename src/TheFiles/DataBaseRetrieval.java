package TheFiles;

import java.sql.Connection;
import javax.swing.JPanel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class DataBaseRetrieval {
	public static JPanel Retrieve(String Col_Name, String Table_Name, String Search_Col, String Search_Cond) {
		ResultSet Result = null;
		String column[] = null;
		String data[][] = null;
		int i = 0, cols = 0;
		try {
			Connection Con = DataBaseConnect.getConnect();
			String txt ;
			if((Search_Col=="*") || (  Search_Cond=="*")) {
				txt = "select "+Col_Name+" from "+Table_Name;
			}else {
				txt = "select "+ Col_Name +" from "+Table_Name+" where "+Search_Col+" = '"+Search_Cond+"'";
			}
			//System.out.println(txt+" "+Search_Col+" "+Search_Cond);
			PreparedStatement RetQuery = Con.prepareStatement(
					txt, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			Result = null;
			Result = RetQuery.executeQuery();
			// Collection Column Names
			ResultSetMetaData rsmd = Result.getMetaData();
			cols = rsmd.getColumnCount();
			column = new String[cols];
			for (i = 1; i <= cols; i++) {
				column[i - 1] = rsmd.getColumnName(i);
			}
			// Inserting Data into table
			Result.last();
			int rows = Result.getRow();
			Result.beforeFirst();

			data = new String[rows][cols];
			int count = 0;
			while (Result.next()) {
				for (i = 1; i <= cols; i++) {
					data[count][i - 1] = Result.getString(i);
				}
				count++;
			}

		} catch (Exception ex) {
			System.out.println("Something wrong at DataBaseRetrieval!! : " + ex);

		}
		// Getting a panel with the data
		JPanel table = Methods.createtable(data, column);

		return table;

	}

}
