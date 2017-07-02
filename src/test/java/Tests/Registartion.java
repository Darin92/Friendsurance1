package Tests;

import Pages.AbstractPage;
import Pages.RegNewUserPage;
import Variables.LoginVariables;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Registartion implements LoginVariables{

   public static WebDriver driver;
    @BeforeClass

    public void setUp() {
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
        System.setProperty("webdriver.chrome.driver", "F:\\Auto_Tests\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test

        public void Registration() {
            RegNewUserPage regNewUserPage = new RegNewUserPage(driver);
            regNewUserPage.gotoHomePage();
            regNewUserPage.gotoRegisterNewUserPage();
            String LoginName = "Login-" + AbstractPage.getCurrentDate();
            String PasswordName1 = "Password";
            String PasswordName2 = "Password";
            regNewUserPage.RegisterNewUser(LoginName, PasswordName1, PasswordName2);
    }

    @AfterClass
    public void tearDown () {
        driver.close();
        driver.quit();
    }
}

