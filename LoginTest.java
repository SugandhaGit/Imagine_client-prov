
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

	static WebDriver driver;
	


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://a1f4df2a9dd144e1c8de1ea88030b386-c7c661263a51f8e5.elb.us-east-1.amazonaws.com/qa/login");
		// System.out.println(driver.getTitle());

		ImagineLogin Lgn = new ImagineLogin(driver);

		WebElement btnAdvn = driver.findElement(By.id("details-button"));
		btnAdvn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement proceedLink = driver.findElement(By.id("proceed-link"));
		proceedLink.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//String actual=driver.findElement(By.xpath("//div[@role='alert' and @aria-label='Client created Successfully' and contains(@class, 'toast-message")).getText();

		// TC1 = Login into co-pilot

		Lgn.txtUsername("rgontarek");
		Lgn.txtPass("Imagine$1");
		Thread.sleep(3000);
		Lgn.logInclick();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		
		
		// TC2 = Client Provisioning -Add Client with mandatory tags and Active checkbox which is optional with save & exit button

		Lgn.navProvhov(driver);
	
		Lgn.clientprovclick();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Lgn.addclientbtnclick(driver);
		Lgn.clntname("Suman Radiology");
		Lgn.clntshrtname("SR");
		Lgn.active(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Lgn.saveexitclick(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		// ✅ Explicit wait for 15 seconds after save & exit
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//		WebElement toastMessage = wait.until(
//		        ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-message")) // use your locator here
//		);
//
//		System.out.println("Toast message displayed: " + toastMessage.getText());

	
		
		//TC3= Verify the toaster message
		
		String actual = Lgn.SuccessMessage();
		String expected = "Client created Successfully";
		Assert.assertEquals(actual, expected, "Toast message text does not match!");
		 
		// TC4 = Client Provisioning -Add Client with  save & addmore button
		//@Test (priority=1)
				Lgn.navProvhov(driver);
			    Lgn.clientprovclick();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				Lgn.addclientbtnclick(driver);
				Lgn.clntname("Part");
				Lgn.clntshrtname("PA");
				Lgn.active(driver);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				Lgn.copilotcheckbox(driver);
				
				WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

				// wait for overlay to disappear
				wait1.until(
						ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.ngx-overlay.foreground-closing")));

				// wait for the button to be clickable
				wait1.until(ExpectedConditions.elementToBeClickable(saveandaddmore));

				Lgn.saveandaddmoreclick();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				
				
				
			
		
				
				// TC5 = Client Provisioning -Add Client - Reset button

				Lgn.navProvhov(driver);
			    Lgn.clientprovclick();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				Lgn.addclientbtnclick(driver);
				Lgn.clntname("Part");
				Lgn.clntshrtname("PA");
			    Lgn.resetbutton();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.quit();
	}

}
