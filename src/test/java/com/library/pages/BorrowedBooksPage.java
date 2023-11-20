package com.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BorrowedBooksPage extends BasePage{


    @FindBy(xpath = "//tbody//td[2]")
    public List<WebElement> allBorrowedBooksName;

    @FindBy (xpath = "//li[@class='nav-item dropdown']/a")
    public WebElement loggedUser;

    @FindBy (xpath = "//a[@onclick]")
    public List<WebElement> listOfBooksBorrowed;

    public void unborrow(){

        listOfBooksBorrowed.get(listOfBooksBorrowed.size()-1).click();

    }
}
