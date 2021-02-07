package com.techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethods {
	@Test(priority = 5)
	public void logIn(){
		System.out.println("Login Test");
		Assert.assertTrue(false);
	}
	@Test(dependsOnMethods = "logIn")
	public void homePage(){
		System.out.println("homePage Test");
	}
	@Test(priority = 3)
	public void search(){
		System.out.println("search Test");
	}
	@Test(priority = 4)
	public void results(){
		System.out.println("results Test");
	}
}
