import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static setup.DriverSetup.getDriver;

public class HomePage extends BasePage{

    @FindBy(css = ".dashboard-container")
    private WebElement dashboardContainer;

    public HomePage () {
        PageFactory.initElements(getDriver(),this);
        waitForElementVisibility(dashboardContainer);

    }

    @Override
    public String getUrl() {
        return null;
    }

    public boolean isHomePageOpened() {
        return isDisplayed(dashboardContainer);
    }

}
