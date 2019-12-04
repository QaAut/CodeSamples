package by.onliner.goodsorder;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageclasses.CartPage;
import pageclasses.GenericMethods;
import pageclasses.MainPage;
import pageclasses.PricesPage;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class BasketTest {
	private WebDriver driver;
	private String baseUrl;
	MainPage mainPageobj;
	PricesPage pricesPageobj;
	CartPage CartPageobj;
	private String itemToBeFound = "Xiaomi Mi9";
	private String itemExpected;
	private String itemActual;
	private double expected;
	private double actual;
	private boolean actualBool;

	@Test
	public void putItemInTheBasket() throws InterruptedException {
		mainPageobj = new MainPage(driver); // Create new instance for the main page
		mainPageobj.clickSearchField(); // Clicking the search field
		mainPageobj.typeInSearchField(itemToBeFound); // Typing in the search field
		itemExpected = mainPageobj.getNameOfItem(); // Saving the title of the first item
		mainPageobj.clickOnOffersForTheFIrstItem(); // Clicking see offers for the first item in the list
		pricesPageobj = new PricesPage(driver); // Create new instance for the main page
		pricesPageobj.putIntoBasket(); // Put the first item into the basket
		pricesPageobj.clickBasket(); // Clicking the basket icon
		CartPageobj = new CartPage(driver); // Create new instance of Cart Page
		itemActual = CartPageobj.getItemName(); // Saving the title of the item in the basket
		Assert.assertEquals(itemActual, itemExpected); // Comparing 2 titles

	}

	@Test(dependsOnMethods = { "putItemInTheBasket" })
	public void increasItemByNumber() {
		itemExpected = CartPageobj.getSumOfOrder(); // Saving the sum of the original order
		CartPageobj.clearQuanBox(); // CLearing quantity box from the previous number
		CartPageobj.increaseNumber(); // Sending number 2 to the quantity box
		itemActual = CartPageobj.getSumOfOrder(); // Saving the sum after increasing by 2
		itemExpected = GenericMethods.trimString(itemExpected);
		itemActual = GenericMethods.trimString(itemActual);
		expected = GenericMethods.convertStringToDouble(itemExpected); // converting expected item to double
		expected = expected * 2; // Increasing expected by 2
		actual = GenericMethods.convertStringToDouble(itemActual); // converting actual string to double
		actualBool = GenericMethods.compareDouble(actual, expected); // Comparing to doubles and saving boolean
		assertEquals(actualBool, true); //Comparing actual boolean with the expected result 

	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		baseUrl = "https://www.onliner.by/";

		// maximize the window
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		driver.get(baseUrl);

	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

}
