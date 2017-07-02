package Tests;

import Pages.AbstractPage;
import Pages.CategoriesPage;
import Pages.RegNewUserPage;
import Variables.CategoriesVariables;
import Variables.ExpensesVariables;
import Variables.LoginVariables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CategoryTest extends  AbstractPage implements ExpensesVariables, LoginVariables, CategoriesVariables {
    public static WebDriver driver;

    @BeforeClass

    public void setUp() {
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
        System.setProperty("webdriver.chrome.driver", "F:\\Auto_Tests\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
        public void CreateCategoryTest() {
        //Register new user
        RegNewUserPage regNewUserPage = new RegNewUserPage(driver);
        regNewUserPage.gotoHomePage();
        regNewUserPage.gotoRegisterNewUserPage();
        String LoginName = "Login-" + AbstractPage.getCurrentDate();
        String PasswordName1 = "Password";
        String PasswordName2 = "Password";
        regNewUserPage.RegisterNewUser(LoginName, PasswordName1, PasswordName2);

        //CreateCategory
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        String name = "Category-" + AbstractPage.getCurrentDate();
        categoriesPage.gotoAddCategoryPage();
        categoriesPage.CreateCategory(name);
        String nameOfCreatedCategory = categoriesPage.getTextOnElement(String.format(NAME_OF_CREATED_CATEGORY, name));
        Assert.assertTrue(name.equals(nameOfCreatedCategory), "Not correct name of created category "
                + nameOfCreatedCategory);
    }

    @AfterClass
    public void tearDown () {
        driver.close();
        driver.quit();
    }

}
