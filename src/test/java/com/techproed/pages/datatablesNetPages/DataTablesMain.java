package com.techproed.pages.datatablesNetPages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataTablesMain {
	public DataTablesMain(){
		PageFactory.initElements(Driver.getDriver(),this);
	}
	@FindBy(xpath = "//div[@class = 'dt-buttons']/button/span")
	public WebElement newBtn;
	@FindBy(id = "DTE_Field_first_name")
	public WebElement firstName;
	@FindBy(id = "DTE_Field_last_name")
	public WebElement lastName;
	@FindBy(id = "DTE_Field_position")
	public WebElement position;
	@FindBy(id = "DTE_Field_office")
	public WebElement office;
	@FindBy(id = "DTE_Field_extn")
	public WebElement extn;
	@FindBy(id = "DTE_Field_start_date")
	public WebElement startDate;
	@FindBy(id = "DTE_Field_salary")
	public WebElement salary;
	@FindBy(xpath = "//button[.='Create']")
	public WebElement createBnt;
	@FindBy(xpath = "//input[@type='search']")
	public WebElement search;
	@FindBy(xpath = "//td[@class = 'sorting_1']")
	public WebElement nameField;
}
