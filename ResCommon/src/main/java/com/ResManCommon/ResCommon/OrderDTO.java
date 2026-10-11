package com.ResManCommon.ResCommon;

public class OrderDTO {

	private int orderID;
	private String dishName;
	private int quantity;
	private char status;
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "OrderDTO [orderID=" + orderID + ", dishName=" + dishName + ", quantity=" + quantity + ", status="
				+ status + "]";
	}
	public OrderDTO(int orderID, String dishName, int quantity, char status) {
		super();
		this.orderID = orderID;
		this.dishName = dishName;
		this.quantity = quantity;
		this.status = status;
	}
	public OrderDTO() {
		super();
	}
	
}
