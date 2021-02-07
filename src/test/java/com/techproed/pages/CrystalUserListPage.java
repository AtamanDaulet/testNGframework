package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrystalUserListPage {
	public CrystalUserListPage(){
		PageFactory.initElements(Driver.getDriver(), this);
	}
	@FindBy(xpath = "//a[@href = '/admin/userAdmin/Create']")
	public WebElement addUserBtn;
}
