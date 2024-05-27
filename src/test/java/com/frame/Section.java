package com.frame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Section {
    protected WebDriver driver;

    public Section(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(className = "rf-text")
    public WebElement sectionTitle;

    public String getTitle() {
        String title = sectionTitle.getText();
        return title;
    }

    public boolean verifyTitleSection() {
        String expectedTitle = "Test Requirements";
        return getTitle().equals(expectedTitle);
    }

}
