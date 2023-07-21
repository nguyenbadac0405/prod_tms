package com.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Common;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class new_to_assign {
	protected static WebDriver driver;
	public new_to_assign(WebDriver driver) {
		this.driver = driver;
	}
	
//	public String id;
	
	public static String find_id() {
		WebElement id_case = driver.findElement(By.id("casenameID"));
//		System.out.println(id_case.getAttribute("value"));
//		System.out.println("1");
		
//		System.out.println(id_case);
		String id = id_case.getAttribute("value");
		return id;
	}

	
	public void Genetics_to_assign() {
		//compliance
		Actions action = new Actions(driver);
		System.out.println("---------------------------------New to Assign---------------------------------------");
		System.out.println("Check Compliance");
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[3]/div[2]/div/div/div/div[1]/div[10]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[3]/div[2]/div/div/div/div[1]/div[11]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[3]/div[2]/div/div/div/div[1]/div[12]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[3]/div[2]/div/div/div/div[1]/div[13]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[3]/div[2]/div/div/div/div[1]/div[14]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_fulfill_communication_41589]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_willing_test_41589]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_gender_41589]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_dob_41589]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_state_41589]")).click();

		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(3);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(3);
		
		
		//select provider
		System.out.println("Select Provider");

		driver.findElement(By.xpath(".//div[text()='Select ...']")).click();
		Common.waitSec(2);
		action.sendKeys("dac").build().perform();
		Common.waitSec(3);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(5);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//div[text()='Assign']"))));
		Common.waitSec(2);
		driver.findElement(By.xpath(".//div[text()='Assign']")).click();
		Common.waitSec(3);
		action.sendKeys(Keys.ENTER).build().perform();
		System.out.println("------------------------------Done Assign-----------------------------------");
		Common.waitSec(5);
	}
	
	public void CGM_to_assign() {
		//compliance
		Actions action = new Actions(driver);
		driver.findElement(By.name("data[compliance_verification_verified_patient_name]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_previously_taken_genetic_test]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_previously_taken_genetic_test_1]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_fulfill_communication]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_willing_test]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_gender]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_dob]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_state]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_more_product_like][]")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(2);
//		driver.findElement(By.xpath(".//button[text()='Create new']")).click();
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(3);
		
		//selected provider
		System.out.println("Select Provider");


		driver.findElement(By.xpath(".//div[text()='No Provider Available']")).click();
		Common.waitSec(2);
		action.sendKeys("dac").build().perform();
		Common.waitSec(3);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(5);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//div[text()='Assign']"))));
		Common.waitSec(2);
		driver.findElement(By.xpath(".//div[text()='Assign']")).click();
		Common.waitSec(1);
		action.sendKeys(Keys.ENTER).build().perform();
		System.out.println("------------------------------Done Assign-----------------------------------");
		Common.waitSec(5);
	}
	
	public void Beauty_to_assign() {
		//compliance
		driver.findElement(By.name("data[compliance_verification_verified_patient_name]")).click();
		Common.waitSec(1);
		driver.findElement(By.name("data[compliance_verification_verified_patient_dob]")).click();
		Common.waitSec(1);
		driver.findElement(By.name("data[compliance_verification_verified_patient_gender]")).click();
		Common.waitSec(1);
		driver.findElement(By.name("data[compliance_verification_verified_patient_state]")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//input[@value='Me']")).click();
		Common.waitSec(1);

		driver.findElement(By.name("data[submit]")).click();
		Common.waitSec(5);
		Actions action = new Actions(driver);
		driver.findElement(By.name("data[order_info_textfield]")).sendKeys("123");
		Common.waitSec(1);

		driver.findElement(By.name("data[submit]")).click();
		Common.waitSec(3);
		//selected provider
		System.out.println("Select Provider");
		driver.findElement(By.xpath(".//div[text()='No Provider Available']")).click();
		Common.waitSec(2);
		action.sendKeys("dac").build().perform();
		Common.waitSec(3);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(5);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//div[text()='Assign']"))));
		Common.waitSec(2);
		driver.findElement(By.xpath(".//div[text()='Assign']")).click();
		Common.waitSec(1);
		action.sendKeys(Keys.ENTER).build().perform();
		System.out.println("------------------------------Done Assign-----------------------------------");
		Common.waitSec(5);
	}

	public void Monkeypox_to_assign() {
		//compliance
		Actions action = new Actions(driver);
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_name]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_gender]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_dob]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_state]']")).click();
		driver.findElement(By.xpath("/html/body/div/div[5]/div[3]/div[2]/div/div/div/div[1]/div[5]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div/div[5]/div[3]/div[2]/div/div/div/div[1]/div[6]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(2);
//		driver.findElement(By.xpath(".//button[text()='Create new']")).click();
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(5);


		//selected provider
		System.out.println("Select Provider");
//		Actions action = new Actions(driver);

		driver.findElement(By.xpath(".//div[text()='No Provider Available']")).click();
		Common.waitSec(2);
		action.sendKeys("dac").build().perform();
		Common.waitSec(3);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(5);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//div[text()='Assign']"))));
		Common.waitSec(2);
		driver.findElement(By.xpath(".//div[text()='Assign']")).click();
		Common.waitSec(1);
		action.sendKeys(Keys.ENTER).build().perform();
		System.out.println("------------------------------Done Assign-----------------------------------");
		Common.waitSec(5);
	}

	public void MDL_diagnosis_to_assign() {
		//compliance
		Actions action = new Actions(driver);
		driver.findElement(By.name("data[compliance_verification_verified_patient_name]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_previously_taken_genetic_test]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_previously_taken_genetic_test_1]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_fulfill_communication]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_willing_test]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_gender]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_dob]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_state]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_more_product_like][]")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(2);
//		driver.findElement(By.xpath(".//button[text()='Create new']")).click();
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(3);

		//selected provider
		System.out.println("Select Provider");


		driver.findElement(By.xpath(".//div[text()='No Provider Available']")).click();
		Common.waitSec(2);
		action.sendKeys("dac").build().perform();
		Common.waitSec(3);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(5);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//div[text()='Assign']"))));
		Common.waitSec(2);
		driver.findElement(By.xpath(".//div[text()='Assign']")).click();
		Common.waitSec(1);
		action.sendKeys(Keys.ENTER).build().perform();
		System.out.println("------------------------------Done Assign-----------------------------------");
		Common.waitSec(5);
	}

	public void weightloss_to_assign() {
		//selected provider
		System.out.println("Select Provider");
		Actions action = new Actions(driver);

		driver.findElement(By.xpath(".//div[text()='No Provider Available']")).click();
		Common.waitSec(2);
		action.sendKeys("dac").build().perform();
		Common.waitSec(3);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(5);
		driver.findElement(By.xpath(".//span[text()='Patient Information']")).click();
		Common.waitSec(3);
		driver.findElement(By.xpath(".//span[text()='Billing Information']")).click();
		Common.waitSec(3);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//div[text()='Assign']"))));
		Common.waitSec(2);
		driver.findElement(By.xpath(".//div[text()='Assign']")).click();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		System.out.println("------------------------------Done Assign-----------------------------------");
		Common.waitSec(5);
	}

	public void genetic_cancel() {
		Actions action = new Actions(driver);
		driver.findElement(By.xpath(".//div[text()='Cancel']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//div[text()='Please select reason to cancel case']")).click();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Done']")).click();
	}
}


