package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.XacThucVayPageUI;

public class XacThucVayPO extends AbstractPage {
	WebDriver driver;
	String otpCode = null;

	public XacThucVayPO(WebDriver driver) {
		this.driver = driver;
	}

	public String generateOTPValue(String primaryPhone) {
		return otpCode = generateOtpValue(primaryPhone);
	}

	public void EnterOTPValueToOTPTextbox(String primaryPhone) {
		waitForElementVisible(driver, XacThucVayPageUI.OTP_TEXTBOX);
		sendkeyToElement(driver, XacThucVayPageUI.OTP_TEXTBOX, otpCode);
	}

	public void clickToToiDongYCheckbox() {
		waitForElementClickable(driver, XacThucVayPageUI.TOI_DONG_Y_CHECKBOX);
		checkToCheckbox(driver, XacThucVayPageUI.TOI_DONG_Y_CHECKBOX);
	}

	public void clickToXacNhanButton() {
		waitForElementClickable(driver, XacThucVayPageUI.XAC_NHAN_BUTTON);
		clickToElement(driver, XacThucVayPageUI.XAC_NHAN_BUTTON);
	}
}
