package com.techproed.tests;

import com.techproed.utilities.TestBaseOld;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class day08_windowHandle extends TestBaseOld {
	/*
Create a new Class Tests package: Day08_WindowHandleExample
Method name:windowHandle
Given user is on the https://the-internet.herokuapp.com/windows
	 */
	@Test
	public void windowHandle(){
	driver.get("https://the-internet.herokuapp.com/windows");
//		Then user verifies the text : “Opening a new window”
	String textOpening = driver.findElement(By.xpath("//h3[. = 'Opening a new window']")).getText();
		Assert.assertTrue(textOpening.contains("Opening a new window"));

//		Then user verifies the title of the page is “The Internet”
		String title = driver.getTitle();
//		System.out.println(title);
		Assert.assertTrue(title.contains("The Internet"),"False! title.contains(\"The Internet\")");

//		When user clicks on the “Click Here” button
		driver.findElement(By.xpath("//a[. = 'Click Here']")).click();

//		Then user verifies the new window title is “New Window”
		String window1 = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();

		for (String eachWindow : windows ) {
			if (!eachWindow.equals(window1)){
				driver.switchTo().window(eachWindow);
			}
		}

		String title2 = driver.getTitle();
//		System.out.println(title2);
		Assert.assertEquals(title2,"New Window");

//		Then user verifies the text:  “New Window”
		String textNewWindow = driver.findElement(By.tagName("h3")).getText();
//		System.out.println(textNewWindow);
		Assert.assertEquals(textNewWindow,"New Window");

//		When user goes back to the previous window and then verifies the title : “The Internet”
		driver.switchTo().window(window1);
		String titleAgainCheckFirstPage = driver.getTitle();
		Assert.assertTrue(titleAgainCheckFirstPage.contains("The Internet"));
	}
}
