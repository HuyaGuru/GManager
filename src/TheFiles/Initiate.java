package TheFiles;

import java.sql.Connection;
import java.sql.Statement;

public class Initiate {
	public static void Reset() {
		try {
			Connection con = DataBaseConnect.getConnect();
			Statement stmt = con.createStatement();
			// Check
			try {
				stmt.execute("drop table DEPARTMENT cascade constraints");
				stmt.execute("drop table FACULTY cascade constraints");
				stmt.execute("drop table COURSE cascade constraints");
				stmt.execute("drop table STUDENT cascade constraints");
				stmt.execute("drop table SEMESTER cascade constraints");
			} catch (Exception e) {
				System.out.println("Something wrong at Dropper!! : " + e);
			}

			// Create the tables
			stmt.execute(
					"create table DEPARTMENT(ID varchar2(25), NAME varchar2(50) unique, DEPT_HEAD varchar2(50), CONTACT_NO varchar2(50), constraint pk primary key (ID))");
			stmt.execute(
					"create table FACULTY(ID varchar2(25), NAME varchar2(50), DEPARTMENT varchar2(50), DESIGNATION varchar2(50), TEACHING varchar2(50), CONTACT varchar2(50), primary key (ID), constraint ForeignKey_Faculty foreign key (DEPARTMENT) references DEPARTMENT(NAME) on delete cascade)");
			stmt.execute(
					"create table COURSE(ID varchar2(25), NAME varchar2(50) unique, DEPARTMENT varchar2(50) not null, primary key (ID), constraint ForeignKey_Course foreign key (DEPARTMENT) references DEPARTMENT(NAME) on delete cascade)");
			stmt.execute(
					"create table STUDENT(ID varchar2(25), NAME varchar2(50) not null, COURSE varchar2(50), TOTAL_FEE varchar2(25), FEE_PENDING varchar2(25), CONTACT varchar2(50), primary key (ID), constraint ForeignKey_StudentCourse foreign key (COURSE) references COURSE(NAME) on delete cascade)");
			stmt.execute("create table SEMESTER(ID varchar2(25) not null, SEMESTER varchar2(10) not null, COURSE varchar2(50), STATUS varchar2(10) not null, primary key (ID,SEMESTER) , constraint fk_fromStudent foreign key (ID) references STUDENT(ID) on delete cascade, constraint fk_fromcourse foreign key (COURSE) references COURSE(NAME) on delete cascade)");
			// Insert the data

			stmt.execute("insert into DEPARTMENT values('1','BCA','ARVIND KUMAR PANDEY','9999999999')");
			stmt.execute("insert into DEPARTMENT values('2','BBA','BBA DEPT HEAD','9999888888')");
			stmt.execute("insert into DEPARTMENT values('3','BTC','BTC DEPT HEAD','9999777777')");
			stmt.execute("insert into DEPARTMENT values('4','B.Ed','B.Ed DEPT HEAD','9999555555')");
			stmt.execute("insert into DEPARTMENT values('5','LAW','LAW DEPT HEAD','9999444444')");
			stmt.execute("insert into DEPARTMENT values('6','B.COM','B.COM DEPT HEAD','9999333333')");

			stmt.execute("insert into FACULTY values ('1','TEACHER','BBA','LECTURER','MATHS','9999999999')");
			stmt.execute("insert into FACULTY values ('2','LECTURER','BBA','ASST. LECTURER','ECONOMICS','9999888888')");
			stmt.execute("insert into FACULTY values ('3','EDUCATOR','BBA','ASST. LECTURER','TAX','9999777777')");
			stmt.execute("insert into FACULTY values ('4','TUTOR','BBA','LECTURER','ETHICS','9999666666')");
			stmt.execute("insert into FACULTY values ('5','PROFESSOR','BBA','LECTURER','SOCIOLOGY','9999555555')");
			stmt.execute(
					"insert into FACULTY values ('6','EDUCATIONIST','BCA','LECTURER','PROGRAMMING','7007007007')");
			stmt.execute("insert into FACULTY values ('7','EDUCATIONALIST','BCA','LECTURER','SQL','9090909090')");
			stmt.execute(
					"insert into FACULTY values ('8','PRECEPTOR','BCA','ASST. LECTURER','NETWORK','9018476235')");
			stmt.execute("insert into FACULTY values ('9','PEDAGOGUE','BCA','ASST. LECTURER','MATHS','9567820762')");
			stmt.execute("insert into FACULTY values ('10','MENTOR','BCA','ASST. LECTURER','SECURITY','0120675374')");

			stmt.execute("insert into COURSE values('1','BCA','BCA')");
			stmt.execute("insert into COURSE values('2','BBA','BBA')");
			stmt.execute("insert into COURSE values('3','BTC','BTC')");
			stmt.execute("insert into COURSE values('4','B.Ed','B.Ed')");
			stmt.execute("insert into COURSE values('5','LAW','LAW')");
			stmt.execute("insert into COURSE values('6','B.COM','B.COM')");

			stmt.execute("insert into STUDENT values('180995106002','ABHISHEK SHANDILYA','BCA','200000','0','9999999999' )");
			stmt.execute("insert into STUDENT values('180995106029','VISHAL SHANDILYA','BCA','200000','0','7007007007' )");
			stmt.execute("insert into STUDENT values('180995106001','ASHISH PAL','BCA','200000','18750','9999988888' )");
			stmt.execute("insert into STUDENT values('180995106003','DEEPAK','BCA','200000','870','9999977777' )");
			stmt.execute("insert into STUDENT values('180995106004','AMAN','BCA','200000','300000','9999991111' )");
			stmt.execute("insert into STUDENT values('180995106005','SANDEEP','BCA','200000','76289','9997099999' )");
			stmt.execute("insert into STUDENT values('180995106006','AMIT','BCA','200000','0','9999999999' )");
			stmt.execute("insert into STUDENT values('180995106007','PUNYA GAUTAM','BCA','200000','20','9999666666' )");
			stmt.execute("insert into STUDENT values('180995106008','AAKASH KUMAR','BCA','200000','0','9999777777' )");
			stmt.execute("insert into STUDENT values('180995106033','STUDENT','BCA','265000','2356','9999777877' )");
			stmt.execute("insert into STUDENT values('180995106028','SARUN VERMA','BCA','200000','50000','9999988888' )");
			
			
			stmt.execute("insert into SEMESTER values('180995106029','1','BCA','PASS')");
			stmt.execute("insert into SEMESTER values('180995106029','2','BCA','PASS')");
			stmt.execute("insert into SEMESTER values('180995106029','3','BCA','PASS')");
			stmt.execute("insert into SEMESTER values('180995106029','4','BCA','PASS')");
			stmt.execute("insert into SEMESTER values('180995106029','5','BCA','PASS')");
			stmt.execute("insert into SEMESTER values('180995106028','1','BCA','PASS')");
			stmt.execute("insert into SEMESTER values('180995106028','2','BCA','PASS')");
			stmt.execute("insert into SEMESTER values('180995106028','3','BCA','PASS')");
			stmt.execute("insert into SEMESTER values('180995106028','4','BCA','PASS')");
			stmt.execute("insert into SEMESTER values('180995106028','5','BCA','PASS')");
			stmt.execute("insert into SEMESTER values('180995106002','1','BCA','PASS')");
			stmt.execute("insert into SEMESTER values('180995106002','2','BCA','PASS')");
			stmt.execute("insert into SEMESTER values('180995106002','3','BCA','PASS')");
			stmt.execute("insert into SEMESTER values('180995106002','4','BCA','PASS')");
			stmt.execute("insert into SEMESTER values('180995106002','5','BCA','PASS')");
			stmt.execute("insert into SEMESTER values('180995106007','1','BCA','PASS')");
			stmt.execute("insert into SEMESTER values('180995106007','2','BCA','PASS')");
			stmt.execute("insert into SEMESTER values('180995106007','3','BCA','BACK')");
			stmt.execute("insert into SEMESTER values('180995106007','4','BCA',' SEM BACK')");
			stmt.execute("insert into SEMESTER values('180995106007','5','BCA','PASS')");
			stmt.execute("insert into SEMESTER values('180995106033','1','BCA','PASS')");
			stmt.execute("insert into SEMESTER values('180995106033','2','BCA','BACK')");
			stmt.execute("insert into SEMESTER values('180995106033','3','BCA','PASS')");
			stmt.execute("insert into SEMESTER values('180995106033','4','BCA','BACK')");
			stmt.execute("insert into SEMESTER values('180995106033','5','BCA','PASS')");
			
			System.out.println("DataBase Reset and Ready.");

		} catch (Exception e) {
			System.out.println("Something wrong at Initiate.Reset!! : " + e);
		}
	}

	public static void Admin() {
		try {
			Connection con = DataBaseConnect.getConnect();
			Statement stmt = con.createStatement();
			// Dropper
			try {
				stmt.execute("drop table ADMIN cascade constraints");
			} catch (Exception e) {
				System.out.println("Something wrong at Admin.Dropper!! : " + e);
			}
			// Creator
			stmt.execute("create table ADMIN(password varchar2(50) not null)");
			// Insertion
			stmt.execute("insert into ADMIN values('password')");

			
			System.out.println("Admin Password set.");
			
		} catch (Exception e) {
			System.out.println("Something wrong at Initiate.Admin!! : " + e);
		}
	}

}
