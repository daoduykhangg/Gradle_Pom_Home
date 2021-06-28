package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.CustomerOfferPageUI;

public class CustomerOfferPO extends AbstractPage{
	WebDriver driver;

	public CustomerOfferPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToVayNgayButton() {
		waitForElementVisibleWithScoringTime(driver, CustomerOfferPageUI.VAY_NGAY_BUTTON);
		waitForElementInvisible(driver, CustomerOfferPageUI.LOADING_ICON);
		clickToElement(driver, CustomerOfferPageUI.VAY_NGAY_BUTTON);
	}
	
	public void waitForLoadingIconInvisible() {
		waitForElementInvisible(driver, CustomerOfferPageUI.LOADING_ICON);
	}
}
