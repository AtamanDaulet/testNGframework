package excelautomation;

import com.techproed.pages.datatablesNetPages.DataTablesMain;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ExcelUtil;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class Day16_ExcelAutomationWithDateFormat {

	ExcelUtil excelUtil;
	List<Map<String, String>> testData;

	DataTablesMain dataTablePage;

	@Test(groups = "regression1")
	public void dataTables() throws InterruptedException {
		excelUtil = new ExcelUtil("src/test/java/resources/exceldata.xlsx",
						"datatablessheet");
		testData = excelUtil.getDataList();
		System.out.println(testData);

		Driver.getDriver().get(ConfigReader.getProperty("dt_url"));

		dataTablePage = new DataTablesMain();


			for (Map person: testData  ) {

				String oldDateString = person.get("startdate").toString();
//				System.out.println(oldDateString);
				LocalDate datetime = LocalDate.parse(oldDateString, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
				String newDateString = datetime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

//				System.out.println(newDateString);

				dataTablePage.newBtn.click();

					Thread.sleep(1000);

			dataTablePage.firstName.sendKeys(person.get("firstname").toString());
			dataTablePage.lastName.sendKeys(person.get("lastname").toString());
			dataTablePage.position.sendKeys(person.get("position").toString());
			dataTablePage.office.sendKeys(person.get("office").toString());
			dataTablePage.extn.sendKeys(person.get("extension").toString());
			dataTablePage.startDate.sendKeys(newDateString);
			dataTablePage.salary.sendKeys(person.get("salary").toString());
			dataTablePage.createBnt.click();
	//		WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
				dataTablePage.search.clear();
				dataTablePage.search.sendKeys(person.get("firstname").toString());

				Thread.sleep(1000);

			String actualName = dataTablePage.nameField.getText();
			Assert.assertEquals(actualName,
							person.get("firstname").toString()+" "+person.get("lastname").toString());

				dataTablePage.search.clear();
		}
	}
}
