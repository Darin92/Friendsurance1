package Pages;

import Variables.CategoriesVariables;
import Variables.LoginVariables;
import org.openqa.selenium.*;
import org.testng.Assert;
import java.util.List;

public class CategoriesPage implements CategoriesVariables, LoginVariables{
    static WebDriver driver;
    public int standardTimeout = 20;

    public CategoriesPage(WebDriver driver) {
        this.driver = driver;
    }

    public static CategoriesPage gotoAddCategoryPage() {
        driver.get(HOME_PAGE_URL);
        driver.findElement(By.xpath(LIST_CATEGORIES_PAGE_LINK)).click();
        //Verify Login text is present
        Assert.assertTrue(!driver.findElements(By.xpath(LIST_CATEGORIES_TEXT)).isEmpty(),
                "No List Categories header on the Categories page");
        return new CategoriesPage(driver);
    }
    public static CategoriesPage CreateCategory(String name) {
        driver.findElement(By.xpath(ADD_CATEGORY_LINK)).click();
        Assert.assertTrue(!driver.findElements(By.xpath(ADD_CATEGORIES_TEXT)).isEmpty(),
                "No Add Categories header on the Add Categories page");
        driver.findElement(By.xpath(NAME_CATEGORIES_FIELD)).sendKeys(name);
        driver.findElement(By.xpath(CREATE_CATEGORY_BUTTON)).click();
        Assert.assertTrue(!driver.findElements(By.xpath(LIST_CATEGORIES_TEXT)).isEmpty(),
                "No List Categories header on the Categories page");
        return new CategoriesPage(driver);
    }

    public String getTextOnElement(String xpath) {
        for (int i = 0; i <= standardTimeout; i++) {
            List<WebElement> matching_elements = driver.findElements(By.xpath(xpath));
            for (WebElement elem : matching_elements) {
                try {
                    Dimension d = elem.getSize();
                    if (d.getWidth() > 0 && elem.isDisplayed()) {
                        return elem.getText();
                    }
                } catch (StaleElementReferenceException e) {
                } catch (ElementNotVisibleException e) {
                }
            }
        }
        return null;
    }
}
