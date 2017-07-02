package Pages;

import Variables.ExpensesVariables;
import Variables.LoginVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ExpensesPage implements ExpensesVariables, LoginVariables {
    static WebDriver driver;

    public ExpensesPage(WebDriver driver) {
        this.driver = driver;
    }

    public static ExpensesPage gotoAddExpensesPage() {
        driver.get(HOME_PAGE_URL);
        driver.findElement(By.xpath(ADD_EXPENSES_PAGE_LINK)).click();

        //Verify Login text is present
        Assert.assertTrue(!driver.findElements(By.xpath(ADD_EXPENSES_TEXT)).isEmpty(), "No Add expenses header on the Login page");
        return new ExpensesPage(driver);
    }

    public static ExpensesPage gotoListExpensesPage() {
        driver.get(HOME_PAGE_URL);
        driver.findElement(By.xpath(LIST_EXPENSES_PAGE_LINK)).click();
        //Verify Login text is present
        Assert.assertTrue(!driver.findElements(By.xpath(LIST_EXPENSES_PAGE_TEXT)).isEmpty(), "No List expenses header on the Login page");
        return new ExpensesPage(driver);
    }

    public static ExpensesPage CreateExpenses(String day, String month, String year, String num, String text) {
        driver.findElement(By.xpath(DAY_FIELD)).sendKeys(month);
        driver.findElement(By.xpath(MONTH_FIELD)).sendKeys(day);
        driver.findElement(By.xpath(YEAR_FIELD)).sendKeys(year);
        driver.findElement(By.xpath(AMMOUNT_FIELD)).sendKeys(num);
        driver.findElement(By.xpath(REASON_FIELD)).sendKeys(text);
        driver.findElement(By.xpath(CREATE_EXPENSE_BUTTON)).click();
        return new ExpensesPage(driver);
    }

    public static ExpensesPage VerifyFieldsOnAddExpensesPage() {
        Assert.assertTrue(!driver.findElements(By.xpath(DATE_TEXT)).isEmpty(), "No Date text on AddExpensesPage");
        Assert.assertTrue(!driver.findElements(By.xpath(CATEGORY_TEXT)).isEmpty(), "No Category on AddExpensesPage");
        Assert.assertTrue(!driver.findElements(By.xpath(AMOUNT_TEXT)).isEmpty(), "No amount text on AddExpensesPage");
        return new ExpensesPage(driver);
    }

    public static ExpensesPage VerifyFieldsOnListExpensesPage() {
        Assert.assertTrue(!driver.findElements(By.xpath(DATE_TEXT_ON_LIST_PAGE)).isEmpty(), "No Date text on list Expenses page");
        Assert.assertTrue(!driver.findElements(By.xpath(CATEGORY_TEXT_ON_LIST_PAGE)).isEmpty(), "No Category on list Expenses page");
        Assert.assertTrue(!driver.findElements(By.xpath(AMOUNT_TEXT_ON_LIST_PAGE)).isEmpty(), "No amount text on list Expenses page");
        return new ExpensesPage(driver);
    }
}

