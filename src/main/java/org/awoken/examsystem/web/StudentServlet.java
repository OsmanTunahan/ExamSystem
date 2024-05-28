package org.awoken.examsystem.web;

import org.awoken.examsystem.dao.StudentDAOImpl;
import org.awoken.examsystem.model.Student;
import org.awoken.examsystem.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    private StudentService studentService;

    @Override
    public void init() throws ServletException {
        studentService = new StudentService(new StudentDAOImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = studentService.getAllStudents();
        request.setAttribute("students", students);
        request.getRequestDispatcher("/student/student.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            Student student = new Student();
            student.setName(request.getParameter("name"));
            student.setRollNo(request.getParameter("rollNo"));
            student.setSection(request.getParameter("section"));
            student.setBranch(request.getParameter("branch"));
            student.setYear(Integer.parseInt(request.getParameter("year")));
            studentService.addStudent(student);
        } else if ("update".equals(action)) {
            Student student = new Student();
            student.setId(Integer.parseInt(request.getParameter("id")));
            student.setName(request.getParameter("name"));
            student.setRollNo(request.getParameter("rollNo"));
            student.setSection(request.getParameter("section"));
            student.setBranch(request.getParameter("branch"));
            student.setYear(Integer.parseInt(request.getParameter("year")));
            studentService.updateStudent(student);
        } else if ("delete".equals(action)) {
            int studentId = Integer.parseInt(request.getParameter("id"));
            studentService.deleteStudent(studentId);
        }

        response.sendRedirect("student");
    }
}
