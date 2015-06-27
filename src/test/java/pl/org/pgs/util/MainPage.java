package pl.org.pgs.util;

import static org.openqa.selenium.By.id;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

	public static boolean isMainPageLoaded (WebDriver driver) {

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
