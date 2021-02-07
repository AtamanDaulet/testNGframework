package com.techproed.crossBrowserTest;

import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseCross;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
public class NegativeTest extends TestBaseCross {
	WebDriverWait wait;

	@Test
	public void invalidID(){
		driver.get("https://qa-environment.crystalkeyhotels.com/Account/Logon");
		WebElement userName=driver.findElement(By.id("UserName"));
		WebElement password=driver.findElement(By.id("Password"));
		WebElement loginButton=driver.findElement(By.id("btnSubmit"));
		userName.sendKeys("manar2");
		password.sendKeys("manager2!");
		loginButton.click();
	}
	@Test
	public void invalidPass(){
		driver.get("https://qa-environment.crystalkeyhotels.com/Account/Logon");
		WebElement userName=driver.findElement(By.id("UserName"));
		WebElement password=driver.findElement(By.id("Password"));
		WebElement loginButton=driver.findElement(By.id("btnSubmit"));
		userName.sendKeys("manager");
		password.sendKeys("mana2!");
		loginButton.click();
	}
	@Test
	public void invalidIDPass(){
		wait = new WebDriverWait(Driver.getDriver(),10);
		driver.get("https://qa-environment.crystalkeyhotels.com/Account/Logon");
		WebElement userName=driver.findElement(By.id("UserName"));
		WebElement password=driver.findElement(By.id("Password"));
		WebElement loginButton=driver.findElement(By.id("btnSubmit"));
		wait.until(ExpectedConditions.visibilityOf(userName));
		userName.sendKeys("mager2");
		password.sendKeys("mana2!");
		loginButton.click();
	}
}

