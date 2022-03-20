package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Testcases.Base;

public class LoginPage {

	WebDriver driver = Base.driver;
	ExtentTest test = Base.test;
	
	//******************Web Elements*****************************

	@FindBy(id = "user-name")
	WebElement Username;

	@FindBy(id = "password")
	WebElement Password;

	@FindBy(name = "login-button")
	WebElement LoginButton;

	public LoginPage() {
	PageFactory.initElements(driver, this);
	}
	
	//******************Functions*****************************

	public void Logn(String UsernameValue, String PasswordValue) {

		
		Username.sendKeys(UsernameValue);
		test.log(LogStatus.PASS, "Enter Username","Username entered successfully");
		Password.sendKeys(PasswordValue);
		test.log(LogStatus.PASS, "Enter Password","Password entered successfully");
		LoginButton.click();
		test.log(LogStatus.PASS, "Click on Login button ","Login Button clicked successfully");

	}

	

}
