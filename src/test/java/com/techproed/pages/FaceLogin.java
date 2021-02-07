package com.techproed.pages;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceLogin {
	/*
	Create a new class: FaceLogin
Create a test method: logInTest() and test the following user story
When user enter invalid credentials, we should see sign up page
https://www.facebook.com/   --->Day13_FaceLogin
Username: fakeusername
Password: fakepassword
	 */

	public  FaceLogin(){

	PageFactory.initElements(Driver.getDriver(), this);
}
	@FindBy(id = "email")
	public WebElement username;

	@FindBy(id = "pass")
	public WebElement password;

	@FindBy(xpath = "//button[@type = 'submit']")
	public WebElement loginButton;

	@FindBy(className = "_9ay7")
	public WebElement errorMessage;


}
