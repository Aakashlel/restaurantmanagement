package com.resman.ManagerResMan.Models;

import java.time.LocalTime;

import com.ResManCommon.ResCommon.Branches;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="reservation")
public class Reservation {

	@Column(name="ReservationID")
	@Id
	int reservationID;
	@Column(name="CustomerName")
	String custName;
	@Enumerated(EnumType.STRING)
	@Column(name="Branch")
	Branches branch;
	@Column(name="NumCustomers")
	int count;
	@JsonFormat(pattern = "HH:mm:ss")
	@Column(name="TimeSlot")
	LocalTime timeSlot;
	@JsonFormat(pattern = "HH:mm:ss")
	@Column(name="TimeIn")
	LocalTime timeIn;
	@Column(name="Status")
	char status;
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
	public Reservation(int reservationID, String custName, Branches branch, int count, LocalTime timeSlot,
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
	public Reservation() {
		super();
	}
	@Override
	public String toString() {
		return "Reservation [reservationID=" + reservationID + ", custName=" + custName + ", branch=" + branch
				+ ", count=" + count + ", timeSlot=" + timeSlot + ", timeIn=" + timeIn + ", Status=" + status + "]";
	}
	
}
