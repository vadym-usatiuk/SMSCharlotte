package jpa.dao;

import jpa.entitymodels.Course;
import org.eclipse.persistence.sessions.factories.SessionFactory;

import javax.persistence.*;
import java.util.List;

public class CourseDAOInterface implements CourseDAO {

	@PersistenceContext
	private SessionFactory sessionFactory;

	@Override
	public List<Course> getAllCourses() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SMSCharlotte");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT c FROM Course c");
		@SuppressWarnings("unchecked")
		List<Course> courseList = query.getResultList();
		return courseList;
	}
}
