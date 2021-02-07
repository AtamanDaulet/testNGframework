package com.techproed.tests;

import org.testng.annotations.*;

public class TestNGAnnotations {
	/*
	Create Project: File -> New -> Project-> Select maven -> click next
Name:testNGframework->finish->click on EnableAutoImport
Right click on java create the package. package name: com.techproed
Right click on java create another package. package name: com.techproed.tests
Right click on tests package and create a java class. Class name: TestNGAnnotations
Add the dependencies on you pom.xml file:
Get the dependencies mvnrepository.com
selenium java,
webdrivermanager,
testNG
Right click on java and create the package: com.techproed.tests
Right click on com.techproed.tests  and create another package.: com.techproed.utilities
	 */
	@BeforeMethod
	public void setUp(){
		System.out.println("Before Method");
	}
	@AfterMethod
	public void tearDown(){
		System.out.println("After Method");
	}

	@Test
	public void test1(){
		System.out.println("Test01");
	}
	@Test(priority = -2)
	public void test2(){
		System.out.println("Test02");
	}
	@Ignore
	@Test(priority = 1)
	public void test3(){
		System.out.println("Test03");
	}
	@Test(priority = 3)
	public void test4(){
		System.out.println("Test04");
	}
}
