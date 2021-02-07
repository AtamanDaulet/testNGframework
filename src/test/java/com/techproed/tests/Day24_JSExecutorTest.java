package com.techproed.tests;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.JSUtils;
import com.techproed.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Day24_JSExecutorTest {
	@Test
	public void jsExecutorTest(){
		Driver.getDriver().get(ConfigReader.getProperty("qa_environment_url"));
		WebElement element1 = Driver.getDriver().findElement(By.xpath("(//h2)[10]"));
		System.out.println(element1.isDisplayed());
		System.out.println("1");

		JavascriptExecutor je = (JavascriptExecutor) Driver.getDriver();
		je.executeScript("arguments[0].scrollIntoView(true);",element1);
		ReusableMethods.waitFor(2);
		System.out.println(element1.isDisplayed());
		System.out.println("2");


	}

	@Test
	public void JSExecutorTest2(){
		Driver.getDriver().get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
		WebElement element2 = Driver.getDriver().findElement(By.xpath("//*[@id='mCSB_3_container']/p[3]"));
		ReusableMethods.waitFor(2);
		System.out.println(element2.isDisplayed());
		System.out.println("3");

		JavascriptExecutor je=(JavascriptExecutor) Driver.getDriver();
		je.executeScript("arguments[0].scrollIntoView(true);",element2);
		ReusableMethods.waitFor(2);
		System.out.println(element2.isDisplayed());
		System.out.println("4");
	}
	@Test
	public void JSExecutorTest3(){
		Driver.getDriver().get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
		WebElement element3 = Driver.getDriver().findElement(By.xpath("//*[@id='mCSB_3_container']/p[9]/textarea"));
		ReusableMethods.waitFor(2);
		System.out.println(element3.isDisplayed());
		System.out.println("5");

		JavascriptExecutor je=(JavascriptExecutor) Driver.getDriver();
		je.executeScript("arguments[0].scrollIntoView(true);",element3);
		ReusableMethods.waitFor(2);
		System.out.println(element3.isDisplayed());
		element3.clear();
		element3.sendKeys("123");
		System.out.println("6");

		//        We have JSUtils class in our Utilities
//        We should use the nethods from that class.
//        So as always we should seperate our actual test cases from the set up related tasks
		WebElement element2=Driver.getDriver().findElement(By.xpath("(//img[@src='images/img5.jpg'])[2]"));
		JSUtils.scrollIntoVIewJS(element2);
//        je.executeScript("arguments[0].scrollIntoView(true);",element2);
		boolean imageIsDisplayed=element2.isDisplayed();
		System.out.println(imageIsDisplayed);

	}
	@Test
	public void JSExecutorTest4(){
		Driver.getDriver().get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
		WebElement element4 = Driver.getDriver().findElement(By.xpath("//*[@id='mCSB_3_container']/p[9]/textarea"));
		ReusableMethods.waitFor(2);
		System.out.println(element4.isDisplayed());
		System.out.println("7");

		JSUtils.scrollIntoVIewJS(element4);

		ReusableMethods.waitFor(2);
		System.out.println(element4.isDisplayed());
		element4.clear();
		element4.sendKeys("123");
		System.out.println("8");
	}
	@Test
	public void JSExecutorTest5(){
		Driver.getDriver().get("https://qa-environment.crystalkeyhotels.com/Account/Logon");
		WebElement loginButton = Driver.getDriver().findElement(By.xpath("//input[@id='btnSubmit']"));

		JSUtils.flash(loginButton);

	}
}
/*
Day24
				=====================
				Javascript Executor:
				-Javascript Executor can be used to handle the web page elements
				-We can change the color, scroll to an element, click on an element,...
				-One of the main reason is we can get exeption when we do testing.
				-The reason is not wait issue, or locator issue.But the reason can be element is not displayed on the page bacuse of the scroll bars
				-In this case, we can use Javascript executor.
				JavascriptExecutor je = (JavascriptExecutor) Driver.getDriver();
				WebElement element = Driver.findElement(By.xpath("//p"));
				je.executeScript("arguments[0].scrollIntoView(true);",element);
				-Some pages can have multiple scroll bars
				-In this case, we can get some selenium exeptions
				---->>>org.openqa.selenium.ElementNotInteractableException: element not interactable
				-We got this exception, because we try to interact with an element that is ON THE PAGE
				   but CANNOT BE SEEN BY SELENIUM DUE TO THE SCROLL ISSUE.
				   SO WE MUST SCROLL DOWN TO THE ELEMENT SO IT CAN BE INTERACTABLE
				-We use javascript executor from our Javascript utilities class.For example:
				JSUtils.scrollIntoVIewJS(element);
				===========DATA PROVIDER================
				DataProvider is a TestNG annotation
				It can be used with testng only
				It is used to provide test data for test cases
				We create a 2d array to get the data.
				Use   @DataProvider(name = "smoke test data"){}
				||                     ||
				Annotation name          We provide this name in TestNG parameter
				||                     ||
@Test(dataProvider = "smoke test data")
public void loginTest(String user,String pass){}
*/
