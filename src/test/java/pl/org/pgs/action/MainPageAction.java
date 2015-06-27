package pl.org.pgs.action;

import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPageAction extends AbstractAction {

	public static void goEnviromentsListPage(WebDriver driver) {

		driver.get(data.getEnviromentsListUrl());
	}

	public static void goAddPhasePage(WebDriver driver) {

		driver.get(data.getAddPhaseUrl());
	}

	public static boolean sortByDescriptionPossible(WebDriver driver) {

		WebElement element = null;

		try {
			element = driver.findElement(xpath("//table[1]/thead/tr[1]/th[2]/a"));
		} catch (NoSuchElementException e) {
			return false;
		}

		return element != null;
	}

	public static void fillPhaseFormular(WebDriver driver, String name,
			String startDate, String endDate) {

		driver.findElement(By.id("name")).sendKeys(endDate);

		

		driver.findElement(By.id("startDate")).sendKeys(startDate);
		driver.findElement(By.id("endDate")).sendKeys(endDate);

	}
}
