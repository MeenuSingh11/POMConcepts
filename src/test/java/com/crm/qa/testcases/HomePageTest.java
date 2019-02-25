package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends Base {

	LoginPage login;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		login = new LoginPage();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		homePage = login.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.homePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Homepage title is not matched");

	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		testUtil.switchToFrame();
		boolean corrUserName = homePage.correctUserName();
		Assert.assertTrue(corrUserName);

	}

	@Test(priority = 3)
	public void verifyContactsLinkTest()  {
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactLink();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
