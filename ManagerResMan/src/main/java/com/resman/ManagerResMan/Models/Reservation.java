package com.resman.ManagerResMan.Models;

import java.time.LocalTime;

import com.ResManCommon.ResCommon.Branches;

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
	public int getReservationID() {
		return reservationID;
	}
	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Branches getBranch() {
		return branch;
	}
	public void setBranch(Branches branch) {
		this.branch = branch;
	}
	public int getNumCustomers() {
		return numCustomers;
	}
	public void setNumCustomers(int numCustomers) {
		this.numCustomers = numCustomers;
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
	@Column(name="CustomerName")
	String customerName;
	@Enumerated(EnumType.STRING)
	@Column(name="Branch")
	Branches branch;
	@Column(name="NumCustomers")
	int numCustomers;
	@Column(name="TimeSlot")
	LocalTime timeSlot;
	@Column(name="TimeIn")
	LocalTime timeIn;
	@Column(name="Status")
	char status;
	@Override
	public String toString() {
		return "Reservation [reservationID=" + reservationID + ", customerName=" + customerName + ", branch=" + branch
				+ ", numCustomers=" + numCustomers + ", timeSlot=" + timeSlot + ", timeIn=" + timeIn + ", status="
				+ status + "]";
	}
	public Reservation() {
		super();
	}
	public Reservation(int reservationID, String customerName, Branches branch, int numCustomers, LocalTime timeSlot,
			LocalTime timeIn, char status) {
		super();
		this.reservationID = reservationID;
		this.customerName = customerName;
		this.branch = branch;
		this.numCustomers = numCustomers;
		this.timeSlot = timeSlot;
		this.timeIn = timeIn;
		this.status = status;
	}
}
