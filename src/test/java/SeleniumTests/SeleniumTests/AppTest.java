package SeleniumTests.SeleniumTests;

import static org.assertj.core.api.StrictAssertions.assertThat;

import java.util.concurrent.TimeUnit;
import com.google.common.base.Function;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class AppTest {

	private static final String TEXT_ON_PAGE = "Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros etos.";

	Wait<WebDriver> wait;

	WebDriver driver;

	@Before
	public void init() {
		driver = new FirefoxDriver();

		wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
	}

	@After
	public void tearDown() {
		driver.close();
	}

	@Test
	public void shouldOpenProperPage() {
		driver.get("http://www.kiernozek.pl");

		assertThat(driver.getPageSource().contains("Hello")).isTrue();
	}

	@Test
	public void shouldContainsContent() {
		driver.get("http://www.kiernozek.pl");

		assertThat(driver.getPageSource().contains(TEXT_ON_PAGE)).isTrue();
	}

	@Test
	public void shouldDisplayExtendendText() throws Exception {
		driver.get("http://www.kiernozek.pl");

		WebElement czytajDalejAnchor = driver.findElement(By.xpath("//*[contains(text(), 'Czytaj dalej')]"));

		czytajDalejAnchor.click();

		assertThat(driver.getPageSource().contains("O mnie")).isTrue();
		assertThat(driver.getPageSource().contains("Lorem ipsum dolor sit amet")).isTrue();
	}

	@Test
	public void shouldDisplayExtendendTextWhenGivenMenuPositionIsSelected() throws Exception {
		driver.get("http://www.kiernozek.pl");

		WebElement czytajDalejAnchor = driver.findElement(By.xpath("//*[contains(text(), 'O mnie')]"));

		czytajDalejAnchor.click();

		assertThat(driver.getPageSource().contains("O mnie")).isTrue();
		assertThat(driver.getPageSource().contains("Lorem ipsum dolor sit amet")).isTrue();
	}

	@Test
	public void shouldDisplayContactDataWhenContactPositionIsSelected() throws Exception {
		driver.get("http://www.kiernozek.pl");

		WebElement czytajDalejAnchor = driver.findElement(By.xpath("//*[contains(text(), 'Kontakt')]"));

		czytajDalejAnchor.click();

		assertThat(driver.getPageSource().contains("50-370 Wrocław")).isTrue();
	}

	@Test
	public void shouldSendEmail() throws Exception {
		driver.get("http://www.kiernozek.pl");

		WebElement czytajDalejAnchor = driver.findElement(By.xpath("//*[contains(text(), 'Kontakt')]"));

		czytajDalejAnchor.click();
		
		WebElement nazwa = wait.until(new com.google.common.base.Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.name("wb_input_0"));
			}
		});

		nazwa.sendKeys("Test");

		WebElement email = driver.findElement(By.name("wb_input_1"));
		email.sendKeys("Test");

		WebElement wiadomosc = driver.findElement(By.name("wb_input_2"));
		nazwa.sendKeys("testowa wiadomosc");

		WebElement submitBtn = driver.findElement(By.className("btn"));
		submitBtn.click();
		Alert alert = null;

		try {
			alert = driver.switchTo().alert();
		} catch (NoAlertPresentException n) {
			assertThat(true).isFalse();
		}

		assertThat(alert.getText()).isEqualTo("Fomularz został wysłany.");
	}
}
