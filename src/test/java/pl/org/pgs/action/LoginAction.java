package pl.org.pgs.action;

import static org.openqa.selenium.By.id;

import org.openqa.selenium.WebDriver;

import pl.org.pgs.IData;

public class LoginAction {

	private static IData data;

	public static void login(WebDriver driver, String login, String password) {

		driver.get(data.getUrl());

		driver.findElement(id("email")).sendKeys(login);
		driver.findElement(id("password")).sendKeys(password);

		driver.findElement(id("login")).click();
	}

	public static void fillCaptcha(WebDriver driver, String text) {

		driver.findElement(id("captcha-input")).sendKeys(text);
	}

	public static void setIData(IData d) {
		data = d;
	}
}
