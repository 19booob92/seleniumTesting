package pl.org.pgs.action;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;

public class MainPageAction extends AbstractAction {

    public final static int WYDANIA_ID = 1;
    public final static int FAZY_ID = 2;
    public final static String ANY_VALUE = "anyName";


    public static void goEnviromentsListPage() {

        driver.get(data.getEnviromentsListUrl());
    }

    public static void goAddPhasePage() {

        driver.get(data.getAddPhaseUrl());
    }

    public static boolean sortByDescriptionPossible() {

        WebElement element = null;

        try {
            element = driver.findElement(xpath("//table[1]/thead/tr[1]/th[2]/a"));
        } catch (NoSuchElementException e) {
            return false;
        }

        return element != null;
    }

    public static void fillPhaseFormular(String name,
                                         String startDate, String endDate) {

        driver.findElement(By.id("name")).sendKeys("name");

        WebElement start = driver.findElement(By.id("startDate"));
        start.clear();
        start.sendKeys(startDate);

        WebElement end = driver.findElement(By.id("endDate"));
        end.clear();
        end.sendKeys(endDate);

    }

    public static void autoCompleteSelectFirst(String inputId, String inputValue) {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        WebElement inputRelease = driver.findElement(By.id(inputId));
        inputRelease.sendKeys(inputValue);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-autocomplete")));
        List<WebElement> listItems = driver.findElements(By.cssSelector(".ui-menu-item"));
        listItems.get(0).click();

    }

	public static void goRoleListPage() {

		driver.get(data.getRoleListUrl());
	}

    public static void fillPhaseFormularAndSubmit() {
        autoCompleteSelectFirst("releaseName", ANY_VALUE);

        fillPhaseFormular("anyPhaseName", "2015-06-27", "2015-06-28");

        driver.findElements(By.id("save")).get(1).click();
    }

    public static void fillFormInRelasesAndSubmit() {
        driver.findElement(By.id("name")).sendKeys("anyName");

        driver.findElement(By.id("startDate")).sendKeys("2015-06-27");
        driver.findElement(By.id("endDate")).sendKeys("2015-06-28");

        driver.findElements(By.id("save")).get(1).click();
    }

    public static void clickOnMenuItem(int idx) {
        Select select = new Select(driver.findElement(By.id("activeProject")));
        select.selectByVisibleText("11");

        WebElement menuItem = driver.findElements(By.className("item3")).get(idx);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        menuItem.findElement(By.cssSelector("a")).click();
    }

	public static void goToEditViewOfFirstRole() {

		driver.findElement(By.id("action_icon")).click();
		driver//.findElement(By.id("action_icon"))
				.findElement(By.xpath("//div[@class='collapse']/ul/li[1]/a")).click();
	}

    public static void clickOnAddButton() throws InterruptedException {
        WebElement sectionContent = driver.findElement(By.id("content"));
        WebElement article = sectionContent.findElement(By.className("article_in_content"));
        WebElement nav = article.findElement(By.className("button_link_nav"));
        WebElement ul = nav.findElement(By.className("button_link_ul"));
        WebElement li = ul.findElement(By.className("button_link_li"));
        li.findElement(By.cssSelector("a")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
