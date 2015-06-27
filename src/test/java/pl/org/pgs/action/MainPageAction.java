package pl.org.pgs.action;

import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class MainPageAction extends AbstractAction {

	public static void goEnviromentsListPage() {

		driver.get(data.getEnviromentsListUrl());
	}

	public static void goRoleListPage() {

		driver.get(data.getRoleListUrl());
	}

	public static void goAddPhasePage() {

		driver.get(data.getAddPhaseUrl());
	}

	public static boolean sortByDescriptionPossible() {

		WebElement element = null;

		try {
			element = driver.findElement(xpath("//table[1]/thead/tr[1]/th[2]/a"));
		} catch (NoSuchElementException e) {
			return false;
		}

		return element != null;
	}

	public static void fillPhaseFormular(String name,
			String startDate, String endDate) {

		driver.findElement(By.id("name")).sendKeys(endDate);

		driver.findElement(By.id("startDate")).sendKeys(startDate);
		driver.findElement(By.id("endDate")).sendKeys(endDate);

	}

	public static void goToEditViewOfFirstRole() {

		driver.findElement(By.id("action_icon")).click();
		driver//.findElement(By.id("action_icon"))
				.findElement(By.xpath("//div[@class='collapse']/ul/li[1]/a")).click();
	}
}
