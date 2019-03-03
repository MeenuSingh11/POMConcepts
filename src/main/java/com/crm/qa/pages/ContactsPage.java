package com.crm.qa.pages;

import com.crm.qa.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactsPage extends Base {

    @FindBy(xpath = "//a[@title='Contacts']")
    WebElement contactsLabel;

    @FindBy(xpath = "//input[@name='first_name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@name='surname']")
    WebElement lastName;

    @FindBy(xpath = "//input[@name='client_lookup']")
    WebElement company;

    @FindBy(xpath = "//input[@type='submit' and @value='Save']")
    WebElement saveButton;

    public ContactsPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean contactsLabelC() {
        return contactsLabel.isDisplayed();

    }

    public void selectContactsByName(String name) {

        driver.findElement(By.xpath("//a[text()='" + name + "']//parent::td[@class='datalistrow']"
                + "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();

    }

    public void createNewContact(String title, String fname, String lname, String comp) {

        Select select = new Select(driver.findElement(By.name("title")));
        select.selectByVisibleText(title);

        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        company.sendKeys(comp);
        saveButton.click();


    }
}
