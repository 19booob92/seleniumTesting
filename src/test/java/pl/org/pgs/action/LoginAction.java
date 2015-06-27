package pl.org.pgs.action;

import static org.openqa.selenium.By.id;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginAction {

	public static void login(WebDriver driver, String login, String password) {

		driver.get("http://demo.mrbuggy2.testarena.pl/zaloguj");

		driver.findElement(id("email")).sendKeys(login);
		driver.findElement(id("password")).sendKeys(password);

		driver.findElement(id("login")).click();
	}
}
