package com.frame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = dashboard.tms.partners
public class test {

    public test(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}