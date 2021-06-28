package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.BatDauVayPageUI;

public class BatDauVayPO extends AbstractPage{
	WebDriver driver;

	public BatDauVayPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAdvancedButton() {
		waitForElementVisible(driver, BatDauVayPageUI.ADVANCED_BUTTON);
		clickToElement(driver, BatDauVayPageUI.ADVANCED_BUTTON);
	}

	public void clickToTeleLandingLink() {
		waitForElementVisible(driver, BatDauVayPageUI.TELELANDING_LINK);
		clickToElement(driver, BatDauVayPageUI.TELELANDING_LINK);
	}

	public void clickToBatDauVayNgayButton() {
		waitForElementClickable(driver, BatDauVayPageUI.BAT_DAU_VAY_NGAY_BUTTON);
		clickToElement(driver, BatDauVayPageUI.BAT_DAU_VAY_NGAY_BUTTON);
	}
}
