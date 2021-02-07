package com.techproed.tests;

import com.techproed.pages.FaceLogin;
import com.techproed.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day13_FaceLogin {
	FaceLogin faceLogin;


	@Test
	public void login(){
		Driver.getDriver().get("https://www.facebook.com/");
		faceLogin = new FaceLogin();
		faceLogin.username.sendKeys("fakeusername");
		faceLogin.password.sendKeys("fakepassword");
		faceLogin.loginButton.click();

		WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
		wait.until(ExpectedConditions.visibilityOf(faceLogin.errorMessage));

		String expectedErrorMessage="The password you’ve entered is incorrect. Forgot Password?";

		Assert.assertEquals(faceLogin.errorMessage.getText(),expectedErrorMessage);
	}
}
