package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;

public class HomePage extends Base {

	@FindBy(xpath = "//td[contains(text(),'User: Meenu Singh')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//a[@title='Contacts']")
	WebElement contactsLink;

	@FindBy(xpath = "//a[@title='Deals']")
	WebElement dealsLink;

	@FindBy(xpath = "//a[@title='Tasks']")
	WebElement taskLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String homePageTitle() {
		return driver.getTitle();
	}

	public boolean correctUserName() {
		return userNameLabel.isDisplayed();
	}

	public ContactsPage clickOnContactLink() {
		contactsLink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealLink() {
		dealsLink.click();
		return new DealsPage();
	}

	public TaskPage clickOnTaskLink() {
		taskLink.click();
		return new TaskPage();
	}
}
