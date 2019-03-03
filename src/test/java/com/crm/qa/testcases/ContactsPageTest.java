package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends Base {

	LoginPage login;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName = "contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		login = new LoginPage();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		homePage = login.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactLink();

	}

	@Test(priority = 1)
	public void verifyContactPageLabelTest() {
		Assert.assertTrue(contactsPage.contactsLabelC());
	}

	@Test(priority = 2)
	public void verifySelectContactTest() {
		contactsPage.selectContactsByName("Reenu Singh");
	}

	@Test(priority = 3)
	public void verifyMultipleContactsTest() {
		contactsPage.selectContactsByName("Reenu Singh");
		contactsPage.selectContactsByName("Shubham Singh");
	}

	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 4 , dataProvider = "getCRMTestData")
	public void verifyclickOnNewContactTest(String title, String firstName, String lastName, String company){
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(title, firstName, lastName, company);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
