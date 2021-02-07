package com.techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day10FileExistTest {
	/*

	 */
@Test
	public void isExist(){
	//Path of a file that we want to test
	String path = "C:\\Users\\hi\\Desktop\\Screen Shot 2020-10-10 at 4.23.44 PM.png";

	//we need Java to deal with windows path=Files
	boolean isExist = Files.exists(Paths.get(path));

	//If file exist, returns true. If file doesn't exist, returns false.
	Assert.assertTrue(isExist);


}


}
