package com.techproed.tests;

import com.techproed.utilities.TestBaseOld;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestBaseDemo extends TestBaseOld {
	/*
	Create a class:TestBaseDemo
	Create two methods: test1, test2
	test1 search “porcelain teapot” on google
	Then verify page contains “porcelain teapot”
					——————————-
	test2 search “porcelain teapot” on amazon
	Then verify page contains “porcelain teapot”
	 */
	@Test
	public void test1() {
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("porcelain teapot" + Keys.ENTER);
		String pageSource = driver.getPageSource();
//		System.out.println(pageSource);
		Assert.assertTrue(pageSource.contains("porcelain teapot"));
	}

	@Test
	public void test2() {
		driver.get("https://www.amazon.com");
		driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']")).sendKeys("porcelain teapot" + Keys.ENTER);
		String pageSource = driver.getPageSource();
//		System.out.println(pageSource);
		Assert.assertTrue(pageSource.contains("porcelain teapot"));
	}

}
