package com.resman.ManagerResMan.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {
	@Column(name="orderID")
	@Id
	int orderID;
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
	@Column(name="DishName")
	String dishName;
	@Column(name="Quantity")
	int quantity;
	@Column(name="Status")
	char status;
	public Orders(int orderID, String dishName, int quantity, char status) {
		super();
		this.orderID = orderID;
		this.dishName = dishName;
		this.quantity = quantity;
		this.status = status;
	}
	public Orders() {
		super();
	}
	@Override
	public String toString() {
		return "Orders [orderID=" + orderID + ", dishName=" + dishName + ", quantity=" + quantity + ", status=" + status
				+ "]";
	}

}
