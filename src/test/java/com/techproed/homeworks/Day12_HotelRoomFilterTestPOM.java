package com.techproed.homeworks;

import com.techproed.pages.*;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day12_HotelRoomFilterTestPOM {
	/*
        HOMEWORK
        When user clicks on Hotel Roooms link
        End filters
        IdHotel :ADA
        IdGroup :Studio
        IsAvailable :true
        And click Search
        Then verify table name includes " Royal Family "
         */
//----------------POM-----------
	CrystalMainPage mainlogin;
	CrystalkeyhotelsLogin loginCrystal;
	CrystalUserListPage userListPage;
	CrystalAdminSideBar sideBar;
	CrystalHotelRoomsListPage hotelRoomsList;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp(){
		mainlogin = new CrystalMainPage();
		loginCrystal = new CrystalkeyhotelsLogin();
		userListPage = new CrystalUserListPage();
		sideBar = new CrystalAdminSideBar();
		hotelRoomsList = new CrystalHotelRoomsListPage();
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
	public void hotelRoomFilterTest() throws InterruptedException {
//		When user clicks on Hotel Roooms link
		sideBar.hotelManagementBtn.click();
		sideBar.hotelRoomsBtn.click();
		wait.until(ExpectedConditions.visibilityOf(hotelRoomsList.addHotelRoomBtn));
//		End filters
//		IdHotel :ADA
		Select optionsIdHotel = new Select(hotelRoomsList.iDHotelFilter);
		optionsIdHotel.selectByVisibleText("Ada");
//		IdGroup :Studio
		Select optionsIdGroup = new Select(hotelRoomsList.iDGroupRoomTypesFilter);
		optionsIdGroup.selectByVisibleText("Studio");
//		IsAvailable :true
		Select optionsIsAvailable = new Select(hotelRoomsList.isAvailableFilter);
		optionsIsAvailable.selectByVisibleText("True");
//		And click Search
		hotelRoomsList.searchBtn.click();
//		Then verify table name includes " Royal Family "
		Thread.sleep(1000);
		String row1nameColumnText = hotelRoomsList.row1nameColumn.getText();
		Assert.assertEquals(row1nameColumnText , "Royal Family");

	}

}
