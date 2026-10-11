# Student Result Management System

## Project Overview
The Student Result Management System is a console-based Java application used to manage student information, maintain subject-wise marks, calculate percentages and grades, and generate student results. It also supports searching, updating, deleting, sorting, and identifying the topper.

## Technologies Used
- Core Java
- Object-Oriented Programming (OOP)
- Encapsulation
- Abstraction and Interfaces
- Collections Framework
- ArrayList
- Comparator and Lambda Expressions
- Exception Handling

## Project Structure
```text
Student-Result-Management-System/
└── src/
    └── com/
        └── studentmanagament/
            ├── client/
            │   └── Test.java
            ├── model/
            │   ├── Student.java
            │   └── Marks.java
            └── service/
                ├── StudentService.java
                └── StudentServiceImpl.java
```

## Features
1. Add student details with unique roll numbers.
2. View all registered students.
3. Search students by ID.
4. Update student name and address.
5. Delete student records.
6. Add or update subject-wise marks.
7. Calculate total marks and percentage.
8. Generate pass/fail results and grades.
9. Find the class topper.
10. Sort students by ID, name, or percentage.

## Student Information
- Roll Number
- Name
- Address

## Subjects
- Java
- SQL
- Spring
- HTML
- React

Each subject is scored out of 100, giving a maximum total of 500 marks.

## Grading System
| Percentage | Grade |
|---|---|
| 90–100% | A+ |
| 80–less than 90% | A |
| 70–less than 80% | B |
| 60–less than 70% | C |
| 50–less than 60% | D |
| Below 50% | E |
| Any subject below 40 marks | Fail |

## How to Run
1. Install the Java Development Kit (JDK).
2. Open the project in Eclipse, IntelliJ IDEA, or VS Code.
3. Ensure all classes are in their correct packages.
4. Run `Test.java` from the `com.studentmanagament.client` package.
5. Select an operation from the console menu.

## Data Storage
The application uses `ArrayList` to store student records in memory. Data is not permanently stored and will be lost when the application terminates.

## Learning Outcomes
- Implementing OOP concepts in Java.
- Using interfaces and service implementation classes.
- Performing CRUD operations on collections.
- Calculating marks, percentages, and grades.
- Sorting and searching student records.
- Applying validation to student IDs and subject marks.

## Future Enhancements
- Integrate MySQL for permanent data storage.
- Add student reports and result cards.
- Export results to PDF.
- Improve input validation and exception handling.
- Add a graphical user interface.

## Author
Java Developer Fresher
