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
        link = new GetDriver(driver1);
        login = PageFactory.initElements(driver1, login.class);
        new_case_intake = PageFactory.initElements(driver1, create_new_case_intake.class);
        to_assign = PageFactory.initElements(driver1, new_to_assign.class);
        to_approved = PageFactory.initElements(driver1, assign_to_approved.class);
        to_complete = PageFactory.initElements(driver1, approved_to_complete.class);
        search = PageFactory.initElements(driver1, search_case.class);
        ass = PageFactory.initElements(driver1, assign_provider.class);
        logout = PageFactory.initElements(driver1, log_out.class);
        excel = new ExcelHelpers();
        getinfo = PageFactory.initElements(driver1, getInfo.class);
        to_AFU = PageFactory.initElements(driver1, approve_to_assign_follow_up.class);
        billing = PageFactory.initElements(driver1, billing.class);
        fpc = PageFactory.initElements(driver1, FPC_Approved.class);
        render = PageFactory.initElements(driver1, render_name_medicare_ID.class);
        create_PSS = PageFactory.initElements(driver1, create_PSS.class);
        sendback = PageFactory.initElements(driver1, sendback.class);
        intake = PageFactory.initElements(driver1, intake.class);
        doctor = PageFactory.initElements(driver1, provider.class);
        pss = PageFactory.initElements(driver1, pss.class);
    }
    @Test
    public void check_migrate_data() {
        login.URL_TMS();
        login.provider("123456");
    }
}
