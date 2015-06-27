package pl.org.pgs;

import static pl.org.pgs.action.LoginAction.fillCaptcha;
import static pl.org.pgs.action.LoginAction.goLoginPage;
import static pl.org.pgs.action.LoginAction.login;
import static pl.org.pgs.util.MainPage.isMainPageLoaded;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pl.org.pgs.action.LoginAction;

public class test {

	WebDriver driver;
	IData data = MrBuggyData.getInstance();

	// IData data = TeatAreaData.getInstance();

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		LoginAction.setIData(data);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	// @Test
	public void shouldLoginSuccessfully() {

		goLoginPage(driver);
		login(driver, data.getAdminLogin(), data.getAdminPassword());

		Assertions.assertThat(isMainPageLoaded(driver)).isTrue();
	}

	@Test
	public void shouldNotLoginAfter3FailsWithoutCaptchaID268() {

		goLoginPage(driver);

		login(driver, data.getWrongLogin(), data.getWrongPassword());
		login(driver, data.getWrongLogin(), data.getWrongPassword());
		login(driver, data.getWrongLogin(), data.getWrongPassword());

		fillCaptcha(driver, "");

		login(driver, data.getAdminLogin(), data.getAdminPassword());

		Assertions.assertThat(isMainPageLoaded(driver)).isFalse();
	}

	@Test
	public void shoulReturn404StatusID272() {

		LoginAction.goWrongLoginPage(driver);

		Assertions.assertThat(isMainPageLoaded(driver)).isFalse();

	}

}