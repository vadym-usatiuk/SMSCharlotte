package jpa.mainrunner;

import java.util.List;
import java.util.Scanner;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseServiceInterface;
import jpa.service.StudentServiceInterface;

public class SMSRunner {
	// Create two static object for StudentService and CourseService to use  methods easier
		static StudentServiceInterface s = new StudentServiceInterface();
		static CourseServiceInterface c = new CourseServiceInterface();

		public static void main(String[] args) {
			
			// open scanner for userinput
			Scanner input = new Scanner(System.in);
			int userInput;
			// infinite loop for system
			while (true) {
				// user selection from menu
				System.out.println("Select From List:\n1.Show Students List\n2.Show Courses List\n3.Student Login\n4.Quit \n");
				System.out.println();
				// save user selection
				userInput = input.nextInt();
				// switch case for user input
				switch (userInput) {
				// get all students
				case 1:
					List<Student> stuList = s.getAllStudents();
					// print on console all students
					System.out.println("All Students:");
					System.out.printf("%-35s|%-25s \n", "Email", "Name");
					System.out.println();
					for (Student x : stuList) {
						System.out.printf("%-35s|%-25s \n", x.getsEmail(), x.getsName());

					}
					System.out.println();
					break;
				case 2:
					// get all courses
					List<Course> AllCourses = c.getAllCourses();
					System.out.println("All Courses:");
					// print on console
					System.out.printf("%-3s|%-35s|%-35s \n", "#", "Instructor Name", "Course Name");
					System.out.println();
					for (Course x : AllCourses) {

						System.out.printf("%-3s|%-35s|%-35s \n", x.getcId(), x.getcInstructorName(), x.getcName());

					}
					System.out.println();
					break;

				case 3:
					// login user and pass
					System.out.println("Enter your email:");
					String sEmail = input.next();
					System.out.println("Enter your password:");
					String sPass = input.next();
					// if user and pass are right then go to next screen
					if (s.validateStudent(sEmail, sPass)) {
						// selection screen
						System.out.println("1.Register to class\n2.Logout");
						userInput = input.nextInt();
						switch (userInput) {

						case 1:
							// print all courses
							System.out.println("All Courses:");
							List<Course> stuCourses = c.getAllCourses();
							System.out.printf("%-3s|%-35s|%-35s \n", "#", "Instructor Name", "Course Name");
							for (Course x : stuCourses) {

								System.out.printf("%-3s|%-35s|%-35s \n", x.getcId(), x.getcInstructorName(), x.getcName());

							}
							// print current courses of student
							String[] e = sEmail.split("@");
							System.out.println("Student " + e[0] + " Courses");
							List<Course> stuCourses2 = s.getStudentCourses(sEmail);

							for (Course x : stuCourses2) {

								System.out.printf("%-3s|%-35s|%-35s \n", x.getcId(), x.getcInstructorName(), x.getcName());

							}
							// select new course to register
							System.out.println("Select Course ID to register:");
							userInput = input.nextInt();
							// use method
							s.registerStudentToCourse(sEmail, userInput);
							// split user email by @
							String[] user = sEmail.split("@");
							System.out.println("Student " + user[0] + " Courses");
							// print new list of course for user
							List<Course> stuCourses3 = s.getStudentCourses(sEmail);

							for (Course x : stuCourses3) {

								System.out.printf("%-3s|%-35s|%-35s \n", x.getcId(), x.getcInstructorName(), x.getcName());

							}

							System.out.println("Course Add!");
							break;
						case 2:
							// logout
							System.out.println("You have been signed out.");
							input.close();
							System.exit(1);
						}
					} else {
						// case of wrong info in login
						System.out.println("Wrong credentials! Logout");
						input.close();
						System.exit(1);
					}

				case 4:
					// logout
					System.out.println("You have been signed out.");
					input.close();
					System.exit(1);
				}

			}
		}// main
}