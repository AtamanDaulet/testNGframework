package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrystalHotelRoomsListPage {
	public CrystalHotelRoomsListPage(){
		PageFactory.initElements(Driver.getDriver(),this);
	}
	@FindBy(xpath = "//span[contains(. , 'Add Hotelroom')]")
	public WebElement addHotelRoomBtn;
	@FindBy(id = "lkpHotels")
	public WebElement iDHotelFilter;
	@FindBy(id = "lkpGroupRoomTypes")
	public WebElement iDGroupRoomTypesFilter;
	@FindBy(xpath = "//select[@name ='IsAvailable']")
	public WebElement isAvailableFilter;
	@FindBy(xpath = "//button[. ='Search']")
	public WebElement searchBtn;
	@FindBy(xpath = "//tbody/tr[1]/td[4]")
	public WebElement row1nameColumn;

}
