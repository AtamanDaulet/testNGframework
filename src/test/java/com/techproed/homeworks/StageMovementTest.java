package com.techproed.homeworks;

import com.github.javafaker.Faker;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class StageMovementTest {
	Faker faker = new Faker(new Locale("en_US"));
	String emailFake = "zxc123Test123@gmail.com";
	String password = "123456";

	@Ignore
	@Test
	public void createAccount(String emailFake, String password) {
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String gender = faker.demographic().sex();
		String dayBirth = "5";
		String monthBirth = "2";
		String yearBirth = "2000";
		String companyName = faker.company().name();
		String addressStreet = faker.address().streetAddress();
		String city = faker.address().cityName();
		String stateTx = "43";
		String zipCode = faker.address().zipCode().substring(0, 5);
		String homePhone = faker.numerify("+1###-###-####");

		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//	Go to http://automationpractice.com/index.php
		Driver.getDriver().get("http://automationpractice.com/index.php");

		//	3. Click on sign in button
		Driver.getDriver().findElement(By.xpath("//a[@class='login']")).click();

		//	4.Send your email and click on create an account button
		Driver.getDriver().findElement(By.id("email_create")).sendKeys(emailFake);
		Driver.getDriver().findElement(By.xpath("//button[@id='SubmitCreate']")).click();

		//5.Verify the Text : CREATE AN ACCOUNT

		String actualCreateAnAccountText = Driver.getDriver().
						findElement(By.xpath("//h1[. ='Create an account']")).getText();
		String expectedCreateAnAccountText = "CREATE AN ACCOUNT";
		Assert.assertEquals(actualCreateAnAccountText, expectedCreateAnAccountText);

		//8. Select your title
		if (gender.contains("Male")) {
			Driver.getDriver().findElement(By.xpath("//div[@id='uniform-id_gender1']")).click();
		} else {
			Driver.getDriver().findElement(By.xpath("//div[@id='uniform-id_gender2']")).click();
		}

		//9. Enter your first name
		Driver.getDriver().findElement(By.xpath("//input[@id='customer_firstname']")).
						sendKeys(firstName);

		//10. Enter your last name
		Driver.getDriver().findElement(By.xpath("//input[@id='customer_lastname']")).
						sendKeys(lastName);

		//12. Enter your password
		Driver.getDriver().findElement(By.xpath("//input[@id='passwd']")).sendKeys(password);


		//13. ENTER DATE OF BIRTH
		WebElement selectElement = Driver.getDriver().findElement(By.xpath("//select[@id='days']"));
		Select optionsDay = new Select(selectElement);

		optionsDay.selectByValue(dayBirth);

		WebElement selectMonth = Driver.getDriver().findElement(By.xpath("//select[@id='months']"));
		Select optionsMonth = new Select(selectMonth);

		optionsMonth.selectByValue(monthBirth);

		WebElement selectYear = Driver.getDriver().findElement(By.xpath("//select[@id='years']"));
		Select optionsYear = new Select(selectYear);

		optionsYear.selectByValue(yearBirth);


		//14. Click on Sign up for our newsletter!
		WebElement checkboxNewsletter =
						Driver.getDriver().findElement(By.xpath("//input[@id='newsletter']"));

		if (!checkboxNewsletter.isSelected()) {
			checkboxNewsletter.click();
		}

		//17. Enter your company
		Driver.getDriver().findElement(By.xpath("//input[@id='company']")).sendKeys(companyName);

		//18. Enter your Address
		Driver.getDriver().findElement(By.xpath("//input[@id='address1']")).
						sendKeys(addressStreet);

		//19. Enter your City
		Driver.getDriver().findElement(By.xpath("//input[@id='city']")).
						sendKeys(city);

		//20. SELECT STATE
		WebElement stateEl = Driver.getDriver().findElement(By.xpath("//select[@id='id_state']"));
		Select options43 = new Select(stateEl);
		options43.selectByValue(stateTx);

		//21. Enter Postal Code
		Driver.getDriver().findElement(By.xpath("//input[@id='postcode']")).
						sendKeys(zipCode);

		//24. Enter home phone
		Driver.getDriver().findElement(By.xpath("//input[@id='phone']")).
						sendKeys(homePhone);

		//25. Enter mobile phone
		Driver.getDriver().findElement(By.xpath("//input[@id='phone_mobile']")).
						sendKeys(homePhone);

		//27. Click Register
		Driver.getDriver().findElement(By.xpath("//button[@id='submitAccount']")).click();

		Driver.getDriver().findElement(By.xpath("//a[@title= 'My Store']")).click();


	}

	@Test
	public void stageMovements() {
		//	Go to http://automationpractice.com/index.php
		Driver.getDriver().get("http://automationpractice.com/index.php");

//		Click on Add To Cart
		WebElement primeButton = Driver.getDriver().findElement(By.xpath("//ul[@id='homefeatured']/li"));
		Actions actions = new Actions(Driver.getDriver());
		actions.moveToElement(primeButton).perform();    //Hover
		Driver.getDriver().findElement(By.xpath("//a[@data-id-product = '1']")).click();

//			And verifies the product is added to the cart

		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(.,'Product successfully ')]")));

		WebElement actualCartTitle = Driver.getDriver().
						findElement(By.xpath("//h2[contains(.,'Product successfully')]"));
//		System.out.println(actualCartTitle.getText());

		Assert.assertTrue(actualCartTitle.isDisplayed());

//			And verifies the color, size, quantity, price, shipping, Total Price
		String colorAndSize = Driver.getDriver().
						findElement(By.id("layer_cart_product_attributes")).getText();
//		System.out.println("2: " + color);
		Assert.assertEquals(colorAndSize, "Orange, S");

		//quantity
		String actualQuantity = Driver.getDriver().
						findElement(By.id("layer_cart_product_quantity")).getText();
		Assert.assertEquals(actualQuantity, "1");

//		price
		String actualPrice = Driver.getDriver().
						findElement(By.id("layer_cart_product_price")).getText();
		Assert.assertEquals(actualPrice, "$16.51");

		//		shipping
		String actualShipping = Driver.getDriver().
						findElement(By.xpath("//span[@class = 'ajax_cart_shipping_cost']")).getText();
		Assert.assertEquals(actualShipping, "$2.00");

//		Total Price
		String actualTotalPrice = Driver.getDriver().
						findElement(By.xpath("//span[@class = 'ajax_block_cart_total']")).getText();
		Assert.assertEquals(actualTotalPrice, "$18.51");

//			And clicks on Proceed to checkout
		Driver.getDriver().
						findElement(By.xpath("//a[@title= 'Proceed to checkout']")).click();

//		Then verify Summary card is displayed
		WebElement shoppingCartSummary = Driver.getDriver().
						findElement(By.id("cart_title"));
		Assert.assertTrue(shoppingCartSummary.isDisplayed());

//		Then verify product is In stock
		WebElement actualInStock = Driver.getDriver().
						findElement(By.xpath("//td[@class= 'cart_avail']/span"));
		Assert.assertTrue(actualInStock.isDisplayed());

//		Then verify the Unit price matches the price that is on the Add To Card page
		String actualUnitPrice = Driver.getDriver().findElement(By.id("product_price_1_1_0")).getText();
		Assert.assertEquals(actualUnitPrice, actualPrice);

//		And user clicks on + sign
		Driver.getDriver().findElement(By.id("cart_quantity_up_1_1_0_0")).click();

		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("total_product_price_1_1_0"), "$16.51"));

//		Then verifies the TOTAL price is 2*price+shipping
		String actualTotalPrice2Items = Driver.getDriver().
						findElement(By.xpath("//span[@id='total_price']")).
						getText().
						substring(1);

		String expectedTotal = String.valueOf(Double.parseDouble(actualUnitPrice.substring(1)) * 2
						+ Double.parseDouble(actualShipping.substring(1)));

		Assert.assertEquals(actualTotalPrice2Items, expectedTotal);

//		And click on Proceed to checkout
		Driver.getDriver().findElement(By.partialLinkText("Proceed to checkout")).click();

//		Then verify sign in page displayed
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[.='Authentication']")));
		WebElement isAuthenticationTextDisplayed = Driver.getDriver().findElement(By.xpath("//h1[.='Authentication']"));

		Assert.assertTrue(isAuthenticationTextDisplayed.isDisplayed());

//		Then user enters username password and sign in
		Driver.getDriver().findElement(By.id("email")).sendKeys(emailFake);
		Driver.getDriver().findElement(By.id("passwd")).sendKeys(password);
		Driver.getDriver().findElement(By.id("SubmitLogin")).click();

//		Then Verify user in on the Address stage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[.='Addresses']")));
		WebElement isAddressesTextDisplayed = Driver.getDriver().findElement(By.xpath("//h1[.='Addresses']"));

		Assert.assertTrue(isAddressesTextDisplayed.isDisplayed());

//		And click on Proceed to checkout
		Driver.getDriver().findElement(By.name("processAddress")).click();

//		Then verify user moves to Shipping stage(SHIPPING)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[.='Shipping']")));
		WebElement isShippingTextDisplayed = Driver.getDriver().findElement(By.xpath("//h1[.='Shipping']"));

		Assert.assertTrue(isShippingTextDisplayed.isDisplayed());

//		And click on Proceed to checkout
		Driver.getDriver().findElement(By.name("processCarrier")).click();

//		Then verify the error message: You must agree to the terms of service before continuing.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class = 'fancybox-error']")));
		WebElement isErrorTextDisplayed = Driver.getDriver().findElement(By.xpath("//p[@class = 'fancybox-error']"));
		System.out.println(isErrorTextDisplayed.getText());
		Assert.assertTrue(isErrorTextDisplayed.isDisplayed());

//		Then click on x to exit out
		Driver.getDriver().findElement(By.xpath("//a[@title = 'Close']")).click();

//		And click on Terms of service checkbox
		WebElement cgvCheckbox = Driver.getDriver().findElement(By.id("cgv"));
		if (!cgvCheckbox.isSelected()) {
			cgvCheckbox.click();
		}

//		And click on Proceed to checkout
		Driver.getDriver().findElement(By.name("processCarrier")).click();

//		Then verify user is on Payment stage(PLEASE CHOOSE YOUR PAYMENT METHOD)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class = 'navigation_page']")));
		WebElement isPaymentMethodTextDisplayed = Driver.getDriver().
						findElement(By.xpath("//span[@class = 'navigation_page']"));
		System.out.println(isPaymentMethodTextDisplayed.getText());
		Assert.assertTrue(isPaymentMethodTextDisplayed.isDisplayed());
	}

//		@AfterClass
//		public void tearDown() {
//			Driver.getDriver().quit();
//		}


}
