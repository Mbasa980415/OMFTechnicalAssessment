package pagePath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/* Xpaths for all the web elements that are being selected/used in the execution of the test*/
public class pageXpaths
{
    protected WebDriver driver;

    public pageXpaths(WebDriver driver)
    {
        this.driver = driver;

        PageFactory.initElements(driver,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 15), this);
    }

    @FindBy(xpath = "(//div[@class='om-product-card-primary-button'])[2]")
    public WebElement personaLoansBtn;

    @FindBy(xpath = "//span[contains(text(),'CALCULATE')]")
    public WebElement calculatePageBtn;

    @FindBy(xpath = "//span[@class='selected-value-container']")
    public WebElement openAmountList;

    @FindBy(xpath = "//*[@id='R50000']")
    public WebElement clickAmountNeedBtn;

    @FindBy(xpath = "//span[@class='om-button-text' and contains(text(),'Next')]")
    public WebElement NextBtn;

    @FindBy(xpath = "//*[@id='60 Months']")
    public WebElement durationNeedBtn;

    @FindBy(xpath = "//span[@class='om-button-text' and contains(text(),'Calculate')]")
    public WebElement calculateEstimateBtn;

    @FindBy(xpath = "//strong[contains(text(), 'R1 656.43 - R1 810.05')]")
    public WebElement estimatedAmountBtn;


}
