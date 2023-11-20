package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.BorrowedBooksPage;
import com.library.utility.DB_Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class US07_StepDefs {

    BookPage bookPage = new BookPage();
    BorrowedBooksPage borrowedBooksPage = new BorrowedBooksPage();
    String str;

    @And("the user searches for {string} book")
    public void theUserSearchesForBook(String bookName) {

        str = bookName;
        bookPage.search.sendKeys(bookName);

    }

    @When("the user clicks Borrow Book")
    public void theUserClicksBorrowBook() {
        bookPage.borrowBook(str);
    }

    @Then("verify that book is shown in {string} page")
    public void verifyThatBookIsShownInPage(String module) {

        bookPage.navigateModule(module);
        List<String> actualListOfBooksBorrowed = new ArrayList<>();
/*
        for (WebElement eachWebElement : borrowedBooksPage.allBorrowedBooksName) {

            actualListOfBooksBorrowed.add(eachWebElement.getText());

        }

 */
        Assert.assertEquals(borrowedBooksPage.allBorrowedBooksName.get(borrowedBooksPage.allBorrowedBooksName.size()-1).getText(), str);
       // Assert.assertTrue(actualListOfBooksBorrowed.contains(str));

    }

    @And("verify logged student has same book in database")
    public void verifyLoggedStudentHasSameBookInDatabase() {
        DB_Util.runQuery("");
    }
}
