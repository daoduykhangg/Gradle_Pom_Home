package commons;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import jdbcConnect.OracleSQLConnUtils;


public class AbstractPage {
	protected void openPageURL(WebDriver driver, String url) {
		driver.get(url);
	}

	protected String getCurrentPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	protected String getCurrentPageURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	protected void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	protected void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	protected void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	protected void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	protected void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	protected void setTextAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	protected void waitForAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIME);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	protected String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText().trim();
	}

	protected void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
			}
		}
	}

	protected void switchToWindowByTitle(WebDriver driver, String expectedPageTitle) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			driver.switchTo().window(window);
			String actualPageTitle = driver.getTitle();
			if (actualPageTitle.equals(expectedPageTitle)) {
				break;
			}
		}

	}

	protected void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> AllWindows = driver.getWindowHandles();
		for (String runWindow : AllWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	protected By getByXpath(String localtor) {
		return By.xpath(localtor);
	}

	protected WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	protected List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}

	protected void clickToElement(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		element.click();
	}

	protected void sendkeyToElement(WebDriver driver, String locator, String value) {
		element = getElement(driver, locator);
		element.clear();
		if (driver.toString().contains("chrome") | driver.toString().contains("edge")) {
			sleepInMiliSecond(500);
		}
		element.sendKeys(value);
	}

	protected void selectToElement(WebDriver driver, String locator, String itemValue) {
		element = getElement(driver, locator);
		select = new Select(element);
		select.selectByVisibleText(itemValue);
	}
	
	protected String getFirstSelectedText(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		select = new Select(element);
		return select.getFirstSelectedOption().getText().trim();
	}
	
	protected boolean isDropdownMultiple(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		select = new Select(element);
		return select.isMultiple();
	}
	
	protected void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String expectedItem) {
		getElement(driver, parentLocator).click();
		sleepInSecond(1);

		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIME);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

		elements = getElements(driver, childItemLocator);

		for (WebElement item : elements) {
			if (item.getText().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}
	
	protected String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		element = getElement(driver, locator);
		return element.getAttribute(attributeName);
	}
	
	protected String getTextElement(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		return element.getText().trim();
	}
	
	protected int countElementNumber(WebDriver driver, String locator) {
		elements = getElements(driver, locator);
		return elements.size();
	}
	
	protected void checkToCheckbox(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	protected void uncheckToCheckbox(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		if(element.isSelected()) {
			element.click();
		}
	}
	
	protected boolean isElementDisplayed(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		return element.isDisplayed();
	}
	
	protected boolean isElementUndisplayed(WebDriver driver, String locator) {
		overideImplicitWait(driver, GlobalConstants.SHORT_TIME);
		elements = getElements(driver, locator);
		overideImplicitWait(driver, GlobalConstants.LONG_TIME);
		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	protected boolean isElementSelected(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		return element.isSelected();
	}
	
	protected boolean isElementEnabled(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		return element.isEnabled();
	}
	
	protected void switchToFrame(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		driver.switchTo().frame(element);
	}
	
	protected void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	protected void doubleClickToElement(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		action = new Actions(driver);
		action.doubleClick(element).perform();
	}
	
	protected void hoverMouseToElement(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	protected void rightClickToElement(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		action = new Actions(driver);
		action.contextClick(element).perform();
	}
	
	protected void dragAndDropElement(WebDriver driver, String source, String target) {
		action = new Actions(driver);
		action.dragAndDrop(getElement(driver, source), getElement(driver, target)).perform();;
	}
	
	protected void sendKeyBoardToElement(WebDriver driver, String locator, Keys key) {
		element = getElement(driver, locator);
		action = new Actions(driver);
		action.sendKeys(element, key).perform();
	}

	protected void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		sleepInSecond(1);
	}

	protected void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}
	
	protected void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}
	
	protected void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIME);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	
	protected void waitForElementVisibleWithScoringTime(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.SCORING_TIME);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	
	protected void waitForAllElementsVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIME);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
	}
	
	protected void waitForElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIME);
		overideImplicitWait(driver, GlobalConstants.SHORT_TIME);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
		overideImplicitWait(driver, GlobalConstants.LONG_TIME);
	}
	
	protected void waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIME);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	
	private void overideImplicitWait(WebDriver driver, long shortTime) {
		driver.manage().timeouts().implicitlyWait(shortTime, TimeUnit.SECONDS);
	}
	
	protected void sleepInMiliSecond(long timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	protected void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	protected String generateOtpValue(String primaryPhone) {
		ArrayList<String> otpCodeList = new ArrayList<>();
		String otpCode = null;
		Connection conn = OracleSQLConnUtils.getOracleSQLConnection();
		String sql = "SELECT * FROM HSOTP.OTP_REQUEST RE "
				+ "LEFT JOIN HSOTP.OTP_VERIFICATION VE ON RE.ID = VE.OTP_REQUEST_ID "
				+ "LEFT JOIN HSOTP.OTP_DISPATCH DI ON RE.ID = DI.OTP_REQUEST_ID "
				+ "WHERE RE.RECIPIENT = '" + primaryPhone + "' "
						+ "ORDER BY RE.UUID desc";

		try {
			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				otpCodeList.add(rs.getString("OTP_CODE"));
			}
			otpCode = otpCodeList.get(0);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return otpCode;
	}
	private WebElement element;
	private List<WebElement> elements;
	private WebDriverWait explicitWait;
	private Actions action;
	private Select select;
	private JavascriptExecutor jsExecutor;
	
}
