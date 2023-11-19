package com.library.steps;

import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class US02_StepDefs {

    LoginPage loginPage = new LoginPage();

    DashBoardPage dashBoardPage = new DashBoardPage();

    String actualBorrowedBooksNumber;

    @Given("the {string} on the home page")
    public void the_on_the_home_page(String user_type) {

    loginPage.login(user_type);

    }
    @When("the librarian gets borrowed books number")
    public void the_librarian_gets_borrowed_books_number() {

        actualBorrowedBooksNumber = dashBoardPage.borrowedBooksNumber.getText();

    }
    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {

    String query = "select count(*) from book_borrow\n" +
            "    where is_returned = 0";
        DB_Util.runQuery(query);

        String expectedBorrowedBooksNumber = DB_Util.getFirstRowFirstColumn();

        Assert.assertEquals(expectedBorrowedBooksNumber,actualBorrowedBooksNumber);


    }
}
