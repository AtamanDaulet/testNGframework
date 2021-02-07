package com.techproed.tests;

import com.techproed.pages.*;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day14_RoomReservationTest {
	/*
	//Create a class: RoomReservationTest
//Click on Hotel Management
//Click on Room reservations
//Click on Add Room Reservation
//Enter All required fields
//Click Save
//Verify the message: RoomReservation was inserted successfully
//Click OK
	 */
	CrystalMainPage mainlogin;
	CrystalkeyhotelsLogin loginCrystal;
	CrystalUserListPage userListPage;
	CrystalAdminSideBar sideBar;
	CrystalRoomReservationPage formCreateRoomReserv;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		mainlogin = new CrystalMainPage();
		loginCrystal = new CrystalkeyhotelsLogin();
		userListPage = new CrystalUserListPage();
		sideBar = new CrystalAdminSideBar();
		formCreateRoomReserv = new CrystalRoomReservationPage();
		wait = new WebDriverWait(Driver.getDriver(), 10);

		Driver.getDriver().get(ConfigReader.getProperty("qa_environment_url"));
		mainlogin.login.click();

		loginCrystal.userName.sendKeys(ConfigReader.getProperty("manager_username"));
		loginCrystal.password.sendKeys(ConfigReader.getProperty("manager_password"));
		loginCrystal.loginBtn.click();

		WebElement addUserButton = userListPage.addUserBtn;
		Assert.assertTrue(addUserButton.isDisplayed(), "Log in fail");

	}

	@Test
	public void RoomReservationTestMethod(){
		//		Hotel Management
		sideBar.hotelManagementBtn.click();
		//Click on Room reservations
		sideBar.roomReservationsBtn.click();

//Click on Add Room Reservation
		wait.until(ExpectedConditions.visibilityOf(formCreateRoomReserv.addRoomReservationBtn));
		formCreateRoomReserv.addRoomReservationBtn.click();

//Enter All required fields
		wait.until(ExpectedConditions.visibilityOf(formCreateRoomReserv.titleFormCreateHotelRoomReservation));
		Select usersOptions = new Select(formCreateRoomReserv.selectUser);
		usersOptions.selectByValue("2");

		Select roomOptions = new Select(formCreateRoomReserv.selectHotelRoom);
		roomOptions.selectByValue("72");

		formCreateRoomReserv.price.sendKeys("700");
		formCreateRoomReserv.dateStart.sendKeys("01.01.2021" + Keys.ENTER);
		formCreateRoomReserv.dateEnd.sendKeys("01.07.2021" + Keys.ENTER);
		formCreateRoomReserv.adultAmount.sendKeys("2");
		formCreateRoomReserv.childrenAmount.sendKeys("1");
		formCreateRoomReserv.contactNameSurname.sendKeys("Neo");
		formCreateRoomReserv.contactPhone.sendKeys("999-555-0011");
		formCreateRoomReserv.contactEmail.sendKeys("123@gmail.com");
		formCreateRoomReserv.notes.sendKeys("Note Test");
		formCreateRoomReserv.approvedCheckbox.click();
		formCreateRoomReserv.isPaidCheckbox.click();

//Click Save
		formCreateRoomReserv.saveBtn.click();

//Verify the message: RoomReservation was inserted successfully
		wait.until(ExpectedConditions.attributeToBe(
						formCreateRoomReserv.modalMsgBlock, "display","block"));

		WebElement message = formCreateRoomReserv.popupMsg;
		String expectedMsg = ConfigReader.getProperty("expectedReservationSuccessMessage");
		Assert.assertEquals(message.getText(),expectedMsg);

//Click OK
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		formCreateRoomReserv.okBtn.click();


	}

}
