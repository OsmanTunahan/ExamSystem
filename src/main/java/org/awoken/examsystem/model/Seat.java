package org.awoken.examsystem.model;

public class Seat {
    private int id;
    private int studentId;
    private String seatNumber;
    private String examHall;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getExamHall() {
        return examHall;
    }

    public void setExamHall(String examHall) {
        this.examHall = examHall;
    }
}
