package pl.org.pgs;

import static org.openqa.selenium.By.id;
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

		LoginAction.login(driver, "admin@tc2014.pl", "12qwAS");

		WebElement headerLogo = driver.findElement(id("header_logo"));

		Assertions.assertThat(headerLogo).isNotNull();
	}

}