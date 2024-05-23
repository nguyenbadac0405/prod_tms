package com.frame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class caseDetail {
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

    public void enterText(WebElement fElement, String testText) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOf(fElement)
        ).sendKeys(testText);
    }
    public void clickBtnCheckbox(WebElement btnckElement) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOf(btnckElement)
        ).click();
    }

    public void createCase(String business, String vertical, String MG, String testtype, String lab) throws Exception {
        clickBtnCheckbox(btnPin);

        clickBtnCheckbox(btnCreatecase);

        enterText(fBusiness, business);

        enterText(fVertical, vertical);

        enterText(fMg, MG);

        enterText(fTesttype, testtype);

        enterText(fLab, lab);

    }
}
