package pl.org.pgs.util;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import pl.org.pgs.action.DriverOperator;

public class MainPage extends DriverOperator {

	public static boolean isMainPageLoaded() {

		WebElement element = null;

		try {
			element = driver.findElement(id("header_logo"));
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			return false;
		}

		return element != null;
	}

	public static boolean isSelectAllCheckboxLabelPresentRoles() {

		WebDriverWait wait = new WebDriverWait(driver, 3);

		WebElement element = null;

		try {
			element = wait.until(visibilityOfElementLocated(By
					.xpath("//table/thead/tr/th/label")));
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			return false;
		}

		return element != null;
	}
}
