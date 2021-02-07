package com.techproed.tests;

import com.techproed.utilities.TestBaseOld;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Day09ActionsClass4Scroll extends TestBaseOld {
/*
Create a class: ActionClass4
Create test method : scrollUpDown()
Go to amazon
Scroll the page down
Scroll the page up
 */
@Test
public void scrollUpDown()  {
	driver.get("https://www.amazon.com/");

	Actions actions = new Actions(driver);
	// We want to press shift on keyboard  And type
	actions.sendKeys(Keys.PAGE_DOWN).perform();

	driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL , Keys.END);

	actions.sendKeys(Keys.PAGE_UP).perform();
	actions.sendKeys(Keys.ARROW_DOWN).perform();
	actions.sendKeys(Keys.ARROW_RIGHT).perform();
	actions.sendKeys(Keys.ARROW_UP).perform();
	actions.sendKeys(Keys.ARROW_UP).perform();
}
}
