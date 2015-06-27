package pl.org.pgs.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public static boolean isRecoveryPasswordCaptchaCorrectMessage(WebDriver driver) {

		return driver
				.findElements(By.xpath("//div[@class='login_form_error']"))
				.get(1)
				.getText().equals("Proszę poprawnie uzupełnić pole captcha.");
	}
}
