package com.techproed.homeworks;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class SignInHomework {
	WebDriver driver;
	Faker faker = new Faker(new Locale("en_US"));
	String firstName = faker.name().firstName();
	String lastName = faker.name().lastName();
	String emailFake = faker.internet().emailAddress();

	//	Go to http://automationpractice.com/index.php
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}


	@Test
	public void createAccount() {
		//					3. Click on sign in button
		driver.findElement(By.xpath("//a[@class='login']")).click();
		//	4.Send your email and click on create an account button
		driver.findElement(By.id("email_create")).sendKeys(emailFake);
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();

	}

	//5.Verify the Text : CREATE AN ACCOUNT
	@Test(dependsOnMethods = "createAccount")
	public void verifyCreateAnAccount() {
		String actualCreateAnAccountText = driver.
						findElement(By.xpath("//h1[. ='Create an account']")).getText();
		String expectedCreateAnAccountText = "CREATE AN ACCOUNT";
		Assert.assertEquals(actualCreateAnAccountText, expectedCreateAnAccountText);
	}

	//6. Verify the Text : YOUR PERSONAL INFORMATION
	@Test(dependsOnMethods = "createAccount")
	public void verifyYOUR_PERSONAL_INFORMATION() {
		String actualYOUR_PERSONAL_INFORMATION = driver.
						findElement(By.xpath("//h3[. ='Your personal information']")).getText();
		String expectedYOUR_PERSONAL_INFORMATION = "YOUR PERSONAL INFORMATION";
		Assert.assertEquals(actualYOUR_PERSONAL_INFORMATION, expectedYOUR_PERSONAL_INFORMATION);
	}

	//	7. Verify the Text : Title
	@Test(dependsOnMethods = "createAccount")
	public void verifyTitle() {
		String actualTitle = driver.
						findElement(By.xpath("//label[.='Title']")).getText();
		String expectedTitle = "Title";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	//8. Select your title
	@Test(dependsOnMethods = "createAccount")
	public void selectTitle() {
		if (faker.demographic().sex().contains("Male")) {
			driver.findElement(By.xpath("//div[@id='uniform-id_gender1']")).click();
		} else {
			driver.findElement(By.xpath("//div[@id='uniform-id_gender2']")).click();
		}
	}

	//9. Enter your first name
	@Test(dependsOnMethods = "createAccount")
	public void enterFirstName() {
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).
						sendKeys(firstName);
	}

	//10. Enter your last name
	@Test(dependsOnMethods = "createAccount")
	public void enterLastName() {
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).
						sendKeys(lastName);
	}

	//11. Enter your email
	@Test(dependsOnMethods = "createAccount")
	public void enterEmail() {
//	driver.findElement(By.xpath("//input[@id='email']")).sendKeys(emailFake);
	}

	//12. Enter your password
	@Test(dependsOnMethods = "createAccount")
	public void enterPassword() {
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(faker.internet().password(6, 9));
	}

	//13. ENTER DATE OF BIRTH
	@Test(dependsOnMethods = "createAccount")
	public void enterDateOfBirth() {
		WebElement selectElement = driver.findElement(By.xpath("//select[@id='days']"));
		Select options = new Select(selectElement);

		String dayOfBirth[] = faker.date().birthday().toString().split(" ");
		String dayOfBirthString = dayOfBirth[2] + " " + dayOfBirth[1] + " " + dayOfBirth[5];

		DateTimeFormatter formatterCurrently = DateTimeFormatter.ofPattern("dd MMM yyyy");
		DateTimeFormatter formatterWithMonthDigit = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		String dayOfBirthLD = LocalDate.parse(dayOfBirthString, formatterCurrently).format(formatterWithMonthDigit);

		String dayOfBirthCorrect[] = dayOfBirthLD.split("-");

		String day = String.valueOf(Integer.parseInt(dayOfBirthCorrect[0]));
		String month = String.valueOf(Integer.parseInt(dayOfBirthCorrect[1]));
		String yearBirth = String.valueOf(Integer.parseInt(dayOfBirthCorrect[2]));

		options.selectByValue(day);

		WebElement selectMonth = driver.findElement(By.xpath("//select[@id='months']"));
		Select optionsMonth = new Select(selectMonth);

		optionsMonth.selectByValue(month);

		WebElement selectYear = driver.findElement(By.xpath("//select[@id='years']"));
		Select optionsYear = new Select(selectYear);

		optionsYear.selectByValue(yearBirth);
	}

	//14. Click on Sign up for our newsletter!
	@Test(dependsOnMethods = "createAccount")
	public void clickOnSignUp() {
		WebElement checkboxNewsletter =
						driver.findElement(By.xpath("//input[@id='newsletter']"));

		if (!checkboxNewsletter.isSelected()) {
			checkboxNewsletter.click();
		}
	}

	//15. Enter your first name
	@Test(dependsOnMethods = "createAccount")
	public void enterFirstName2() {
		WebElement firstName2 = driver.findElement(By.xpath("//input[@id='firstname']"));
		firstName2.clear();
		firstName2.sendKeys(firstName);
	}

	//16. Enter your last lane
	@Test(dependsOnMethods = "createAccount")
	public void enterLastName2() {
		WebElement lastName2 = driver.findElement(By.xpath("//input[@id='lastname']"));
		lastName2.clear();
		lastName2.sendKeys(lastName);
	}

	//17. Enter your company
	@Test(dependsOnMethods = "createAccount")
	public void enterCompany() {
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys(faker.company().name());
	}

	//18. Enter your Address
	@Test(dependsOnMethods = "createAccount")
	public void enterAddress() {
		driver.findElement(By.xpath("//input[@id='address1']")).
						sendKeys(faker.address().streetAddress());
	}

	//19. Enter your City
	@Test(dependsOnMethods = "createAccount")
	public void enterCity() {
		driver.findElement(By.xpath("//input[@id='city']")).
						sendKeys(faker.address().cityName());
	}

	//20. SELECT STATE
	@Test(dependsOnMethods = "createAccount")
	public void enterSTATE() {
		WebElement stateEl = driver.findElement(By.xpath("//select[@id='id_state']"));
		Select options = new Select(stateEl);
		options.selectByValue("43");
	}

	//21. Enter Postal Code
	@Test(dependsOnMethods = "createAccount")
	public void enterPostal() {
		driver.findElement(By.xpath("//input[@id='postcode']")).
						sendKeys(faker.address().zipCode().substring(0, 5));
	}

	//22.SELECT COUNTRY
	//There is default US.
//23. Enter additional information
	@Test(dependsOnMethods = "createAccount")
	public void enterAdditionalInformation() {
		driver.findElement(By.xpath("//textarea[@id='other']")).
						sendKeys(faker.lorem().characters(20));
	}

	//24. Enter home phone
	@Test(dependsOnMethods = "createAccount")
	public void enterHomePhone() {
		driver.findElement(By.xpath("//input[@id='phone']")).
						sendKeys(faker.numerify("+1###-###-####"));
	}

	//25. Enter mobile phone
	@Test(dependsOnMethods = "createAccount")
	public void enterMobilePhone() {
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).
						sendKeys(faker.numerify("+1###-###-####"));
	}

	//26. Enter reference name
	@Test(dependsOnMethods = "createAccount")
	public void enterReferenceName() {
		WebElement reference = driver.findElement(By.xpath("//input[@id='alias']"));
		reference.clear();
		reference.sendKeys(faker.address().streetAddress());
	}

	//27. Click Register
	@Test(dependsOnMethods = "createAccount", priority = 1)
	public void clickRegister() {
		driver.findElement(By.xpath("//button[@id='submitAccount']")).click();

	}

	//20. Then verify MY ACCOUNT is displayed on the home page-SEE BELOW IMAGE
	@Test(dependsOnMethods = "createAccount", priority = 2)
	public void verifyMyAccount() {
		String actualMyAccountText = driver.findElement(By.xpath("//h1[.= 'My account']")).getText();
		String expectedMyAccountText = "MY ACCOUNT";
		Assert.assertEquals(actualMyAccountText, expectedMyAccountText);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
