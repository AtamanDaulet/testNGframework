package com.techproed.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.techproed.pages.ContactPage;
import com.techproed.pages.MainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ReusableMethods;
import com.techproed.utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Day23_ExtentReportsTest2 extends TestBase {

	MainPage mainPage=new MainPage();
	ContactPage contactPage=new ContactPage();

	@Test
	public void extendReportsTest(){
		extentTest=extentReports.createTest("Crystal Keys extendReportsTest","Contact Page Test");
		extentTest.info("Opening the Application home page");
		Driver.getDriver().get(ConfigReader.getProperty("qa_environment"));
		extentTest.info("Clicking the contact link");
		mainPage.contact.click();
		extentTest.info("Entering Name");
		contactPage.name.sendKeys("sending name");
		extentTest.info("entering email");
		contactPage.email.sendKeys("sending@fakegmail.com");
		extentTest.info("entering phone number");
		contactPage.phone.sendKeys("9999999");
		extentTest.pass("Sending the subject");
		contactPage.subject.sendKeys("sending the subject");
		extentTest.pass("sending the message");
		contactPage.message.sendKeys("I would like to cancel my weekend reservation");
		extentTest.pass("clicking");
		contactPage.submitButton.click();
		extentTest.pass("Clicked on the click button");
		ReusableMethods.waitForVisibility(contactPage.errorMessage,3);
		extentTest.pass("Found the message");
		System.out.println(contactPage.errorMessage.getText());
//	                                                     	Errors occured, please try again1
		Assert.assertTrue(contactPage.errorMessage.getText().contains("Err111111111111111"));
		extentTest.pass("TEST CASE PASSED");
	}
}