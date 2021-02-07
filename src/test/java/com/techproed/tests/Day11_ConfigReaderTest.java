package com.techproed.tests;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBaseOld;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day11_ConfigReaderTest extends TestBaseOld {

@Test
public void googleTitleTest(){

	driver.get(ConfigReader.getProperty("url_google"));
//	driver.get(ConfigReader.getProperty("qa_environment_url"));
	String actualTitle = driver.getTitle();
	System.out.println(actualTitle);

	Assert.assertEquals(actualTitle,"Google");
}


}
