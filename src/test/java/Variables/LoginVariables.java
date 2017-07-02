package Variables;

public interface LoginVariables {
    String HOME_PAGE_URL = "http://thawing-shelf-73260.herokuapp.com/index.jsp";
    String LOGIN_TEXT = ".//h3[contains(text(), \"Login\")]";
    String REGISTER_NEW_USER_LINK = ".//a[contains(text(),'Register new user')]";
    String LOGIN_FIELD = " .//*[@id='login']";
    String PASSWORD_FIELD = ".//*[@id='password']";
    String PASSWORD1_FIELD = ".//*[@id='password1']";
    String PASSWORD2_FIELD = ".//*[@id='password2']";
    String SUBMIT_BUTTON = ".//*[@id='submit']";
    String REGISTER_NEW_USER_TEXT = ".//h3[contains(text(), \"Register new user\")]";
    String LIST_EXPENSES_TEXT = ".//h1[contains(text(), \"List Expenses\")]";
    String VALIDATION_ALERT_DANGER = ".alert.alert-danger";
    String EDIT_ACCOUNT_LINK = ".//*[@id='editaccount']";
    String EDIT_ACCOUNT_TEXT = ".//h1[contains(text(), \"Edit Account\")]";
    String NEW_PASSWORD1_FIELD = ".//*[@id='newpassword1']";
    String NEW_PASSWORD2_FIELD = ".//*[@id='newpassword2']";
    String GO_LIST_EXPENSES = ".//*[@id='go_list_expenses']";
    String GO_ADD_EXPENSES = ".//*[@id='go_add_expense']";
    String GO_LIST_CATEGORIES = ".//*[@id='go_list_categories']";
    String GO_SHOW_STATISTICS = ".//*[@id='go_show_statistics']";
}
