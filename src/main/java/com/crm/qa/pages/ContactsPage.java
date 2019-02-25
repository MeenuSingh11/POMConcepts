package com.crm.qa.pages;

import com.crm.qa.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends Base {

	@FindBy(xpath = "//a[@title='Contacts']")
	WebElement contactsLabel;

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
}
