package org.awoken.examsystem.web;

import org.awoken.examsystem.dao.AdminDAOImpl;
import org.awoken.examsystem.model.Admin;
import org.awoken.examsystem.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private AdminService adminService;

    @Override
    public void init() throws ServletException {
        adminService = new AdminService(new AdminDAOImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Admin admin = adminService.getAdminByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            request.getSession().setAttribute("admin", admin);
            response.sendRedirect("seat");
        } else {
            response.sendRedirect("admin");
        }
    }
}
