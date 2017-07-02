package Tests;

import Pages.AbstractPage;
import Pages.CategoriesPage;
import Pages.ExpensesPage;
import Pages.RegNewUserPage;
import Variables.CategoriesVariables;
import Variables.ExpensesVariables;
import Variables.LoginVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExpensesTest implements ExpensesVariables, LoginVariables, CategoriesVariables {
    public static WebDriver driver;
    @BeforeClass

    public void setUp() {
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
        System.setProperty("webdriver.chrome.driver", "F:\\Auto_Tests\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void CreareNewExpensesTest() {
        //Register new user
        RegNewUserPage regNewUserPage = new RegNewUserPage(driver);
        regNewUserPage.gotoHomePage();
        regNewUserPage.gotoRegisterNewUserPage();
        String LoginName = "Login-" + AbstractPage.getCurrentDate();
        String PasswordName1 = "Password";
        String PasswordName2 = "Password";
        regNewUserPage.RegisterNewUser(LoginName, PasswordName1, PasswordName2);
        //Verify that you successfully create new user
        //Verify List Expenses text is present that is meat that user is already logged in
        Assert.assertTrue(!driver.findElements(By.xpath(LIST_EXPENSES_TEXT)).isEmpty(),
                "No List Expenses header on the page Already logged in page");

        //CreateCategory
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        String name = "Category-" + AbstractPage.getCurrentDate();
        categoriesPage.gotoAddCategoryPage();
        categoriesPage.CreateCategory(name);
        String nameOfCreatedCategory = categoriesPage.getTextOnElement(String.format(NAME_OF_CREATED_CATEGORY, name));
        Assert.assertTrue(name.equals(nameOfCreatedCategory), "Not correct name of created category on Category List"
                + nameOfCreatedCategory);

        //Create new Expense
        ExpensesPage expensesPage = new ExpensesPage(driver);
        expensesPage.gotoAddExpensesPage();
        expensesPage.VerifyFieldsOnAddExpensesPage();
        String day = "1";
        String month = "12";
        String year = "2016";
        String num = "10";
        String text = "text";
        expensesPage.CreateExpenses(day, month, year, num, text);
        Assert.assertTrue(!driver.findElements(By.xpath(LIST_EXPENSES_TEXT)).isEmpty(),
                "No List Expenses header on the page, new expenses is not created");
        //Verify name of Category on Expense List
        String nameOfCreatedCategoryInExpense = categoriesPage.getTextOnElement(String.format(NAME_OF_CREATED_CATEGORY, name));
        Assert.assertTrue(name.equals(nameOfCreatedCategoryInExpense), "Not correct name of created category in Expenses List "
                + nameOfCreatedCategory);
    }

    @Test
    public void VerifyDataOnListExpensesPageTest() {
        //Register new user
        RegNewUserPage regNewUserPage = new RegNewUserPage(driver);
        regNewUserPage.gotoHomePage();
        regNewUserPage.gotoRegisterNewUserPage();
        String LoginName = "Login-" + AbstractPage.getCurrentDate();
        String PasswordName1 = "Password";
        String PasswordName2 = "Password";
        regNewUserPage.RegisterNewUser(LoginName, PasswordName1, PasswordName2);

        //Verify data on List Expenses page
        ExpensesPage expensesPage = new ExpensesPage(driver);
        expensesPage.gotoListExpensesPage();
        expensesPage.VerifyFieldsOnListExpensesPage();
    }

    @AfterClass
    public void tearDown () {
        driver.close();
        driver.quit();
    }
}
