package pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {

	public static String trimString(String x) {

		x = x.trim().replace(",", ".").replace(" ", "");

		return x;

	}

	public static double convertStringToDouble(String x) {

		double value = Double.parseDouble(x);
		return value;
	}

	public static boolean compareDouble(double a, double b) {

		boolean value;
		if (a == b) {
			value = true;
			return value;

		} else {
			value = false;
			return value;
		}
	}

	public static boolean isDisplayed(String x, WebDriver driver) { // This method checks if element is displayed

		boolean value;

		WebElement b = driver.findElement(By.xpath(x));

		value = b.isDisplayed();
		return value;
	}

	public static void waitForElement(String x, WebDriver driver) { // This method explicitly waits for any Webelment

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(x)));
	}

}
