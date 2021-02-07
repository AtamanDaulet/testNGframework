package com.techproed.tests;

import com.techproed.utilities.TestBaseOld;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day09_Synchronization1 extends TestBaseOld {
/*
Create a class:Day09_Synchronization1. Create a method: synchronization1
Go to https://the-internet.herokuapp.com/dynamic_controls
Click on remove button
And verify the message is equal to “It's gone!”
Then click on Add button
And verify the message is equal to “It's back!”
 */
	@Test
	public void synchronization(){
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		driver.findElement(By.xpath("//button[@onclick= 'swapCheckbox()']")).click();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		String isGone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id= 'message']"))).getText();
		Assert.assertEquals(isGone,"It's gone!");
		driver.findElement(By.xpath("//button[@onclick= 'swapCheckbox()']")).click();
		String isBack = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id= 'message']"))).getText();
		Assert.assertEquals(isBack,"It's back!");
	}
	@Test
	public void synchronization2(){
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		driver.findElement(By.xpath("//button[@onclick= 'swapInput()']")).click();
		String enabledtext= driver.findElement(By.xpath("//p[@id= 'message']")).getText();
//		WebDriverWait wait=new WebDriverWait(driver, 20);
//		String isGone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id= 'message']"))).getText();

		Assert.assertEquals(enabledtext,"It's enabled!");

		driver.findElement(By.xpath("//button[@onclick= 'swapInput()']")).click();
		String disabledtext= driver.findElement(By.xpath("//p[@id= 'message']")).getText();
//		String isBack = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id= 'message']"))).getText();

		Assert.assertEquals(disabledtext,"It's disabled!");
	}
	@Test
	public void synchronization3(){
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		WebDriverWait wait=new WebDriverWait(driver, 20);

		driver.findElement(By.xpath("//button[@onclick= 'swapInput()']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text() , 'enabled')]")));
		WebElement input = driver.findElement(By.xpath("//input[@type= 'text']"));

		Assert.assertTrue(input.isEnabled());

		driver.findElement(By.xpath("//button[@onclick= 'swapInput()']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text() , 'disabled')]")));
		Assert.assertTrue(!input.isEnabled());
	}
	/*
	//Homework"
//Create a new method: isExampled1()
//Use Explicit Wait On The Correct WebElements
	 */
	@Test
	public void isExampled1(){
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		driver.findElement(By.xpath("//button[@onclick= 'swapInput()']")).click();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		String enabledtext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id= 'message']"))).getText();

		Assert.assertEquals(enabledtext,"It's enabled!");

		driver.findElement(By.xpath("//button[@onclick= 'swapInput()']")).click();
		String disabledtext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id= 'message']"))).getText();

		Assert.assertEquals(disabledtext,"It's disabled!");
	}
}
