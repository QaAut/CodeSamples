package pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	WebDriver driver;

	@FindBy(xpath = "//a[@class='cart-product__remove']")
	WebElement removeButton;

	@FindBy(xpath = "//input[contains(@class,'cart-product-add-box__input')]")
	WebElement quantityBox;
	
	
	@FindBy(xpath = "//div[@class='cart-navigation__sum']/span/span[3]")
	WebElement sumOfOrder;
	
	
	
	// Methods begin here
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String getItemName() {
		WebDriverWait wait = new WebDriverWait(driver, 20); // explicit wait for dynamic elements
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cart-product-title']")));
		String title = driver.findElement(By.xpath("//div[@class='cart-product-title']")).getText();
		return title;
	}

	public void removeItem() {
		removeButton.click();
	}
	public void clearQuanBox() {
		quantityBox.click();
		quantityBox.sendKeys(Keys.BACK_SPACE);
	}
	
	public void increaseNumber() {
		quantityBox.sendKeys("2");
	}
	
	public String getSumOfOrder() {
		WebDriverWait wait = new WebDriverWait(driver, 20); // explicit wait for dynamic elements
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cart-navigation__sum']/span/span[3]")));
	 String sum = sumOfOrder.getText();
	 return sum;
		
	}

}
