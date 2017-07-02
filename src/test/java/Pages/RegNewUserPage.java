package Pages;

import Variables.LoginVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegNewUserPage implements LoginVariables {
    protected WebDriver driver;
    public RegNewUserPage (WebDriver driver) {
        this.driver = driver;
    }

    public RegNewUserPage gotoHomePage (){
        driver.get(HOME_PAGE_URL);
        //Verify Login text is present
        Assert.assertTrue(!driver.findElements(By.xpath(LOGIN_TEXT)).isEmpty(), "No Login header on the Login page");
        return new RegNewUserPage(driver);
    }

    public RegNewUserPage gotoRegisterNewUserPage (){
        driver.findElement(By.xpath(REGISTER_NEW_USER_LINK)).click();
        //Verify Register new user text is present
        Assert.assertTrue(!driver.findElements(By.xpath(REGISTER_NEW_USER_TEXT)).isEmpty(),
                "No Register new user header on the Register new user page");
        return new RegNewUserPage(driver);
    }

    public void RegisterNewUser(String loginName, String passwordName1, String passwordName2) {
        driver.findElement(By.xpath(LOGIN_FIELD)).sendKeys(loginName);
        driver.findElement(By.xpath(PASSWORD1_FIELD)).sendKeys(passwordName1);
        driver.findElement(By.xpath(PASSWORD2_FIELD)).sendKeys(passwordName2);
        driver.findElement(By.xpath(SUBMIT_BUTTON)).click();
        //Verify that you successfully create new user
        //Verify List Expenses text is present that is meat that user is already logged in
        Assert.assertTrue(!driver.findElements(By.xpath(LIST_EXPENSES_TEXT)).isEmpty(),
                "No List Expenses header on the page Already logged in page");
    }

    public void RegisterTheSameUser(String loginName, String passwordName1, String passwordName2) {
        driver.findElement(By.xpath(LOGIN_FIELD)).sendKeys(loginName);
        driver.findElement(By.xpath(PASSWORD1_FIELD)).sendKeys(passwordName1);
        driver.findElement(By.xpath(PASSWORD2_FIELD)).sendKeys(passwordName2);
        driver.findElement(By.xpath(SUBMIT_BUTTON)).click();
       //Verify validation appears after trying to create the same user
        Assert.assertTrue(!driver.findElements(By.cssSelector(VALIDATION_ALERT_DANGER)).isEmpty(),
                "No validation appears after trying to create the same user ");
    }

    public void LoginAsCreatedUser (String loginName, String passwordName){
        driver.findElement(By.xpath(LOGIN_FIELD)).sendKeys(loginName);
        driver.findElement(By.xpath(PASSWORD_FIELD)).sendKeys(passwordName);
        driver.findElement(By.xpath(SUBMIT_BUTTON)).click();
    }

    public void GoToEditAccoutPage(){
        driver.findElement(By.xpath(EDIT_ACCOUNT_LINK)).click();
        //Verify Register new user text is present
        Assert.assertTrue(!driver.findElements(By.xpath(EDIT_ACCOUNT_TEXT )).isEmpty(),
                "No Edit Account  header on the Register new user page");
    }

    public void ChangePassword (String passwordName,String passwordName3,String passwordName4){
        driver.findElement(By.xpath(PASSWORD_FIELD)).sendKeys(passwordName);
        driver.findElement(By.xpath(NEW_PASSWORD1_FIELD)).sendKeys(passwordName3);
        driver.findElement(By.xpath(NEW_PASSWORD2_FIELD)).sendKeys(passwordName4);
        driver.findElement(By.xpath(SUBMIT_BUTTON)).click();
        //Verify that you successfully change user data
        //Verify List Expenses text is present that is meant that user is successfully change data
        Assert.assertTrue(!driver.findElements(By.xpath(LIST_EXPENSES_TEXT)).isEmpty(),
                "No List Expenses header on the page Already logged in page");
    }
}
