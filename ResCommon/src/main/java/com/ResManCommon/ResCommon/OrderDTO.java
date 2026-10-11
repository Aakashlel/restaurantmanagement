package com.ResManCommon.ResCommon;

public class OrderDTO {

	private int OrderID;
	private String DishName;
	private int Quantity;
	private char Status;
	@Override
	public String toString() {
		return "OrderDTO [OrderID=" + OrderID + ", DishName=" + DishName + ", Quantity=" + Quantity + ", Status="
				+ Status + "]";
	}
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public String getDishName() {
		return DishName;
	}
	public void setDishName(String dishName) {
		DishName = dishName;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public char getStatus() {
		return Status;
	}
	public void setStatus(char status) {
		Status = status;
	}
	public OrderDTO(int orderID, String dishName, int quantity, char status) {
		super();
		OrderID = orderID;
		DishName = dishName;
		Quantity = quantity;
		Status = status;
	}
	public OrderDTO() {
		super();
	}
}
