package com.scripts;

import com.frame.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class migrate_data extends DriverFactory {
    com.frame.login login;
    GetDriver link;
    create_new_case_intake new_case_intake;
    new_to_assign to_assign;
    assign_to_approved to_approved;
    approved_to_complete to_complete;
    search_case search;
    log_out logout;
    assign_provider ass;
    ExcelHelpers excel;
    getInfo getinfo;
    approve_to_assign_follow_up to_AFU;
    billing billing;
    FPC_Approved fpc;

    render_name_medicare_ID render;

    create_PSS create_PSS;

    sendback sendback;

    intake intake;

    provider doctor;

    pss pss;


    @Override
    public void setUpforTest() {
        link = new GetDriver(driver);
        login = PageFactory.initElements(driver, login.class);
        new_case_intake = PageFactory.initElements(driver, create_new_case_intake.class);
        to_assign = PageFactory.initElements(driver, new_to_assign.class);
        to_approved = PageFactory.initElements(driver, assign_to_approved.class);
        to_complete = PageFactory.initElements(driver, approved_to_complete.class);
        search = PageFactory.initElements(driver, search_case.class);
        ass = PageFactory.initElements(driver, assign_provider.class);
        logout = PageFactory.initElements(driver, log_out.class);
        excel = new ExcelHelpers();
        getinfo = PageFactory.initElements(driver, getInfo.class);
        to_AFU = PageFactory.initElements(driver, approve_to_assign_follow_up.class);
        billing = PageFactory.initElements(driver, billing.class);
        fpc = PageFactory.initElements(driver, FPC_Approved.class);
        render = PageFactory.initElements(driver, render_name_medicare_ID.class);
        create_PSS = PageFactory.initElements(driver, create_PSS.class);
        sendback = PageFactory.initElements(driver, sendback.class);
        intake = PageFactory.initElements(driver, intake.class);
        doctor = PageFactory.initElements(driver, provider.class);
        pss = PageFactory.initElements(driver, pss.class);
    }
    @Test
    public void check_migrate_data() {
        login.URL_TMS();
        login.provider("123456");
    }
}
