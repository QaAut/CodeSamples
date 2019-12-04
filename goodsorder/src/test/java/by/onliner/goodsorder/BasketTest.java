package by.onliner.goodsorder;

import org.testng.annotations.Test;

import dataProviders.DataProvider1;
import junit.framework.Assert;
import pageclasses.CartPage;
import pageclasses.GenericMethods;
import pageclasses.MainPage;
import pageclasses.PricesPage;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
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

	@Test(priority = 0) // This method checks that we can put an item into the basket
	public void test1() throws InterruptedException {
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

	@Test(priority = 1, dataProvider = "quantityBox", dataProviderClass = DataProvider1.class) // This method checks
																								// that we can increase
																								// quantity by inputing
																								// number
	public void test2(String inputNumber) {
		itemExpected = CartPageobj.getSumOfOrder(); // Saving the sum of the original order
		CartPageobj.clearQuanBox(); // CLearing quantity box from the previous number
		CartPageobj.increaseNumber(inputNumber); // Sending the desired number to the quantity box
		itemActual = CartPageobj.getSumOfOrder(); // Saving the sum after increasing 
		itemExpected = GenericMethods.trimString(itemExpected); // Removing spaces from the String and replacing , with .												
		itemActual = GenericMethods.trimString(itemActual);// Removing spaces from the String and replacing , with .
		expected = GenericMethods.convertStringToDouble(itemExpected); // converting expected item to double
		expected = expected * GenericMethods.convertStringToDouble(inputNumber); // Increasing expected 
		actual = GenericMethods.convertStringToDouble(itemActual); // converting actual string to double
		actualBool = GenericMethods.compareDouble(actual, expected); // Comparing to doubles and saving boolean
		CartPageobj.clearQuanBox(); // CLearing quantity box from the previous number
		CartPageobj.increaseNumber("1"); //Setting quantity back to 1
		assertEquals(actualBool, true); // Comparing actual boolean with the expected result

	}

	@Test(priority = 3) // This method checks that we can increase quantity by pressing increase button
	public void test3() throws AWTException {
		itemExpected = CartPageobj.getSumOfOrder(); //Saving the sum of the original order
		CartPageobj.clickIncrQuant(); //Clicking the increase button
		itemActual = CartPageobj.getSumOfOrder(); // Saving the sum after increasing 
		itemExpected = GenericMethods.trimString(itemExpected); // Removing spaces from the String and replacing , with .												
		itemActual = GenericMethods.trimString(itemActual);// Removing spaces from the String and replacing , with .
		expected = GenericMethods.convertStringToDouble(itemExpected); // converting expected item to double
		expected = expected * 2; // Increasing expected by 2 
		actual = GenericMethods.convertStringToDouble(itemActual); // converting actual string to double
		actualBool = GenericMethods.compareDouble(actual, expected); // Comparing to doubles and saving boolean
		assertEquals(actualBool, true); // Comparing actual boolean with the expected result
	}
	
	@Test(priority = 4) // This method checks that we can decrease quantity by pressing decrease button
	public void test4() throws AWTException {
		itemExpected = CartPageobj.getSumOfOrder(); //Saving the sum of the original order
		CartPageobj.clickDecrQuant(); //Clicking the decrease button
		itemActual = CartPageobj.getSumOfOrder(); // Saving the sum after increasing 
		itemExpected = GenericMethods.trimString(itemExpected); // Removing spaces from the String and replacing , with .												
		itemActual = GenericMethods.trimString(itemActual);// Removing spaces from the String and replacing , with .
		expected = GenericMethods.convertStringToDouble(itemExpected); // converting expected item to double
		expected = expected / 2; // Increasing expected by 2 
		actual = GenericMethods.convertStringToDouble(itemActual); // converting actual string to double
		actualBool = GenericMethods.compareDouble(actual, expected); // Comparing to doubles and saving boolean
		assertEquals(actualBool, true); // Comparing actual boolean with the expected result
	}
	
	
	@Test(priority = 5) // This method removes an item from the basket 
	public void test5() {
		CartPageobj.removeItem();
	
		
	}
	@Test(priority = 6) // This method removes an item from the basket 
	public void test6() {
		
		
	}
	

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		baseUrl = "https://www.onliner.by/";
		driver.manage().window().maximize();		
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
