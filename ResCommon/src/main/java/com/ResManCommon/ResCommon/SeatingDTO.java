package com.ResManCommon.ResCommon;

public class SeatingDTO {

	private Branches branch;
	private int seats3;
	private int seats5;
	private int seats10;
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
	@Override
	public String toString() {
		return "SeatingDTO [Branch=" + branch + ", seats3=" + seats3 + ", seats5=" + seats5 + ", seats10=" + seats10
				+ "]";
	}
	public SeatingDTO() {
		super();
	}
	public SeatingDTO(Branches branch, int seats3, int seats5, int seats10) {
		super();
		this.branch = branch;
		this.seats3 = seats3;
		this.seats5 = seats5;
		this.seats10 = seats10;
	}
}
