package tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LocationTest {
    public WebDriver driver;

    @Test
    public void openMyBlog() {
        driver.get("https://www.softwaretestingmaterial.com/");
    }

    @BeforeClass
    public void beforeClass() {

        System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\Drivers\\geckodriver.exe");
        driver = new FirefoxDriver();

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
    /*private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testLocationCase() throws Exception {
        driver.get("http://localhost:8080/faces/main/index.xhtml");
        driver.findElement(By.linkText("Logowanie")).click();
        driver.findElement(By.name("j_username")).click();
        driver.findElement(By.name("j_username")).click();
        driver.findElement(By.name("j_username")).clear();
        driver.findElement(By.name("j_username")).sendKeys("JDoe");
        driver.findElement(By.name("j_password")).click();
        driver.findElement(By.name("j_password")).clear();
        driver.findElement(By.name("j_password")).sendKeys("P@ssw0rd");
        driver.findElement(By.xpath("//input[@value='Zaloguj']")).click();
        driver.findElement(By.linkText("Lokalizacja")).click();
        driver.findElement(By.linkText("Utwórz nową lokalizację")).click();
        driver.findElement(By.id("CreateLocationForm:locationSymbol")).click();
        driver.findElement(By.id("CreateLocationForm:locationSymbol")).clear();
        driver.findElement(By.id("CreateLocationForm:locationSymbol")).sendKeys("TE-00-00-00");
        driver.findElement(By.id("CreateLocationForm:locationType")).click();
        new Select(driver.findElement(By.id("CreateLocationForm:locationType"))).selectByVisibleText("CAŁA");
        driver.findElement(By.xpath("//option[@value='SHELF1']")).click();
        driver.findElement(By.name("CreateLocationForm:j_idt35")).click();
        driver.findElement(By.linkText("Lokalizacja")).click();
        driver.findElement(By.linkText("Lista lokalizacji")).click();
        driver.findElement(By.name("j_idt27:j_idt28:10:onlyWarehouse:j_idt38")).click();
        driver.findElement(By.id("EditLocationForm:locationType")).click();
        new Select(driver.findElement(By.id("EditLocationForm:locationType"))).selectByVisibleText("POŁOWA");
        driver.findElement(By.xpath("//option[@value='SHELF2']")).click();
        driver.findElement(By.name("EditLocationForm:j_idt32")).click();
        driver.findElement(By.name("j_idt27:j_idt28:10:onlyWarehouse:j_idt39")).click();
        driver.findElement(By.name("DeleteLocationForm:j_idt31")).click();
        driver.findElement(By.linkText("Wylogowanie")).click();
        driver.findElement(By.name("j_idt27:j_idt31")).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }*/
}
