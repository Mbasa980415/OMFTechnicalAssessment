package webActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class webActions {

    public static void clickObject(WebElement element, WebDriver driver)
    {
        try
        {
            if (element.isDisplayed())
            {
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(15))
                        .pollingEvery(Duration.ofMillis(1000))
                        .ignoring(WebDriverException.class);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
            }
        } catch (Exception e){
            System.out.println(element + "Not found");
        }
    }
}
