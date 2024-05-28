# Exam System
A web application designed to manage student details such as name, roll number, section, branch, and year, and automate seat allocation for exams.
<hr>

## Database Schema
```sql
CREATE DATABASE exam_system;
USE exam_system

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    rollNo VARCHAR(20) NOT NULL UNIQUE,
    section VARCHAR(20) NOT NULL,
    branch VARCHAR(50) NOT NULL,
    year INT NOT NULL
);

CREATE TABLE admins (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE seats (
    id INT AUTO_INCREMENT PRIMARY KEY,
    studentId INT,
    seatNumber VARCHAR(20) NOT NULL,
    examHall VARCHAR(50) NOT NULL,
    FOREIGN KEY (studentId) REFERENCES students(id) ON DELETE CASCADE
);
```
<hr>

## Installation
To start the project, follow these steps:

1. **Set up the Environment**:
    - Make sure you have Apache Tomcat server installed on your machine.
    - Ensure you have MySQL server installed and running, and create a database named `exam_system`.
    - Configure the MySQL connection details in the `DBConnection.java` file if necessary.
<br><br>
2. **Import the Project**:
    - Import the project into your preferred IDE (like IntelliJ IDEA, Eclipse, etc.) as a Maven project.


3. **Build the Project**:
    - Let Maven download dependencies and build the project. You can do this by running `mvn clean install` command from the terminal in your project directory.


4. **Deploy to Tomcat**:
    - After building the project successfully, you'll find a `.war` file in the `target` directory of your project. This is the deployable file.
    - Copy this `.war` file to the `webapps` directory of your Tomcat installation.
    - Start or restart the Tomcat server.


5. **Access the Application**:
    - Once Tomcat has started successfully, open a web browser and navigate to `http://localhost:8080/ExamSystem` (replace `8080` with the port where your Tomcat is running if it's different).
    - You should see the index page of the application.


6. **Interact with the Application**:
    - You can navigate through the application by clicking on the links and filling out forms provided on the pages (like adding students, allocating seats, etc.).
    - Ensure MySQL is running and properly configured, as the application relies on it to store data.

<hr>


## Conclusion
This completes the code and structure for an Exam Seating Arrangement System. The system adheres to SOLID principles, separating concerns into different classes and layers (DAOs, Services, Models, and Servlets). The JSP pages provide the user interface for interacting with the application. This setup ensures maintainability, scalability, and testability of the code.

Deploy the project on an Apache Tomcat server and ensure the MySQL server is up and running with the correct database configuration as provided in the DBConnection.java utility class.

## Contributors
- [OsmanTunahan](https://www.linkedin.com/in/osmantunahan) - Developer