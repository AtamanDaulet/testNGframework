package com.techproed.homeworks;

import com.techproed.utilities.TestBaseOld;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class iframeHW extends TestBaseOld {
	/*
Note:
Page is too slow. Do some manual testing
and understand the behavior
We will learn how to scroll a page down in the next class that you can use to handle the element better

	 */
	@Test
	public void iframeTest() throws InterruptedException {
//		When user goes to https://html.com/tags/iframe/
		driver.manage().timeouts().pageLoadTimeout(30L, TimeUnit.SECONDS);
		driver.get("https://html.com/tags/iframe/");
		Thread.sleep(10L);

		//Then click on the first video playto play the vide
		WebElement iframeScroll = driver.findElement(By.xpath("(//div[@class = 'render'])[1]"));

		Actions action = new Actions(driver);
		action.moveToElement(iframeScroll).perform();

		driver.switchTo().frame(0).findElement(By.xpath("//button[@aria-label= 'Play']")).click();
	}

}
//scroll to bottom
//		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);

