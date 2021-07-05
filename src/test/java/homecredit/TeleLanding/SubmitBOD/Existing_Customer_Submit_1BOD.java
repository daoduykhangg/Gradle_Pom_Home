package homecredit.TeleLanding.SubmitBOD;

import commons.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import utilities.FakerConfig;

public class Existing_Customer_Submit_1BOD extends AbstractTest {

    @Parameters({"browser", "url"})
    @BeforeMethod(groups = "smoke")
    protected void beforeTest(String browserName, String url) {
        fakeData = FakerConfig.getFakeData();
        birthDay = getToday();
        income = getRandomNumber() + "";

        log.info("Precondition - Step 01: Open TeleLanding Page");
        driver = getBrowserDriver(browserName, url);
        batDauVayPage = PageGeneratorManager.getBatDauVayPage(driver);

        log.info("Precondition - Step 04: Click to 'B?t ??u vay ngay' button");
        batDauVayPage.clickToBatDauVayNgayButton();
        nhapThongTinVayPage = PageGeneratorManager.getNhapThongTinVayPage(driver);
        getDataFromProperties();

    }

    @Test(groups = "smoke")
    public void TC_01_ExistingCustomer_HasOffer_CLX_Submit1BOD() {

        log.info("ExistingCustomer_HasOffer_CLX - Step 01: Enter to 'lastName' Text box with value " + properties.getProperty("LASTNAME_CLX") + "");
        nhapThongTinVayPage.enterToLastNameTextbox(properties.getProperty("LASTNAME_CLX"));

        log.info("ExistingCustomer_HasOffer_CLX - Step 02: Enter to 'middleName' Text box with value " + properties.getProperty("MIDDLE_NAME_CLX") + "");
        nhapThongTinVayPage.enterToMiddleNameTextbox((properties.getProperty("MIDDLE_NAME_CLX")));

        log.info("ExistingCustomer_HasOffer_CLX - Step 03: Enter to 'firstName' Text box with value " + properties.getProperty("firstNameCLX") + "");
        nhapThongTinVayPage.enterToFirstNameTextbox(properties.getProperty("firstNameCLX"));

        log.info("ExistingCustomer_HasOffer_CLX - Step 04: Enter to 'primaryPhone' Text box with value " + properties.getProperty("primaryPhoneCLX") + "");
        nhapThongTinVayPage.enterToPrimaryPhoneTextbox(properties.getProperty("primaryPhoneCLX"));

        log.info("ExistingCustomer_HasOffer_CLX - Step 05: Click to 'FEMALE' RadioButton");
        nhapThongTinVayPage.clickToFemaleRadioButton();

        log.info("ExistingCustomer_HasOffer_CLX - Step 06: Enter to 'birthday' Text box with value " + birthDay + "");
        nhapThongTinVayPage.enterToBirthDayTextbox();

        log.info("ExistingCustomer_HasOffer_CLX - Step 07: Enter to 'income' Text box with value " + income + "");
        nhapThongTinVayPage.enterToIncomeTextbox(income);

        log.info("ExistingCustomer_HasOffer_CLX - Step 08: Enter to 'homeId' Text box with value " + properties.getProperty("homeIdCLX") + "");
        nhapThongTinVayPage.enterToHomeIdTextbox(properties.getProperty("homeIdCLX"));

        log.info("ExistingCustomer_HasOffer_CLX - Step 09: Enter to 'idNumber' Text box with value " + properties.getProperty("idNumberCLX") + "");
        nhapThongTinVayPage.enterToIdNumberTextbox(properties.getProperty("idNumberCLX"));

        log.info("ExistingCustomer_HasOffer_CLX - Step 10: Enter to 'licenseNumber' Text box with value " + properties.getProperty("licenseNumberCLX") + "");
        nhapThongTinVayPage.enterToLicenseNumberTextbox(properties.getProperty("licenseNumberCLX"));

        log.info("ExistingCustomer_HasOffer_CLX - Step 11: Click to 'Ki?m tra ngay' Button");
        nhapThongTinVayPage.clickToKiemTraNgayButton();
        xacThucVayPage = PageGeneratorManager.getXacThucVayPage(driver);

        log.info("ExistingCustomer_HasOffer_CLX - Step 12: Generate OTP value with 'primaryPhone'= " + properties.getProperty("primaryPhoneCLX") + "");
        xacThucVayPage.generateOTPValue(properties.getProperty("primaryPhoneCLX"));

        log.info("ExistingCustomer_HasOffer_CLX - Step 13: Enter OTP value to 'OTP' Text box");
        xacThucVayPage.EnterOTPValueToOTPTextbox(properties.getProperty("primaryPhoneCLX"));

        log.info("ExistingCustomer_HasOffer_CLX - Step 14: Click to 'Tôi ??ng ý' Checkbox");
        xacThucVayPage.clickToToiDongYCheckbox();

        log.info("ExistingCustomer_HasOffer_CLX - Step 15: Click to 'Xác nh?n' Button");
        xacThucVayPage.clickToXacNhanButton();
        additionDocumentPage = PageGeneratorManager.getAdditionDocumentPAge(driver);

        // Uncomment to submit application

        /*log.info("ExistingCustomer_HasOffer_CLX - Step 16: Click to 'VAY NGAY' Button");
        customerOfferPage.clickToVayNgayButton();
        applicationPage = PageGeneratorManager.getApplicationPage(driver);*/
    }

    @Test(groups = "smoke")
    public void TC_02_ExistingCustomer_HasOffer_ACLX_Submit1BOD() {
        log.info("ExistingCustomer_HasOffer_ACLX - Step 01: Enter to 'lastName' Text box with value " + properties.getProperty("lastNameACLX") + "");
        nhapThongTinVayPage.enterToLastNameTextbox(properties.getProperty("lastNameACLX"));

        log.info("ExistingCustomer_HasOffer_ACLX - Step 02: Enter to 'middleName' Text box with value " + properties.getProperty("middleNameACLX") + "");
        nhapThongTinVayPage.enterToMiddleNameTextbox((properties.getProperty("middleNameACLX")));

        log.info("ExistingCustomer_HasOffer_ACLX - Step 03: Enter to 'firstName' Text box with value " + properties.getProperty("firstNameACLX") + "");
        nhapThongTinVayPage.enterToFirstNameTextbox(properties.getProperty("firstNameACLX"));

        log.info("ExistingCustomer_HasOffer_ACLX - Step 04: Enter to 'primaryPhone' Text box with value " + properties.getProperty("primaryPhoneACLX") + "");
        nhapThongTinVayPage.enterToPrimaryPhoneTextbox(properties.getProperty("primaryPhoneACLX"));

        log.info("ExistingCustomer_HasOffer_ACLX - Step 05: Click to 'MALE' RadioButton");
        nhapThongTinVayPage.clickToMaleRadioButton();

        log.info("ExistingCustomer_HasOffer_ACLX - Step 06: Enter to 'birthday' Text box with value " + birthDay + "");
        nhapThongTinVayPage.enterToBirthDayTextbox();

        log.info("ExistingCustomer_HasOffer_ACLX - Step 07: Enter to 'income' Text box with value " + income + "");
        nhapThongTinVayPage.enterToIncomeTextbox(income);

        log.info("ExistingCustomer_HasOffer_ACLX - Step 08: Enter to 'homeId' Text box with value " + properties.getProperty("homeIdACLX") + "");
        nhapThongTinVayPage.enterToHomeIdTextbox(properties.getProperty("homeIdACLX"));

        log.info("ExistingCustomer_HasOffer_ACLX - Step 09: Enter to 'idNumber' Text box with value " + properties.getProperty("idNumberACLX") + "");
        nhapThongTinVayPage.enterToIdNumberTextbox(properties.getProperty("idNumberACLX"));

        log.info("ExistingCustomer_HasOffer_ACLX - Step 10: Enter to 'licenseNumber' Text box with value " + properties.getProperty("licenseNumberACLX") + "");
        nhapThongTinVayPage.enterToLicenseNumberTextbox(properties.getProperty("licenseNumberACLX"));

        log.info("ExistingCustomer_HasOffer_ACLX - Step 11: Click to 'Ki?m tra ngay' Button");
        nhapThongTinVayPage.clickToKiemTraNgayButton();
        xacThucVayPage = PageGeneratorManager.getXacThucVayPage(driver);

        log.info("ExistingCustomer_HasOffer_ACLX - Step 12: Generate OTP value with 'primaryPhone'= " + properties.getProperty("primaryPhoneACLX") + "");
        xacThucVayPage.generateOTPValue(properties.getProperty("primaryPhoneACLX"));

        log.info("ExistingCustomer_HasOffer_ACLX - Step 13: Enter OTP value to 'OTP' Text box");
        xacThucVayPage.EnterOTPValueToOTPTextbox(properties.getProperty("primaryPhoneACLX"));

        log.info("ExistingCustomer_HasOffer_ACLX - Step 14: Click to 'Tôi ??ng ý' Checkbox");
        xacThucVayPage.clickToToiDongYCheckbox();

        log.info("ExistingCustomer_HasOffer_ACLX - Step 15: Click to 'Xác nh?n' Button");
        xacThucVayPage.clickToXacNhanButton();
        additionDocumentPage = PageGeneratorManager.getAdditionDocumentPAge(driver);

        // Uncomment to submit application

        /*log.info("ExistingCustomer_HasOffer_ACLX - Step 16: Click to 'VAY NGAY' Button");
        customerOfferPage.clickToVayNgayButton();
        applicationPage = PageGeneratorManager.getApplicationPage(driver);*/
    }


  /*  @AfterMethod(alwaysRun = true, groups = "smoke")
    public void afterTest() {
        closeBrowserAndDriver(driver);
    }*/

    private WebDriver driver;
    private BatDauVayPO batDauVayPage;
    private FakerConfig fakeData;
    private NhapThongTinVayPO nhapThongTinVayPage;
    private XacThucVayPO xacThucVayPage;
    private AdditionDocumentPO additionDocumentPage;
    private CustomerOfferPO customerOfferPage;
    private ApplicationPO applicationPage;
    String income, birthDay;

}
