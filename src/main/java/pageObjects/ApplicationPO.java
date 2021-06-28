package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.ApplicationPageUI;

public class ApplicationPO extends AbstractPage{
	WebDriver driver;

	public ApplicationPO(WebDriver driver) {
		this.driver = driver;
	}

	public String getSuccessMessage() {
		waitForElementVisibleWithScoringTime(driver, ApplicationPageUI.SUCCESS_MESSAGE_TEXT);
		return getTextElement(driver, ApplicationPageUI.SUCCESS_MESSAGE_TEXT);
	}

	public String getDocumentText() {
		waitForElementVisible(driver, ApplicationPageUI.DOCUMENT_TEXT);
		return getTextElement(driver, ApplicationPageUI.DOCUMENT_TEXT);
	}
}
