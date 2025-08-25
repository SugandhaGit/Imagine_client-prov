import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.interactions.Actions;

public class ImagineLogin {

	// Declaration of data members with private access specifiers

//Login
	@FindBy(xpath = "//input[@id='mat-input-0']")
	private WebElement username;
	@FindBy(xpath = "//input[@id='mat-input-1']")
	private WebElement password;
	@FindBy(xpath = "//button[@class='mat-focus-indicator login-btn mat-raised-button mat-button-base mat-primary']")
	private WebElement btnclick;

	// Client Provisioning

	// Location of Hover over the Provisioning menu

	@FindBy(xpath = "//mat-icon[@svgicon='list_bulleted_add_icon']//*[name()='svg']")
	private WebElement hoverOnProv;

//Location of Client Provisioning 
	@FindBy(xpath = "//span[normalize-space()='Client Provisioning']")
	private WebElement clientprovngclick;

	// Location of add client button

	@FindBy(xpath = "//span[@class='add-client-text']")
	private WebElement addclient;

	// Location of client name of add client pop up
	@FindBy(xpath = "//input[@id='mat-input-12']")
	private WebElement clientname;

	// Location of client short name of add client pop up
	@FindBy(xpath = "//input[@id='mat-input-13']")
	private WebElement clientshortname;

	// Location of client active checkbox of add client pop up
	@FindBy(xpath = "//*[@id='mat-checkbox-2']")
	private WebElement clientactive;

	// Location of Save & Exit button of add client pop up
	@FindBy(xpath = "//span[normalize-space()='Save & Exit']")
	private WebElement saveexit;

	// Location of toaster message

	@FindBy(xpath = "//div[@id=\"toast-container\"]")
	private WebElement verifyClientCreatedToastMessage;

	@FindBy(xpath = "//span[normalize-space(text())='Co-Pilot Enabled']")
	private WebElement copilotenabled;

	@FindBy(xpath = "//span[normalize-space()='Save & Add More']")
	private WebElement saveandaddmore;

	@FindBy(xpath = "//button[@class='mat-focus-indicator extended-width cancel-button mat-stroked-button mat-button-base mat-primary cdk-focused cdk-mouse-focused']")
	private WebElement reset;

	//// span[@class ='add-user-text']

	// Initialization by constructor with page factory

	ImagineLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization with public access specifiers

	// Method for username input on login page
	public void txtUsername(String uname) {
		username.sendKeys(uname);

	}
	// Method for password input on login page

	public void txtPass(String pass) {
		password.sendKeys(pass);

	}

	// Method for login button
	public void logInclick() {
		btnclick.click();

	}

	// Method for hovering over provisioning navbar
	public void navProvhov(WebDriver driver) {
		Actions actions = new Actions(driver);

		actions.moveToElement(hoverOnProv).perform();
	}

	// Method for clientprovisioning navbar menu
	public void clientprovclick() {
		clientprovngclick.click();

	}

	// Method for add client button
	public void addclientbtnclick(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// wait for overlay to disappear
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.ngx-overlay.foreground-closing")));

		// wait for the button to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(addclient));

		addclient.click();
	}

	// Method for clientname of add client
	public void clntname(String cname) {
		clientname.sendKeys(cname);

	}

	// Method for clientshortname of add client

	public void clntshrtname(String cshortname) {
		clientshortname.sendKeys(cshortname);

	}

//	// Method for active checkbox of add client
//	public void active() {
//		clientactive.click();
//
//	}
//	
	public void active(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// wait for overlay to disappear
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.ngx-overlay.foreground-closing")));

		// wait for the button to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(clientactive));

		clientactive.click();
	}

	// Method for save&exit button of add client

	public void saveexitclick(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// wait for overlay to disappear
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.ngx-overlay.foreground-closing")));

		// wait for the button to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(saveexit));

		saveexit.click();

	}

	// Method for toasterconfirmation Message

	public String SuccessMessage() {
		return verifyClientCreatedToastMessage.getText();
	}

	// Method for copilot enable checkbox button of add client

	public void copilotcheckbox(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// wait until overlay is gone
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.ngx-overlay.foreground-closing")));

		// wait until checkbox is clickable
		wait.until(ExpectedConditions.elementToBeClickable(copilotenabled));

		// now click
		copilotenabled.click();
	}

	public void saveandaddmoreclick() {
	
		
		saveandaddmore.click();
	}

	public void resetbutton() {

		WebDriver driver = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// wait for overlay to disappear
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.ngx-overlay.foreground-closing")));

		// wait for the button to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(reset));

		reset.click();
	}
}
