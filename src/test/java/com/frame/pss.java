package com.frame;

import com.Common;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class pss {
    protected static WebDriver driver;

    public pss(WebDriver driver) {
        this.driver = driver;
    }


    public void to_pending() {
        Actions action = new Actions(driver);
        System.out.println("---------------------------------New to Assign---------------------------------------");
        System.out.println("Check Compliance");
//        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[4]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div[2]/label/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[4]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div[2]/label/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[4]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[3]/div[1]/div[2]/label/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[4]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[4]/div[1]/div[2]/label/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[4]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[5]/div[1]/div[2]/label/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[4]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[6]/div[1]/div[1]/label/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[4]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[8]/div[1]/div[1]/label/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[4]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[9]/div[1]/div[2]/label/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[4]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[10]/div[1]/div[2]/label/input")).click();
        driver.findElement(By.name("data[compliance_verification_verified_patient_gender_41589]")).click();
        driver.findElement(By.name("data[compliance_verification_verified_patient_dob_41589]")).click();
        driver.findElement(By.name("data[compliance_verification_verified_patient_state_41589]")).click();

        driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
        Common.waitSec(15);

        //assign
        driver.findElement(By.id("rec-form-select-collapse-btn")).click();
        Common.waitSec(3);

        driver.findElement(By.xpath(".//div[text()='Select ...']")).click();
        Common.waitSec(2);
        action.sendKeys("dac").build().perform();
        action.sendKeys(Keys.ENTER).build().perform();
        action.sendKeys(Keys.ENTER).build().perform();

        Common.waitSec(5);
        driver.findElement(By.xpath(".//span[text()='Assign']")).click();
        Common.waitSec(2);
        action.sendKeys(Keys.ENTER).build().perform();

    }

    public void to_AFU() {
        //to result available
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions action = new Actions(driver);
        driver.findElement(By.xpath("//*[@id=\"patient-dashboard\"]/div[6]/div[4]/div/div[1]/div[5]/div/div/div[1]")).click();
        Common.waitSec(3);
        WebElement chooseFile = driver.findElement(By.xpath(".//input[@type='file']"));
        chooseFile.sendKeys("C:/Users/dac/Downloads/file.pdf");
        Common.waitSec(5);
        //to assign follow up
        driver.findElement(By.xpath(".//div[text()='Select ...']")).click();
        Common.waitSec(1);
        action.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(1);
        driver.findElement(By.xpath(".//button[text()='Upload ']")).click();
        Common.waitSec(10);

        WebElement button_send = driver.findElement(By.xpath(".//button[@class='btn btn-primary btn-md']"));
        Common.waitSec(3);
        action.moveToElement(button_send).click().build().perform();
        System.out.println("check");
        driver.findElement(By.xpath(".//button[text()='Send & Move']")).click();
        Common.waitSec(3);
        action.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(3);

        driver.findElement(By.xpath(".//span[text()='Forward']")).click();
        action.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(3);

//        try {
//            WebElement button_send = driver.findElement(By.xpath(".//button[@class='btn btn-primary btn-md']"));
//            action.moveToElement(button_send).click().build().perform();
//        } catch (Exception e) {
//            driver.findElement(By.xpath(".//button[@class='rf-close-btn']")).click();
//            Common.waitSec(3);
//            driver.findElement(By.xpath(".//button[@class='rf-btn-link']")).click();
//            Common.waitSec(3);
//            driver.findElement(By.xpath(".//button[@class='btn btn-primary btn-md']")).click();
//
//        }
    }

    public void complete() {
        Actions action = new Actions(driver);
        driver.findElement(By.xpath(".//span[text()='Close Case']")).click();
        Common.waitSec(3);
        action.sendKeys(Keys.ENTER).build().perform();
    }

    public void cancel() {
        Actions actions = new Actions(driver);

        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[4]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div[2]/label/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[4]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[3]/div[1]/div[2]/label/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[4]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[4]/div[1]/div[2]/label/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[4]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[5]/div[1]/div[2]/label/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[4]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[6]/div[1]/div[1]/label/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[4]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[8]/div[1]/div[1]/label/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[4]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[9]/div[1]/div[2]/label/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[4]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[10]/div[1]/div[2]/label/input")).click();
        driver.findElement(By.name("data[compliance_verification_verified_patient_gender_41589]")).click();
        driver.findElement(By.name("data[compliance_verification_verified_patient_dob_41589]")).click();
        driver.findElement(By.name("data[compliance_verification_verified_patient_state_41589]")).click();

        driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
        Common.waitSec(15);

        driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[6]/div[2]/div[4]/div[1]/div[2]/button")).click();
        Common.waitSec(3);
        driver.findElement(By.xpath(".//span[text()='Cancel']")).click();
        Common.waitSec(3);
        driver.findElement(By.xpath(".//div[text()='Please select reason to cancel case']")).click();
        Common.waitSec(1);
        actions.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(2);
        driver.findElement(By.xpath(".//button[text()='Done']")).click();

    }

    public void assign_RPM() {
        
    }

}
