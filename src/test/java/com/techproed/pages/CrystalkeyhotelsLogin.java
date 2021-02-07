package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrystalkeyhotelsLogin {
	public CrystalkeyhotelsLogin(){
		PageFactory.initElements(Driver.getDriver(), this);
	}
	@FindBy(id = "UserName")
	public WebElement userName;

	@FindBy(id = "Password")
	public WebElement password;

	@FindBy(id = "btnSubmit")
	public  WebElement loginBtn;


}
