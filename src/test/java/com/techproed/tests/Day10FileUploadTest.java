package com.techproed.tests;

import com.techproed.utilities.TestBaseOld;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day10FileUploadTest extends TestBaseOld {
	/*
	When user goes to https://the-internet.herokuapp.com/upload
And click on the chooseFile button
And selects an image from the computer
And click on the upload button
Then verify the File uploaded!  Message displayed
	 */
	@Test
	public void fileUploadTest(){
		driver.get("https://the-internet.herokuapp.com/upload");

		WebDriverWait wait = new WebDriverWait(driver, 20);

		WebElement chooseAFile=driver.findElement(By.id("file-upload"));

		String path = "C:\\Users\\hi\\Desktop\\Screen Shot 2020-10-10 at 4.23.44 PM.png";

		//send the path of the file to chooseAFile element
		chooseAFile.sendKeys(path);

		//Locating upload button and clicking on it
		WebElement upload=driver.findElement(By.id("file-submit"));
		upload.click();

		//Locating the uploaded message and Verifying the text
		String uploadedMessage=driver.findElement(By.xpath("//h3")).getText();
		Assert.assertEquals(uploadedMessage,"File Uploaded!");


	}
}
