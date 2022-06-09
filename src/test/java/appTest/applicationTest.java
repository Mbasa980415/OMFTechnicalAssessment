package appTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webFunctions.webFunctions;
import webUtilities.webUtilities;
import webUtilities.browserReports;

import java.awt.*;
import java.io.IOException;

public class applicationTest
{
    public webUtilities app = new webUtilities();
    public webFunctions web = new webFunctions();
    public browserReports br = new browserReports();
    String sUrl, sBrowser;
    ExtentReports reports;
    ExtentTest node;

    @Parameters({"OMFURL", "Browser"})
    @BeforeTest
    public void beforeMethod(String OMFURL, String Browser)
    {
        sUrl = OMFURL;
        sBrowser = Browser;
        app.setWebDriver(app.initializeWebDriver(Browser));
        br.createBrowserReport(Browser);
        node = br.getNode();
        reports = br.getReports();

    }

    @Test
    public void executeLoanEstimate() throws InterruptedException, IOException, AWTException {

        app.navigate(sUrl);
        web.verifyHomePage(webUtilities.getWebDriver(),node);
        web.openLoanPages(webUtilities.getWebDriver(), node);
        web.clickCalculate(webUtilities.getWebDriver(), node);
        web.calculateEstimatePayment(webUtilities.getWebDriver());
        web.verifyEstimatePayment(webUtilities.getWebDriver(), node);
    }

    @AfterTest
    public void closeUp() throws InterruptedException
    {

        reports.flush();
        Thread.sleep(3000);
        app.getWebDriver().quit();


    }
}
