package com.frame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PCP {
    protected WebDriver driver;

    public PCP(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(name = "data[pcp_no_pcp_certification]")
    public WebElement btnNoPcp;




}
