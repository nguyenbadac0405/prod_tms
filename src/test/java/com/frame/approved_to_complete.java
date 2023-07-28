package com.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Common;

public class approved_to_complete {
    protected WebDriver driver;

    public approved_to_complete(WebDriver driver) {
        this.driver = driver;
    }

    public void complete_case() {
        //complete case				 //*[@id="patient-dashboard"]/div[5]/div[2]/div[1]/div[3]/div[1]/div[3]/button
        driver.findElement(By.xpath(".//div[text()='Approve']")).click();
        Common.waitSec(3);
        driver.findElement(By.xpath(".//button[text()='Yes']")).click();
        System.out.println("----------------------PSS approved success----------------------------");
        String status = driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[1]/div[1]/div/div[1]/span[2]")).getText();
        System.out.println("------------------------------" +status+"------------------------------");
    }

    public void complete() {
        Actions action = new Actions(driver);
        driver.findElement(By.xpath(".//div[text()='Approve']")).click();
        Common.waitSec(3);
        driver.findElement(By.xpath(".//button[text()='Yes']")).click();
        System.out.println("----------------------PSS approved success----------------------------");
        Common.waitSec(3);
        driver.findElement(By.xpath(".//input[@name='ADMIN_MEDICAL-print_final_letter-check']")).click();
        Common.waitSec(3);
        driver.findElement(By.xpath(".//input[@name='ADMIN_MEDICAL-emailed_final_letter-check']")).click();
        Common.waitSec(3);

        driver.findElement(By.xpath(".//div[text()='Close Case']")).click();
        Common.waitSec(2);
        action.sendKeys(Keys.ENTER).build().perform();

        String status = driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[1]/div[1]/div/div[1]/span[2]")).getText();
        System.out.println("------------------------------" +status+"------------------------------");

    }

    public void denied_approved(String id) {
        driver.findElement(By.xpath(".//span[text()='QC']")).click();
        Common.waitSec(10);
        driver.findElement(By.xpath(".//input[@placeholder='I want to search for…']")).sendKeys(id);
        Common.waitSec(5);
        driver.findElement(By.xpath(".//div[text()='Reject']")).click();
        Common.waitSec(2);
        driver.findElement(By.xpath(".//button[text()='Done']")).click();
        Common.waitSec(10);
    }
}