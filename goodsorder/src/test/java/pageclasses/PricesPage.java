package pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PricesPage {
	WebDriver driver;

	@FindBy(xpath = "//tr[1]//a[contains(@class,'button')]")
	WebElement firstItem;

	@FindBy(xpath = "//a[@title='Корзина']")
	WebElement basketIcon;

	
	@FindBy(xpath = "//div[@class='auth-bar__counter']")
	WebElement cartItemCount;
	
	
	
	// Methods start here

	public PricesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void putIntoBasket() {
		WebDriverWait wait = new WebDriverWait(driver, 20); // explicit wait for dynamic elements
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[1]//a[contains(@class,'button')]")));
		firstItem.click();
	}

	public void clickBasket() {
		WebDriverWait wait = new WebDriverWait(driver, 20); // explicit wait for dynamic elements
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='auth-bar__counter']")));
		basketIcon.click();
	}
}
