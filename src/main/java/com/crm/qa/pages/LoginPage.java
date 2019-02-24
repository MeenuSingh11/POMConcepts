package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;

public class LoginPage extends Base {

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type ='submit']")
	WebElement loginButton;

	@FindBy(linkText = "Sign Up")
	WebElement signUp;

	@FindBy(xpath = "//img[@class='img-responsive' and @src='https://classic.crmpro.com/img/logo@2x.png']")
	WebElement crmProLogo;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	/* All the method in login page*/

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCRMImage() {
		return crmProLogo.isDisplayed();

	}

	public HomePage login(String un, String pwd) throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(3000);
		loginButton.click();
		return new HomePage();

	}

}
