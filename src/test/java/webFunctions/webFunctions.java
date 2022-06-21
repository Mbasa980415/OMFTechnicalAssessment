package webFunctions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import extentReports.extentReport;
import org.openqa.selenium.WebDriver;
import pagePath.pageXpaths;
import webUtilities.webActions;

import java.awt.*;
import java.io.IOException;

/* Functions to perform the necessary steps in order to complete the scenario*/
public class webFunctions extends webActions
{
    extentReport repo = new extentReport();
    pageXpaths paths;

    public void verifyHomePage(WebDriver driver, ExtentTest node) throws IOException
    {
        String screenShot = repo.CaptureScreenShot(driver);

        if(driver.getTitle().contains("Bank and Borrow Solutions | Old Mutual"))
        {
            node.pass("Home Page", MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());

        }
        else
        {
            node.fail("Error! Home Page not verified",  MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());
        }

    }

    public void openLoanPages(WebDriver driver, ExtentTest node) throws IOException, InterruptedException {
        paths = new pageXpaths(driver);
        scrollPage(driver,"650");
        Thread.sleep(2000);
        clickObject(paths.personaLoansBtn, driver);
        String screenShot = repo.CaptureScreenShot(driver);

        if(driver.getCurrentUrl().contains("personal-loans"))
        {
            node.pass("Personal loan Page", MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());

        }
        else
        {
            node.fail("Error! loan Page not verified",  MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());
        }

    }

    public void clickCalculate(WebDriver driver, ExtentTest node) throws InterruptedException, IOException, AWTException {
        paths = new pageXpaths(driver);
        Thread.sleep(2000);
        clickObject(paths.calculatePageBtn, driver);
        switchTabs(driver);
        String screenShot = repo.CaptureScreenShot(driver);

        if(driver.getTitle().contains("Personal Loan Calculator"))
        {
            node.pass("Personal loan calculator Page", MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());

        }
        else
        {
            node.fail("Error! Personal loan calculator",  MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());
        }

    }

    public void calculateEstimatePayment(WebDriver driver) throws InterruptedException {
        paths = new pageXpaths(driver);
        scrollPage(driver, "650");
        Thread.sleep(5000);

        /* Selecting Amount*/
        clickObject(paths.openAmountList, driver);
        clickObject(paths.clickAmountNeedBtn, driver);
        clickObject(paths.NextBtn,driver);
        Thread.sleep(2000);

        /*Selecting Months*/
        clickObject(paths.openAmountList, driver);
        clickObject(paths.durationNeedBtn, driver);
        Thread.sleep(2000);
        clickObject(paths.calculateEstimateBtn, driver);

    }

    public void verifyEstimatePayment(WebDriver driver, ExtentTest node) throws IOException, InterruptedException {
        paths = new pageXpaths(driver);
        scrollPage(driver, "450");
        Thread.sleep(2000);
        String screenShot = repo.CaptureScreenShot(driver);

        if(paths.estimatedAmountBtn.isDisplayed())
        {
            node.pass("Estimate Amount correct", MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());

        }
        else
        {
            node.fail("Error!! Estimate Amount not correct",  MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());
        }
    }

}
