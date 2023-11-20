package com.library.steps;

import com.library.pages.BookPage;
import com.library.utility.BrowserUtil;
import com.library.utility.ConfigurationReader;
import com.library.utility.DB_Util;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class US04_StepDefs {

    BookPage bookPage = new BookPage();


    @When("the user searches for {string} book")
    public void the_user_searches_for_book(String bookName) {
        bookPage.search.sendKeys(bookName);
    }

    @When("the user clicks edit book button")
    public void the_user_clicks_edit_book_button() {
        BrowserUtil.waitForVisibility(bookPage.editCustomBookBtn, 10).click();
        BrowserUtil.waitFor(3);
    }

    @Then("book information must match the Database")
    public void book_information_must_match_the_database() {

        TreeMap<String, String> actualBookDataMap = new TreeMap<>();
        bookPage.editBookInfoList.forEach(
                x->actualBookDataMap.put(x.getAttribute("name"), x.getAttribute("value")));
        actualBookDataMap.put("book_category", new Select(bookPage.editBookCategory).getFirstSelectedOption().getText());

        String query = "select b.name, b.isbn, b.year, b.author, b.description, bc.name as book_category from books b\n" +
                "join book_categories bc on b.book_category_id = bc.id\n" +
                "where b.isbn = 999240111";
        DB_Util.runQuery(query);
        Map<String,String> expectedBookDataMap = new TreeMap<>(DB_Util.getRowWithLabelAsMap(1));

        Assert.assertEquals(expectedBookDataMap, actualBookDataMap);
    }

}
