package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class LocationTest {
    public static void main(String [] args) {
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        System.setProperty("webdriver.gecko.driver", "/var/lib/jenkins/workspace/test/WM/geckodriver/geckodriver");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
        try {
            driver.get("http://www.google.com");
            driver.manage().timeouts().implicitlyWait(4,
                    TimeUnit.SECONDS);
            WebElement queryBox = driver.findElement(By.name("q"));
            queryBox.sendKeys("headless firefox");
            WebElement searchBtn = driver.findElement(By.name("btnK"));
            searchBtn.click();
            WebElement iresDiv = driver.findElement(By.id("ires"));
            iresDiv.findElements(By.tagName("a")).get(0).click();
            System.out.println(driver.getPageSource());
        } finally {
            driver.quit();
        }
    }
}
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxBinary;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.testng.Assert;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//public class LocationTest {
//    private WebDriver driver;
//    @Test
//    public void testEasy() {
//        driver.get("http://demo.guru99.com/test/guru99home/");
//        String title = driver.getTitle();
//        Assert.assertTrue(title.contains("Demo Guru99 Page"));
//    }
//    @BeforeTest
//    public void beforeTest() {
//        FirefoxBinary firefoxBinary = new FirefoxBinary();
//        firefoxBinary.addCommandLineOptions("--headless");
//        System.setProperty("webdriver.gecko.driver", "/var/lib/jenkins/workspace/test/WM/geckodriver/geckodriver");
//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        firefoxOptions.setBinary(firefoxBinary);
//        FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
//        driver = new FirefoxDriver();
//    }
//    @AfterTest
//    public void afterTest() {
//        driver.quit();
//    }
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
//}
