package Variables;

public interface CategoriesVariables {
    String LIST_CATEGORIES_TEXT = ".//h1[contains(text(), \"List Categories\")]";
    String LIST_CATEGORIES_PAGE_LINK = ".//*[@id='go_list_categories']";
    String ADD_CATEGORY_LINK = ".//*[@id='go_add_category']";
    String NAME_CATEGORIES_TEXT =  ".//th[contains(text(), \"Name\")]";
    String MODIFY_CATEGORIES_TEXT =  ".//th[contains(text(), \"Modify\")]";
    String ADD_CATEGORIES_TEXT = ".//h1[contains(text(), \"Add Category\")]";
    String COLUMN_NAME_CATEGORIES_TEXT =  ".//label[contains(text(), \"Name\")]";
    String NAME_CATEGORIES_FIELD = ".//*[@id='name']";
    String CREATE_CATEGORY_BUTTON = ".//*[@id='submit']";
    String NAME_OF_CREATED_CATEGORY = "//td[.='%s']";
    String EDIT_CATEGORY_LINK = ".//td[.='%s']/img[@alt='edit category']";
    String DELETE_CATEGORY_LINK = ".//td[.='%s']/img[@alt='delete category']";
    String EDIT_CATEGORIES_TEXT = ".//h1[contains(text(), \"Edit Category\")]";
    String SAVE_CATEGORY_BUTTON = ".//*[@id='submit']";
}
