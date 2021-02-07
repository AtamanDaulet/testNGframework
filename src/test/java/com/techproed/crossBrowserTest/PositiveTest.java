package com.techproed.crossBrowserTest;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseCross;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.techproed.utilities.ReusableMethods.fluentWait;

public class PositiveTest extends TestBaseCross {
	WebElement userNamePT;
	WebElement passwordPT;
	WebElement loginButtonPT;

	@Test
	public void createHotel(){
		Driver.getDriver().get(ConfigReader.getProperty("qa_environment_url"));

//		fluentWait(Driver.getDriver().findElement(By.id("navLogon")),10);

		Driver.getDriver().findElement(By.id("navLogon")).click();
		userNamePT = Driver.getDriver().findElement(By.id("UserName"));
		passwordPT = Driver.getDriver().findElement(By.id("Password"));
		loginButtonPT = Driver.getDriver().findElement(By.id("btnSubmit"));

		userNamePT.sendKeys("manager");
		passwordPT.sendKeys("Manager2!");
		loginButtonPT.click();

		WebElement addUserButton = Driver.getDriver().findElement(By.xpath("//span[@class = 'hidden-480']"));
		Assert.assertTrue(addUserButton.isDisplayed(), "Login Test fail");

		WebElement hotelManagement = Driver.getDriver().findElement(By.id("menuHotels"));
		hotelManagement.click();
		WebElement hotelRoomButton = Driver.getDriver().findElement(By.xpath("//a[@href = '/admin/HotelRoomAdmin']"));
		hotelRoomButton.click();

		WebElement addHotelRooms = Driver.getDriver().findElement(By.xpath("//a[@href='/admin/HotelroomAdmin/Create']"));
		addHotelRooms.click();

	}
}
