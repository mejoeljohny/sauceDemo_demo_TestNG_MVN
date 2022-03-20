package Testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base {
	public static WebDriver driver;
	
	XSSFWorkbook wbook;
	XSSFSheet sheet;
	
	public static ExtentReports report;
	public static ExtentTest test;
	
	
	@BeforeTest
	public void DataSetUP() throws IOException {
		FileInputStream fis=new FileInputStream("Excel_Sheet.xlsx");
		wbook=new XSSFWorkbook(fis);
		sheet=wbook.getSheet("Sheet1");
		
		report= new ExtentReports("ExtentReport.html");
	}

	@AfterTest
	public void DataTearDown() throws IOException {
		wbook.close();
		report.flush();
		report.close();
	}
	
	@BeforeMethod
	public void Setup(Method method) {
		
		test=report.startTest(method.getName());
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe"); // Firefox webdriver

		driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/");

		

		driver.manage().window().maximize(); // Window Maximize
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}

	@AfterMethod
	public void Teardown() {
		report.endTest(test);
		driver.quit();
	}

}
