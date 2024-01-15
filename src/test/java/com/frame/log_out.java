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
		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[2]/div[3]/div[2]/button")).click();

		Common.waitSec(3);
		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[2]/div[3]/div[2]/div/div/div[2]/button")).click();


	}

	public void provider() {
//		driver.findElement(By.xpath(".//span[text()='Log Out']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('logout-menu').click();");

	}
}
