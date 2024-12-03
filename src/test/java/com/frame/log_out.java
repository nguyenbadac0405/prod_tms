package com.frame;

import com.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class log_out {
	protected WebDriver driver;
	public log_out(WebDriver driver) {
		this.driver = driver;
	}
	
	public void logout() {
		//intake
		try {driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[2]/div[3]/div[2]/button")).click();}
		catch (Exception e) {}
		try {driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[2]/div[3]/div[2]/div/div/div[2]/button")).click();}
		catch (Exception e) {}

		//pss
		try {driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[2]/div[3]/div[3]/button")).click();}
		catch (Exception e) {}

		try {driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[2]/div[3]/div[3]/div/div/div[2]/button")).click();}
		catch (Exception e) {}

		//provider
		try {driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[3]/div[3]/div[3]/button")).click();}
		catch (Exception e) {}
		try {driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[3]/div[3]/div[3]/div/div/div[2]/button")).click();}
		catch (Exception e) {}
	}

	public void intake() {
		try {driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[2]/div[3]/div[2]/button")).click();}
		catch (Exception e) {}
		try {driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[2]/div[3]/div[2]/div/div/div[2]/button")).click();}
		catch (Exception e) {}
	}

	public void pss(){
		try {driver.findElement(By.xpath("//button[@type='button'][.//i[contains(@class, 'fa-gear')]]")).click();}
		catch (Exception e) {}

		try {driver.findElement(By.xpath("//div[@class='gk-con-right']/button")).click();}
		catch (Exception e) {}
	}
	public void provider(){
		try {
			System.out.println(driver.findElement(By.xpath("//button[.//i[contains(@class, 'fa-gear')]]")).isDisplayed());
			driver.findElement(By.xpath("//button[.//i[contains(@class, 'fa-gear')]]")).click();
		}
		catch (Exception e) {}
		try {
			driver.findElement(By.xpath("//div[@class='gk-con-right']/button")).click();}
		catch (Exception e) {
			System.out.println("Can not logout");
		}
	}



	public void provider1() {
//		driver.findElement(By.xpath(".//span[text()='Log Out']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('logout-menu').click();");

	}

	public void test_logout() {
		//intake
		try {
			//intake
			if(driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[2]/div[3]/div[2]/button")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[2]/div[3]/div[2]/button")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[2]/div[3]/div[2]/div/div/div[2]/button")).click();
			}
			//pss
			if(driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[2]/div[3]/div[3]/button")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[2]/div[3]/div[3]/button")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[2]/div[3]/div[3]/div/div/div[2]/button")).click();
			}
			//provider
			if(driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[3]/div[3]/div[3]/button")).isDisplayed()){
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[3]/div[3]/div[3]/button")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[3]/div[3]/div[3]/div/div/div[2]/button")).click();
			}
		}
		catch (Exception e) {
			System.out.println("The element of logout button is changed");
		}

	}
}
