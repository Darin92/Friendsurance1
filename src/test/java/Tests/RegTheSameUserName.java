package Tests;

import Pages.AbstractPage;
import Pages.RegNewUserPage;
import Variables.LoginVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegTheSameUserName implements LoginVariables{

    public static WebDriver driver;
    @BeforeClass

    public void setUp() {
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
        System.setProperty("webdriver.chrome.driver", "F:\\Auto_Tests\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public static void RegTheSameUserName() {
        //First register a new user
        RegNewUserPage regNewUserPage = new RegNewUserPage(driver);
        regNewUserPage.gotoHomePage();
        regNewUserPage.gotoRegisterNewUserPage();
        String LoginName = "Login-" + AbstractPage.getCurrentDate();
        String PasswordName1 = "Password";
        String PasswordName2 = "Password";
        regNewUserPage.RegisterNewUser(LoginName, PasswordName1, PasswordName2);

        //logout
        driver.findElement(By.xpath(".//*[@id='logout']")).click();
        //Reg the same user again
        regNewUserPage.gotoRegisterNewUserPage();
        //Use the same LoginName, PasswordName1, PasswordName2 while registration
        regNewUserPage.RegisterTheSameUser(LoginName, PasswordName1, PasswordName2);
    }

    @AfterClass
    public void tearDown () {
        driver.close();
        driver.quit();
    }
}
