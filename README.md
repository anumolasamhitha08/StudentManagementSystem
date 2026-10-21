# Student Management System

## Description
A menu-driven Java application for enrolling students, updating grades, searching records, and generating reports. Student records are stored in a data file so they can be loaded again when the application restarts.

## Features
- Enrol students with unique IDs.
- Add or update grades from 0 to 100.
- Search for students by ID.
- Generate a report of all students.
- Read records from and write records to `students.txt`.
- Save data when records change and when the application exits.

## Class Hierarchy

The application uses an interface-based design.

- **StudentOperations (interface):** Defines the required student-management operations.
- **StudentManager (implements StudentOperations):** Implements enrolment, grading, searching, reporting, and file storage.
- **Student:** Represents an individual student and stores their ID, name, course, and grade.
- **Main:** Displays the menu, accepts user input, and calls StudentManager methods.

`StudentManager` implements the `StudentOperations` interface. `Main` uses `StudentManager`, and `StudentManager` stores `Student` objects in a map keyed by student ID.

## Technologies
- Java
- Object-Oriented Programming
- Interfaces
- LinkedHashMap
- File I/O
- Exception Handling

## Files
- `Student.java`
- `StudentOperations.java`
- `StudentManager.java`
- `Main.java`

## How to Run
Install the Java JDK and place all four Java files in the same folder.

Compile:

`javac Student.java StudentOperations.java StudentManager.java Main.java`

Run:

`java Main`

The application creates `students.txt` when it first saves data. Keep this file in the same working directory when restarting the application to load previously saved records.

## Data Format
Each line in `students.txt` contains:

`studentId,name,course,grade`

A grade of `-1` indicates that the student has not yet been graded. Avoid commas in student names and course names because commas separate the fields.
