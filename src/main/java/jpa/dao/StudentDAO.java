package jpa.dao;

import java.util.List;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public interface StudentDAO {
	// interface methods to be used in StudentService
		public List<Student> getAllStudents();

		public Student getStudentByEmail(String sEmail);

		public boolean validateStudent(String sEmail, String sPassword);

		public void registerStudentToCourse(String sEmail, int cId);

		public List<Course> getStudentCourses(String sEmail);
}
