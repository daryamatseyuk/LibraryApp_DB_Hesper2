package com.library.steps;

import com.library.pages.BookPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import com.library.utility.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class US04_StepDefs {

    String bookName1 = "";
    String ISBN = "";
    BookPage bookPage = new BookPage();

    @When("the user searches for {string} book")
    public void the_user_searches_for_book(String bookName) {
        BrowserUtil.waitFor(1);
        bookPage.search.sendKeys(bookName + Keys.ENTER);
        BrowserUtil.waitFor(2);
        bookName1 = bookName;

    }


    @When("the user clicks edit book button")
    public void the_user_clicks_edit_book_button() {

        bookPage.editBook(bookName1).click();
        BrowserUtil.waitFor(2);

    }


    @Then("book information must match the Database")
    public void book_information_must_match_the_database() {

        Select select = new Select(Driver.getDriver().findElement(By.id("book_group_id")));

        String actualBookValue = bookPage.bookName.getAttribute("value");
        String actualIsbn = bookPage.isbn.getAttribute("value");
        String actualYear = bookPage.year.getAttribute("value");
        String actualAuthor = bookPage.author.getAttribute("value");
        String actualActionAndAdventure = select.getFirstSelectedOption().getText();
        String actualDescription = bookPage.description.getAttribute("value");
        this.ISBN = actualIsbn;

        System.out.println("isbn = " + actualIsbn);
        List<String> actualUI_Data = new ArrayList<>(Arrays.asList(actualBookValue, actualIsbn, actualYear, actualAuthor, actualActionAndAdventure, actualDescription));
        //created List of actualUI_Data


        //=========================================================================

        String query = "select b.name, isbn,year,author,bc.name,b.description from books b\n" +
                "        join book_categories bc\n" +
                "            on b.book_category_id = bc.id\n" +
                "where isbn = "+ISBN+"";

        DB_Util.runQuery(query);

        List<String> expectedDataFromDB = DB_Util.getRowDataAsList(1);
        System.out.println(actualUI_Data);
        System.out.println(expectedDataFromDB);

        Assert.assertEquals(actualUI_Data,expectedDataFromDB);

    }


}
