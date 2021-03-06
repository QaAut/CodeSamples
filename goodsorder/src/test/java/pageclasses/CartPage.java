package pageclasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.sql.Driver;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	WebDriver driver;

	@FindBy(xpath = "//div[@class='cart-products']//a[@class='cart-product__remove']")
	WebElement removeButton;

	@FindBy(xpath = "//input[contains(@class,'cart-product-add-box__input')]")
	WebElement quantityBox;

	@FindBy(xpath = "//div[@class='cart-navigation__sum']/span/span[3]")
	WebElement sumOfOrder;

	@FindBy(xpath = "//div[@class='cart-product-add-box']/span[3]")
	WebElement increaseQuanbtn;

	@FindBy(xpath = "//div[@class='cart-product-add-box']/span[1]")
	WebElement decreaseQuanbtn;

	@FindBy(xpath = "//a[contains(@class,'cart-navigation__button_сheckout')]")
	WebElement makeOrderBtn;
	
	@FindBy(xpath = "//div[@class='cart-message__preview']")
	WebElement emptyCartIcon;
	
	

	// Methods begin here
	public CartPage(WebDriver driver) { // constructor for the page
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String getItemName() { // this method gets an item name from the basket (1st one)
		WebDriverWait wait = new WebDriverWait(driver, 20); // explicit wait for dynamic elements
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cart-product-title']")));
		String title = driver.findElement(By.xpath("//div[@class='cart-product-title']")).getText();
		return title;
	}

	public void removeItem() { // this method clicks the remove button (1st one)
		removeButton.click();
	}

	public void clearQuanBox() { // this method clears the quantity box
		quantityBox.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE);
	}

	public void increaseNumber(String x) { // this method increases quantity by our parameter number
		quantityBox.sendKeys(x);
	}

	public String getSumOfOrder() { // This methods returns the sum of the items in the basket
		WebDriverWait wait = new WebDriverWait(driver, 20); // explicit wait for dynamic elements
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='cart-navigation__sum']/span/span[3]")));
		String sum = sumOfOrder.getText();
		String newTitle = sum.replace(" р.", ""); // Removing the word руб from the beginning
		return newTitle;

	}

	public void clickIncrQuant() throws AWTException { // This method clicks on increase quantity button
		//We use actions to move to the element since buttons only visible on hover
		 Actions action = new Actions(driver);
		 WebElement we = driver.findElement(By.xpath("//input[contains(@class,'cart-product-add-box__input')]"));
		 action.moveToElement(we).click().build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 20); // explicit wait for dynamic elements
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='cart-product-add-box']/span[3]")));
		increaseQuanbtn.click();

	}

	public void clickDecrQuant() throws AWTException { // This method clicks on decrease quantity button
		//We use actions to move to the element since buttons only visible on hover
		Actions action = new Actions(driver);
		 WebElement we = driver.findElement(By.xpath("//div[@class='cart-product-title']"));
		 action.moveToElement(we).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 20); // explicit wait for dynamic elements
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='cart-product-add-box']/span[1]")));
		decreaseQuanbtn.click();

	}

	public void clickMakeOderBtn() { // This method clicks on make order button

		makeOrderBtn.click();

	}
	
	

}
