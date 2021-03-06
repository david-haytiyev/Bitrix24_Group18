package com.bitrix24.tests;


import com.bitrix24.pages.LoginPage;
import com.bitrix24.pages.PollPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class PollTest extends TestBase {

    @Test(priority = 0, description = "Verify that user can upload file from personal desktop")
    public void test1(){
        LoginPage loginPage = new LoginPage();
        PollPage poll = new PollPage();
        test= report.createTest("user can upload file from desktop");
        loginPage.login("marketing1@cybertekschool.com/" ,"UserUser");
        poll.navigateTo("Poll");
        // String filePath ="\"C:\\Users\\QCSS\\Desktop\\invitation.docx\"";
        String workingDirectory = System.getProperty("user.home");
        String filePath = "";
        String expectedFileName = "invitation";
        filePath = workingDirectory + File.separator+"Desktop"+File.separator+expectedFileName;
        WebElement uploadedFile = poll.getUploadedFile();
        String str1 =poll.uploadFileFromDesktop(filePath, expectedFileName,uploadedFile).getText();
        Assert.assertTrue(str1.contains(expectedFileName));
        test.pass("verified that user can upload file from desktop");
    }
    @Test(priority =1, description = "Verify that user can upload file from personal desktop")
    public void test2() {
        LoginPage loginPage = new LoginPage();
        PollPage poll = new PollPage();
        test = report.createTest("user can upload image from desktop");
        loginPage.login("marketing1@cybertekschool.com","UserUser");
        poll.navigateTo("Poll");
        String workingDirectory = System.getProperty("user.home");
        String filePath = "";
        String expectedFileName = "kitten";
        //String filePath ="\"C:\\Users\\QCSS\\Desktop\\kitten.jpg\""; //wrote the path dynamically below instead of using hard code.
        filePath = workingDirectory + File.separator + "Desktop" + File.separator + expectedFileName;
        WebElement uploadedImage = poll.getUploadedImage();
        Assert.assertTrue(poll.uploadImageFromDesktop(filePath, expectedFileName, uploadedImage));
        test.pass("verified that user can upload image from desktop");


    }


}
