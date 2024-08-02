package com.frame;

import com.Common;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class caseDetail extends Section {
    protected WebDriver driver;

    public caseDetail (WebDriver driver){
        this.driver = driver;
    }

    @FindBy(css = "i[class='fa-regular fa-thumbtack']")
    public WebElement btnPin;
    @FindBy(xpath = "//*[@id=\"patient-dashboard\"]/div[6]/div[2]/div/div[2]/div[1]/div[2]/button")
    public WebElement btnCreatecase;

    @FindBy(id = "react-select-9-input")
    public WebElement fBusiness;

    @FindBy(id = "react-select-10-input")
    public WebElement fVertical;

    @FindBy(id = "react-select-15-input")
    public WebElement fMg;

    @FindBy(id = "react-select-12-input")
    public WebElement fTesttype;

    @FindBy(id = "react-select-13-input")
    public WebElement fLab;

    public void createCase(String business, String vertical, String MG, String testtype, String lab) {
        Actions action = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //        clickBtnCheckbox(btnPin);   //pin case list

        clickBtnCheckbox(btnCreatecase); //click create case button

        System.out.println(vertical.equals("Genetics"));
        System.out.println(vertical);
        //check vertical
        if (vertical.equals("Genetic Testing")){
            enterText(fBusiness, business); //select business
            action.sendKeys(Keys.ENTER).build().perform();
//            action.moveToElement(fBusiness).click().sendKeys(business).sendKeys(Keys.ENTER).build().perform();
            enterText(fVertical, vertical); //select vertical
            action.sendKeys(Keys.ENTER).build().perform();

//            action.moveToElement(fVertical).click().sendKeys(vertical).sendKeys(Keys.ENTER).build().perform();
            enterText(fMg, MG); //select MG
            action.sendKeys(Keys.ENTER).build().perform();
//            action.moveToElement(fMg).click().sendKeys(MG).sendKeys(Keys.ENTER).build().perform();
            enterText(fTesttype, testtype); //select test type
            Common.waitSec(1);
            action.sendKeys(Keys.ENTER).build().perform();
            Common.waitSec(3);
//            action.moveToElement(fTesttype).click().sendKeys(testtype).sendKeys(Keys.ENTER).build().perform();
            enterText(fLab, lab);   //select lab
            action.sendKeys(Keys.ENTER).build().perform();
//            action.moveToElement(fLab).click().sendKeys(lab).sendKeys(Keys.ENTER).build().perform();
        }
        else {
            enterText(fBusiness, business);

            enterText(fVertical, vertical);

            enterText(fMg, MG);
        }
    }
    public String getCaseID()  {
        WebElement id_case = driver.findElement(By.xpath(".//span[@class='rf-code']"));
        String id = id_case.getText();
        return id;
    }

    public void searchbyCaseID(String id) {
        driver.findElement(By.xpath(".//input[@placeholder='I want to search for…']")).sendKeys(id, Keys.ENTER);
        Common.waitSec(3);
        driver.findElement(By.className("gk-cs-top")).click();
    }
}
