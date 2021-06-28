package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.NhapThongTinVayPageUI;

public class NhapThongTinVayPO extends AbstractPage{
	WebDriver driver;

	public NhapThongTinVayPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, NhapThongTinVayPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, NhapThongTinVayPageUI.LASTNAME_TEXTBOX, lastName);
	}

	public void enterToMiddleNameTextbox(String middleName) {
		waitForElementVisible(driver, NhapThongTinVayPageUI.MIDDLENAME_TEXTBOX);
		sendkeyToElement(driver, NhapThongTinVayPageUI.MIDDLENAME_TEXTBOX, middleName);
	}

	public void enterToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, NhapThongTinVayPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, NhapThongTinVayPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void enterToPrimaryPhoneTextbox(String primaryPhone) {
		waitForElementVisible(driver, NhapThongTinVayPageUI.PRIMARY_PHONE_TEXTBOX);
		sendkeyToElement(driver, NhapThongTinVayPageUI.PRIMARY_PHONE_TEXTBOX, primaryPhone);
	}

	public void clickToMaleRadioButton() {
		waitForElementClickable(driver, NhapThongTinVayPageUI.GENDER_MALE_RADIOBUTTON);
		clickToElement(driver, NhapThongTinVayPageUI.GENDER_MALE_RADIOBUTTON);
	}

	public void enterToBirthDayTextbox() {
		waitForElementClickable(driver, NhapThongTinVayPageUI.BIRTHDAY_TEXTBOX);
		clickToElement(driver, NhapThongTinVayPageUI.BIRTHDAY_TEXTBOX);
		sleepInMiliSecond(500);;
		sendKeyBoardToElement(driver, NhapThongTinVayPageUI.BIRTHDAY_TEXTBOX, Keys.ENTER);
	}

	public void enterToIncomeTextbox(String income) {
		waitForElementVisible(driver, NhapThongTinVayPageUI.INCOME_TEXTBOX);
		sendkeyToElement(driver, NhapThongTinVayPageUI.INCOME_TEXTBOX, income);
	}

	public void enterToHomeIdTextbox(String homeId) {
		waitForElementVisible(driver, NhapThongTinVayPageUI.HOMEID_TEXTBOX);
		sendkeyToElement(driver, NhapThongTinVayPageUI.HOMEID_TEXTBOX, homeId);
	}
	
	public void enterToIdNumberTextbox(String idNumber) {
		waitForElementVisible(driver, NhapThongTinVayPageUI.IDNUMBER_TEXTBOX);
		sendkeyToElement(driver, NhapThongTinVayPageUI.IDNUMBER_TEXTBOX, idNumber);
	}

	public void enterToLicenseNumberTextbox(String licenseNumber) {
		waitForElementVisible(driver, NhapThongTinVayPageUI.LICENSE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, NhapThongTinVayPageUI.LICENSE_NUMBER_TEXTBOX, licenseNumber);
	}
	
	public void clickToKiemTraNgayButton() {
		waitForElementClickable(driver, NhapThongTinVayPageUI.KIEM_TRA_NGAY_BUTTON);
		clickToElement(driver, NhapThongTinVayPageUI.KIEM_TRA_NGAY_BUTTON);
		sleepInSecond(5);
	}

}
