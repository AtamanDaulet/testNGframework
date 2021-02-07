package com.techproed.tests;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class Day11_FirstDriverClass {
	@Test
	public void firstDriverTest(){

		Driver.getDriver().get(ConfigReader.getProperty("qa_environment_url"));
		String actualTitle = Driver.getDriver().getTitle();
		System.out.println(actualTitle);
	}
}
