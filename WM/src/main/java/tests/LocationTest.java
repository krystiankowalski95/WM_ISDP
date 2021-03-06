package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.FileAssert.fail;

public class LocationTest {
    private StringBuffer verificationErrors = new StringBuffer();
    private FirefoxDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        System.setProperty("webdriver.gecko.driver", "/var/lib/jenkins/workspace/test/WM/geckodriver/geckodriver");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void LocationCase() {
        try {
            driver.get("http://localhost:8080/faces/main/index.xhtml");
            driver.findElement(By.linkText("Sign in")).click();
            driver.findElement(By.name("j_username")).click();
            driver.findElement(By.name("j_username")).clear();
            driver.findElement(By.name("j_username")).sendKeys("JDoe");
            driver.findElement(By.name("j_password")).click();
            driver.findElement(By.name("j_password")).clear();
            driver.findElement(By.name("j_password")).sendKeys("P@ssw0rd");
            driver.findElement(By.xpath("//input[@value='Sign in']")).click();
            try {
                assertEquals(driver.findElement(By.xpath("//h4")).getText(), "Authenticated user: JDoe");
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            driver.findElement(By.linkText("Location")).click();
            driver.findElement(By.linkText("Locations list")).click();
            try {
                assertEquals(driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr[10]/td")).getText(), "AA-01-04-04");
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            driver.findElement(By.linkText("Location")).click();
            driver.findElement(By.linkText("Create new location")).click();
            driver.findElement(By.id("CreateLocationForm:locationSymbol")).click();
            driver.findElement(By.id("CreateLocationForm:locationSymbol")).clear();
            driver.findElement(By.id("CreateLocationForm:locationSymbol")).sendKeys("TT-00-00-00");
            driver.findElement(By.id("CreateLocationForm:locationType")).click();
            new Select(driver.findElement(By.id("CreateLocationForm:locationType"))).selectByVisibleText("WHOLE");
            driver.findElement(By.xpath("//option[@value='SHELF1']")).click();
            driver.findElement(By.name("CreateLocationForm:j_idt35")).click();
            driver.findElement(By.linkText("Location")).click();
            driver.findElement(By.linkText("Locations list")).click();
            try {
                assertEquals(driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr[11]/td")).getText(), "TT-00-00-00");
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            try {
                assertEquals(driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr[11]/td[2]")).getText(), "WHOLE");
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            driver.findElement(By.name("j_idt27:j_idt28:10:onlyWarehouse:j_idt38")).click();
            driver.findElement(By.id("EditLocationForm:locationType")).click();
            new Select(driver.findElement(By.id("EditLocationForm:locationType"))).selectByVisibleText("HALF");
            driver.findElement(By.xpath("//option[@value='SHELF2']")).click();
            driver.findElement(By.name("EditLocationForm:j_idt32")).click();
            try {
                assertEquals(driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr[11]/td")).getText(), "TT-00-00-00");
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            try {
                assertEquals(driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr[11]/td[2]")).getText(), "HALF");
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            driver.findElement(By.name("j_idt27:j_idt28:10:onlyWarehouse:j_idt39")).click();
            driver.findElement(By.name("DeleteLocationForm:j_idt31")).click();
            try {
                assertEquals(driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr[10]/td")).getText(), "AA-01-04-04");
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            try {
                assertEquals(driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr[10]/td[2]")).getText(), "QUARTER");
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            driver.findElement(By.linkText("Sign out")).click();
            driver.findElement(By.name("j_idt27:j_idt31")).click();


        } finally {
            driver.quit();
        }
    }
    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}