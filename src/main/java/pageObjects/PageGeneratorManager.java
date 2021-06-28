package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static BatDauVayPO getBatDauVayPage(WebDriver driver) {
		return new BatDauVayPO(driver);
	}

	public static NhapThongTinVayPO getNhapThongTinVayPage(WebDriver driver) {
		return new NhapThongTinVayPO(driver);
	}

	public static XacThucVayPO getXacThucVayPage(WebDriver driver) {
		return new XacThucVayPO(driver);
	}
	
	public static AdditionDocumentPO getAdditionDocumentPAge(WebDriver driver) {
		return new AdditionDocumentPO(driver);
	}
	
	public static CustomerOfferPO getCustomerOfferPage(WebDriver driver) {
		return new CustomerOfferPO(driver);
	}
	
	public static ApplicationPO getApplicationPage(WebDriver driver) {
		return new ApplicationPO(driver);
	}
}
