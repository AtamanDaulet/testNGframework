package com.techproed.tests;

import com.techproed.utilities.TestBaseOld;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day09ActionsClass1 extends TestBaseOld {
	/*
	Create a class: ActionsClass1
Create a test method : contextClickMethod() and test the following scenario:
Given user is on the https://the-internet.herokuapp.com/context_menu
When use Right clicks on the box
Then verify the alert message is “You selected a context menu”
Then accept the alert
	 */
	@Test
	public void contextClickMethod(){
		driver.get("https://the-internet.herokuapp.com/context_menu");
//		When use Right clicks on the box
		WebElement box =  driver.findElement(By.id("hot-spot"));

		Actions action = new Actions(driver);
		action.contextClick(box).perform();

		String actualAlertText = driver.switchTo().alert().getText();
		Assert.assertEquals(actualAlertText , "You selected a context menu");
		driver.switchTo().alert().accept();

	}
}
