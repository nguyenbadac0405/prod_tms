package com.frame;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import com.Common;

public class approve_to_assign_follow_up {
	protected WebDriver driver;

	public approve_to_assign_follow_up(WebDriver driver) {
		this.driver = driver;
	}
	
	public void EEG_to_assign_follow_up() {
		Actions action = new Actions(driver);
//		to awaiting result 
		driver.findElement(By.xpath(".//div[text()='Approve']")).click();
		Common.waitSec(2);
//		driver.findElement(By.xpath(".//input[@value='Yes']")).click();
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(10);
		//to result available
		WebElement chooseFile = driver.findElement(By.xpath(".//input[@type='file']"));
		chooseFile.sendKeys("C:/Users/dac/Downloads/file.pdf");
		Common.waitSec(5);
		//to assign follow up
		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[8]/div/div[2]/div[2]/div/div[2]/div/div")).click();
		Common.waitSec(1);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(5);
		driver.findElement(By.xpath(".//div[text()='Submit']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Yes']")).click();
		Common.waitSec(3);
		driver.findElement(By.xpath(".//div[text()='Forward']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Yes']")).click();
		
		
	}
	
	public void Genetics_to_RTS() {
		Actions action = new Actions(driver);
//		to awaiting result 
		driver.findElement(By.xpath(".//div[text()='Approve']")).click();
		Common.waitSec(2);
//		driver.findElement(By.xpath(".//input[@value='Yes']")).click();
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(10);
	}
	
	public void Genetics_to_Awating_Result() {
		Actions action = new Actions(driver);
		driver.findElement(By.id("shipped-check")).click();
		Common.waitSec(3);
		driver.findElement(By.id("kit-returned-check")).click();
		Common.waitSec(3);
		driver.findElement(By.name("is-completed")).click();
		Common.waitSec(3);
		driver.findElement(By.xpath(".//div[text()='Sent to Lab']")).click();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
	}

	public void Genetics_to_AFU() {
		//to result available
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		WebElement chooseFile = driver.findElement(By.xpath(".//input[@type='file']"));
		chooseFile.sendKeys("C:/Users/dac/Downloads/file.pdf");
		Common.waitSec(5);
		//to assign follow up
		driver.findElement(By.xpath(".//div[text()='Select ...']")).click();
		Common.waitSec(1);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//button[text()='Upload ']")).click();
		Common.waitSec(5);
//		WebElement button_send = (WebElement) js.executeScript("return document.querySelector('body .modal-content .modal-body button');");
//		button_send.click();
		try {
			WebElement button_send = driver.findElement(By.xpath(".//button[@class='btn btn-primary btn-md']"));
			action.moveToElement(button_send).click().build().perform();
		}
		catch (Exception e) {
			driver.findElement(By.xpath(".//button[@class='rf-close-btn']")).click();
			Common.waitSec(3);
			driver.findElement(By.xpath(".//button[@class='rf-btn-link']")).click();
			Common.waitSec(3);
			driver.findElement(By.xpath(".//button[@class='btn btn-primary btn-md']")).click();

		}

		System.out.println("success");
		Common.waitSec(3);

//		action.moveToElement(button_send).click().build().perform();
		Common.waitSec(3);
		driver.findElement(By.xpath(".//button[text()='Send & Move']")).click();
		Common.waitSec(6);
		driver.findElement(By.xpath(".//div[text()='Forward']")).click();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(3);
	}
	
	
	public void test() {
		driver.findElement(By.xpath(".//button[@class='rf-btn-link']")).click();
		Common.waitSec(3);
		try {
			WebElement element = driver.findElement(By.xpath(".//button[@class='btn btn-primary btn-md']"));
			System.out.println("success");
		}
		catch (Exception e) {
			System.out.println("nothing");
		}


	}
	
	
}
