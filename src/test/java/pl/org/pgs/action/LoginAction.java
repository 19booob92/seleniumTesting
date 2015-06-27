package pl.org.pgs.action;

import static org.openqa.selenium.By.id;

import org.openqa.selenium.By;

public class LoginAction extends AbstractAction {

	public static void fillLoginFormularAndSubmit(String login, String password) {

		// driver.get(data.getLoginUrl());

		driver.findElement(id("email")).clear();

		driver.findElement(id("email")).sendKeys(login);
		driver.findElement(id("password")).sendKeys(password);

		submitLogin();
	}

	public static void submitLogin() {
		driver.findElement(id("login")).click();
	}

	public static void fillCaptcha(String text) {

		driver.findElement(id("captcha-input")).sendKeys(text);
	}

	public static void clickRemindPassword() {

		driver.findElement(By.xpath("//div[@class='remember_check']/a[1]"))
				.click();
	}

	public static void clickRecoverPassword() {

		driver.findElement(By.id("recover")).click();
	}

	public static void goWrongLoginPage() {

		driver.get(data.getUrl() + "/ZALOGUJ");
	}

	public static void goLoginPage() {

		driver.get(data.getLoginUrl());
	}
}
