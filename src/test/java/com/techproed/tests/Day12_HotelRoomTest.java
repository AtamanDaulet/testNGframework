package com.techproed.tests;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day12_HotelRoomTest {  //Happy Path
	WebElement userNamePT;
	WebElement passwordPT;
	WebElement loginButtonPT;
	@BeforeMethod
	public void login() {
		Driver.getDriver().get(ConfigReader.getProperty("qa_environment_url"));
		Driver.getDriver().findElement(By.id("navLogon")).click();
		userNamePT = Driver.getDriver().findElement(By.id("UserName"));
		passwordPT = Driver.getDriver().findElement(By.id("Password"));
		loginButtonPT = Driver.getDriver().findElement(By.id("btnSubmit"));
	}
	@Test
	public void positiveLoginTest(){
		userNamePT.sendKeys("manager");
		passwordPT.sendKeys("Manager2!");
		loginButtonPT.click();

		WebElement addUserButton = Driver.getDriver().findElement(By.xpath("//span[@class = 'hidden-480']"));
		Assert.assertTrue(addUserButton.isDisplayed(), "Log in fail");

//		Hotel Management
		WebElement hotelManagementButton = Driver.getDriver().findElement(By.partialLinkText("Hotel Management"));
		hotelManagementButton.click();

//		Hotel Rooms
		WebElement hotelRoomsButton = Driver.getDriver().findElement(By.xpath("//a[@href = '/admin/HotelRoomAdmin']"));
		hotelRoomsButton.click();

		WebElement addHotelRoomsButton = Driver.getDriver().
					findElement(By.xpath("//a[@href = '/admin/HotelroomAdmin/Create']"));
		addHotelRoomsButton.click();

		//Wait createHotelRoom Button
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'caption']")));
		WebElement createHotelRoomButton = Driver.getDriver().
						findElement(By.xpath("//div[@class = 'caption']"));
		Assert.assertTrue(createHotelRoomButton.isDisplayed());

//		IDHotel
		WebElement idHotel = Driver.getDriver().findElement(By.id("IDHotel"));
		Select hotelOptions = new Select(idHotel);
		hotelOptions.selectByValue("1018");

		WebElement codeField = Driver.getDriver().findElement(By.id("Code"));
		codeField.sendKeys("12345");

		WebElement nameField = Driver.getDriver().findElement(By.id("Name"));
		nameField.sendKeys("Royal Family");

		WebElement locationField = Driver.getDriver().findElement(By.id("Location"));
		locationField.sendKeys("345");

		WebElement hotelDescription=Driver.getDriver().findElement(By.xpath("//textarea[@role='textbox']"));
		hotelDescription.sendKeys("This is the best room in the Hotel");
		WebElement price=Driver.getDriver().findElement(By.id("Price"));
		price.sendKeys("700");
		WebElement roomType=Driver.getDriver().findElement(By.id("IDGroupRoomType"));
		Select roomTypeOptions=new Select(roomType);
		roomTypeOptions.selectByVisibleText("Studio");
		WebElement adultCount=Driver.getDriver().findElement(By.id("MaxAdultCount"));
		adultCount.sendKeys("2");
		WebElement maxChildrenCount=Driver.getDriver().findElement(By.id("MaxChildCount"));
		maxChildrenCount.sendKeys("3");
		WebElement isApproved=Driver.getDriver().findElement(By.id("IsAvailable"));
		isApproved.click();
		WebElement saveButton =Driver.getDriver().findElement(By.id("btnSubmit"));
		saveButton.click();


//explicit wait
		// 1 way
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'bootbox-body']")));
//		WebElement successMessage=Driver.getDriver().findElement(By.xpath("//div[@class = 'bootbox-body']"));
//		String successMessageText=successMessage.getText();
//		Assert.assertEquals(successMessageText,"HotelRoom was inserted successfully");

// 2 way
		boolean isTrue=wait.until(ExpectedConditions.textToBe(By.className("bootbox-body"),"HotelRoom was inserted successfully"));

		Assert.assertTrue(isTrue);


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
//		Done

	}
//	@AfterMethod
//	public void tearDown(){
//		Driver.closeDriver();
//	}
}
