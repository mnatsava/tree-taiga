import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static setup.DriverSetup.getDriver;

public class LoginPage extends BasePage{

    @FindBy(name = "username")
    private WebElement loginField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(css = ".btn-small")
    private WebElement loginButton;

    public LoginPage () {
        PageFactory.initElements(getDriver(),this);
    }

    @Override
    public String getUrl() {
        return BASE_URL + "/login";
    }

    public void clickOnLoginField() {
        click(loginButton);
    }

    public void clickOnPasswordButton() {
        click(loginButton);
    }

    public HomePage clickOnLoginButton() {
        click(loginButton);
        return new HomePage();
    }

    public void typeUsername(String username) {
        type(loginField, username);
    }

    public void typePassword(String password) {
        type(passwordField, password);
    }

}
