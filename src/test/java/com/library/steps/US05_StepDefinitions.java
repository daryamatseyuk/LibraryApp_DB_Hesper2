package com.library.steps;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US05_StepDefinitions {

    @When("I execute query to find most popular book genre")
    public void iExecuteQueryToFindMostPopularBookGenre() {

        DB_Util.runQuery("select bc.name,count(*) from book_borrow bb\n" +
                "inner join books b on bb.book_id = b.id\n" +
                "inner join book_categories bc on b.book_category_id=bc.id\n" +
                "group by name\n" +
                "order by 2 desc;");

    }

    @Then("verify {string} is the most popular book genre.")
    public void verifyIsTheMostPopularBookGenre(String mostPopular) {

        String actualFirstRowFirstColumn = DB_Util.getFirstRowFirstColumn();

        System.out.println("Expected most popular genre: " + mostPopular);
        System.out.println("Actual most popular genre: " + actualFirstRowFirstColumn);
        Assert.assertEquals(mostPopular, actualFirstRowFirstColumn);

    }

}
