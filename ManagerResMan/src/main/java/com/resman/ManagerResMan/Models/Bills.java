package com.resman.ManagerResMan.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bills")
public class Bills {
	
	@Column(name="ID")
	@Id
	int billID;
	@Column(name="DishName")
	String dishName;
	@Column(name="Price")
	int price;
	@Column(name="Discount")
	int discount=0;
	@Column(name="Quantity")
	int quantity;
	public int getBillID() {
		return billID;
	}
	public void setBillID(int billID) {
		this.billID = billID;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Bills [billID=" + billID + ", dishName=" + dishName + ", price=" + price + ", discount=" + discount
				+ ", quantity=" + quantity + "]";
	}
	public Bills(int billID, String dishName, int price, int discount, int quantity) {
		super();
		this.billID = billID;
		this.dishName = dishName;
		this.price = price;
		this.discount = discount;
		this.quantity = quantity;
	}
	public Bills() {
		super();
	}
	
}
