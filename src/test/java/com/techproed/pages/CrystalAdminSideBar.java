package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrystalAdminSideBar {
	public CrystalAdminSideBar(){
		PageFactory.initElements(Driver.getDriver(), this);
	}
	@FindBy(id = "menuYonetim")
	public WebElement systemManagementBtn;
	@FindBy(id = "menuUsers")
	public WebElement userManagementBtn;
	@FindBy(xpath = "//a[@href='/admin/UserAdmin']")
	public WebElement userListBtn;
	@FindBy(id = "menuHotels")
	public WebElement hotelManagementBtn;
	@FindBy(xpath = "//a[@href='/admin/HotelAdmin']")
	public WebElement hotelListBtn;
	@FindBy(xpath = "//a[@href='/admin/HotelRoomAdmin']")
	public WebElement hotelRoomsBtn;
	@FindBy(xpath = "//a[@href='/admin/RoomReservationAdmin']")
	public WebElement roomReservationsBtn;

}
