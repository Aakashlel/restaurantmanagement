package com.ResManCommon.ResCommon;

public class MenuItemDTO {

	private int DishID;
	private String DishName;
	private int price;
	private String FoodType;
	private Branches Branch;
	public MenuItemDTO() {
		super();
	}
	public MenuItemDTO(int dishID, String dishName, int price, String foodType, Branches branch) {
		super();
		DishID = dishID;
		DishName = dishName;
		this.price = price;
		FoodType = foodType;
		Branch = branch;
	}
	public int getDishID() {
		return DishID;
	}
	public void setDishID(int dishID) {
		DishID = dishID;
	}
	public String getDishName() {
		return DishName;
	}
	public void setDishName(String dishName) {
		DishName = dishName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getFoodType() {
		return FoodType;
	}
	public void setFoodType(String foodType) {
		FoodType = foodType;
	}
	public Branches getBranch() {
		return Branch;
	}
	public void setBranch(Branches branch) {
		Branch = branch;
	}
	@Override
	public String toString() {
		return "MenuItemDTO [DishID=" + DishID + ", DishName=" + DishName + ", price=" + price + ", FoodType="
				+ FoodType + ", Branch=" + Branch + "]";
	}
	
}
