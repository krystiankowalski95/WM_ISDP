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

public class UserTest {
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
    public void userCase() {
        try {
            driver.get("https://localhost:8181/faces/main/index.xhtml");
            driver.findElement(By.linkText("Sign in")).click();
            driver.findElement(By.name("j_username")).click();
            driver.findElement(By.name("j_username")).clear();
            driver.findElement(By.name("j_username")).sendKeys("DMitchell");
            driver.findElement(By.name("j_password")).click();
            driver.findElement(By.name("j_password")).clear();
            driver.findElement(By.name("j_password")).sendKeys("P@ssw0rd");
            driver.findElement(By.xpath("//input[@value='Sign in']")).click();
            driver.findElement(By.linkText("Register account")).click();
            driver.findElement(By.id("RegisterForm:name")).click();
            driver.findElement(By.id("RegisterForm:name")).clear();
            driver.findElement(By.id("RegisterForm:name")).sendKeys("Name");
            driver.findElement(By.id("RegisterForm:surname")).click();
            driver.findElement(By.id("RegisterForm:surname")).clear();
            driver.findElement(By.id("RegisterForm:surname")).sendKeys("Surname");
            driver.findElement(By.id("RegisterForm:email")).click();
            driver.findElement(By.id("RegisterForm:email")).clear();
            driver.findElement(By.id("RegisterForm:email")).sendKeys("email@mail.com");
            driver.findElement(By.id("RegisterForm:login")).click();
            driver.findElement(By.id("RegisterForm:login")).clear();
            driver.findElement(By.id("RegisterForm:login")).sendKeys("NSurname");
            driver.findElement(By.id("RegisterForm:password")).click();
            driver.findElement(By.id("RegisterForm:password")).clear();
            driver.findElement(By.id("RegisterForm:password")).sendKeys("P@ssw0rd");
            driver.findElement(By.id("RegisterForm:passwordRepeat")).click();
            driver.findElement(By.id("RegisterForm:passwordRepeat")).clear();
            driver.findElement(By.id("RegisterForm:passwordRepeat")).sendKeys("P@ssw0rd");
            driver.findElement(By.xpath("//form[@id='RegisterForm']/table/tbody/tr[7]/td[2]")).click();
            driver.findElement(By.id("RegisterForm:question")).click();
            driver.findElement(By.id("RegisterForm:question")).clear();
            driver.findElement(By.id("RegisterForm:question")).sendKeys("question");
            driver.findElement(By.id("RegisterForm:answer")).click();
            driver.findElement(By.id("RegisterForm:answer")).clear();
            driver.findElement(By.id("RegisterForm:answer")).sendKeys("answer");
            driver.findElement(By.name("RegisterForm:j_idt37")).click();
            driver.findElement(By.linkText("User account")).click();
            driver.findElement(By.linkText("New registered accounts")).click();
            driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr[4]/td")).click();
            try {
                assertEquals(driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr[4]/td")).getText(), "NSurname");
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            try {
                assertEquals(driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr[4]/td[2]")).getText(), "Name");
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            try {
                assertEquals(driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr[4]/td[3]")).getText(), "Surname");
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            try {
                assertEquals(driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr[4]/td[4]")).getText(), "email@mail.com");
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            driver.findElement(By.name("j_idt27:j_idt28:3:j_idt42")).click();
            driver.findElement(By.name("DeleteNewAccountForm:j_idt31")).click();
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