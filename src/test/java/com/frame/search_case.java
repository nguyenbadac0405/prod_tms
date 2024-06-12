package com.frame;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

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

	public boolean compareStatus(String expectedStatus) {
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		//get list element status follow class
		String eleStatus = "return document.querySelectorAll('[class*=\"rc-status fs-10\"')";
		List <WebElement> status = (List<WebElement>) js.executeScript(eleStatus);

		//compare with expected status
		if (eleStatus.equals(status.get(0).getText())) {
			return true;
		}
		else {
			return false;
		}
	}

	public String getStatus()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//get list element status follow class
		String eleStatus = "return document.querySelectorAll('[class*=\"rc-status fs-10\"')";
		List <WebElement> status = (List<WebElement>) js.executeScript(eleStatus);
		return (String) status.get(0).getText();
	}
	
}
