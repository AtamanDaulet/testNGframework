package com.techproed.tests;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Day13_WebTables {
	/*
	Create a method: login()
Log in  https://qa-environment.crystalkeyhotels.com/
//Click on Hotel Management
//Click on Hotel Rooms
Create a test method: entireTable() and Find the size of the entire table body and print all of headers
Create a test method: printRows() and Print all of the rows and print the element s on the 4th row
Create a test method: printCells() and a the total number of cells in the table body and print all of the cells
Create a test method: printColumns() and print Find the total number of columns and Print the elements of the 5th column
Create a test method: printData(int row, int column); This method should print the given cell. Example: printData(2,3); should print 2nd row,3rd column

	 */
	WebElement userNamePT;
	WebElement passwordPT;
	WebElement loginButtonPT;

	@BeforeClass
	public void setUp() {
		Driver.getDriver().get(ConfigReader.getProperty("qa_environment_url"));
		Driver.getDriver().findElement(By.id("navLogon")).click();
		userNamePT = Driver.getDriver().findElement(By.id("UserName"));
		passwordPT = Driver.getDriver().findElement(By.id("Password"));
		loginButtonPT = Driver.getDriver().findElement(By.id("btnSubmit"));
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

	}

	//	Create a test method: entireTable() and Find the size of the entire table body and print all of headers
	@Test
	public void entireTable() {
		System.out.println("=======================TABLE DATA==============================");
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody")));

		WebElement tBody = Driver.getDriver().findElement(By.xpath("//tbody"));
//		System.out.println(tBody.getText());
		System.out.println("Height of body is " + tBody.getSize().getHeight());
		System.out.println("Width of body is " + tBody.getSize().getWidth());

		WebElement header = Driver.getDriver().findElement(By.className("heading"));
		System.out.println("Headers : " + header.getText());
	}

	//	Create a test method: printRows() and Print all of the rows and print the element s on the 4th row
	@Test(priority = 1)
	public void printRows() {
		WebElement tBody = Driver.getDriver().findElement(By.xpath("//tbody"));
//		System.out.println(tBody.getText());
		WebElement row4 = Driver.getDriver().findElement(By.xpath("//tbody/tr[4]"));
		System.out.println("Row 4th : " + row4.getText());
	}

	//	Create a test method: printCells() and a total number of cells in the table body and print all of the cells
	@Test(priority = 2)
	public void printCells() {
//		Integer totalNumberOfCells =
//						Driver.getDriver().findElements(By.xpath("//tbody/*/td")).size();

		System.out.println("=======================All Cells==============================");
		List<WebElement> allCells = Driver.getDriver().findElements(By.xpath("//tbody/*/td"));
		System.out.println(allCells.size() + " cells");
//	allCells.stream().forEach(t -> System.out.println(t.getText()));

	}

	//	Create a test method: printColumns() and print Find the total number of columns
//	and Print the elements of the 5th column
	@Test(priority = 3)
	public void printColumns() {
		List<WebElement> totalNumberOfColumnsList =
						Driver.getDriver().findElements(By.xpath("//tbody/tr[1]/td"));
		System.out.println("=======================total number of columns==============================");
		System.out.println(totalNumberOfColumnsList.size() + " columns");

		// 1 way
		System.out.println(totalNumberOfColumnsList.get(4).getText());

		// 2 way
		System.out.println(Driver.getDriver().findElements(By.xpath("//tbody//tr//td[5]")).get(0).getText());

		System.out.println(printData(2,3).getText());
		System.out.println(printData(2,1).getText());
	}

	//	Create a test method: printData(int row, int column); This method should print the given cell.
	//	Example: printData(2,3); should print 2nd row,3rd column

	public WebElement printData(int row, int column) {
		System.out.println("=======================method: printData==============================");
		WebElement dataCell =
						Driver.getDriver().findElement(By.xpath("//tbody/tr["+row+"]/td["+column+"]"));

		return dataCell;


	}
}
