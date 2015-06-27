package pl.org.pgs.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import pl.org.pgs.action.DriverOperator;

public class LoginPage extends DriverOperator {

	public static boolean isRecoveryPasswordCaptchaCorrectMessage() {

		return driver
				.findElements(By.xpath("//div[@class='login_form_error']"))
				.get(1)
				.getText().equals("Proszę poprawnie uzupełnić pole captcha.");
	}

	public static boolean isBackButtonPresent() {

		WebElement element = null;

		try {
			element = driver.findElement(By.xpath("//div[@class='remember_check']/a[1]"));
		} catch (NoSuchElementException e) {
			return false;
		}

		return element != null;
	}
}
