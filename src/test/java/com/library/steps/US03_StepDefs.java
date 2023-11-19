package com.library.steps;
import com.library.pages.BookPage;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.stream.Collectors;

public class US03_StepDefs {
    BookPage bookPage = new BookPage();

    @When("the user navigates to {string} page")
    public void the_user_navigates_to_page(String module) {
        bookPage.navigateModule(module);
    }
    @When("the user clicks book categories")
    public void the_user_clicks_book_categories() {
        bookPage.categoryDropdown.click();
    }
    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {
        Select select = new Select(bookPage.categoryDropdown);

        List<WebElement> bookCategories = select.getOptions();
        List<String> actualBookCategories = bookCategories.stream().map(WebElement::getText).collect(Collectors.toList());
        actualBookCategories.remove(0);

        DB_Util.runQuery("select name from book_categories");
        List<String> expectedColumnDataAsList = DB_Util.getColumnDataAsList(1);

        Assert.assertEquals(expectedColumnDataAsList,actualBookCategories);

    }

}
