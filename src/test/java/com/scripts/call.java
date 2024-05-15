package com.scripts;
import com.Common;
import com.frame.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class call extends DriverFactory {

    login login1;
    login login2;

    pss pss;

    log_out logout;

    provider provider;

    @Override
    public void setUpforTest(){

        login1 = PageFactory.initElements(driver1, login.class);
        login2 = PageFactory.initElements(driver2, login.class);

        pss = PageFactory.initElements(driver1, pss.class);
        logout = PageFactory.initElements(driver1, log_out.class);

        provider = PageFactory.initElements(driver2,provider.class);
    }


    public void make_call() {
        login1.URL_TMS();
        login1.pss("111111");

        login2.URL_TMS();
        login2.provider("123456");
    }

    @Test
    public void login_logout() {
        login1.URL_TMS();
        login1.intake("123456");
        Common.waitSec(5);
        login1.pss("111111");
        Common.waitSec(5);
        logout.pss();
        System.out.println("check");
        login1.provider("123456");
        Common.waitSec(5);
        logout.provider();
        System.out.println("done");
    }
}
