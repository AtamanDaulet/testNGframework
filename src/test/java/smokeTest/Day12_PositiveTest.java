package smokeTest;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day12_PositiveTest {
	/*
	Create a class: PositiveTest
positiveLoginTest
When user goes to https://qa-environment.crystalkeyhotels.com/
And click on Log in
And send the username and password
	 */
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
	//	@AfterMethod
//	public void tearDown(){
//		Driver.closeDriver();
//	}

	/*
	//Create a clickOnLogin method
//Click on Hotel Management
//Click on Hotel Rooms
//Click on Add Hotel Room
//Enter All required fields
//To enter a price, we can send keys, OR we can use actions class to drag and drop
//Click Save
//Verify the message: HotelRoom was inserted successfully
//Click OK
	 */
	@Test
	public void createHotel(){

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
