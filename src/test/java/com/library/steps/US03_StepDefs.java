package com.library.steps;

import com.library.pages.BasePage;
import com.library.pages.BookPage;
import com.library.utility.BrowserUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class US03_StepDefs {
    BookPage bookPage = new BookPage();
    Select select = new Select(bookPage.categoryDropdown);

    @When("the user navigates to {string} page")
    public void the_user_navigates_to_page(String module) {
        bookPage.navigateModule(module);
    }
    @When("the user clicks book categories")
    public void the_user_clicks_book_categories() {
        bookPage.categoryDropdown.click();
        BrowserUtil.waitFor(3);
    }
    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {
        List<WebElement> BookCategories = select.getOptions();
        List<String> actualBookCategories = BookCategories.stream().map(WebElement::getText).collect(Collectors.toList());
        System.out.println(actualBookCategories);
    }

}
