package com.studentmanagament.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.studentmanagament.model.Marks;
import com.studentmanagament.model.Student;

public class StudentServiceImpl implements StudentService {

	Scanner sc = new Scanner(System.in);

	List<Student> list = new ArrayList<Student>();

	@Override
	public void addStudent(Student student) {

		list.add(student);

	}

	@Override
	public List<Student> getAllStudents() {

		return list;
	}

	@Override
	public Student findStudentById(int studentId) {

		for (Student stu : list) {

			if (stu.getRollno() == studentId) {

				return stu;
			}
		}

		return null;
	}

	@Override
	public boolean updateStudent(Student student) {

		Student existingStudent = findStudentById(student.getRollno());

		if (existingStudent != null) {

			existingStudent.setName(student.getName());
			existingStudent.setAddress(student.getAddress());

			return true;
		}

		return false;
	}

	@Override
	public boolean deleteStudent(int studentId) {

		Student student = findStudentById(studentId);

		if (student != null) {

			list.remove(student);

			return true;
		}

		return false;
	}

	@Override
	public String getStudentResult(int studentId) {

		Student student = findStudentById(studentId);

		if (student == null) {

			return "Student Not Found";

		}

		if (student.getMark() == null) {

			return "Marks Not Available";

		}

		Marks marks = student.getMark();

		float total = marks.calculateTotal();
		float percentage = marks.calculatePercentage();
		
		String result;

		if (marks.isPassed()) {
			
			result = "Pass";
			
		} else {

			result = "Fail";
			
		}
		
		return "Student Name : " + student.getName()
		+ "\nTotal Marks : " + total
		+ "\nPercentage  : " + percentage
		+ "\nResult      : " + result
		+ "\nGrade       : " + marks.calculateGrade();

	}

	@Override
	public Student findTopper() {

		if (list.isEmpty()) {
			
			return null;
		}

		Student topper = null;
		
		float highestPercentage = -1;

		for (Student stu : list) {

			if (stu.getMark() != null) {

				float percentage = stu.getMark().calculatePercentage();

				if (percentage > highestPercentage) {

					highestPercentage = percentage;

					topper = stu;
				}
			}
		}

		return topper;

	}

	@Override
	public List<Student> findStudentsByName(String name) {

		List<Student> result = new ArrayList<Student>();

		for (Student stu : list) {

			if (stu.getName().equalsIgnoreCase(name)) {

				result.add(stu);
			}
		}

		return result;
	}

	@Override
	public List<Student> findStudentsAbovePercentage(double percentage) {

		List<Student> result = new ArrayList<Student>();

		for (Student stu : list) {

			if (stu.getMark() != null) {

				if (stu.getMark().calculatePercentage() > percentage) {

					result.add(stu);
				}
			}
		}

		return result;
	}

}
