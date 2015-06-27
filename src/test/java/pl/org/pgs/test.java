package pl.org.pgs;

import static org.assertj.core.api.StrictAssertions.assertThat;
import static pl.org.pgs.action.LoginAction.clickRecoverPassword;
import static pl.org.pgs.action.LoginAction.clickRemindPassword;
import static pl.org.pgs.action.LoginAction.fillCaptcha;
import static pl.org.pgs.action.LoginAction.fillLoginFormularAndSubmit;
import static pl.org.pgs.action.LoginAction.goLoginPage;
import static pl.org.pgs.action.LoginAction.goWrongLoginPage;
import static pl.org.pgs.action.LoginAction.submitLogin;
import static pl.org.pgs.action.MainPageAction.goEnviromentsListPage;
import static pl.org.pgs.action.MainPageAction.goRoleListPage;
import static pl.org.pgs.action.MainPageAction.goToEditViewOfFirstRole;
import static pl.org.pgs.action.MainPageAction.sortByDescriptionPossible;
import static pl.org.pgs.util.LoginPage.areOnlyTwoErrorMessagesPresent;
import static pl.org.pgs.util.LoginPage.isBackButtonPresent;
import static pl.org.pgs.util.LoginPage.isRecoveryPasswordCaptchaCorrectMessage;
import static pl.org.pgs.util.MainPage.isMainPageLoaded;
import static pl.org.pgs.util.MainPage.isSelectAllCheckboxLabelPresentRoles;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pl.org.pgs.action.AbstractAction;
import pl.org.pgs.action.DriverOperator;

public class test {

	WebDriver driver;
	IData data = MrBuggyData.getInstance();

	// IData data = TeatAreaData.getInstance();

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		AbstractAction.setData(data);
		DriverOperator.setDriver(driver);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	// @Test
	public void shouldLoginSuccessfully() {

		goLoginPage();

		fillLoginFormularAndSubmit(data.getAdminLogin(), data.getAdminPassword());

		assertThat(isMainPageLoaded()).isTrue();
	}

	@Test
	public void shouldNotLoginAfter3FailsWithoutCaptchaID268() {

		goLoginPage();

		fillLoginFormularAndSubmit(data.getWrongLogin(), data.getWrongPassword());
		fillLoginFormularAndSubmit(data.getWrongLogin(), data.getWrongPassword());
		fillLoginFormularAndSubmit(data.getWrongLogin(), data.getWrongPassword());

		fillCaptcha("");

		fillLoginFormularAndSubmit(data.getAdminLogin(), data.getAdminPassword());

		assertThat(isMainPageLoaded()).isFalse();
	}

	@Test
	public void shoulReturn404StatusID272() {

		goWrongLoginPage();

		assertThat(isMainPageLoaded()).isFalse();
	}

	@Test
	public void shoulSortEnviromentByDescriptionID218() {

		goLoginPage();

		fillLoginFormularAndSubmit(data.getAdminLogin(), data.getAdminPassword());

		goEnviromentsListPage();

		assertThat(sortByDescriptionPossible()).isFalse();
	}

	@Test
	public void shouldNotLoginAfter3FailsWithoutCaptchaAfterChangingUrlID269() {

		goLoginPage();

		fillLoginFormularAndSubmit(data.getWrongLogin(), data.getWrongPassword());
		fillLoginFormularAndSubmit(data.getWrongLogin(), data.getWrongPassword());
		fillLoginFormularAndSubmit(data.getWrongLogin(), data.getWrongPassword());

		goLoginPage();

		fillLoginFormularAndSubmit(data.getAdminLogin(), data.getAdminPassword());

		assertThat(isMainPageLoaded()).isFalse();
	}

	@Test
	public void shouldBeCorrectMessageAtRememberPasswordCaptchaID280() {

		goLoginPage();

		clickRemindPassword();
		clickRecoverPassword();

		assertThat(isRecoveryPasswordCaptchaCorrectMessage()).isTrue();
	}

	@Test
	public void shouldBeBackButtonID290() {

		goLoginPage();

		clickRemindPassword();

		assertThat(isBackButtonPresent()).isTrue();
	}

	@Test
	public void shouldWrongMessageNotBePresentID260() {

		goLoginPage();

		submitLogin();

		assertThat(areOnlyTwoErrorMessagesPresent()).isTrue();
	}

	@Test
	public void shouldBeLabbelSelectAllID294() {

		goLoginPage();

		fillLoginFormularAndSubmit(data.getAdminLogin(), data.getAdminPassword());

		goRoleListPage();

		goToEditViewOfFirstRole();

		assertThat(isSelectAllCheckboxLabelPresentRoles()).isTrue();
	}

	@Test
	public void shoulCookieSessionBeHttpOnlyID278() {

		driver.manage().deleteAllCookies();

		goLoginPage();

		fillLoginFormularAndSubmit(data.getAdminLogin(), data.getAdminPassword());

		// driver.manage().getCookies().stream().filter((c) ->
		// c.isHttpOnly()).forEach((c) -> System.out.println(c.toString()));

		assertThat(driver.manage().getCookieNamed("FrameProfile").isHttpOnly()).isTrue();
	}

}