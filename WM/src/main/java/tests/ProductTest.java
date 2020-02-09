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

public class ProductTest {
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
    public void productCase() {
        try {
            driver.get("https://localhost:8181/faces/main/index.xhtml");
            driver.findElement(By.linkText("Sign in")).click();
            driver.findElement(By.name("j_username")).click();
            driver.findElement(By.name("j_username")).clear();
            driver.findElement(By.name("j_username")).sendKeys("LRey");
            driver.findElement(By.name("j_password")).click();
            driver.findElement(By.name("j_password")).clear();
            driver.findElement(By.name("j_password")).sendKeys("P@ssw0rd");
            driver.findElement(By.xpath("//input[@value='Sign in']")).click();
            driver.findElement(By.linkText("Product")).click();
            driver.findElement(By.linkText("Create new product")).click();
            driver.findElement(By.id("CreateProductForm:productSymbol")).click();
            driver.findElement(By.id("CreateProductForm:productSymbol")).clear();
            driver.findElement(By.id("CreateProductForm:productSymbol")).sendKeys("5906961196123");
            driver.findElement(By.id("CreateProductForm:description")).click();
            driver.findElement(By.id("CreateProductForm:description")).clear();
            driver.findElement(By.id("CreateProductForm:description")).sendKeys("Desc");
            driver.findElement(By.id("CreateProductForm:price")).click();
            driver.findElement(By.id("CreateProductForm:price")).clear();
            driver.findElement(By.id("CreateProductForm:price")).sendKeys("1.34");
            driver.findElement(By.id("CreateProductForm:weight")).click();
            driver.findElement(By.id("CreateProductForm:weight")).clear();
            driver.findElement(By.id("CreateProductForm:weight")).sendKeys("1765");
            driver.findElement(By.name("CreateProductForm:j_idt36")).click();
            driver.findElement(By.linkText("Product")).click();
            driver.findElement(By.linkText("Products list")).click();
            try {
                assertEquals(driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr/td")).getText(), "5906961196123");
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            try {
                assertEquals(driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr/td[2]")).getText(), "Desc");
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            try {
                assertEquals(driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr/td[3]")).getText(), "1.34");
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            try {
                assertEquals(driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr/td[4]")).getText(), "1765");
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            driver.findElement(By.name("j_idt27:j_idt28:0:onlyOffice:j_idt40")).click();
            driver.findElement(By.id("EditProductForm:description")).click();
            driver.findElement(By.id("EditProductForm:description")).clear();
            driver.findElement(By.id("EditProductForm:description")).sendKeys("Desc update");
            driver.findElement(By.name("EditProductForm:j_idt36")).click();
            try {
                assertEquals(driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr/td")).getText(), "5906961196123");
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            try {
                assertEquals(driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr/td[2]")).getText(), "Desc update");
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            try {
                assertEquals(driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr/td[3]")).getText(), "1.34");
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            try {
                assertEquals(driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr/td[4]")).getText(), "1765");
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            driver.findElement(By.name("j_idt27:j_idt28:0:onlyOffice:j_idt41")).click();
            driver.findElement(By.name("DeleteProductForm:j_idt31")).click();
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