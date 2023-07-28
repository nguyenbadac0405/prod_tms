package com.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class log_out {
	protected WebDriver driver;
	public log_out(WebDriver driver) {
		this.driver = driver;
	}
	
	public void logout() {
		driver.findElement(By.xpath("//*[@id='logout-menu']")).click();
//		Common.waitSec(30);
	}

	public void provider() {
//		driver.findElement(By.xpath(".//span[text()='Log Out']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('logout-menu').click();");

	}
}
