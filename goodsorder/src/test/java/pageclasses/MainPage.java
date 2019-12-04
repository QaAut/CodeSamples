package pageclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
	WebDriver driver;

	@FindBy(name = "query")
	WebElement searchField;

	// iframe elements on the main page start here
	@FindBy(xpath = "//iframe[@class='modal-iframe']")
	WebElement iFrame;

	// Methods start here

	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickSearchField() {
		searchField.click();

	}

	public void typeInSearchField(String a) {
		searchField.sendKeys(a);

	}

	public void clickOnOffersForTheFIrstItem() throws InterruptedException {
		// finding the first item in the search field and checking offers for it

		WebElement x = driver
				.findElement(By.xpath("//li[contains(@class,'search__result')][1]//a[contains(@class,'button')]"));
		x.click();

	}

	public String getNameOfItem() {
		// saving the name of the first item
		driver.switchTo().frame(iFrame); // switching to iframe
		WebDriverWait wait = new WebDriverWait(driver, 20); // explicit wait for dynamic elements
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//li[contains(@class,'search__result')][1]//a[@class='product__title-link']")));
		String title = driver
				.findElement(By.xpath("//li[contains(@class,'search__result')][1]//a[@class='product__title-link']"))
				.getText(); // Getting the title
		String newTitle = title.replaceFirst("Смартфон ", ""); //Removing the word Смартфон from the beginning
		return newTitle;
	}

}
