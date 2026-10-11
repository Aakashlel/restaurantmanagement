package com.resman.ManagerResMan.Models;

import com.ResManCommon.ResCommon.Branches;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="seating")
public class Seating {
	
	@Enumerated(EnumType.STRING)
	@Column(name="branch")
	@Id
	Branches branch;
	@Column(name="Seats3")
	int seats3;
	public Branches getBranch() {
		return branch;
	}
	public void setBranch(Branches branch) {
		this.branch = branch;
	}
	public int getSeats3() {
		return seats3;
	}
	public void setSeats3(int seats3) {
		this.seats3 = seats3;
	}
	public int getSeats5() {
		return seats5;
	}
	public void setSeats5(int seats5) {
		this.seats5 = seats5;
	}
	public int getSeats10() {
		return seats10;
	}
	public void setSeats10(int seats10) {
		this.seats10 = seats10;
	}
	@Column(name="Seats5")
	int seats5;
	@Column(name="Seats10")
	int seats10;
	public Seating() {
		super();
	}
	public Seating(Branches branch, int seats3, int seats5, int seats10) {
		super();
		this.branch = branch;
		this.seats3 = seats3;
		this.seats5 = seats5;
		this.seats10 = seats10;
	}
	@Override
	public String toString() {
		return "Seating [branch=" + branch + ", seats3=" + seats3 + ", seats5=" + seats5 + ", seats10=" + seats10 + "]";
	}

}
