package com.frame;

import org.openqa.selenium.*;
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
        driver.findElement(By.xpath(".//div[text()='Close Case']")).click();
        Common.waitSec(2);
        action.sendKeys(Keys.ENTER).build().perform();

    }

    public void denied_approved(String id) {
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath(".//span[text()='QC']")).click();
        Common.waitSec(5);
        driver.findElement(By.xpath(".//input[@placeholder='I want to search for…']")).sendKeys(id);
        Common.waitSec(3);
        driver.findElement(By.xpath(".//div[text()='  Accept ']")).click();
        Common.waitSec(2);
        actions.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(10);
    }

    public void complete_wellness() {
        Actions action = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Common.waitSec(5);
        WebElement id_wellness = (WebElement) js.executeScript("return document.querySelector('body .rce-mb-15 strong');");
        id_wellness.click();
        Common.waitSec(5);

        //general health
        driver.findElement(By.xpath(".//span[text()='General Health']")).click();
        Common.waitSec(3);
        driver.findElement(By.name("data[test_requirements_conclusion]")).sendKeys("test");
        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(3);

        //medical history
        driver.findElement(By.name("data[patient_personal_history_progress_note_phmx]")).sendKeys("test");
        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(3);

        //family history
//        driver.findElement(By.name("data[family_history_member_1_name]")).sendKeys("daddy");
//		Common.waitSec(2);
//		driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
//		Common.waitSec(1);
//		action.sendKeys(Keys.ENTER).build().perform();
//		Common.waitSec(1);
//		driver.findElement(By.xpath(".//input[@value='Male']")).click();
//		Common.waitSec(2);
//
//        driver.findElement(By.name("data[family_history_member_1_related_health_issue]")).sendKeys("test");
//
//        driver.findElement(By.name("data[family_history_member_confirm_doctor]")).click();
//        Common.waitSec(1);
//
//		driver.findElement(By.name("data[submit]")).click();
//		Common.waitSec(3);

        //review of systems
//        driver.findElement(By.xpath(".//span[text()='Review of Systems']")).click();
//        Common.waitSec(3);
//        driver.findElement(By.name("data[review_of_system_confirm]")).click();
//        driver.findElement(By.name("data[submit]")).click();
//        Common.waitSec(3);
//
//        //depresion screening
//        driver.findElement(By.name("data[test_requirements_depression_screening_conclusion]")).sendKeys("test");
//        driver.findElement(By.name("data[submit]")).click();
//        Common.waitSec(3);
//
//        //sexual health
//        driver.findElement(By.name("data[screening_questionnaire_conclusion]")).sendKeys("test");
//        driver.findElement(By.name("data[submit]")).click();
//        Common.waitSec(3);
//
//        //medications
////        driver.findElement(By.name("shipped")).click();
//        driver.findElement(By.xpath(".//button[text()='Save']")).click();
//		Common.waitSec(3);

        //diagnosis

        //assessment & plan
        driver.findElement(By.xpath(".//span[text()='Assessment & Plan']")).click();
        Common.waitSec(3);
        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(3);

        //aproved case
        driver.findElement(By.xpath(".//div[text()='Approve']")).click();
        Common.waitSec(3);
        action.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(3);
        driver.findElement(By.xpath(".//button[text()='Continue']")).click();
        Common.waitSec(3);

    }
    public void RPM_complete() {

        Actions action = new Actions(driver);
        //Patient's Personal History
        driver.findElement(By.xpath(".//span[text()=\"Medical History\"]")).click();
        Common.waitSec(3);
        driver.findElement(By.name("data[patient_personal_history_progress_note_confirm_doctor]")).click();
        Common.waitSec(2);
        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(3);

        //family history
        driver.findElement(By.name("data[family_history_member_1_name]")).sendKeys("daddy");
		Common.waitSec(2);
		driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
		Common.waitSec(1);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//input[@value='Male']")).click();
		Common.waitSec(2);

        driver.findElement(By.name("data[family_history_member_1_related_health_issue]")).sendKeys("test");

        driver.findElement(By.name("data[family_history_member_confirm_doctor]")).click();
        Common.waitSec(1);

		driver.findElement(By.name("data[submit]")).click();
		Common.waitSec(3);

        //review of systems
        driver.findElement(By.xpath(".//input[@name='data[review_of_system_confirm]']")).click();
        Common.waitSec(2);
        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(3);

        // medication
        System.out.println("Check Medications");
        driver.findElement(By.xpath(".//input[@name='shipped']")).click();
        Common.waitSec(2);
        driver.findElement(By.xpath(".//button[text()='Save']")).click();
        Common.waitSec(5);
        System.out.println("check");

        //diagnosis
        driver.findElement(By.xpath(".//*[text()='Diagnosis']")).click();
        Common.waitSec(3);
        driver.findElement(By.xpath(".//div[text()='M02']")).click();
        driver.findElement(By.xpath(".//div[text()='I25.5']")).click();
        Common.waitSec(1);
        driver.findElement(By.xpath(".//div[text()='G45']")).click();
        driver.findElement(By.xpath(".//div[text()='E08']")).click();
        Common.waitSec(1);
        driver.findElement(By.xpath(".//div[text()='I10']")).click();
        driver.findElement(By.xpath(".//div[text()='Z91.83']")).click();
        Common.waitSec(1);

        driver.findElement(By.xpath(".//button[text()='Save']")).click();
        Common.waitSec(3);


        //Assessment & plan
        System.out.println("Set Assessment & Plan");
        driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
        Common.waitSec(3);

        //RPM device
        driver.findElement(By.name("data[vital_blood_pressure]")).click();
        Common.waitSec(2);
        driver.findElement(By.name("data[systolic_upper_high_alert]")).sendKeys("1");
        driver.findElement(By.name("data[systolic_upper_med_alert]")).sendKeys("1");
        driver.findElement(By.name("data[systolic_lower_high_alert]")).sendKeys("1");
        driver.findElement(By.name("data[systolic_lower_med_alert]")).sendKeys("1");
        driver.findElement(By.name("data[systolic_latest]")).sendKeys("1");

        driver.findElement(By.name("data[diastolic_upper_high_alert]")).sendKeys("2");
        driver.findElement(By.name("data[diastolic_upper_med_alert]")).sendKeys("2");
        driver.findElement(By.name("data[diastolic_lower_high_alert]")).sendKeys("2");
        driver.findElement(By.name("data[diastolic_lower_med_alert]")).sendKeys("2");
        driver.findElement(By.name("data[diastolic_latest]")).sendKeys("2");

        driver.findElement(By.name("data[pulse_upper_high_alert]")).sendKeys("3");
        driver.findElement(By.name("data[pulse_upper_med_alert]")).sendKeys("3");
        driver.findElement(By.name("data[pulse_lower_high_alert]")).sendKeys("3");
        driver.findElement(By.name("data[pulse_lower_med_alert]")).sendKeys("3");
        driver.findElement(By.name("data[pulse_latest]")).sendKeys("3");

        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(3);

        //aprrove
        driver.findElement(By.xpath(".//div[text()='Approve']")).click();
        Common.waitSec(3);
//        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(3);

    }
}

