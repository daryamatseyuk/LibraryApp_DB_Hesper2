package com.library.steps;

import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import com.library.pages.BookPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.Map;

public class US06RO_StepDefs {

    BookPage bookPage = new BookPage();
    LoginPage loginPage = new LoginPage();

    @Given("the {string} on the home page RO")
    public void theOnTheHomePageRO(String userType) {
        loginPage.login(userType);
    }

    @Given("the user logged in as {string} RO")
    public void theUserLoggedInAsRO(String userType) {
        loginPage.login(userType);
        BrowserUtil.waitFor(4);
    }

    @And("the user navigates to {string} page RO")
    public void theUserNavigatesToPageRO(String module) {
        bookPage.navigateModule(module);
    }

    @When("the librarian click to add book RO")
    public void the_librarian_click_to_add_book() {
        bookPage.addBook.click();
    }

    @When("the librarian enter book name {string} RO")
    public void the_librarian_enter_book_name(String string) {
        bookPage.bookName.sendKeys(string);
    }

    @When("the librarian enter ISBN {string} RO")
    public void the_librarian_enter_isbn(String string) {
        bookPage.isbn.sendKeys(string);
    }

    @When("the librarian enter year {string} RO")
    public void the_librarian_enter_year(String string) {
        bookPage.year.sendKeys(string);
    }

    @When("the librarian enter author {string} RO")
    public void the_librarian_enter_author(String string) {
        bookPage.author.sendKeys(string);
    }

    @When("the librarian choose the book category {string} RO")
    public void the_librarian_choose_the_book_category(String string) {
        BrowserUtil.selectOptionDropdown(bookPage.categoryDropdown,string);
    }

    @When("the librarian click to save changes RO")
    public void the_librarian_click_to_save_changes() {
        bookPage.saveChanges.click();
    }

    @Then("verify {string} message is displayed RO")
    public void verify_the_book_has_been_created_message_is_displayed(String expectedMessage) {
        String actualMessage = bookPage.toastMessage.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Then("verify {string} information must match with DB RO")
    public void verify_information_must_match_with_db(String expectedBookName) {
        String query = "select name, author, isbn from books\n" +
                "where name = '"+expectedBookName+"'";

        DB_Util.runQuery(query);
        Map<String, String> rowMap = DB_Util.getRowMap(1);
        String actualBookName = rowMap.get("name");
        Assert.assertEquals(expectedBookName,actualBookName);
    }



}




