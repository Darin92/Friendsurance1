package Pages;

import Variables.LoginVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage implements LoginVariables {
    static WebDriver driver;
    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }

    public static LoginPage gotoHomePage(){
        driver.get(HOME_PAGE_URL);
        //Verify Login text is present
        Assert.assertTrue(!driver.findElements(By.xpath(LOGIN_TEXT)).isEmpty(), "No Login header on the Login page");
        return new LoginPage(driver);
    }
    public static LoginPage VerifyAccessToAllLinks(){
        driver.findElement(By.xpath(GO_LIST_EXPENSES)).click();
        //Verify Login text is present
        Assert.assertTrue(!driver.findElements(By.xpath(LOGIN_TEXT)).isEmpty(), "No Login header on the Login page");
        driver.findElement(By.xpath(GO_ADD_EXPENSES)).click();
        //Verify Login text is present
        Assert.assertTrue(!driver.findElements(By.xpath(LOGIN_TEXT)).isEmpty(), "No Login header on the Login page");
        driver.findElement(By.xpath(GO_LIST_CATEGORIES)).click();
        //Verify Login text is present
        Assert.assertTrue(!driver.findElements(By.xpath(LOGIN_TEXT)).isEmpty(), "No Login header on the Login page");
        driver.findElement(By.xpath(GO_SHOW_STATISTICS)).click();
        //Verify Login text is present
        Assert.assertTrue(!driver.findElements(By.xpath(LOGIN_TEXT)).isEmpty(), "No Login header on the Login page");
        return new LoginPage(driver);
    }
}

