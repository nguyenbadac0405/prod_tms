package com.frame;

import com.Common;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class sendback {
    protected static WebDriver driver;
    public sendback(WebDriver driver) {
        this.driver = driver;
    }

    public void for_qc_correction(String id) {
        driver.findElement(By.xpath(".//span[text()='QC']")).click();
        Common.waitSec(5);
        driver.findElement(By.xpath(".//input[@placeholder='I want to search for…']")).sendKeys(id);
        Common.waitSec(3);

        driver.findElement(By.xpath(".//div[text()=' Send Back ']")).click();
        Common.waitSec(2);
        driver.findElement(By.xpath(".//*[@class='form-control mt-15']")).sendKeys("test");
        Common.waitSec(2);
        driver.findElement(By.xpath(".//button[@class='btn rce-btn ']")).click();
        Common.waitSec(3);
    }

    public void for_provider_correction(String id) {
        driver.findElement(By.xpath(".//span[text()='QC']")).click();
        Common.waitSec(5);
        driver.findElement(By.xpath(".//input[@placeholder='I want to search for…']")).sendKeys(id);
        Common.waitSec(3);
        driver.findElement(By.xpath(".//div[text()=' Send Back']")).click();
        Common.waitSec(2);

        driver.findElement(By.xpath(".//*[@class='form-control mt-15']")).sendKeys("test");
        Common.waitSec(2);
        driver.findElement(By.xpath(".//button[@class='btn rce-btn ']")).click();
        Common.waitSec(3);

    }

    public void denied_again() {
        driver.findElement(By.xpath(".//div[text()='Deny']")).click();
        Common.waitSec(2);
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath(".//div[text()='Please select reason to reject case']")).click();
        Common.waitSec(1);
        actions.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(2);
        driver.findElement(By.xpath(".//input[@placeholder='Search']")).sendKeys("a");
        Common.waitSec(3);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement icd = (WebElement) js.executeScript("return document.querySelector('body .modal-content .modal-body .content-wrapper .rc-suggest li');");
        icd.click();
        Common.waitSec(1);
        driver.findElement(By.xpath(".//span[text()='Done']")).click();
        Common.waitSec(3);
        driver.findElement(By.xpath(".//button[text()='Done']")).click();
        Common.waitSec(3);
        actions.sendKeys(Keys.ENTER).build().perform();
    }
}
