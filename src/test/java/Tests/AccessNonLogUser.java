package Tests;

import Pages.LoginPage;
import Variables.LoginVariables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccessNonLogUser implements LoginVariables {
    public static WebDriver driver;
    @BeforeClass

    public void setUp() {
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
        System.setProperty("webdriver.chrome.driver", "F:\\Auto_Tests\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void AccessNonLogUser() {
        LoginPage loginPage = new LoginPage(driver);
        LoginPage.gotoHomePage();
        LoginPage.VerifyAccessToAllLinks();
    }

    @AfterClass
    public void tearDown () {
        driver.close();
        driver.quit();
    }
}

