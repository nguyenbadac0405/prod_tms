package com.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class search_case {
	protected WebDriver driver;

	public search_case(WebDriver driver) {
		this.driver = driver;
	}
	
	public void search_from_intake(String id) {
		driver.findElement(By.xpath(".//input[@placeholder='I want to search for…']")).sendKeys(id);

		driver.findElement(By.className("gk-cs-top")).click();
	}

	public void search(String id) {
		driver.findElement(By.xpath(".//input[@placeholder='I want to search for…']")).clear();
		driver.findElement(By.xpath(".//input[@placeholder='I want to search for…']")).sendKeys(id);

		WebElement elementToCheck = null;

		try {
			elementToCheck = driver.findElement(By.className("gk-cs-top"));
		} catch (NoSuchElementException e) {
		}

		// Kiểm tra xem phần tử có tồn tại và hiển thị hay không
		if (elementToCheck != null && elementToCheck.isDisplayed()) {
			elementToCheck.click();
		}

	}

	public void pin() {
		driver.findElement(By.xpath("//*[@id=\"patient-dashboard\"]/div[6]/div[2]/div/div[1]/div[1]/div[2]/button")).click();
	}
	
}
