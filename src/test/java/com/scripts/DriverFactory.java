package com.scripts;

import java.time.Duration;

import com.frame.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.Common;
import org.testng.annotations.Parameters;

public class DriverFactory {
	WebDriver driver;
	WebDriver driver2;
	
	login pss_login;
//	GetDriver link;
	create_new_case_intake n_case;
	new_to_assign to_assign;
	assign_to_approved to_approved;
	approved_to_complete to_complete;
	search_case search;
	log_out logout;
	assign_provider ass;
	billing billing;
	FPC_Approved fpc;

	intake intake;
	public void setUpforTest() {
	}
	
//	@Parameters({"intake", "pss", "provider"})
	@BeforeMethod
	public void setUp() throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//		System.setProperty("webdriver.chrome.driver","E:\\chromedriver-win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
//
		setUpforTest();
		RecordVideo.startRecord("test_core");
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Common.waitSec(2);
		driver.close();
		RecordVideo.stopRecord();
	}
}
