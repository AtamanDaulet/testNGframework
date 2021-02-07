package com.techproed.tests;

import com.techproed.utilities.TestBaseOld;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Day09ActionsClass3 extends TestBaseOld {
	/*
	Create a class: ActionsClass3
Create test method : keysUpDown()
Go to google
Send iPhone X prices => convert small letter capital vice versa.
Highlight the search box by double clicking
	 */
	@Test
	public void keysUpDown()  {
		driver.get("https://www.google.com/");
//.sendKeys("iPhone X prices");
		WebElement searchBox = driver.findElement(By.name("q"));
		Actions actions = new Actions(driver);
		// We want to press shift on keyboard  And type
		actions.
						keyDown(searchBox, Keys.SHIFT).
						sendKeys("iPhone X prices").
						keyUp(searchBox, Keys.SHIFT).
						perform();

		driver.findElement(By.xpath("//li[@class = 'sbct'][2]")).click();

	}
}
