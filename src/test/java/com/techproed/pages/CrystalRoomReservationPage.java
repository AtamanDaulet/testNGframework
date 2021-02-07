package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrystalRoomReservationPage {
	public CrystalRoomReservationPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//span[@class = 'hidden-480']")
	public WebElement addRoomReservationBtn;

	@FindBy(className = "caption")
	public WebElement titleFormCreateHotelRoomReservation;

	@FindBy(id = "IDUser")
	public WebElement selectUser;

	@FindBy(id = "IDHotelRoom")
	public WebElement selectHotelRoom;

	@FindBy(id = "Price")
	public WebElement price;

	@FindBy(id = "DateStart")
	public WebElement dateStart;

	@FindBy(id = "DateEnd")
	public WebElement dateEnd;

	@FindBy(id = "AdultAmount")
	public WebElement adultAmount;

	@FindBy(id = "ChildrenAmount")
	public WebElement childrenAmount;

	@FindBy(id = "ContactNameSurname")
	public WebElement contactNameSurname;

	@FindBy(id = "ContactPhone")
	public WebElement contactPhone;

	@FindBy(id = "ContactEmail")
	public WebElement contactEmail;

	@FindBy(id = "Notes")
	public WebElement notes;

	@FindBy(id = "uniform-Approved")
	public WebElement approvedCheckbox;

	@FindBy(id = "uniform-IsPaid")
	public WebElement isPaidCheckbox;

	@FindBy(id = "btnSubmit")
	public WebElement saveBtn;

	@FindBy(className = "bootbox-body")
	public WebElement popupMsg;

	@FindBy(xpath = "//button[. = 'OK']")
	public WebElement okBtn;

	@FindBy(xpath = "//div[@class='bootbox modal fade bootbox-alert in']")
	public WebElement modalMsgBlock;
}
