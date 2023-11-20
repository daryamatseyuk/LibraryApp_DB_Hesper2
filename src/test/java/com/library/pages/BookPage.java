package com.library.pages;

import com.library.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BookPage extends BasePage {

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> allRows;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement search;

    @FindBy(id = "book_categories")
    public WebElement mainCategoryElement;

    @FindBy(name = "name")
    public WebElement bookName;

    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement author;

    @FindBy(xpath = "//div[@class='portlet-title']//a")
    public WebElement addBook;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveChanges;

    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement toastMessage;

    @FindBy(name = "year")
    public WebElement year;

    @FindBy(name = "isbn")
    public WebElement isbn;

    @FindBy(id = "book_categories")
    public WebElement categoryDropdown;


    @FindBy(id = "description")
    public WebElement description;

    @FindBy(xpath = "//td[.='999240111']//preceding-sibling::td/a")
    public WebElement editCustomBookBtn;

    @FindBy(xpath = "//div[@class='form-group']//input | //textarea[@class='form-control']")
    public List<WebElement> editBookInfoList;

    @FindBy(id = "book_group_id")
    public WebElement editBookCategory;


    public WebElement editBook(String book) {
        String xpath = "//td[3][.='" + book + "']/../td/a";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    public void borrowBook(String book) {
        String xpath = "//td[3][.='" + book + "']/../td/a";
        Driver.getDriver().findElement(By.xpath(xpath)).click();
    }
    public List<WebElement> getListOfAvailableBooks(String book) {
        String xpath = "//td[3][.='" + book + "']/../td/a";
        return Driver.getDriver().findElements(By.xpath(xpath));
    }







}
