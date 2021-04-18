package TheFiles;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DataBaseInsert {
	public static int Dept(String Id, String NAME, String DEPT_HEAD, String CONTACT_NUMBER) {

		int status = 0;
		try {
			Connection Con = DataBaseConnect.getConnect();
			PreparedStatement DepIns = Con.prepareStatement("insert into DEPARTMENT values(?, ?, ?, ?)");
			DepIns.setString(1, Id);
			DepIns.setString(2, NAME);
			DepIns.setString(3, DEPT_HEAD);
			DepIns.setString(5, CONTACT_NUMBER);
			status = DepIns.executeUpdate();
			Con.close();
		} catch (Exception ex) {
			System.out.println("Something wrong at DataBaseInsert.Dept!! : " + ex);
		}
		return status;

	}

	public static int Student(String ID, String NAME, String COURSE, String Total_Fees, String Fees_Pending, String CONTACT) {
		int status = 0;
		try {
			Connection Con = DataBaseConnect.getConnect();
			PreparedStatement StuIns = Con.prepareStatement("insert into STUDENT values(?, ?, ?, ?, ?, ?, ?, ?)");
			StuIns.setString(1, ID);
			StuIns.setString(2, NAME);
			StuIns.setString(3, COURSE);
			StuIns.setString(4, Total_Fees);
			StuIns.setString(5, Fees_Pending);
			StuIns.setString(6, CONTACT);
			status = StuIns.executeUpdate();
			Con.close();

		} catch (Exception ex) {
			System.out.println("Something wrong at DataBaseInsert.Student!! : " + ex);
		}
		return status;

	}

	public static int Faculty(String ID, String NAME, String DEPT, String DESIGNATION, String TEACHING, String CONTACT) {
		int status = 0;
		try {
			Connection Con = DataBaseConnect.getConnect();
			PreparedStatement FacIns = Con.prepareStatement("insert into FACULTY values (?, ?, ?, ?, ?, ?)");
			FacIns.setString(1, ID);
			FacIns.setString(2, NAME);
			FacIns.setString(3, DEPT);
			FacIns.setString(4, DESIGNATION);
			FacIns.setString(5, TEACHING);
			FacIns.setString(6, CONTACT);
			status = FacIns.executeUpdate();
			Con.close();

		} catch (Exception ex) {
			System.out.println("Something wrong at DataBaseInsert.Faculty!! : " + ex);
		}
		return status;

	}

	public static int Course(String Id, String Name, String Dept) {
		int status = 0;
		try {
			Connection Con = DataBaseConnect.getConnect();
			PreparedStatement CouIns = Con.prepareStatement("insert into COURSE values(?, ?, ?)");
			CouIns.setString(1, Id);
			CouIns.setString(2, Name);
			CouIns.setString(3, Dept);
			status = CouIns.executeUpdate();
			Con.close();

		} catch (Exception ex) {
			System.out.println("Something wrong at DataBaseInsert.Course!! : " + ex);
		}
		return status;

	}
	
	public static int Semester(String Id, String Semester, String Course ,String Status) {
		int status = 0;
		try {
			Connection Con = DataBaseConnect.getConnect();
			PreparedStatement SemIns = Con.prepareStatement("insert into SEMESTER values(?, ?, ?, ?)");
			SemIns.setString(1, Id);
			SemIns.setString(2, Semester);
			SemIns.setString(3, Course);
			SemIns.setString(4, Status);
			status = SemIns.executeUpdate();
			Con.close();

		} catch (Exception ex) {
			System.out.println("Something wrong at DataBaseInsert.Course!! : " + ex);
		}
		return status;

	}

}
