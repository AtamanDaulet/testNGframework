package com.techproed.tests;

import com.techproed.utilities.TestBaseOld;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day09ActionsClass2 extends TestBaseOld {
	/*
	Create a class: ActionClass2
Create test method : hoverOver() and test the following scenario:
Given user is on the https://www.amazon.com/
When use click on “Your Account” link
Then verify the page title contains “Your Account”
Create another method: imageTest()
Hover over the Try Prime
And Verify the image displays.
	 */
	@Test
	public void hoverOver() throws InterruptedException {
		driver.get("https://www.amazon.com/");
//		When use click on “Your Account” link
		WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
		Actions actions = new Actions(driver);
		actions.moveToElement(accountList).perform();  //Hover
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href = '/gp/css/homepage.html?ref_=nav_AccountFlyout_ya']")).click();
//		Then verify the page title contains “Your Account”
		Assert.assertEquals(driver.getTitle(), "Your Account");
	}
	@Test
	public void imageTest() {
		driver.get("https://www.amazon.com/");
//		Hover over the Try Prime
		WebElement primeButton = driver.findElement(By.id("nav-link-prime"));
		Actions actions = new Actions(driver);
		actions.moveToElement(primeButton).perform();    //Hover

//		And Verify the image displays.
		WebElement imageBlock = driver.findElement(By.xpath("//div[@id = 'nav-flyout-prime']"));
		Assert.assertTrue(imageBlock.isDisplayed());

	}
}
