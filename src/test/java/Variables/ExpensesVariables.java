package Variables;

public interface ExpensesVariables {
    String ADD_EXPENSES_PAGE_LINK = ".//*[@id='go_add_expense']";
    String ADD_EXPENSES_TEXT = ".//h1[contains(text(), \"Add Expense\")]";
    String LIST_EXPENSES_PAGE_LINK = ".//*[@id='go_list_expenses']";
    String LIST_EXPENSES_PAGE_TEXT = ".//h1[contains(text(), \"List Expenses\")]";

    String DATE_TEXT = ".//label[contains(text(), \"Date\")]";
    String CATEGORY_TEXT = ".//label[contains(text(), \"Category\")]";
    String AMOUNT_TEXT = ".//label[contains(text(), \"Amount (€)\")]";
    //  String REASON_TEXT = ".//label[contains(text(), \"Reason\")]";
    String DAY_FIELD = ".//*[@id='day']";
    String MONTH_FIELD = ".//*[@id='month']";
    String YEAR_FIELD = ".//*[@id='year']";
    String CATEGORY_FIELD = ".//*[@id='category']";
    String AMMOUNT_FIELD = ".//*[@id='amount']";
    String REASON_FIELD = ".//*[@id='reason']";
    String CREATE_EXPENSE_BUTTON = ".//*[@id='submit']";
    String DATE_TEXT_ON_LIST_PAGE = ".//tr[2]/th[1][contains(text(), \"Date\")]";
    String CATEGORY_TEXT_ON_LIST_PAGE = ".//tr[2]/th[contains(text(), \"Category\")]";
    String AMOUNT_TEXT_ON_LIST_PAGE = ".//tr[2]/th[contains(text(), \"Amount\")]";
    //  String REASON_TEXT_ON_LIST = ".//tr[2]/th[contains(text(), "Reason")]";
}