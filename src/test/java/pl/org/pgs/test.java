package pl.org.pgs;

import static pl.org.pgs.action.LoginAction.fillCaptcha;
import static pl.org.pgs.action.LoginAction.goLoginPage;
import static pl.org.pgs.action.LoginAction.goWrongLoginPage;
import static pl.org.pgs.action.LoginAction.login;
import static pl.org.pgs.action.MainPageAction.goAddPhasePage;
import static pl.org.pgs.action.MainPageAction.goEnviromentsListPage;
import static pl.org.pgs.action.MainPageAction.sortByDescriptionPossible;
import static pl.org.pgs.util.MainPage.isMainPageLoaded;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pl.org.pgs.action.AbstractAction;
import pl.org.pgs.action.MainPageAction;

public class test {

	WebDriver driver;
	IData data = MrBuggyData.getInstance();

	// IData data = TeatAreaData.getInstance();

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		AbstractAction.setIData(data);
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

		goWrongLoginPage(driver);

		Assertions.assertThat(isMainPageLoaded(driver)).isFalse();

	}

	@Test
	public void shoulSortEnviromentByDescriptionID218() {

		goLoginPage(driver);
		login(driver, data.getAdminLogin(), data.getAdminPassword());

		goEnviromentsListPage(driver);

		Assertions.assertThat(sortByDescriptionPossible(driver)).isFalse();

	}

	@Test
	public void shouldNotBePossibleToAddPhaseWithDateToBeforeDateFromID289() {

		goLoginPage(driver);
		login(driver, data.getAdminLogin(), data.getAdminPassword());

		goAddPhasePage(driver);
		MainPageAction

		Assertions.assertThat().isFalse();

	}

}