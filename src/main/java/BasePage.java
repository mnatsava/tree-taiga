import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static setup.DriverSetup.getDriver;

public abstract class BasePage {

    protected WebDriver driver;
    public static final String BASE_URL="https://tree.taiga.io";

    public BasePage() {
        this.driver = getDriver();
    }

    public abstract String getUrl();

    public void open(String url) {
        driver.get(url);
    }

    public WebElement find(By location) {
        return driver.findElement(location);
    }

    public void click(By location) {
        click(find(location));
    }


    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void waitForElementVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


}
