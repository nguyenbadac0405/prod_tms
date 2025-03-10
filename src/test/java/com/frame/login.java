package com.frame;

import com.Common;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class login {
	protected WebDriver driver;


	public login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="username")
	public WebElement fUsername;

	@FindBy(id = "pwd")
	public WebElement fPassword;

	@FindBy(css = "button[type='submit']")
	public WebElement btnSignIn;

	@FindBy(css = "div[class='text-error sp-mt-10']")
	public WebElement errorMessage;



	public void enterText(WebElement fElement, String testText) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(
				ExpectedConditions.visibilityOf(fElement)
		).sendKeys(testText);
	}
	public void clickBtnCheckbox(WebElement btnckElement) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(
				ExpectedConditions.visibilityOf(btnckElement)
		).click();
	}

	public String getLoginPageTitle () {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}

	public boolean verifyLoginPageTitle() {
		String expectedTitle = "Login | TMS Dashboard";
		return getLoginPageTitle().equals(expectedTitle);
	}

	public void signin (String role)
	{
		if (role.equals("Intake")) {
			enterText(fUsername, "dac+1@gkxim.com");
			enterText(fPassword, "123456");
		}
		if (role.equals("PSS")) {
			enterText(fUsername, "dac+3@gkxim.com");
			enterText(fPassword, "111111");
		}
		if (role.equals("Provider")) {
			enterText(fUsername, "dac+2@gkxim.com");
			enterText(fPassword, "123456");
		}
		clickBtnCheckbox(btnSignIn);
	}

	public String getErrorMessage() {
		String strErrorMsg = null;
		if(errorMessage.isDisplayed() && errorMessage.isEnabled())
		{
			strErrorMsg = (String) errorMessage.getText();
		}
		return strErrorMsg;
	}
	
	
	public void URL_telehealth() {
		driver.get("https://dashboard.gkim.digital/");
	}
	public void pdflink() {
        driver.get("https://prod-tms-reqform-viewer.web.app/c71e7cef-228f-4d0e-b7a1-5dceeb0eb70b/40484fc2-b62d-4712-b26d-49c34667d8a9?role=ADMIN_MEDICAL&recform_id=f436df31-118e-4419-8196-a0b13ebcb984&token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNzU0MTE3MDgxLCJpYXQiOjE3MjI1ODEwODEsImp0aSI6IjI1NDFhZjI5YTU4NDQ1NGNhYTQxNDQyYWMxNGMyYmI5IiwidXNlcl9pZCI6ImRmOTFlNzM0LTNmZTgtNDYyNS05NTJjLTJjYjllMTdhMDA2NCJ9.HpKYBFAK9-szBzFBE_13oQ43b7QJQrTjrOZJ_WeNOj0&redirect=&data-json-merge=%7B%7D");

    }
	public void URL_TMS() {
		driver.get("https://dashboard.tms.partners/#/");
	}
	public void URL_TMS_STAG() {
		driver.get("https://stag.tms.partners/#/");
	}
	public void URL_NEW_PROD() {
		driver.get("https://dashboard.gkim.digital/#/");
	}
	public void URL_MDL() {
		driver.get("https://mydoctorslive.com/gkim-telehealth/");
	}
	public void URL_MDR() {
		driver.get("https://mydoctorsreleaf.com/patient-profile/");
	}

	public void URL_ADMIN() { driver.get("https://dashboard.tms.partners/admin");}
	
	public void pss(String password) 
	{
		fUsername.sendKeys("dac+3@gkxim.com");
//		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("dac+3@gkxim.com");
		driver.findElement(By.xpath("//*[@id='pwd']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='submit_login']/div/div[4]/button")).click();
		System.out.println("--------------------Login PSS success.------------------------");
		Common.waitSec(5);
//		driver.findElement(By.xpath(".//div[@class='rce-pl-20 rce-pr-20 col d-flex flex-column']/div[2]/div[2]/div/div/div[1]/div[2]/button")).click();
		try {
			driver.findElement(By.xpath(".//button[text()='Close']")).click();
		}
		catch (Exception e) {}
	}



	public void lab(String password) {
		fUsername.sendKeys("dac+4@gkxim.com");
//		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("dac+3@gkxim.com");
		driver.findElement(By.xpath("//*[@id='pwd']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='submit_login']/div/div[4]/button")).click();
		System.out.println("--------------------Login PSS success.------------------------");
		Common.waitSec(5);
//		driver.findElement(By.xpath(".//div[@class='rce-pl-20 rce-pr-20 col d-flex flex-column']/div[2]/div[2]/div/div/div[1]/div[2]/button")).click();
	}

	public void intake(String password) 
	{
		fUsername.sendKeys("dac+1@gkxim.com");
//		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("dac+3@gkxim.com");
		driver.findElement(By.xpath("//*[@id='pwd']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='submit_login']/div/div[4]/button")).click();
		System.out.println("--------------------Login Intake success.------------------------");
		try {
			driver.findElement(By.xpath(".//button[text()='Close']")).click();
		}
		catch (Exception e) {}
	}
	public void provider(String password) {
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("dac+2@gkxim.com");
		driver.findElement(By.xpath("//*[@id='pwd']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='submit_login']/div/div[4]/button")).click();
		System.out.println("-------------------Provider login success---------------------");
		Common.waitSec(5);
		try{
			driver.findElement(By.xpath(".//*[text()='Dismiss']")).click();
		}
		catch (Exception e) {}
	}
	public void providerRPM(String password) {
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("dacprovider@gkxim.com");
		driver.findElement(By.xpath("//*[@id='pwd']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='submit_login']/div/div[4]/button")).click();
		System.out.println("-------------------Provider login success---------------------");
		Common.waitSec(5);
		try{
			driver.findElement(By.xpath(".//*[text()='Dismiss']")).click();
		}
		catch (Exception e) {}
//		Common.waitSec(5);
		try {
			driver.findElement(By.xpath(".//button[text()='Close']")).click();
		}
		catch (Exception e) {}
	}

	public void MDL_patient() {
		driver.findElement(By.xpath(".//input[@autocomplete='new-password']")).sendKeys("dac+3@gkxim.com");
		Common.waitSec(1);
		driver.findElement(By.xpath(".//button[text()='Continue']")).click();
		Common.waitSec(3);
		driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div/div/div[2]/div/div/form/div[2]/div[2]/input")).sendKeys("123456789");
		driver.findElement(By.xpath(".//button[text()='Login']")).click();
	}

	public void change_link_to_pss() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location='https://dashboard.tms.partners/#/';");
	}

	public void change_link_to_MDL() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location='https://mydoctorslive.com/gkim-telehealth/';");
	}

	public void change_link_to_admin() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location='https://dashboard.tms.partners/admin/ehealth/adminmedical/add/';");
	}

	public void MDR_patient() {
		driver.findElement(By.xpath("//*[@id=\"dcrootID\"]/div[3]/div[2]/i")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@id=\"dcrootID\"]/div[3]/div[1]/div[2]/div/div/div[2]/div[1]/div/div")).click();
		Common.waitSec(3);

		driver.findElement(By.xpath(".//input[@autocomplete='new-password']")).sendKeys("dac+3@gkxim.com");
		Common.waitSec(3);
		driver.findElement(By.xpath(".//button[text()='Continue']")).click();
		Common.waitSec(3);
		driver.findElement(By.xpath("//*[@id=\"dcrootID\"]/div[4]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div[2]/div/div/form/div[2]/div[2]/input")).sendKeys("123456");
		driver.findElement(By.xpath(".//button[text()='Login']")).click();


	}

	public void admin() {
		driver.findElement(By.name("username")).sendKeys("dac@gkim.vn");
		Common.waitSec(2);
		driver.findElement(By.name("password")).sendKeys("dac_admin_qc12345");
		driver.findElement(By.xpath(".//input[@value='Log in']")).click();
		Common.waitSec(10);
	}

	public void change_price() {
		driver.findElement(By.xpath("//*[@id=\"accordionSidenav\"]/a[15]")).click();
		Common.waitSec(5);
		driver.findElement(By.xpath(".//a[@href='/admin/ecommerce/product/afbd97fa-ac92-4b79-b427-2109292288b5/change/']")).click();
		Common.waitSec(5);
		driver.findElement(By.id("id_unit_price")).click();
		Common.waitSec(2);
		driver.findElement(By.id("id_unit_price")).clear();
		driver.findElement(By.id("id_unit_price")).sendKeys("0.1");
		Common.waitSec(2);
		driver.findElement(By.name("_save")).click();
		Common.waitSec(5);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location='https://rcelive.gkim.digital/admin/ecommerce/product/e6f8ce1a-525e-4b1c-ae9c-a5245e6cdb15/change/?_changelist_filters=p%3D1';");

		Common.waitSec(15);

		driver.findElement(By.id("id_unit_price")).click();
		Common.waitSec(2);
		driver.findElement(By.id("id_unit_price")).clear();
		driver.findElement(By.id("id_unit_price")).sendKeys("0.1");

		Common.waitSec(2);
		driver.findElement(By.name("_save")).click();
		Common.waitSec(5);

	}

	public void back_price() {
		driver.findElement(By.xpath("//*[@id=\"accordionSidenav\"]/a[15]")).click();
		Common.waitSec(5);
		driver.findElement(By.xpath(".//a[@href='/admin/ecommerce/product/afbd97fa-ac92-4b79-b427-2109292288b5/change/']")).click();
		Common.waitSec(5);
		driver.findElement(By.id("id_unit_price")).click();
		Common.waitSec(2);
		driver.findElement(By.id("id_unit_price")).clear();
		driver.findElement(By.id("id_unit_price")).sendKeys("309");
		Common.waitSec(2);
		driver.findElement(By.name("_save")).click();
		Common.waitSec(5);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location='https://rcelive.gkim.digital/admin/ecommerce/product/e6f8ce1a-525e-4b1c-ae9c-a5245e6cdb15/change/?_changelist_filters=p%3D1';");

		Common.waitSec(15);

		driver.findElement(By.id("id_unit_price")).click();
		Common.waitSec(2);
		driver.findElement(By.id("id_unit_price")).clear();
		driver.findElement(By.id("id_unit_price")).sendKeys("90");

		Common.waitSec(2);
		driver.findElement(By.name("_save")).click();
		Common.waitSec(5);
	}

	public void MG_dashboard() {
		Actions action = new Actions(driver);

		driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[1]/ul/li[2]/a/i")).click();
		Common.waitSec(10);
		WebElement status = driver.findElement(By.xpath(".//div[text()='Status']"));
		status.click();
		Common.waitSec(1);
		action.sendKeys("read").build().perform();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(5);

		driver.findElement(By.id("selected-all-cases")).click();
		Common.waitSec(3);

		driver.findElement(By.xpath(".//button[text()='Download All']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));


		Common.waitSec(120);
		WebElement go_back = driver.findElement(By.xpath(".//button[text()='Go back']"));

		wait.until(ExpectedConditions.elementToBeClickable(go_back));
		Common.waitSec(10);
		System.out.println("test cicd");
	}

	public void PSS_dashboard() {
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div[1]/ul/li[2]/a/i")).click();
		Common.waitSec(10);
		driver.findElement(By.xpath(".//span[text()='Export CSV']")).click();
		Common.waitSec(20);
	}

	public void lobURL() {
		driver.get("https://dashboard.lob.com/");
	}

	public void changelinktoletter() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location='https://dashboard.lob.com/letters';");
	}

	public void lob() {
		driver.findElement(By.id("login-email")).sendKeys("top@gkxim.com");
		Common.waitSec(1);
		driver.findElement(By.id("password")).sendKeys("TOPtms$052023", Keys.ENTER);
		Common.waitSec(1);
	}
}
