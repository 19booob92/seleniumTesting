package pl.org.pgs.action;

import org.openqa.selenium.WebDriver;

public abstract class DriverOperator {

	protected static WebDriver driver;

	public static void setDriver(WebDriver d) {
		driver = d;
	}
}
