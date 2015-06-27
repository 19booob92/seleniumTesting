package pl.org.pgs;

import static org.openqa.selenium.By.id;
import static pl.org.pgs.Data.adminLogin;
import static pl.org.pgs.Data.adminPassword;
import static pl.org.pgs.Data.wrongLogin;
import static pl.org.pgs.Data.wrongPassword;
import static pl.org.pgs.action.LoginAction.fillCaptcha;
import static pl.org.pgs.action.LoginAction.login;
import static pl.org.pgs.util.MainPage.isMainPageLoaded;
import junit.framework.TestCase;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

import pl.org.pgs.action.LoginAction;
import pl.org.pgs.util.MainPage;

public class test {

	WebDriver driver;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void shouldLoginSuccessfully() {

		login(driver, adminLogin, adminPassword);

		Assertions.assertThat(isMainPageLoaded(driver)).isTrue();
	}

	@Test
	public void shouldNotLoginAfter3FailsWithoutCaptchaID268() {

		login(driver, wrongLogin, wrongPassword);
		login(driver, wrongLogin, wrongPassword);
		login(driver, wrongLogin, wrongPassword);

		fillCaptcha(driver, "");

		login(driver, adminLogin, adminPassword);

		Assertions.assertThat(isMainPageLoaded(driver)).isFalse();
	}

}