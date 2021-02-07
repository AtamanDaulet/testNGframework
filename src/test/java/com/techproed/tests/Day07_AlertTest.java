package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class Day07_AlertTest {
	/*
 */
	WebDriver driver;

	//	Go to https://the-internet.herokuapp.com/javascript_alerts
//	Create setUp method
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	//	Create 3 test methods:
//	acceptAlert() => click on the first alert, verify the text “I am a JS Alert” , click OK ,
//	and Verify “You successfuly clicked an alert”
	@Test
	public void acceptAlertTest() {
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		String actualAlertText = driver.switchTo().alert().getText();

		Assert.assertEquals(actualAlertText, "I am a JS Alert");
		driver.switchTo().alert().accept();
		String actualResult = driver.findElement(By.xpath("//p[. = 'You successfuly clicked an alert']")).getText();
		Assert.assertEquals(actualResult, "You successfuly clicked an alert");


//		dismissAlert()=> click on the second alert,
//			verify text "I am a JS Confirm”, click cancel, and Verify “You clicked: Cancel”
	}

	@Test
	public void dismissAlertTest() {
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		String dismissAlert = driver.switchTo().alert().getText();
		Assert.assertEquals(dismissAlert, "I am a JS Confirm");
		driver.switchTo().alert().dismiss();
		String actualResult = driver.findElement(By.xpath("//p[. = 'You clicked: Cancel']")).getText();
		Assert.assertEquals(actualResult, "You clicked: Cancel");

	}

//	sendKeysAlert()=> click on the third alert, verify text “I am a JS prompt”,
//	type “Hello Word”, click OK, and Verify “You entered: Hello Word”
	@Test
	public void sendKeysAlertTest() {
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		String sendKeysAlertText = driver.switchTo().alert().getText();
		Assert.assertEquals(sendKeysAlertText, "I am a JS prompt");
		driver.switchTo().alert().sendKeys("Hello Word");
		driver.switchTo().alert().accept();
		String actualResultSendKeysAlert = driver.findElement(By.xpath("//p[. = 'You entered: Hello Word']")).getText();
		Assert.assertEquals(actualResultSendKeysAlert, "You entered: Hello Word");

	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
