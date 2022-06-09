package webUtilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;

public class webActions {

    /* Function to click on page elements*/
    public static void clickObject(WebElement element, WebDriver driver) {
        try
        {
            if (element.isDisplayed())
            {
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(5))
                        .pollingEvery(Duration.ofMillis(1000))
                        .ignoring(WebDriverException.class);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
            }
        } catch (Exception e){
            System.out.println(element + "Not found");
        }
    }

    /* Scroll down the page Function*/
    public void scrollPage(WebDriver driver, String y)
    {
        String script = "window.scrollBy(0,"+y+ ")"; /* This is to allow for manipulation outside of this class*/
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, "");
    }

    /* Function to Switch between tabs on the same window*/
    public void switchTabs(WebDriver driver) throws AWTException {
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(1));

        Robot rb  = new Robot();
        for (int i = 0; i < 2; i++)
        {
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_TAB);
            rb.keyRelease(KeyEvent.VK_TAB);
            rb.keyRelease(KeyEvent.VK_CONTROL);
        }
    }
}
