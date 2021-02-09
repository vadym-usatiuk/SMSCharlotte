package jpa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

class StudentServiceInterfaceTest {

	private static Connection connect;
	private static ResultSet resSet;
	private static ResultSet secondResSet;
	private static ResultSet thirdResSet;
	private static Student expected;
	private static StudentServiceInterface test;
	private static PreparedStatement prepared;
	private static PreparedStatement secondPrepared;
	private static PreparedStatement thirdPrepared;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		DatabaseConnection dbConn = new DatabaseConnection();
		try {
			connect = dbConn.getConnection();
		} catch (Exception e) {
			System.out.println("Unable to connect to Database");
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		if (connect != null) {
			connect.close();
		}
	}

	@BeforeEach
	void setUp() throws Exception {
		List<Course> list = new ArrayList<Course>();
		prepared = connect.prepareStatement("Select * From student where email = ?");
		secondPrepared = connect.prepareStatement("Select * From student_course where Student_email = ?");
		thirdPrepared = connect.prepareStatement("Select * From course where id = ?");
		prepared.setString(1, "hluckham0@google.ru");
		secondPrepared.setString(1, "hluckham0@google.ru");
		resSet = prepared.executeQuery();
		resSet.next();
		secondResSet = secondPrepared.executeQuery();

		while (secondResSet.next()) {
			int id = secondResSet.getInt(2);
			thirdPrepared.setInt(1, id);
			thirdResSet = thirdPrepared.executeQuery();
			thirdResSet.next();
			Course course = new Course(thirdResSet.getInt(1), thirdResSet.getString(2), thirdResSet.getString(3));
			list.add(course);
		}

		expected = new Student();
		expected.setsEmail(resSet.getString(1));
		expected.setsName(resSet.getString(2));
		expected.setsPass(resSet.getString(3));
		expected.setsCourses(list);	
	}

	@AfterEach
	void tearDown() throws Exception {
		if (resSet != null) {
			resSet.close();
		}
		if (prepared != null) {
			prepared.close();
		}
	}

	@Test
	void testGetStudentByEmailOne() {
		test = new StudentServiceInterface();
		Student stud = test.getStudentByEmail("hluckham0@google.ru");
		assertThat(stud, sameBeanAs(expected));
	}
}
