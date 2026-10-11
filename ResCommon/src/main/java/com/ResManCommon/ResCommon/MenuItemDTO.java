package com.ResManCommon.ResCommon;

public class MenuItemDTO {

	private int dishID;
	private String dishName;
	private int price;
	private String foodType;
	private Branches branch;
	public MenuItemDTO() {
		super();
	}
	public MenuItemDTO(int dishID, String dishName, int price, String foodType, Branches branch) {
		super();
		this.dishID = dishID;
		this.dishName = dishName;
		this.price = price;
		this.foodType = foodType;
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "MenuItemDTO [dishID=" + dishID + ", dishName=" + dishName + ", price=" + price + ", foodType="
				+ foodType + ", branch=" + branch + "]";
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
	
}
