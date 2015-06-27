package pl.org.pgs.action;

import static org.openqa.selenium.By.id;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginAction extends AbstractAction {

	public static void login(WebDriver driver, String login, String password) {

		// driver.get(data.getLoginUrl());

		driver.findElement(id("email")).clear();

		driver.findElement(id("email")).sendKeys(login);
		driver.findElement(id("password")).sendKeys(password);

		driver.findElement(id("login")).click();
	}

	public static void fillCaptcha(WebDriver driver, String text) {

		driver.findElement(id("captcha-input")).sendKeys(text);
	}

	public static void clickRemindPassword(WebDriver driver) {

		driver.findElement(By.xpath("//div[@class='remember_check']/a[1]"))
				.click();
	}

	public static void clickRecoverPassword(WebDriver driver) {

		driver.findElement(By.id("recover")).click();
	}

	public static void goWrongLoginPage(WebDriver driver) {

		driver.get(data.getUrl() + "/ZALOGUJ");
	}

	public static void goLoginPage(WebDriver driver) {

		driver.get(data.getLoginUrl());
	}
}
