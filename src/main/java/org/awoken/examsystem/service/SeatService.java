package org.awoken.examsystem.service;

import org.awoken.examsystem.dao.SeatDAO;
import org.awoken.examsystem.model.Seat;
import java.util.List;

public class SeatService {
    private final SeatDAO seatDAO;

    public SeatService(SeatDAO seatDAO) {
        this.seatDAO = seatDAO;
    }

    public void allocateSeat(Seat seat) {
        seatDAO.allocateSeat(seat);
    }

    public void updateSeat(Seat seat) {
        seatDAO.updateSeat(seat);
    }

    public void deleteSeat(int seatId) {
        seatDAO.deleteSeat(seatId);
    }

    public Seat getSeatById(int seatId) {
        return seatDAO.getSeatById(seatId);
    }

    public List<Seat> getAllSeats() {
        return seatDAO.getAllSeats();
    }
}