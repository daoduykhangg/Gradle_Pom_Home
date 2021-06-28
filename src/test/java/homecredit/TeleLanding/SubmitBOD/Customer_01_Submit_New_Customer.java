package homecredit.TeleLanding.SubmitBOD;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.AdditionDocumentPO;
import pageObjects.ApplicationPO;
import pageObjects.BatDauVayPO;
import pageObjects.CustomerOfferPO;
import pageObjects.NhapThongTinVayPO;
import pageObjects.PageGeneratorManager;
import pageObjects.XacThucVayPO;
import utilities.FakerConfig;

public class Customer_01_Submit_New_Customer extends AbstractTest {
	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforeTest(String browserName, String url) {

		fakeData = FakerConfig.getFakeData();
		lastName = fakeData.getLastname();
		middleName = "AMRIT ACLND KRGA";
		firstName = fakeData.getFirstname();
		primaryPhone = "0" + getRandomPhoneNumber();
		birthDay = getToday();
		income = getRandomNumber() + "";
		homeId = "uatuser01_tls";
		idNumber = getRandomPhoneNumber();
		lincenseNumber = getRandomPhoneNumber();

		log.info("Precondition - Step 01: Open TeleLanding Page");
		driver = getBrowserDriver(browserName, url);
		batDauVayPage = PageGeneratorManager.getBatDauVayPage(driver);

		log.info("Precondition - Step 02: Click to 'Advanced' button");
		batDauVayPage.clickToAdvancedButton();

		log.info("Precondition - Step 03: Click to 'TeleLanding' Link");
		batDauVayPage.clickToTeleLandingLink();

		log.info("Precondition - Step 04: Click to 'Bắt đầu vay ngay' button");
		batDauVayPage.clickToBatDauVayNgayButton();
		nhapThongTinVayPage = PageGeneratorManager.getNhapThongTinVayPage(driver);
	}

	@Test
	public void TC_01_Submit_New_Customer_Info_No_Docs() {
		log.info("New Customer [No Docs] - Step 01: Enter to 'lastName' Textbox with value "+ lastName +"");
		nhapThongTinVayPage.enterToLastNameTextbox(lastName);

		log.info("New Customer [No Docs] - Step 02: Enter to 'middleName' Textbox with value "+ middleName +"");
		nhapThongTinVayPage.enterToMiddleNameTextbox(middleName);

		log.info("New Customer [No Docs] - Step 03: Enter to 'firstName' Textbox with value "+ lastName +"");
		nhapThongTinVayPage.enterToFirstNameTextbox(firstName);

		log.info("New Customer [No Docs] - Step 04: Enter to 'primaryPhone' Textbox with value "+ primaryPhone +"");
		nhapThongTinVayPage.enterToPrimaryPhoneTextbox(primaryPhone);

		log.info("New Customer [No Docs] - Step 05: Click to 'MALE' RadioButton");
		nhapThongTinVayPage.clickToMaleRadioButton();

		log.info("New Customer [No Docs] - Step 06: Enter to 'birthday' Textbox with value "+ birthDay +"");
		nhapThongTinVayPage.enterToBirthDayTextbox();

		log.info("New Customer [No Docs] - Step 07: Enter to 'income' Textbox with value "+ income +"");
		nhapThongTinVayPage.enterToIncomeTextbox(income);

		log.info("New Customer [No Docs] - Step 08: Enter to 'homeId' Textbox with value "+ homeId +"");
		nhapThongTinVayPage.enterToHomeIdTextbox(homeId);

		log.info("New Customer [No Docs] - Step 09: Enter to 'idNumber' Textbox with value "+ idNumber +"");
		nhapThongTinVayPage.enterToIdNumberTextbox(idNumber);

		log.info("New Customer [No Docs] - Step 10: Enter to 'licenseNumber' Textbox with value "+ lincenseNumber +"");
		nhapThongTinVayPage.enterToLicenseNumberTextbox(lincenseNumber);

		log.info("New Customer [No Docs] - Step 11: Click to 'Kiểm tra ngay' Button");
		nhapThongTinVayPage.clickToKiemTraNgayButton();
		xacThucVayPage = PageGeneratorManager.getXacThucVayPage(driver);
		
		log.info("New Customer [No Docs] - Step 12: Generate OTP value with 'primaryPhone'="+ primaryPhone +"");
		xacThucVayPage.generateOTPValue(primaryPhone);
		
		log.info("New Customer [No Docs] - Step 13: Enter OTP value to 'OTP' Textbox");
		xacThucVayPage.EnterOTPValueToOTPTextbox(primaryPhone);
		
		log.info("New Customer [No Docs] - Step 14: Click to 'Tôi đồng ý' Checkbox");
		xacThucVayPage.clickToToiDongYCheckbox();
		
		log.info("New Customer [No Docs] - Step 15: Click to 'Xác nhận' Button");
		xacThucVayPage.clickToXacNhanButton();
		additionDocumentPage = PageGeneratorManager.getAdditionDocumentPAge(driver);
		
		log.info("New Customer [No Docs] - Step 16: Click to First 'Bỏ qua' button ");
		additionDocumentPage.clickToFirstBoQuaButton();
		
		log.info("New Customer [No Docs] - Step 17: Click to Second 'Bỏ qua' button ");
		additionDocumentPage.clickToSecondBoQuaButton();
		customerOfferPage = PageGeneratorManager.getCustomerOfferPage(driver);
		
		log.info("New Customer [No Docs] - Step 18: Click to 'VAY NGAY' Button");
		customerOfferPage.waitForLoadingIconInvisible();
		customerOfferPage.clickToVayNgayButton();
		applicationPage = PageGeneratorManager.getApplicationPage(driver);
		
		log.info("New Customer [No Docs] - Step 19: Verify Success Message is displayed with value 'Hợp đồng đã được duyệt'");
		verifyEquals(applicationPage.getSuccessMessage(), "Hợp đồng đã được duyệt");
		
		log.info("New Customer [No Docs] - Step 20: Verify Document Text is displayed with value 'Vui lòng mang bản gốc CMND,Sổ hộ khẩu/Giấy phép lái xe, để hoàn tất hồ sơ tại cửa hàng gần nhất.'");
		verifyEquals(applicationPage.getDocumentText(), "Vui lòng mang bản gốc CMND,Sổ hộ khẩu/Giấy phép lái xe, để hoàn tất hồ sơ tại cửa hàng gần nhất.");
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		closeBrowserAndDriver(driver);
	}

	private WebDriver driver;
	private BatDauVayPO batDauVayPage;
	private NhapThongTinVayPO nhapThongTinVayPage;
	private FakerConfig fakeData;
	private XacThucVayPO xacThucVayPage;
	private AdditionDocumentPO additionDocumentPage;
	private CustomerOfferPO customerOfferPage;
	private ApplicationPO applicationPage;
	String lastName, middleName, firstName, primaryPhone, birthDay, homeId, income, idNumber, lincenseNumber;
}
