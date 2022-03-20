package Testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Page.LoginPage;

public class Login_Test extends Base {

	@Test(priority = 0)
	public void LoginSuccessTest() {
		//test=report.startTest("LoginSuccessTest");
		LoginPage login=new LoginPage();
		login.Logn("standard_user", "secret_sauce");
		//report.endTest(test);
	}

	@Test(priority = 1)
	public void LoginFailiureTest() {
		
		//test=report.startTest("LoginFailiureTest");
		LoginPage login=new LoginPage();
		login.Logn("xyz@gmail.com", "ABCef@123");

		WebElement Errmsg = driver.findElement(By.xpath("//h3[@data-test='error']"));
		String Actualmsg = Errmsg.getText();
		String Expmsg = "Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(Actualmsg, Expmsg);
		//report.endTest(test);
	}
	
	@Test
	@Parameters({"Param1","Param2"})
		public void ParameterizedTest(String UserNameVal, String PasswordVal) {
		//test=report.startTest("ParameterizedTest");
		LoginPage login = new LoginPage();
		login.Logn(UserNameVal,PasswordVal);		
		//report.endTest(test);
	}

	@Test
		public void ExternalDataTest(){
	//	//test=report.startTest("ExternalDataTest");
		String UsernameVal=sheet.getRow(1).getCell(0).getStringCellValue();
		String PasswordVal=sheet.getRow(1).getCell(1).getStringCellValue();
		
		LoginPage login = new LoginPage();
		login.Logn(UsernameVal,PasswordVal);	
		//report.endTest(test);
	}
	
	
}
