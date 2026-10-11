package com.studentmanagament.client;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.studentmanagament.model.Marks;
import com.studentmanagament.model.Student;
import com.studentmanagament.service.StudentService;
import com.studentmanagament.service.StudentServiceImpl;

public class Test {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		StudentService service = new StudentServiceImpl();

		while (true) {

			System.out.println();
			System.out.println("========================================");
			System.out.println("     STUDENT RESULT MANAGEMENT SYSTEM");
			System.out.println("========================================");
			System.out.println("1. Add Student");
			System.out.println("2. View All Students");
			System.out.println("3. Search Student");
			System.out.println("4. Update Student");
			System.out.println("5. Delete Student");
			System.out.println("6. Add/Update Marks");
			System.out.println("7. Student Result");
			System.out.println("8. Find Topper");
			System.out.println("9. Sort Students");
			System.out.println("10. Exit");
			System.out.println("========================================");
			System.out.println("Enter Your Choice:");

			int choice = sc.nextInt();

			switch (choice) {

			// =========================================
			// 1. ADD STUDENT
			// =========================================

			case 1:

				System.out.println("Enter Student ID:");

				int id = sc.nextInt();

				// ID validation
				if (id <= 0) {

					System.out.println("Student ID should be greater than 0.");

					break;
				}

				// Duplicate ID validation
				Student existingStudent = service.findStudentById(id);

				if (existingStudent != null) {

					System.out.println("Student with ID " + id + " already exists.");

					break;
				}

				Student student = new Student();

				student.setRollno(id);

				System.out.println("Enter Student Name:");

				student.setName(sc.next());

				System.out.println("Enter Student Address:");

				student.setAddress(sc.next());

				service.addStudent(student);

				System.out.println("Student Added Successfully.");

				break;

			// =========================================
			// 2. VIEW ALL STUDENTS
			// =========================================

			case 2:

				List<Student> students = service.getAllStudents();

				if (students.isEmpty()) {

					System.out.println("No Student Found.");

				} else {

					System.out.println();
					System.out.println("========== ALL STUDENTS ==========");

					for (Student stu : students) {

						System.out.println("Student ID      : " + stu.getRollno());

						System.out.println("Student Name    : " + stu.getName());

						System.out.println("Student Address : " + stu.getAddress());

						if (stu.getMark() != null) {

							System.out.println("Percentage      : " + stu.getMark().calculatePercentage());
						}

						System.out.println("--------------------------------");
					}
				}

				break;

			// =========================================
			// 3. SEARCH STUDENT
			// =========================================

			case 3:

				System.out.println("Enter Student ID:");

				int searchId = sc.nextInt();

				if (searchId <= 0) {

					System.out.println("Student ID should be greater than 0.");

					break;
				}

				Student foundStudent = service.findStudentById(searchId);

				if (foundStudent != null) {

					System.out.println("========== STUDENT DETAILS ==========");

					System.out.println("Student ID      : " + foundStudent.getRollno());

					System.out.println("Student Name    : " + foundStudent.getName());

					System.out.println("Student Address : " + foundStudent.getAddress());

				} else {

					System.out.println("Student Not Found.");
				}

				break;

			// =========================================
			// 4. UPDATE STUDENT
			// =========================================

			case 4:

				System.out.println("Enter Student ID to Update:");

				int updateId = sc.nextInt();

				if (updateId <= 0) {

					System.out.println("Student ID should be greater than 0.");

					break;
				}

				Student oldStudent = service.findStudentById(updateId);

				if (oldStudent == null) {

					System.out.println("Student Not Found.");

					break;
				}

				Student updateStudent = new Student();

				updateStudent.setRollno(updateId);

				System.out.println("Enter New Name:");

				updateStudent.setName(sc.next());

				System.out.println("Enter New Address:");

				updateStudent.setAddress(sc.next());

				boolean updated = service.updateStudent(updateStudent);

				if (updated) {

					System.out.println("Student Updated Successfully.");

				} else {

					System.out.println("Student Update Failed.");
				}

				break;

			// =========================================
			// 5. DELETE STUDENT
			// =========================================

			case 5:

				System.out.println("Enter Student ID to Delete:");

				int deleteId = sc.nextInt();

				if (deleteId <= 0) {

					System.out.println("Student ID should be greater than 0.");

					break;
				}

				boolean deleted = service.deleteStudent(deleteId);

				if (deleted) {

					System.out.println("Student Deleted Successfully.");

				} else {

					System.out.println("Student Not Found.");
				}

				break;

			// =========================================
			// 6. ADD / UPDATE MARKS
			// =========================================

			case 6:

				System.out.println("Enter Student ID:");

				int marksId = sc.nextInt();

				if (marksId <= 0) {

					System.out.println("Student ID should be greater than 0.");

					break;
				}

				Student marksStudent = service.findStudentById(marksId);

				if (marksStudent == null) {

					System.out.println("Student Not Found.");

					break;
				}

				Marks marks = new Marks();

				System.out.println("Enter Java Marks:");

				float java = sc.nextFloat();

				if (java < 0 || java > 100) {

					System.out.println("Marks should be between 0 and 100.");

					break;
				}

				marks.setJavaMarks(java);

				System.out.println("Enter SQL Marks:");

				float sql = sc.nextFloat();

				if (sql < 0 || sql > 100) {

					System.out.println("Marks should be between 0 and 100.");

					break;
				}

				marks.setSqlMarks(sql);

				System.out.println("Enter Spring Marks:");

				float spring = sc.nextFloat();

				if (spring < 0 || spring > 100) {

					System.out.println("Marks should be between 0 and 100.");

					break;
				}

				marks.setSpringMarks(spring);

				System.out.println("Enter HTML Marks:");

				float html = sc.nextFloat();

				if (html < 0 || html > 100) {

					System.out.println("Marks should be between 0 and 100.");

					break;
				}

				marks.setHtmlMarks(html);

				System.out.println("Enter React Marks:");

				float react = sc.nextFloat();

				if (react < 0 || react > 100) {

					System.out.println("Marks should be between 0 and 100.");

					break;
				}

				marks.setReactMarks(react);

				marksStudent.setMark(marks);

				System.out.println("Marks Added/Updated Successfully.");

				break;

			// =========================================
			// 7. STUDENT RESULT
			// =========================================

			case 7:

				System.out.println("Enter Student ID:");

				int resultId = sc.nextInt();

				if (resultId <= 0) {

					System.out.println("Student ID should be greater than 0.");

					break;
				}

				String result = service.getStudentResult(resultId);

				System.out.println();
				System.out.println("========== STUDENT RESULT ==========");

				System.out.println(result);

				break;

			// =========================================
			// 8. FIND TOPPER
			// =========================================

			case 8:

				Student topper = service.findTopper();

				if (topper == null) {

					System.out.println("No Student Found.");

				} else {

					System.out.println();
					System.out.println("========== TOPPER ==========");

					System.out.println("Student ID   : " + topper.getRollno());

					System.out.println("Student Name : " + topper.getName());

					System.out.println("Percentage   : " + topper.getMark().calculatePercentage());

					System.out.println("Grade        : " + topper.getMark().calculateGrade());
				}

				break;

			// =========================================
			// 9. SORT STUDENTS
			// =========================================

			case 9:

				List<Student> sortList = service.getAllStudents();

				if (sortList.isEmpty()) {

					System.out.println("No Student Found.");

					break;
				}

				System.out.println("1. Sort By ID");

				System.out.println("2. Sort By Name");

				System.out.println("3. Sort By Percentage");

				System.out.println("Enter Sort Choice:");

				int sortChoice = sc.nextInt();

				if (sortChoice == 1) {

					sortList.sort(Comparator.comparing(Student::getRollno));

				} else if (sortChoice == 2) {

					sortList.sort(Comparator.comparing(Student::getName));

				} else if (sortChoice == 3) {

					sortList.sort(Comparator
							.comparingDouble(s -> s.getMark() == null ? 0 : s.getMark().calculatePercentage()));

				} else {

					System.out.println("Invalid Sort Choice.");

					break;
				}

				System.out.println();
				System.out.println("========== SORTED STUDENTS ==========");

				for (Student stu : sortList) {

					System.out.println("ID : " + stu.getRollno() + " | Name : " + stu.getName() + " | Percentage : "
							+ (stu.getMark() == null ? "N/A" : stu.getMark().calculatePercentage()));
				}

				break;

			// =========================================
			// 10. EXIT
			// =========================================

			case 10:

				System.out.println();
				System.out.println("========================================");

				System.out.println("Thank You!");

				System.out.println("Program Exited Successfully.");

				System.out.println("========================================");

				sc.close();

				return;

			default:

				System.out.println("Invalid Choice.");

				System.out.println("Please Enter Choice Between 1 and 10.");
			}
		}
	}
}