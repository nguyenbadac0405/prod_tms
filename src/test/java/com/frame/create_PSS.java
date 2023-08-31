package com.frame;

import com.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class create_PSS {
    protected static WebDriver driver;
    public create_PSS(WebDriver driver) {
        this.driver = driver;
    }

    public void create_PSS(String email, String name) {
        driver.findElement(By.id("id_email")).sendKeys(email);
        Common.waitSec(2);
        driver.findElement(By.id("id_password")).sendKeys("123456");
        Common.waitSec(2);
        driver.findElement(By.id("id_confirm_password")).sendKeys("123456");
        Common.waitSec(2);
        driver.findElement(By.id("id_is_sales")).click();
        Common.waitSec(1);

        driver.findElement(By.id("id_is_qc")).click();
        Common.waitSec(1);

        driver.findElement(By.id("id_can_compensate_provider")).click();
        Common.waitSec(1);

        driver.findElement(By.id("id_can_send_request_for_payment_directly_to_patient")).click();
        Common.waitSec(1);

        driver.findElement(By.xpath("//*[@id=\"adminmedical_form\"]/div/div/div[2]/div[12]/div/div/span/span[1]/span/ul/li/input")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).build().perform();
        action.sendKeys(Keys.ARROW_DOWN).build().perform();
        action.sendKeys(Keys.ARROW_DOWN).build().perform();
        action.sendKeys(Keys.ARROW_DOWN).build().perform();
        action.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(3);

        driver.findElement(By.xpath("//*[@id=\"adminmedical_form\"]/div/div/div[2]/div[13]/div/div/span/span[1]/span/ul/li/input")).click();
        action.sendKeys(Keys.ARROW_DOWN).build().perform();
        action.sendKeys(Keys.ARROW_DOWN).build().perform();
        action.sendKeys(Keys.ARROW_DOWN).build().perform();
        action.sendKeys(Keys.ARROW_DOWN).build().perform();
        action.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(3);

        driver.findElement(By.id("id_full_name")).sendKeys(name);
        Common.waitSec(3);

        driver.findElement(By.name("_save")).click();
        Common.waitSec(5);

    }
}
