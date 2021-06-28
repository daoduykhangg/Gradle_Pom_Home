package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AdditionDocumentPageUI;

public class AdditionDocumentPO extends	AbstractPage{
	WebDriver driver;

	public AdditionDocumentPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToFirstBoQuaButton() {
		waitForElementClickable(driver, AdditionDocumentPageUI.FIRST_BO_QUA_BUTTON);
		clickToElement(driver, AdditionDocumentPageUI.FIRST_BO_QUA_BUTTON);
	}

	public void clickToSecondBoQuaButton() {
		waitForElementClickable(driver, AdditionDocumentPageUI.SECOND_BO_QUA_BUTTON);
		clickToElement(driver, AdditionDocumentPageUI.SECOND_BO_QUA_BUTTON);
	}
}
