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

	public void clickToMedialInsCardButton() {
		waitForElementClickable(driver, AdditionDocumentPageUI.MEDICAL_INS_CARD_CHECKBOX);
		checkToCheckbox(driver, AdditionDocumentPageUI.MEDICAL_INS_CARD_CHECKBOX);
	}

	public String getMessageTextInAdditionDoc() {
		waitForElementVisible(driver, AdditionDocumentPageUI.MESSAGE_TEXT_IN_ADD_DOC_PAGE);
		return getTextElement(driver, AdditionDocumentPageUI.MESSAGE_TEXT_IN_ADD_DOC_PAGE);
	}

	public void clickToBankStament3Radiobutton() {
		waitForElementClickable(driver, AdditionDocumentPageUI.BANK_STATMENT_3_BUTTON);
		clickToElement(driver, AdditionDocumentPageUI.BANK_STATMENT_3_BUTTON);
	}

	public void clickToSendDocumentButton() {
		waitForElementClickable(driver, AdditionDocumentPageUI.SEND_DOCUMENTS_BUTTON);
		clickToElement(driver, AdditionDocumentPageUI.SEND_DOCUMENTS_BUTTON);
	}

	public void clickToAgreeInPopupButton() {
		waitForElementClickable(driver, AdditionDocumentPageUI.AGREE_BUTTON);
		clickToElement(driver, AdditionDocumentPageUI.AGREE_BUTTON);		
	}
}
