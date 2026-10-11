package com.ResManCommon.ResCommon;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservationDTO {

	private int reservationID;
	private String custName;
	private Branches branch;
	private int count;
	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime timeSlot;
	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime timeIn;
	private char status;
	public ReservationDTO() {
		super();
	}
	public ReservationDTO(int reservationID, String custName, Branches branch, int count, LocalTime timeSlot,
			LocalTime timeIn, char status) {
		super();
		this.reservationID = reservationID;
		this.custName = custName;
		this.branch = branch;
		this.count = count;
		this.timeSlot = timeSlot;
		this.timeIn = timeIn;
		this.status = status;
	}
	public int getReservationID() {
		return reservationID;
	}
	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Branches getBranch() {
		return branch;
	}
	public void setBranch(Branches branch) {
		this.branch = branch;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public LocalTime getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(LocalTime timeSlot) {
		this.timeSlot = timeSlot;
	}
	public LocalTime getTimeIn() {
		return timeIn;
	}
	public void setTimeIn(LocalTime timeIn) {
		this.timeIn = timeIn;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ReservationDTO [reservationID=" + reservationID + ", custName=" + custName + ", branch=" + branch
				+ ", count=" + count + ", timeSlot=" + timeSlot + ", timeIn=" + timeIn + ", Status=" + status
				+  "]";
	}
}
