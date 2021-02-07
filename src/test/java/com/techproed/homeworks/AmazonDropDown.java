package com.techproed.homeworks;

import com.techproed.utilities.TestBaseOld;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AmazonDropDown extends TestBaseOld {
	/*
	Create A Class: AmazonDropdown
Create A Method dropdownTest
	 */

	//	Go to https://www.amazon.com/
	@Test
	public void dropdownTest() {
		driver.get("https://www.amazon.com");

//	Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
		WebElement departmentsDropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

//	Print the first selected option and assert if it equals “All Departments”
		Select optionsOfDepartment = new Select(departmentsDropDown);
		String actualSelectedOption = optionsOfDepartment.getFirstSelectedOption().getText();
		System.out.println("The first selected option " + actualSelectedOption);
		Assert.assertEquals(actualSelectedOption, "All Departments", "Selected Option");
//		Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.
//		(after you select you need to use get first selected option method)
		String option4thIndex = optionsOfDepartment.getOptions().get(4).getText();
		Assert.assertEquals(option4thIndex, "Amazon Devices", "option 4th Index");
//		Print all of the dropdown options
		List<String> allOptions = optionsOfDepartment.
						getOptions().
						stream().
						map(t -> t.getText().trim()).
						collect(Collectors.toList());

		System.out.println("All of the dropdown options: " + allOptions);

//		Print the total number of options in the dropdown
		System.out.println("The total number of options is " + allOptions.size());

//		Check if Appliances is a drop down option.
//		Print true if “Appliances” is an option. Print false otherwise.
		if (allOptions.contains("Appliances")) {
			System.out.println("Appliances is a drop down option");
		} else {
			System.out.println("Appliances is not a drop down option");
		}

//		BONUS: Check if the dropdown is in Alphabetical Order

		List<String> alphabeticalOrderAllOptions = new ArrayList<>();
		allOptions.stream().forEach(t -> alphabeticalOrderAllOptions.add(t));
		Collections.sort(alphabeticalOrderAllOptions);

		for (int i = 0; i < allOptions.size(); i++) {
			if (!allOptions.get(i).equals(alphabeticalOrderAllOptions.get(i))) {
				System.out.println("The dropdown is not in Alphabetical Order");
				break;
			}
			if (i == allOptions.size()-1) {
				System.out.println("The dropdown is in Alphabetical Order");
			}
		}

	}
}
