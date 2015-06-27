package pl.org.pgs;

import static org.assertj.core.api.StrictAssertions.assertThat;
import static pl.org.pgs.action.LoginAction.clickRecoverPassword;
import static pl.org.pgs.action.LoginAction.clickRemindPassword;
import static pl.org.pgs.action.LoginAction.fillCaptcha;
import static pl.org.pgs.action.LoginAction.goLoginPage;
import static pl.org.pgs.action.LoginAction.goWrongLoginPage;
import static pl.org.pgs.action.LoginAction.login;
import static pl.org.pgs.action.MainPageAction.goEnviromentsListPage;
import static pl.org.pgs.action.MainPageAction.sortByDescriptionPossible;
import static pl.org.pgs.util.LoginPage.isBackButtonPresent;
import static pl.org.pgs.util.LoginPage.isRecoveryPasswordCaptchaCorrectMessage;
import static pl.org.pgs.util.MainPage.isMainPageLoaded;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pl.org.pgs.action.AbstractAction;

public class test {

	WebDriver driver;
	IData data = MrBuggyData.getInstance();

	// IData data = TeatAreaData.getInstance();

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		AbstractAction.setData(data);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	// @Test
	public void shouldLoginSuccessfully() {

		goLoginPage(driver);
		login(driver, data.getAdminLogin(), data.getAdminPassword());

		assertThat(isMainPageLoaded(driver)).isTrue();
	}

	@Test
	public void shouldNotLoginAfter3FailsWithoutCaptchaID268() {

		goLoginPage(driver);

		login(driver, data.getWrongLogin(), data.getWrongPassword());
		login(driver, data.getWrongLogin(), data.getWrongPassword());
		login(driver, data.getWrongLogin(), data.getWrongPassword());

		fillCaptcha(driver, "");

		login(driver, data.getAdminLogin(), data.getAdminPassword());

		assertThat(isMainPageLoaded(driver)).isFalse();
	}

	@Test
	public void shoulReturn404StatusID272() {

		goWrongLoginPage(driver);

		assertThat(isMainPageLoaded(driver)).isFalse();

	}

	@Test
	public void shoulSortEnviromentByDescriptionID218() {

		goLoginPage(driver);
		login(driver, data.getAdminLogin(), data.getAdminPassword());

		goEnviromentsListPage(driver);

		assertThat(sortByDescriptionPossible(driver)).isFalse();

	}

	@Test
	public void shouldNotLoginAfter3FailsWithoutCaptchaAfterChangingUrlID269() {

		goLoginPage(driver);

		login(driver, data.getWrongLogin(), data.getWrongPassword());
		login(driver, data.getWrongLogin(), data.getWrongPassword());
		login(driver, data.getWrongLogin(), data.getWrongPassword());

		goLoginPage(driver);

		login(driver, data.getAdminLogin(), data.getAdminPassword());

		assertThat(isMainPageLoaded(driver)).isFalse();
	}

	@Test
	public void shouldBeCorrectMessageAtRememberPasswordCaptchaID280() {

		goLoginPage(driver);

		clickRemindPassword(driver);
		clickRecoverPassword(driver);

		assertThat(isRecoveryPasswordCaptchaCorrectMessage(driver)).isTrue();
	}

	@Test
	public void shouldBeBackButtonID290() {

		goLoginPage(driver);

		clickRemindPassword(driver);

		assertThat(isBackButtonPresent(driver)).isTrue();
	}

}