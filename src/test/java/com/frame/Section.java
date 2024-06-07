package com.frame;

import com.Common;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Section {
    protected WebDriver driver;

    @FindBy(className = "rf-text")
    public WebElement sectionTitle;

    @FindBy(className = "card-header")
    public List<WebElement> listSectionName;

    public String getTitle() {
        String title = sectionTitle.getText();
        return title;
    }

    public void keyEnter()
    {
        Actions actions = new Actions(driver);
        Common.waitSec(2);
        actions.sendKeys(Keys.ENTER).build().perform();
    }


    public boolean verifyTitleSection(String nameSection) {
        return getTitle().equals(nameSection);
    }

    public void enterText(WebElement fElement, String testText) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                    ExpectedConditions.visibilityOf(fElement)
            ).sendKeys(testText);
        }
        catch (Exception e) {
            System.out.println("The element" + fElement + " can not found");
        }

    }
    public void clickBtnCheckbox(WebElement btnckElement) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                    ExpectedConditions.visibilityOf(btnckElement)
            ).click();
        }
        catch (Exception e) {
            System.out.println("The element" + btnckElement + " can not found");
        }
    }

    public void intakeSubmit(String vertical) {}

    public void pssSubmit(String vertical) {}

    public void providerSubmit(String vertical) {}

    public void openSection (String nameSection)
    {
        for (int i=0; i < listSectionName.size(); i++)
        {
            String name = (String) listSectionName.get(i).getText();
            if(name.equals(nameSection))
            {
                clickBtnCheckbox(listSectionName.get(i));
            }
        }
    }

}
