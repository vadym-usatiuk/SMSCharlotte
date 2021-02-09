package jpa.service;

import jpa.entitymodels.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
}
