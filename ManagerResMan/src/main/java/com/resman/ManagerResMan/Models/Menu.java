package com.resman.ManagerResMan.Models;

import com.ResManCommon.ResCommon.Branches;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="menu")
public class Menu {
	@Column(name="dishID")
	@Id
	int dishID;
	@Column(name="dishName")
	String dishName;
	@Column(name="Price")
	int price;
	@Column(name="FoodType")
	String foodType;
	@Enumerated(EnumType.STRING)
	@Column(name="Branch")
	Branches branch;
	public Menu() {
		super();
	}
	public Menu(int dishID, String dishName, int price, String foodType, Branches branch) {
		super();
		this.dishID = dishID;
		this.dishName = dishName;
		this.price = price;
		this.foodType = foodType;
		this.branch = branch;
	}
	public int getDishID() {
		return dishID;
	}
	public void setDishID(int dishID) {
		this.dishID = dishID;
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
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public Branches getBranch() {
		return branch;
	}
	public void setBranch(Branches branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Menu [dishID=" + dishID + ", dishName=" + dishName + ", price=" + price + ", foodType=" + foodType
				+ ", branch=" + branch + "]";
	}

}
