package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertTest {
	/*
//When user goes to google home page
//And search for porcelain teapot
//Then verify the page title includes teapot
	 */
	WebDriver driver;

	@BeforeMethod
	public void setUp(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Test
	public void search(){
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("porcelain teapot"+ Keys.ENTER);

		String expectedTitle = "teapot";
		String actualTitle  = driver.getTitle();

		SoftAssert softAssert = new SoftAssert();

		softAssert.assertTrue(actualTitle.contains("jhbvljhzbvlkjs"),"title does not include jhbvljhzbvlkjs");
		softAssert.assertTrue(actualTitle.contains(expectedTitle),"title does not include teapot");
		softAssert.assertTrue(actualTitle.contains("teapot123"),"title does not include teapot123");

		System.out.println("This is After Hard Assertion");
		driver.quit();
		softAssert.assertAll();


	}

}
