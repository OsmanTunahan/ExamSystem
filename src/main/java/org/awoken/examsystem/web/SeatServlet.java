package org.awoken.examsystem.web;

import org.awoken.examsystem.dao.SeatDAOImpl;
import org.awoken.examsystem.model.Seat;
import org.awoken.examsystem.service.SeatService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/seat")
public class SeatServlet extends HttpServlet {
    private SeatService seatService;

    @Override
    public void init() throws ServletException {
        seatService = new SeatService(new SeatDAOImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Seat> seats = seatService.getAllSeats();
        request.setAttribute("seats", seats);
        request.getRequestDispatcher("/seat/seat.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("allocate".equals(action)) {
            Seat seat = new Seat();
            seat.setStudentId(Integer.parseInt(request.getParameter("studentId")));
            seat.setSeatNumber(request.getParameter("seatNumber"));
            seat.setExamHall(request.getParameter("examHall"));
            seatService.allocateSeat(seat);
        } else if ("update".equals(action)) {
            Seat seat = new Seat();
            seat.setId(Integer.parseInt(request.getParameter("id")));
            seat.setStudentId(Integer.parseInt(request.getParameter("studentId")));
            seat.setSeatNumber(request.getParameter("seatNumber"));
            seat.setExamHall(request.getParameter("examHall"));
            seatService.updateSeat(seat);
        } else if ("delete".equals(action)) {
            int seatId = Integer.parseInt(request.getParameter("id"));
            seatService.deleteSeat(seatId);
        }

        response.sendRedirect("seat");
    }
}