package com.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Common;

public class assign_to_approved {
    protected WebDriver driver;


    public assign_to_approved(WebDriver driver) {
        this.driver = driver;
    }



    public void to_approve3() {
        Actions action = new Actions(driver);
        // set assessment & plan
        driver.findElement(By.xpath(".//span[text()='Assessment & Plan']")).click();
        Common.waitSec(2);
        driver.findElement(By.xpath(".//input[@value='Yes']")).click();
        Common.waitSec(1);
        driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
        Common.waitSec(2);
        // approve
        driver.findElement(By.xpath(".//div[text()='Approve']")).click();
        Common.waitSec(3);
//        driver.findElement(By.xpath(".//button[text()='Yes']")).click();
        action.sendKeys(Keys.ENTER).build().perform();

        Common.waitSec(3);

        System.out.println("-------------------------Done Approve----------------------------");
        Common.waitSec(5);

    }


    public void Genetics_to_approve1(String type, String lab) {
        Actions action = new Actions(driver);
        // TYPE == CGX
        if (type.equals("CGX")) {
            if (lab.equals("CGX-Unity")) {
                // patient infor
                System.out.println("Check Patient Information");
                driver.findElement(By.xpath(".//input[@value='Yes']")).click();
                Common.waitSec(2);
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // Medical History
                System.out.println("Patient's Personal History");
                driver.findElement(By.xpath(".//span[text()=\"Patient's Personal History\"]")).click();
                Common.waitSec(2);
                driver.findElement(By.name("data[patient_personal_history_progress_note_phmx]")).sendKeys("test");
//                driver.findElement(By.name("data[medical_history_confirm_doctor]")).click();
                Common.waitSec(2);
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // Family History
                System.out.println("Check Family History");
                driver.findElement(By.name("data[family_history_member_1_related_health_issue]")).sendKeys("test");
                driver.findElement(By.xpath("//*[@name='data[family_history_member_confirm_doctor]']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // medication
                System.out.println("Check Medications");
                driver.findElement(
                                By.xpath("//*[@id=\"patient-dashboard\"]/div[5]/div[3]/div[3]/div/div[4]/label/input"))
                        .click();
                Common.waitSec(2);
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(5);

                // Diagnosis
                System.out.println("Set Diagnosis");
                driver.findElement(By.xpath(".//div[text()='Z80.1']")).click();
                driver.findElement(By.xpath(".//div[text()='C44.300']")).click();
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(5);

                // review of systems
                System.out.println("Review of Systems");

                driver.findElement(By.name("data[review_of_system_confirm]")).click();
                driver.findElement(By.name("data[submit]")).click();
                Common.waitSec(5);
                // assessment & plan
                System.out.println("Set Assessment & Plan");
                driver.findElement(By.name("data[assessment_plan_plan]"))
                        .sendKeys("There is all plan that the provider is setting for you.");
                Common.waitSec(2);
                driver.findElement(By.name("data[submit]")).click();
                Common.waitSec(3);

            }
            if (lab.equals("CGX - Biogroup")) {
                // patient infor
                System.out.println("Check Patient Information");
                driver.findElement(By.xpath(".//input[@value='Yes']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // Medical History
                System.out.println("Check Medical History");
                driver.findElement(By.xpath(".//span[text()='Medical History']")).click();
                Common.waitSec(2);
                driver.findElement(By.xpath(".//input[@value='Yes']")).click();
                Common.waitSec(2);
                driver.findElement(By.name("data[medical_history_patient_question2]")).sendKeys("test");
                driver.findElement(By.name("data[medical_history_patient_question3]")).sendKeys("test");
                driver.findElement(By.name("data[patient_personal_history_progress_note_phmx]")).sendKeys("test");
                driver.findElement(By.name("data[submit]")).click();
                Common.waitSec(3);

                // Family History
                Actions actions = new Actions(driver);
                System.out.println("Check Family History");
                WebElement element = driver.findElement(By.xpath(".//span[text()='Family History']"));
                actions.moveToElement(element).click().build().perform();
                Common.waitSec(3);
                driver.findElement(By.name("data[family_history_member_1_related_health_issue]")).sendKeys("test");
                driver.findElement(By.xpath("//*[@name='data[family_history_member_confirm_doctor]']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // medication
                System.out.println("Check Medications");
                driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(5);

                // Diagnosis
                System.out.println("Set Diagnosis");
                driver.findElement(By.xpath(".//div[text()='Z80.1']")).click();
                driver.findElement(By.xpath(".//div[text()='C44.300']")).click();
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(5);

                // review of systems
                System.out.println("Review of Systems");

                driver.findElement(By.name("data[review_of_system_confirm]")).click();
                driver.findElement(By.name("data[submit]")).click();
                Common.waitSec(5);
                // assessment & plan
                System.out.println("Set Assessment & Plan");
                driver.findElement(By.name("data[assessment_plan_plan]")).sendKeys("There is all plan that the provider is setting for you.");
                Common.waitSec(2);
                driver.findElement(By.name("data[submit]")).click();
                Common.waitSec(3);
            }

        }

        // TYPE == CARDIO
        if (type.equals("Cardio")) {
            // LAB == CARDIO - ALIGN
            if (lab.equals("Cardio - ALIGN")) {
                // patient infor
                System.out.println("Check Patient Information");
                driver.findElement(By.xpath(".//input[@value='Yes']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // patient's Medical History
                System.out.println("Check Medical History");
                driver.findElement(By.xpath(".//span[text()=\"Patient's Personal History\"]")).click();
                Common.waitSec(2);
                driver.findElement(By.xpath(".//*[@name='data[patient_personal_history_progress_note_phmx]']"))
                        .sendKeys("test");
                driver.findElement(By.name("data[patient_patient_history_confirm_doctor]")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // Family History
                System.out.println("Check Family History");
                driver.findElement(By.name("data[family_history_member_1_related_health_issue]")).sendKeys("test");
                driver.findElement(By.xpath("//*[@name='data[family_history_member_confirm_doctor]']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // medication
                System.out.println("Check Medications");
                driver.findElement(
                                By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input"))
                        .click();
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(5);

                // Diagnosis
                System.out.println("Set Diagnosis");
                driver.findElement(By.xpath(".//div[text()='E78.01']")).click();
                driver.findElement(By.xpath(".//div[text()='E78.49']")).click();
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(5);

                // review of systems
                System.out.println("Review of Systems");

                driver.findElement(By.xpath("//*[@name='data[review_of_system_confirm]']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(5);
                // assessment & plan
                System.out.println("Set Assessment & Plan");
                driver.findElement(By.xpath("//*[@name='data[assessment_plan_plan]']"))
                        .sendKeys("There is all plan that the provider is setting for you.");
                Common.waitSec(2);
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

            }
        }

        // TYPE == PGX
        if (type.equals("PGX")) {
            if (lab.equals("PGX_ADVANTA")) {
                // patient infor
                System.out.println("Check Patient Information");
                driver.findElement(By.xpath(".//input[@value='Yes']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // patient's Medical History
                System.out.println("Check Medical History");
                driver.findElement(By.xpath(".//span[text()='Medical History']")).click();
                Common.waitSec(2);
                driver.findElement(By.name("data[patient_personal_history_progress_note_phmx]")).sendKeys("test");
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // medication
                System.out.println("Check Medications");
                driver.findElement(
                                By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input"))
                        .click();
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(5);

                // Diagnosis
                System.out.println("Set Diagnosis");
                driver.findElement(By.xpath(".//div[text()='Z13.79']")).click();
                driver.findElement(By.xpath(".//div[text()='I25.9']")).click();
                driver.findElement(By.xpath(".//div[text()='I82.890']")).click();
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(3);

                // review of systems
                System.out.println("Review of Systems");

                driver.findElement(By.xpath("//*[@name='data[review_of_system_confirm]']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(5);
                // assessment & plan
                System.out.println("Set Assessment & Plan");
                driver.findElement(By.xpath("//*[@name='data[assessment_plan_plan]']"))
                        .sendKeys("There is all plan that the provider is setting for you.");
                Common.waitSec(2);
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);
            }
        }
        if (type.equals("Pulmonary")) {
            if (lab.equals("Pulmonary AdvaGenix")) {
                // patient infor
                System.out.println("Check Patient Information");
                driver.findElement(By.xpath(".//input[@value='Yes']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // patient's Medical History
                System.out.println("Check Medical History");
                driver.findElement(By.xpath(".//span[text()=\"Patient's Medical History\"]")).click();
                Common.waitSec(2);
                driver.findElement(By.xpath(".//*[@name='data[patient_personal_history_progress_note_phmx]']"))
                        .sendKeys("test");
                driver.findElement(By.name("data[patient_personal_history_confirm_doctor]")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // Family History
                System.out.println("Check Family History");
                driver.findElement(By.name("data[family_history_member_1_related_health_issue]")).sendKeys("test");
                driver.findElement(By.xpath("//*[@name='data[family_history_member_confirm_doctor]']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // medication
                System.out.println("Check Medications");
                driver.findElement(
                                By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input"))
                        .click();
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(5);

                // Diagnosis
                System.out.println("Set Diagnosis");
                driver.findElement(By.xpath(".//div[text()='J43.9']")).click();
                driver.findElement(By.xpath(".//div[text()='J45.99']")).click();
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(5);

                // review of systems
                System.out.println("Review of Systems");

                driver.findElement(By.xpath("//*[@name='data[review_of_system_confirm]']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(5);
                // assessment & plan
                System.out.println("Set Assessment & Plan");
                driver.findElement(By.xpath("//*[@name='data[assessment_plan_plan]']"))
                        .sendKeys("There is all plan that the provider is setting for you.");
                Common.waitSec(2);
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);
            }
        }

        if (type.equals("Diabetes")) {
            if (lab.equals("Diabetes - INFINITY")) {
                // patient infor
                System.out.println("Check Patient Information");
                driver.findElement(By.xpath(".//input[@value='Yes']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // Medical History
                System.out.println("Check Medical History");
                driver.findElement(By.xpath(".//span[text()='Medical History']")).click();
                Common.waitSec(2);
                driver.findElement(By.name("data[patient_personal_history_progress_note_phmx]")).sendKeys("test");
                driver.findElement(By.name("data[patient_personal_history_confirm_sale_2]")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // medication
                System.out.println("Check Medications");
                driver.findElement(
                                By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input"))
                        .click();
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(5);

                // Family History
                System.out.println("Check Family History");
                driver.findElement(By.name("data[family_history_member_1_related_health_issue]")).sendKeys("test");
                driver.findElement(By.xpath("//*[@name='data[family_history_member_confirm_doctor]']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(5);

                // Diagnosis
                driver.findElement(By.xpath(".//span[text()='Diagnosis']")).click();
                System.out.println("Set Diagnosis");
                driver.findElement(By.xpath(".//div[text()='E11.9']")).click();
                driver.findElement(By.xpath(".//div[text()='E78.00']")).click();
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(5);

                // review of systems
                System.out.println("Review of Systems");
                driver.findElement(By.name("data[review_of_system_confirm]")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(5);

                // assessment & plan
                System.out.println("Set Assessment & Plan");
                driver.findElement(By.xpath("//*[@name='data[assessment_plan_plan]']"))
                        .sendKeys("There is all plan that the provider is setting for you.");
                Common.waitSec(2);
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);
            }
        }

        if (type.equals("Immunodeficiency")) {
            if (lab.equals("Immunodeficiency - Biogroup")) {
                // patient infor
                System.out.println("Check Patient Information");
                driver.findElement(By.xpath(".//input[@value='Yes']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // patient's Medical History
                System.out.println("Check Medical History");
                driver.findElement(By.xpath(".//span[text()=\"Patient's Personal History\"]")).click();
                Common.waitSec(2);
                driver.findElement(By.xpath(".//*[@name='data[patient_personal_history_progress_note_phmx]']"))
                        .sendKeys("test");
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // Family History
                driver.findElement(By.xpath(".//span[text()='Family History']")).click();
                System.out.println("Check Family History");
                driver.findElement(By.name("data[family_history_member_1_immunideficiency_condition]"))
                        .sendKeys("test");
                driver.findElement(By.xpath("//*[@name='data[family_history_member_confirm_doctor]']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // Diagnosis
                System.out.println("Set Diagnosis");
                driver.findElement(By.xpath(".//div[text()='A182']")).click();
                driver.findElement(By.xpath(".//div[text()='D609']")).click();
                driver.findElement(By.xpath(".//div[text()='Z83.2']")).click();
                Common.waitSec(1);
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(5);

                // review of systems
                System.out.println("Review of Systems");
                driver.findElement(By.xpath("//*[@name='data[review_of_system_confirm]']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(5);
                // assessment & plan
                System.out.println("Set Assessment & Plan");
                driver.findElement(By.xpath("//*[@name='data[assessment_plan_plan]']"))
                        .sendKeys("There is all plan that the provider is setting for you.");
                Common.waitSec(2);
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);
            }
        }

        if (type.equals("NEUROCOGNITIVE")) {
            if (lab.equals("Neurocognitive-Diax")) {
                // patient infor
                System.out.println("Check Patient Information");
                driver.findElement(By.xpath(".//input[@value='Yes']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // Medical History
                System.out.println("Check Medical History");
                driver.findElement(By.xpath(".//span[text()='Medical History']")).click();
                Common.waitSec(2);
                driver.findElement(By.xpath(".//*[@name='data[patient_personal_history_progress_note_phmx]']"))
                        .sendKeys("test");
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // Family History
                driver.findElement(By.xpath(".//span[text()='Family History']")).click();
                System.out.println("Check Family History");
                Common.waitSec(2);
                driver.findElement(By.name("data[family_history_member_1_related_health_issue]")).sendKeys("test");
                driver.findElement(By.name("data[family_history_member_confirm_doctor]")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // Diagnosis
                System.out.println("Set Diagnosis");
                driver.findElement(By.xpath(".//input[@class='input-search']")).sendKeys("test");
                Common.waitSec(2);
                driver.findElement(By
                                .xpath("//*[@id=\"patient-dashboard\"]/div[5]/div[3]/div[4]/div[3]/div/div[2]/div[3]/ul/li[1]"))
                        .click();
                Common.waitSec(1);
                driver.findElement(By.xpath("//span[text()='Done']")).click();
                Common.waitSec(1);
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(3);

                // medication
                System.out.println("Check Medications");
                driver.findElement(
                                By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input"))
                        .click();
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(5);

                // review of systems
                System.out.println("Review of Systems");
                driver.findElement(By.xpath("//*[@name='data[review_of_system_confirm]']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(5);

                // assessment & plan
                System.out.println("Set Assessment & Plan");
                driver.findElement(By.xpath("//*[@name='data[assessment_plan_plan]']"))
                        .sendKeys("There is all plan that the provider is setting for you.");
                Common.waitSec(2);

                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);
            }
        }

        // approved
        driver.findElement(By.xpath(".//div[text()='Approve']")).click();
        Common.waitSec(3);
//        driver.findElement(By.xpath(".//button[text()='Yes']")).click();
        action.sendKeys(Keys.ENTER).build().perform();

        Common.waitSec(3);
        driver.findElement(By.xpath(".//span[text()=' No Follow Up']")).click();
        System.out.println("-------------------------Done Approve----------------------------");
        Common.waitSec(5);
    }

    public void genetic_denied(String type, String lab) {
        // TYPE == CGX
        if (type.equals("CGX")) {
            if (lab.equals("CGX-Unity")) {
                System.out.println("Check Patient Information");
                driver.findElement(By.xpath(".//input[@value='Yes']")).click();
                Common.waitSec(2);
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // Medical History
                System.out.println("Patient's Personal History");
                driver.findElement(By.xpath(".//span[text()=\"Patient's Personal History\"]")).click();
                Common.waitSec(2);
                driver.findElement(By.name("data[patient_personal_history_progress_note_phmx]")).sendKeys("test");
//                driver.findElement(By.name("data[medical_history_confirm_doctor]")).click();
                Common.waitSec(2);
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // Family History
                System.out.println("Check Family History");
                driver.findElement(By.name("data[family_history_member_1_related_health_issue]")).sendKeys("test");
                driver.findElement(By.xpath("//*[@name='data[family_history_member_confirm_doctor]']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // medication
                System.out.println("Check Medications");
                driver.findElement(
                                By.xpath("//*[@id=\"patient-dashboard\"]/div[5]/div[3]/div[3]/div/div[4]/label/input"))
                        .click();
                Common.waitSec(2);
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(5);

                // Diagnosis
                System.out.println("Set Diagnosis");
                driver.findElement(By.xpath(".//div[text()='Z80.1']")).click();
                driver.findElement(By.xpath(".//div[text()='C44.300']")).click();
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(5);

                // review of systems
                System.out.println("Review of Systems");

                driver.findElement(By.name("data[review_of_system_confirm]")).click();
                driver.findElement(By.name("data[submit]")).click();
                Common.waitSec(5);
                // assessment & plan
                System.out.println("Set Assessment & Plan");
                driver.findElement(By.name("data[assessment_plan_plan]"))
                        .sendKeys("There is all plan that the provider is setting for you.");
                Common.waitSec(2);
                driver.findElement(By.name("data[submit]")).click();
                Common.waitSec(3);

            }
            if (lab.equals("CGX - Biogroup")) {
                // patient infor
                System.out.println("Check Patient Information");
                driver.findElement(By.xpath(".//input[@value='Yes']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // Medical History
                System.out.println("Check Medical History");
                driver.findElement(By.xpath(".//span[text()='Medical History']")).click();
                Common.waitSec(2);
                driver.findElement(By.xpath(".//input[@value='Yes']")).click();
                Common.waitSec(2);
                driver.findElement(By.name("data[medical_history_patient_question2]")).sendKeys("test");
                driver.findElement(By.name("data[medical_history_patient_question3]")).sendKeys("test");
                driver.findElement(By.name("data[patient_personal_history_progress_note_phmx]")).sendKeys("test");
                driver.findElement(By.name("data[submit]")).click();
                Common.waitSec(3);

                // Family History
                Actions actions = new Actions(driver);
                System.out.println("Check Family History");
                WebElement element = driver.findElement(By.xpath(".//span[text()='Family History']"));
                actions.moveToElement(element).click().build().perform();
                Common.waitSec(3);
                driver.findElement(By.name("data[family_history_member_1_related_health_issue]")).sendKeys("test");
                driver.findElement(By.xpath("//*[@name='data[family_history_member_confirm_doctor]']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // medication
                System.out.println("Check Medications");
                driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(5);

                // Diagnosis
                System.out.println("Set Diagnosis");
                driver.findElement(By.xpath(".//div[text()='Z80.1']")).click();
                driver.findElement(By.xpath(".//div[text()='C44.300']")).click();
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(5);

                // review of systems
                System.out.println("Review of Systems");

                driver.findElement(By.name("data[review_of_system_confirm]")).click();
                driver.findElement(By.name("data[submit]")).click();
                Common.waitSec(5);
                // assessment & plan
                System.out.println("Set Assessment & Plan");
                driver.findElement(By.name("data[assessment_plan_plan]")).sendKeys("There is all plan that the provider is setting for you.");
                Common.waitSec(2);
                driver.findElement(By.name("data[submit]")).click();
                Common.waitSec(3);
            }

        }

        // TYPE == CARDIO
        if (type.equals("Cardio")) {
            // LAB == CARDIO - ALIGN
            if (lab.equals("Cardio - ALIGN")) {
                // patient infor
                System.out.println("Check Patient Information");
                driver.findElement(By.xpath(".//input[@value='Yes']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // patient's Medical History
                System.out.println("Check Medical History");
                driver.findElement(By.xpath(".//span[text()=\"Patient's Personal History\"]")).click();
                Common.waitSec(2);
                driver.findElement(By.xpath(".//*[@name='data[patient_personal_history_progress_note_phmx]']"))
                        .sendKeys("test");
                driver.findElement(By.name("data[patient_patient_history_confirm_doctor]")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // Family History
                System.out.println("Check Family History");
                driver.findElement(By.name("data[family_history_member_1_related_health_issue]")).sendKeys("test");
                driver.findElement(By.xpath("//*[@name='data[family_history_member_confirm_doctor]']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // medication
                System.out.println("Check Medications");
                driver.findElement(
                                By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input"))
                        .click();
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(5);

                // Diagnosis
                System.out.println("Set Diagnosis");
                driver.findElement(By.xpath(".//div[text()='E78.01']")).click();
                driver.findElement(By.xpath(".//div[text()='E78.49']")).click();
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(5);

                // review of systems
                System.out.println("Review of Systems");

                driver.findElement(By.xpath("//*[@name='data[review_of_system_confirm]']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(5);
                // assessment & plan
                System.out.println("Set Assessment & Plan");
                driver.findElement(By.xpath("//*[@name='data[assessment_plan_plan]']"))
                        .sendKeys("There is all plan that the provider is setting for you.");
                Common.waitSec(2);
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

            }
        }

        // TYPE == PGX
        if (type.equals("PGX")) {
            if (lab.equals("PGX_ADVANTA")) {
                // patient infor
                System.out.println("Check Patient Information");
                driver.findElement(By.xpath(".//input[@value='Yes']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // patient's Medical History
                System.out.println("Check Medical History");
                driver.findElement(By.xpath(".//span[text()='Medical History']")).click();
                Common.waitSec(2);
                driver.findElement(By.name("data[patient_personal_history_progress_note_phmx]")).sendKeys("test");
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // medication
                System.out.println("Check Medications");
                driver.findElement(
                                By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input"))
                        .click();
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(5);

                // Diagnosis
                System.out.println("Set Diagnosis");
                driver.findElement(By.xpath(".//div[text()='Z13.79']")).click();
                driver.findElement(By.xpath(".//div[text()='I25.9']")).click();
                driver.findElement(By.xpath(".//div[text()='I82.890']")).click();
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(3);

                // review of systems
                System.out.println("Review of Systems");

                driver.findElement(By.xpath("//*[@name='data[review_of_system_confirm]']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(5);
                // assessment & plan
                System.out.println("Set Assessment & Plan");
                driver.findElement(By.xpath("//*[@name='data[assessment_plan_plan]']"))
                        .sendKeys("There is all plan that the provider is setting for you.");
                Common.waitSec(2);
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);
            }
        }
        if (type.equals("Pulmonary")) {
            if (lab.equals("Pulmonary AdvaGenix")) {
                // patient infor
                System.out.println("Check Patient Information");
                driver.findElement(By.xpath(".//input[@value='Yes']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // patient's Medical History
                System.out.println("Check Medical History");
                driver.findElement(By.xpath(".//span[text()=\"Patient's Medical History\"]")).click();
                Common.waitSec(2);
                driver.findElement(By.xpath(".//*[@name='data[patient_personal_history_progress_note_phmx]']"))
                        .sendKeys("test");
                driver.findElement(By.name("data[patient_personal_history_confirm_doctor]")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // Family History
                System.out.println("Check Family History");
                driver.findElement(By.name("data[family_history_member_1_related_health_issue]")).sendKeys("test");
                driver.findElement(By.xpath("//*[@name='data[family_history_member_confirm_doctor]']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // medication
                System.out.println("Check Medications");
                driver.findElement(
                                By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input"))
                        .click();
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(5);

                // Diagnosis
                System.out.println("Set Diagnosis");
                driver.findElement(By.xpath(".//div[text()='J43.9']")).click();
                driver.findElement(By.xpath(".//div[text()='J45.99']")).click();
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(5);

                // review of systems
                System.out.println("Review of Systems");

                driver.findElement(By.xpath("//*[@name='data[review_of_system_confirm]']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(5);
                // assessment & plan
                System.out.println("Set Assessment & Plan");
                driver.findElement(By.xpath("//*[@name='data[assessment_plan_plan]']"))
                        .sendKeys("There is all plan that the provider is setting for you.");
                Common.waitSec(2);
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);
            }
        }

        if (type.equals("Diabetes")) {
            if (lab.equals("Diabetes - INFINITY")) {
                // patient infor
                System.out.println("Check Patient Information");
                driver.findElement(By.xpath(".//input[@value='Yes']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // Medical History
                System.out.println("Check Medical History");
                driver.findElement(By.xpath(".//span[text()='Medical History']")).click();
                Common.waitSec(2);
                driver.findElement(By.name("data[patient_personal_history_progress_note_phmx]")).sendKeys("test");
                driver.findElement(By.name("data[patient_personal_history_confirm_sale_2]")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // medication
                System.out.println("Check Medications");
                driver.findElement(
                                By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input"))
                        .click();
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(5);

                // Family History
                System.out.println("Check Family History");
                driver.findElement(By.name("data[family_history_member_1_related_health_issue]")).sendKeys("test");
                driver.findElement(By.xpath("//*[@name='data[family_history_member_confirm_doctor]']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(5);

                // Diagnosis
                driver.findElement(By.xpath(".//span[text()='Diagnosis']")).click();
                System.out.println("Set Diagnosis");
                driver.findElement(By.xpath(".//div[text()='E11.9']")).click();
                driver.findElement(By.xpath(".//div[text()='E78.00']")).click();
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(5);

                // review of systems
                System.out.println("Review of Systems");
                driver.findElement(By.name("data[review_of_system_confirm]")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(5);

                // assessment & plan
                System.out.println("Set Assessment & Plan");
                driver.findElement(By.xpath("//*[@name='data[assessment_plan_plan]']"))
                        .sendKeys("There is all plan that the provider is setting for you.");
                Common.waitSec(2);
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);
            }
        }

        if (type.equals("Immunodeficiency")) {
            if (lab.equals("Immunodeficiency - Biogroup")) {
                // patient infor
                System.out.println("Check Patient Information");
                driver.findElement(By.xpath(".//input[@value='Yes']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // patient's Medical History
                System.out.println("Check Medical History");
                driver.findElement(By.xpath(".//span[text()=\"Patient's Personal History\"]")).click();
                Common.waitSec(2);
                driver.findElement(By.xpath(".//*[@name='data[patient_personal_history_progress_note_phmx]']"))
                        .sendKeys("test");
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // Family History
                driver.findElement(By.xpath(".//span[text()='Family History']")).click();
                System.out.println("Check Family History");
                driver.findElement(By.name("data[family_history_member_1_immunideficiency_condition]"))
                        .sendKeys("test");
                driver.findElement(By.xpath("//*[@name='data[family_history_member_confirm_doctor]']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // Diagnosis
                System.out.println("Set Diagnosis");
                driver.findElement(By.xpath(".//div[text()='A182']")).click();
                driver.findElement(By.xpath(".//div[text()='D609']")).click();
                driver.findElement(By.xpath(".//div[text()='Z83.2']")).click();
                Common.waitSec(1);
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(5);

                // review of systems
                System.out.println("Review of Systems");
                driver.findElement(By.xpath("//*[@name='data[review_of_system_confirm]']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(5);
                // assessment & plan
                System.out.println("Set Assessment & Plan");
                driver.findElement(By.xpath("//*[@name='data[assessment_plan_plan]']"))
                        .sendKeys("There is all plan that the provider is setting for you.");
                Common.waitSec(2);
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);
            }
        }

        if (type.equals("NEUROCOGNITIVE")) {
            if (lab.equals("Neurocognitive-Diax")) {
                // patient infor
                System.out.println("Check Patient Information");
                driver.findElement(By.xpath(".//input[@value='Yes']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // Medical History
                System.out.println("Check Medical History");
                driver.findElement(By.xpath(".//span[text()='Medical History']")).click();
                Common.waitSec(2);
                driver.findElement(By.xpath(".//*[@name='data[patient_personal_history_progress_note_phmx]']"))
                        .sendKeys("test");
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // Family History
                driver.findElement(By.xpath(".//span[text()='Family History']")).click();
                System.out.println("Check Family History");
                Common.waitSec(2);
                driver.findElement(By.name("data[family_history_member_1_related_health_issue]")).sendKeys("test");
                driver.findElement(By.name("data[family_history_member_confirm_doctor]")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);

                // Diagnosis
                System.out.println("Set Diagnosis");
                driver.findElement(By.xpath(".//input[@class='input-search']")).sendKeys("test");
                Common.waitSec(2);
                driver.findElement(By
                                .xpath("//*[@id=\"patient-dashboard\"]/div[5]/div[3]/div[4]/div[3]/div/div[2]/div[3]/ul/li[1]"))
                        .click();
                Common.waitSec(1);
                driver.findElement(By.xpath("//span[text()='Done']")).click();
                Common.waitSec(1);
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(3);

                // medication
                System.out.println("Check Medications");
                driver.findElement(
                                By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input"))
                        .click();
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(5);

                // review of systems
                System.out.println("Review of Systems");
                driver.findElement(By.xpath("//*[@name='data[review_of_system_confirm]']")).click();
                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(5);

                // assessment & plan
                System.out.println("Set Assessment & Plan");
                driver.findElement(By.xpath("//*[@name='data[assessment_plan_plan]']"))
                        .sendKeys("There is all plan that the provider is setting for you.");
                Common.waitSec(2);

                driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
                Common.waitSec(3);
            }
        }

        //deneid
        driver.findElement(By.xpath(".//div[text()='Deny']")).click();
        Common.waitSec(2);
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath(".//div[text()='Please select reason to reject case']")).click();
        Common.waitSec(1);
        actions.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(2);
        driver.findElement(By.xpath(".//input[@placeholder='Search']")).sendKeys("a");
        Common.waitSec(3);
        driver.findElement(By.xpath("/html/body/div[14]/div/div/div/div[1]/div[3]/div[3]/div/div[2]/div[2]/ul/li[1]")).click();
        Common.waitSec(1);
        driver.findElement(By.xpath(".//button[text()='Done']")).click();
        Common.waitSec(3);
        driver.findElement(By.xpath(".//button[text()='Done']")).click();
        Common.waitSec(3);
        actions.sendKeys(Keys.ENTER).build().perform();

    }


}