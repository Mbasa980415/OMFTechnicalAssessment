package webUtilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import extentReports.extentReport;

public class browserReports
{
    public extentReport rt = new extentReport();
    ExtentReports reports;
    ExtentTest node;

    /* Function to create a report a specific browser execution*/
    public void createBrowserReport(String sBrowser)
    {

        switch (sBrowser.toUpperCase()) {
            case "CHROME" -> {
                reports = rt.initilizeExtentReporters("reports/OMF_Chrome_Report.html");
                ExtentTest test = reports.createTest("OMF Loan Application Chrome").assignAuthor("Mbasa Gwama");
                node = test.createNode("OMF Loan application test");


            }
            case "FIREFOX" -> {
                reports = rt.initilizeExtentReporters("reports/OMF_Firefox_Report.html");
                ExtentTest test = reports.createTest("OMF Loan Application Firefox").assignAuthor("Mbasa Gwama");
                node = test.createNode("OMF Loan application test");
            }
        }
    }

    public ExtentReports getReports()
    {
        return reports;
    }

    public ExtentTest getNode()
    {
        return node;
    }
}
