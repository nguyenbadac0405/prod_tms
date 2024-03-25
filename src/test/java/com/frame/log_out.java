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
		try {driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[2]/div[3]/div[3]/button")).click();}
		catch (Exception e) {}

		try {driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[2]/div[3]/div[3]/div/div/div[2]/button")).click();}
		catch (Exception e) {}
	}
	public void provider(){
		try {driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[3]/div[3]/div[3]/button")).click();}
		catch (Exception e) {}
		try {driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[3]/div[3]/div[3]/div/div/div[2]/button")).click();}
		catch (Exception e) {}
	}



	public void provider1() {
//		driver.findElement(By.xpath(".//span[text()='Log Out']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('logout-menu').click();");

	}
}
