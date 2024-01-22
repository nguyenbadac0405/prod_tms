package com.scripts;
import com.frame.*;
import org.openqa.selenium.support.PageFactory;

public class call extends DriverFactory {

    login login1;
    login login2;

    pss pss;

    provider provider;

    @Override
    public void setUpforTest(){

        login1 = PageFactory.initElements(driver1, login.class);
        login2 = PageFactory.initElements(driver2, login.class);

        pss = PageFactory.initElements(driver1, pss.class);

        provider = PageFactory.initElements(driver2,provider.class);
    }


    public void make_call() {
        login1.URL_intake();
        login1.pss("111111");

        login2.URL_intake();
        login2.provider("123456");
    }
}
