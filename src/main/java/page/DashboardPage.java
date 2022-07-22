package page;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//*[@id='page-wrapper']/div[2]/div/h2")WebElement DASHBOARD_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//span[text()='Customers']")WebElement CUSTOMERS_MENU_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[text() ='Add Customer']")WebElement ADD_CUSTOMER_MENU_ELEMENT;
	@FindBy(how=How.XPATH, using="//a[text()='List Customers']") WebElement LIST_CUSTOMERS_MENU_ELEMENT;
	@FindBy(how=How.XPATH,using="//h2[contains(text(), ' Contacts ')]") WebElement LIST_CUSTOMERS_PAGE_HEADER;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public void validateDashboardPage(String validationText) {

		Assert.assertEquals(DASHBOARD_HEADER_ELEMENT.getText(), validationText, "Dashboard page is not available");

	}

	public void clickCustomersButton() {
		CUSTOMERS_MENU_ELEMENT.click();
	}

	public void clickAddCustomerMenuElement() {
		ADD_CUSTOMER_MENU_ELEMENT.click();
	}
	public void clickListCustomerMenuElement() throws InterruptedException {
		Thread.sleep(3000);
		LIST_CUSTOMERS_MENU_ELEMENT.click();
	}
	public void validateListCustomerPageHeader(String validationText) {
		Assert.assertEquals(LIST_CUSTOMERS_PAGE_HEADER.getText(), validationText, "List Customers page not found");
	}
}
