package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;


public class LoginTest {
	
	WebDriver driver;
	
	String userName;
	String password;

	
	@Test
	public void validUserShouldBeAbleLogin() {
		
		driver=BrowserFactory.init();
		
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		//=============================envoking constructor of LoginPage^^ with driver
		
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);;
		loginPage.clickSigninButton();
		
		DashboardPage dashboardPage= PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage("Dashboard");
		
		BrowserFactory.tearDown();
		
	}
}
