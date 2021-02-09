package jpa.entitymodels;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "email")
	private String sEmail;

	@Column(name = "name")
	private String sName;

	@Column(name = "password")
	private String sPass;

	@OneToMany(targetEntity = Course.class)
	@OrderBy
	private List<Course> sCourses;

	public Student() {
		sCourses = new ArrayList<>();
	}

	public Student(String sEmail, String sName, String sPass, List<Course> sCourses) {
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPass = sPass;
		this.sCourses = sCourses;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsPass() {
		return sPass;
	}

	public void setsPass(String sPass) {
		this.sPass = sPass;
	}

	public List<Course> getsCourses() {
		return sCourses;
	}

	public void setsCourses(List<Course> sCourses) {
		this.sCourses = sCourses;
	}

	public void addCourses(Course course) {
		if (sCourses == null) {
			sCourses = new ArrayList<>();
		}
		sCourses.add(course);
	}
}
