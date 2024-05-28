package org.awoken.examsystem.dao;

import org.awoken.examsystem.model.Seat;
import java.util.List;

public interface SeatDAO {
    void allocateSeat(Seat seat);
    void updateSeat(Seat seat);
    void deleteSeat(int seatId);
    Seat getSeatById(int seatId);
    List<Seat> getAllSeats();
}