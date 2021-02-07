package smokeTest;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day12_NegativeTest {
	WebElement userName;
	WebElement password;
	WebElement loginButton;


	@BeforeMethod
	public void login() {
		Driver.getDriver().get(ConfigReader.getProperty("qa_environment_url"));
		Driver.getDriver().findElement(By.id("navLogon")).click();
		userName = Driver.getDriver().findElement(By.id("UserName"));
		password = Driver.getDriver().findElement(By.id("Password"));
		loginButton = Driver.getDriver().findElement(By.id("btnSubmit"));
	}

	/*
	invalidPassword()
When user enters wrong password
Then verify the error message includes “Wrong password”
Test Data:
Url: https://qa-environment.crystalkeyhotels.com/
user: manager
pw: Manage!
	 */
	@Test(groups = "regression1")
	public void invalidPassword() {
		userName.sendKeys("manager");
		password.sendKeys("Manage!");
		loginButton.click();
//		String actualText = Driver.getDriver().findElement(By.id("divMessageResult")).getText();
//		System.out.println(actualText);
//		String actualText3 = Driver.getDriver().
//						findElement(By.xpath("//span[contains(text(), 'Try again please')]")).getText();

		String actualText2 = Driver.getDriver().
						findElement(By.xpath("//li[contains(text(), 'Username or password is incorrect')]")).getText();
		Assert.assertEquals(actualText2, "Username or password is incorrect, please correct them and try again");

	}

	@Test(groups = "regression1")
	public void invalidID() {
		/*
		invalidID()
When user enters wrong id
Then verify the error message includes “Try again please”
Test Data:
Url: https://qa-environment.crystalkeyhotels.com/
user: manager123
pw: Manager2!
		 */
		userName.sendKeys("manager123");
		password.sendKeys("Manager2!");
		loginButton.click();

//		String actualText3 = Driver.getDriver().
//						findElement(By.xpath("//span[contains(text(), 'Try again please')]")).getText();
//		Assert.assertEquals(actualText3, "Try again please");

		//Then verify the error message includes “Try again please”
		WebElement errorMessage = Driver.getDriver().findElement(By.id("divMessageResult"));
		String errorMessageText = errorMessage.getText();
		Assert.assertTrue(errorMessageText.contains("Try again please"));
	}

	@Test
	public void invalidIDAndPassword() {
		/*
		invalidIDAndPassword()
When user enters wrong id and wrong password
Then verify the error message includes “Username or password is incorrect, please correct them and try again”
Test Data:
Url: https://qa-environment.crystalkeyhotels.com/
user: manager123
pw: Manage!
		 */
		userName.sendKeys("manager123");
		password.sendKeys("Manage!");
		loginButton.click();

		WebElement errorMessage = Driver.getDriver().findElement(By.id("divMessageResult"));
		String errorMessageText = errorMessage.getText();
		Assert.assertTrue(errorMessageText.
						contains("Username or password is incorrect, please correct them and try again"));
	}

	@AfterMethod
	public void tearDown(){
		Driver.closeDriver();
	}
}
