package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrystalMainPage {
	public CrystalMainPage(){
		PageFactory.initElements(Driver.getDriver(),this);
	}
	@FindBy(id = "navLogon")
	public WebElement login;
}
