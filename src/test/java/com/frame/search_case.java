package com.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class search_case {
	protected WebDriver driver;

	public search_case(WebDriver driver) {
		this.driver = driver;
	}
	
	public void search_from_intake(String id) {
		driver.findElement(By.xpath(".//input[@placeholder='I want to search for…']")).sendKeys(id);

		driver.findElement(By.className("gk-cs-top")).click();
	}
	
	
}
