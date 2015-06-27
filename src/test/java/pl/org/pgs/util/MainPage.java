package pl.org.pgs.util;

import static org.openqa.selenium.By.id;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import pl.org.pgs.action.DriverOperator;

public class MainPage extends DriverOperator {

	public static boolean isMainPageLoaded() {

		WebElement headerLogo = null;

		try {
			headerLogo = driver.findElement(id("header_logo"));
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			return false;
		}

		return headerLogo != null;
	}
}
