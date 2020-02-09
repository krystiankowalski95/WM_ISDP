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

public class ChangePasswordTest {
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
    public void changePasswordCase() {
        try {
            driver.get("https://localhost:8181/faces/main/index.xhtml");
            driver.findElement(By.linkText("Sign in")).click();
            driver.findElement(By.name("j_username")).click();
            driver.findElement(By.name("j_username")).clear();
            driver.findElement(By.name("j_username")).sendKeys("JDoe");
            driver.findElement(By.name("j_password")).click();
            driver.findElement(By.name("j_password")).clear();
            driver.findElement(By.name("j_password")).sendKeys("P@ssw0rd");
            driver.findElement(By.xpath("//input[@value='Sign in']")).click();
            driver.findElement(By.linkText("Settings")).click();
            driver.findElement(By.linkText("Change password")).click();
            driver.findElement(By.id("ChangeMyPasswordForm:oldPassword")).click();
            driver.findElement(By.id("ChangeMyPasswordForm:oldPassword")).clear();
            driver.findElement(By.id("ChangeMyPasswordForm:oldPassword")).sendKeys("P@ssw0rd");
            driver.findElement(By.id("ChangeMyPasswordForm:newPassword")).click();
            driver.findElement(By.id("ChangeMyPasswordForm:newPassword")).clear();
            driver.findElement(By.id("ChangeMyPasswordForm:newPassword")).sendKeys("NewP@ssw0rd");
            driver.findElement(By.id("ChangeMyPasswordForm:newPasswordRepeat")).click();
            driver.findElement(By.id("ChangeMyPasswordForm:newPasswordRepeat")).clear();
            driver.findElement(By.id("ChangeMyPasswordForm:newPasswordRepeat")).sendKeys("NewP@ssw0rd");
            driver.findElement(By.name("ChangeMyPasswordForm:j_idt33")).click();
            driver.findElement(By.linkText("Sign out")).click();
            driver.findElement(By.name("j_idt27:j_idt31")).click();
            driver.findElement(By.linkText("Sign in")).click();
            driver.findElement(By.name("j_username")).click();
            driver.findElement(By.name("j_username")).clear();
            driver.findElement(By.name("j_username")).sendKeys("JDoe");
            driver.findElement(By.name("j_password")).click();
            driver.findElement(By.name("j_password")).clear();
            driver.findElement(By.name("j_password")).sendKeys("P@ssw0rd");
            driver.findElement(By.xpath("//input[@value='Sign in']")).click();
            try {
                assertEquals(driver.findElement(By.xpath("//p")).getText(), "Incorrect login or password");
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            driver.findElement(By.linkText("Sign in")).click();
            driver.findElement(By.name("j_username")).click();
            driver.findElement(By.name("j_username")).clear();
            driver.findElement(By.name("j_username")).sendKeys("JDoe");
            driver.findElement(By.name("j_password")).click();
            driver.findElement(By.name("j_password")).clear();
            driver.findElement(By.name("j_password")).sendKeys("NewP@ssw0rd");
            driver.findElement(By.xpath("//input[@value='Sign in']")).click();
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