package jpa.service;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();

    public Student getStudentByEmail(String sEmail);

    public boolean validateStudent(String sEmail, String sPassword);

    public void registerStudentToCourse(String sEmail, int cId);

    public List<Course> getStudentCourses(String sEmail);
}
