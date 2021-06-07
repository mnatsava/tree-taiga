import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static setup.DriverSetup.getDriver;

public class DiscoverPage extends BasePage{

    @FindBy(css = ".login")
    private WebElement loginButton;

    public DiscoverPage () {
        open(BASE_URL);
        PageFactory.initElements(getDriver(),this);
        waitForElementVisibility(loginButton); // something like loadable component
    }

    @Override
    public String getUrl() {
        return BASE_URL;
    }

    public LoginPage clickOnLogInButton() {
        click(loginButton);
        return new LoginPage();
    }

}
