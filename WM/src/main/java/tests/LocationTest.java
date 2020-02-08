package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class LocationTest {

    @Test
    public void ChangeUserRole() {
        System.setProperty("webdriver.gecko.driver", System.getenv("WEBDRIVER"));
        WebDriver webDriver = new FirefoxDriver();
        webDriver.navigate().to(System.getenv("WM") + "/faces/common/signIn.xhtml");
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr/td/table/tbody/tr[1]/td[2]/input")).sendKeys(System.getenv("LOGINA"));
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr/td/table/tbody/tr[2]/td[2]/input")).sendKeys(System.getenv("PASSWORDA"));
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/p/input")).click();
        webDriver.navigate().to(System.getenv("WM") + "/faces/account/listAuthorizedAccounts.xhtml");
        String value = webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr[1]/td[5]/input[5]")).getAttribute("disabled");
        assertNull(value);
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr[1]/td[5]/input[5]")).click();
        value = webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr[1]/td[5]/input[5]")).getAttribute("disabled");
        assertEquals("true", value);
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr[1]/td[5]/input[4]")).click();
        value = webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr[1]/td[5]/input[5]")).getAttribute("disabled");
        assertNull(value);
        webDriver.quit();
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