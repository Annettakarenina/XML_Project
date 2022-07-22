package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {

	WebDriver driver;

	String userName;
	String password;
	String fullName;
	String companyName;
	String email;
	String phoneNumber;
	String address;
	String city;
	String country;
	String state;
	String zip;

	@Test
	public void userShouldBeAbleToCreateCustomer() throws InterruptedException {

		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage("Dashboard");
		dashboardPage.clickCustomersButton();
		dashboardPage.clickAddCustomerMenuElement();

		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.validateAddContactPage("Contacts");
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompany(companyName);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhoneNumber(phoneNumber);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.selectCountry(country);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.clickSaveButton();
		
		dashboardPage.clickListCustomerMenuElement();
		dashboardPage.validateListCustomerPageHeader("Contacts");
		
		addCustomerPage.validateInsertedCustomerAndDelete();

		BrowserFactory.tearDown();
	}

}
