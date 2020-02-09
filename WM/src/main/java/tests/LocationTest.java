package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class LocationTest {

    @Test
    public void LocationCase() {
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        System.setProperty("webdriver.gecko.driver", "/var/lib/jenkins/workspace/test/WM/geckodriver/geckodriver");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
        try {
            driver.get("http://localhost:8080/faces/main/index.xhtml");
            driver.findElement(By.linkText("Sign in")).click();
            driver.findElement(By.name("j_username")).click();
            driver.findElement(By.name("j_username")).click();
            driver.findElement(By.name("j_username")).click();
            driver.findElement(By.name("j_username")).clear();
            driver.findElement(By.name("j_username")).sendKeys("JDoe");
            driver.findElement(By.name("j_password")).click();
            driver.findElement(By.name("j_password")).clear();
            driver.findElement(By.name("j_password")).sendKeys("P@ssw0rd");
            driver.findElement(By.name("j_username")).click();
            driver.findElement(By.xpath("//input[@value='Sign in']")).click();
            driver.findElement(By.xpath("//h4")).click();
            try {
                assertEquals("Authenticated user: JDoe", driver.findElement(By.xpath("//h4")).getText());
            } catch (Error e) {
                System.out.println(e.toString());
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
                assertEquals("TT-00-00-00", driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr[11]/td")).getText());
            } catch (Error e) {
                System.out.println(e.toString());
            }
            try {
                assertEquals("WHOLE", driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr[11]/td[2]")).getText());
            } catch (Error e) {
                System.out.println(e.toString());
            }
            driver.findElement(By.name("j_idt27:j_idt28:10:onlyWarehouse:j_idt38")).click();
            driver.findElement(By.id("EditLocationForm:locationType")).click();
            new Select(driver.findElement(By.id("EditLocationForm:locationType"))).selectByVisibleText("HALF");
            driver.findElement(By.xpath("//option[@value='SHELF2']")).click();
            driver.findElement(By.name("EditLocationForm:j_idt32")).click();
            try {
                assertEquals("HALF", driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr[11]/td[2]")).getText());
            } catch (Error e) {
                System.out.println(e.toString());
            }
            try {
                assertEquals("TT-00-00-00", driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr[11]/td")).getText());
            } catch (Error e) {
                System.out.println(e.toString());
            }
            driver.findElement(By.name("j_idt27:j_idt28:10:onlyWarehouse:j_idt39")).click();
            driver.findElement(By.name("DeleteLocationForm:j_idt31")).click();
            try {
                assertEquals("AA-01-04-04", driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr[10]/td")).getText());
            } catch (Error e) {
                System.out.println(e.toString());
            }
            try {
                assertEquals("QUARTER", driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr[10]/td[2]")).getText());
            } catch (Error e) {
                System.out.println(e.toString());
            }
            driver.findElement(By.linkText("Sign out")).click();
            driver.findElement(By.name("j_idt27:j_idt31")).click();


        } finally {
            driver.quit();
        }
    }
}
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxBinary;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.support.ui.Select;
//
//
//import java.util.concurrent.TimeUnit;
//
//import org.testng.annotations.Test;
//
//
//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertNull;
//
//
//
//public class LocationTest {
//    @Test
//    public static void main(String [] args) {
//        FirefoxBinary firefoxBinary = new FirefoxBinary();
//        firefoxBinary.addCommandLineOptions("--headless");
//        System.setProperty("webdriver.gecko.driver", "/var/lib/jenkins/workspace/test/WM/geckodriver/geckodriver");
//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        firefoxOptions.setBinary(firefoxBinary);
//        FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
//        try {
//            driver.get("http://localhost:8080/faces/main/index.xhtml");
//            driver.findElement(By.linkText("Logowanie")).click();
//            driver.findElement(By.name("j_username")).click();
//            driver.findElement(By.name("j_username")).click();
//            driver.findElement(By.name("j_username")).click();
//            driver.findElement(By.name("j_username")).clear();
//            driver.findElement(By.name("j_username")).sendKeys("JDoe");
//            driver.findElement(By.name("j_password")).click();
//            driver.findElement(By.name("j_password")).clear();
//            driver.findElement(By.name("j_password")).sendKeys("P@ssw0rd");
//            driver.findElement(By.name("j_username")).click();
//            driver.findElement(By.xpath("//input[@value='Zaloguj']")).click();
//            driver.findElement(By.xpath("//h4")).click();
//            try {
//                assertEquals("Uwierzytelniony użytkownik: JDoe", driver.findElement(By.xpath("//h4")).getText());
//            } catch (Error e) {
//                System.out.println(e.toString());
//            }
//            driver.findElement(By.linkText("Lokalizacja")).click();
//            driver.findElement(By.linkText("Utwórz nową lokalizację")).click();
//            driver.findElement(By.id("CreateLocationForm:locationSymbol")).click();
//            driver.findElement(By.id("CreateLocationForm:locationSymbol")).clear();
//            driver.findElement(By.id("CreateLocationForm:locationSymbol")).sendKeys("TT-00-00-00");
//            driver.findElement(By.id("CreateLocationForm:locationType")).click();
//            new Select(driver.findElement(By.id("CreateLocationForm:locationType"))).selectByVisibleText("CAŁA");
//            driver.findElement(By.xpath("//option[@value='SHELF1']")).click();
//            driver.findElement(By.name("CreateLocationForm:j_idt35")).click();
//            driver.findElement(By.linkText("Lokalizacja")).click();
//            driver.findElement(By.linkText("Lista lokalizacji")).click();
//            try {
//                assertEquals("TT-00-00-00", driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr[11]/td")).getText());
//            } catch (Error e) {
//                System.out.println(e.toString());
//            }
//            try {
//                assertEquals("CAŁA", driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr[11]/td[2]")).getText());
//            } catch (Error e) {
//                System.out.println(e.toString());
//            }
//            driver.findElement(By.name("j_idt27:j_idt28:10:onlyWarehouse:j_idt38")).click();
//            driver.findElement(By.id("EditLocationForm:locationType")).click();
//            new Select(driver.findElement(By.id("EditLocationForm:locationType"))).selectByVisibleText("POŁOWA");
//            driver.findElement(By.xpath("//option[@value='SHELF2']")).click();
//            driver.findElement(By.name("EditLocationForm:j_idt32")).click();
//            try {
//                assertEquals("POŁOWA", driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr[11]/td[2]")).getText());
//            } catch (Error e) {
//                System.out.println(e.toString());
//            }
//            try {
//                assertEquals("TT-00-00-00", driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr[11]/td")).getText());
//            } catch (Error e) {
//                System.out.println(e.toString());
//            }
//            driver.findElement(By.name("j_idt27:j_idt28:10:onlyWarehouse:j_idt39")).click();
//            driver.findElement(By.name("DeleteLocationForm:j_idt31")).click();
//            try {
//                assertEquals("AA-01-04-04", driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr[10]/td")).getText());
//            } catch (Error e) {
//                System.out.println(e.toString());
//            }
//            try {
//                assertEquals("JEDNA CZWARTA", driver.findElement(By.xpath("//form[@id='j_idt27']/table/tbody/tr[10]/td[2]")).getText());
//            } catch (Error e) {
//                System.out.println(e.toString());
//            }
//            driver.findElement(By.linkText("Wylogowanie")).click();
//            driver.findElement(By.name("j_idt27:j_idt31")).click();
//
//
//        } finally {
//            driver.quit();
//        }
//    }
//}