package com.techproed.tests;

import com.techproed.utilities.TestBaseOld;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class day08_IFrameTest extends TestBaseOld {
	/*
	Go to https://the-internet.herokuapp.com/iframe





	 */
	@Test
	public void iframeTest(){
//		Verify the Bolded text contains “Editor”
		driver.get("https://the-internet.herokuapp.com/iframe");
		String editor_h3Text = driver.findElement(By.tagName("h3")).getText();
		Assert.assertTrue(editor_h3Text.contains("Editor"));
		//Locate the text box
		// Delete the text in the text box
		WebElement textBox = driver.switchTo().frame(0).findElement(By.xpath("//body[@id='tinymce']/p"));
		textBox.clear();
//		Type “This text box is inside the iframe”
		textBox.sendKeys("This text box is inside the iframe");
//		Verify the text Elemental Selenium text is displayed on the page
		String textElemental = driver.switchTo().
						defaultContent().findElement(By.xpath("//a[@href='http://elementalselenium.com/']")).getText();
		Assert.assertTrue(textElemental.contains("Elemental"));
	}
}
