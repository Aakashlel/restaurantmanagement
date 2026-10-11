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
	int id;
	@Column(name="DishName")
	String DishName;
	@Column(name="Price")
	int Price;
	@Column(name="Discount")
	int Discount=0;
	@Column(name="Quantity")
	int Quantity;
	@Override
	public String toString() {
		return "Bills [id=" + id + ", DishName=" + DishName + ", Price=" + Price + ", Discount=" + Discount
				+ ", Quantity=" + Quantity + "]";
	}
	public Bills(int id, String dishName, int price, int discount, int quantity) {
		super();
		this.id = id;
		DishName = dishName;
		Price = price;
		Discount = discount;
		Quantity = quantity;
	}
	public Bills() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDishName() {
		return DishName;
	}
	public void setDishName(String dishName) {
		DishName = dishName;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getDiscount() {
		return Discount;
	}
	public void setDiscount(int discount) {
		Discount = discount;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

}
