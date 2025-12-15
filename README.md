## Student Record Managment System (SRMS)

## Overview
A Java console-based system for managing university student records.
Supports adding, updating, deleting, searching, viewing students, and generating reports.
Includes auto-saving and background reporting using multithreading.

## Requirements
Java JDK 8 or higher
students.txt file (created automatically if missing)

## How to Compile
javac *.java
How to Run
java Main

## Sample Input
add S12345 Sara 3.8 CS 3
Sample Output
Student added successfully.

## Project Structure
StudentProject/
 ├── Main.java
 ├── Student.java
 ├── RegularStudent.java
 ├── HonorStudent.java
 ├── IStudentManager.java
 ├── StudentManager.java
 ├── AutoSaveThread.java
 ├── ReportThread.java
 └── students.txt

## Team Members
Haila Sul — GitHub management, README, Technical Report
Gadeer — CRUD operations, File Handling
Riman — UML diagram, System Design
Amani — Multithreading, Exception Handling

