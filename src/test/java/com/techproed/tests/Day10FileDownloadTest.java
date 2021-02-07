package com.techproed.tests;

import com.techproed.utilities.TestBaseOld;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class Day10FileDownloadTest extends TestBaseOld {
	/*
	Create a class:FileDownloadTest
	downloadTest()
	In the downloadTest() method, do the following test:
	Go to https://the-internet.herokuapp.com/download
	Download flower.png file
	Then verify if the file downloaded successfully
	 */
	@Test
	public void downloadTest() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/download");
		driver.findElement(By.xpath("//a[.='flower.jpg']")).click();

//After click, file will be downloaded on the downloads folder
		//Get the path of the file that is in download folder
		//And check is the path exist

		//User folder + "\Downloads\flower.jpg"
		String userFolder=System.getProperty("user.home");// /Users/techproed  =>gives you the user folder


		// need wait until download  1 WAY
//		Thread.sleep(3000);
//		String path = "C:\\Users\\hi\\Downloads\\flower.jpg";

		// 2 Way--------------
		//HOMEWORK : Try to handle this wait issue using explicit wait
		//Pointing to the flower.jpg in the Downloads folder
		String path1 = userFolder + "\\Downloads\\flower.jpg";
		File targetFile = new File(path1);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
						withTimeout(20, TimeUnit.SECONDS).
						pollingEvery(1,TimeUnit.SECONDS);
		wait.until(webDriver -> targetFile.exists());
//----------------------------

		boolean isDownloaded = Files.exists(Paths.get(path1));
//This pass is isFileExist in the downloaded folder
		Assert.assertTrue(isDownloaded);
	}
}
