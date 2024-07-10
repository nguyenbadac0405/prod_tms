package com.frame;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import com.Common;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class new_to_assign {
	protected static WebDriver driver;

	public new_to_assign(WebDriver driver) {
		this.driver = driver;
	}
	public String getID= "return document.querySelectorAll('[class*=\"rce-btn btn-minw-120\"]')";

	public static String find_id() {
		WebElement id_case = driver.findElement(By.xpath(".//span[@class='rf-code']"));
//		System.out.println(id_case.getAttribute("value"));
//		System.out.println("1");

//		System.out.println(id_case);
		String id = id_case.getText();
		return id;
	}
	public List<String> findName() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		List<WebElement> ID = (List<WebElement>) js.executeScript(getID);
		List<String> id = new ArrayList<String>();
		id.add(ID.get(0).getText());
		id.add(ID.get(1).getText());
		return id;
	}



	public void Genetics_to_assign() {
		//compliance
		Actions action = new Actions(driver);
		System.out.println("---------------------------------New to Assign---------------------------------------");
		System.out.println("Check Compliance");
		driver.findElement(By.xpath("/html/body/div/div[6]/div[3]/div[2]/div/div/div/div/div[1]/div[10]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div/div[6]/div[3]/div[2]/div/div/div/div/div[1]/div[11]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div/div[6]/div[3]/div[2]/div/div/div/div/div[1]/div[12]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div/div[6]/div[3]/div[2]/div/div/div/div/div[1]/div[13]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div/div[6]/div[3]/div[2]/div/div/div/div/div[1]/div[14]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[3]/div[2]/div/div/div/div/div[1]/div[15]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[3]/div[2]/div/div/div/div/div[1]/div[17]/div[1]/div[1]/label/input")).click();
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

	public void genetic_cancel() {
		Actions action = new Actions(driver);
		driver.findElement(By.xpath(".//div[text()='Cancel']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//*[@class='form-control mt-15']")).sendKeys("test");
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Done']")).click();
	}

	public void RPM_cancel() {
		Actions action = new Actions(driver);
		driver.findElement(By.xpath(".//div[text()='Cancel']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//*[text()='Please select reason to cancel case']")).click();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Done']")).click();
	}


	public void RPM() {
		//compliance
		Actions action = new Actions(driver);
		System.out.println("---------------------------------New to Assign---------------------------------------");
		System.out.println("Check Compliance");
		driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[3]/div[2]/div/div/div/div/div[1]/div[6]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[3]/div[2]/div/div/div/div/div[1]/div[7]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[3]/div[2]/div/div/div/div/div[1]/div[8]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[3]/div[2]/div/div/div/div/div[1]/div[9]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[3]/div[2]/div/div/div/div/div[1]/div[10]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[3]/div[2]/div/div/div/div/div[1]/div[11]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[3]/div[2]/div/div/div/div/div[1]/div[13]/div[1]/div[1]/label/input")).click();
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
}


