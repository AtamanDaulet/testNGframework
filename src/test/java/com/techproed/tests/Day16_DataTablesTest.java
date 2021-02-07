package com.techproed.tests;

import com.techproed.pages.datatablesNetPages.DataTablesMain;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day16_DataTablesTest {
	/*
	 Given user is on the datatables
    And user clicks on new button
    And user enters firstname
    And user enters lastname
    And user enters position
    And user enters office
    And user enters extension
    And user enters startdate
    And user enters salary
    And clicks create button
    And user enters firstname in the searchbox
    Then verify that user see the first name in the searchbox
	 */
	DataTablesMain dataTablePage;

@BeforeMethod
	public void setUp(){
	dataTablePage = new DataTablesMain();

	Driver.getDriver().get(ConfigReader.getProperty("dt_url"));

}
@Test
	public void dataTables(){
	dataTablePage.newBtn.click();
	dataTablePage.firstName.sendKeys("John");
	dataTablePage.lastName.sendKeys("Adam");
	dataTablePage.position.sendKeys("Sdet");
	dataTablePage.office.sendKeys("NY");
	dataTablePage.extn.sendKeys("123");
	dataTablePage.startDate.sendKeys("2021-01-19");
	dataTablePage.salary.sendKeys("500000");
	dataTablePage.createBnt.click();
	WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

	dataTablePage.search.sendKeys("John");
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	String actualName = dataTablePage.nameField.getText();
	Assert.assertEquals(actualName,"John Adam");

}



}