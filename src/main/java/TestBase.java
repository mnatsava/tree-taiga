import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import static setup.DriverSetup.getDriver;

public class TestBase {
    private static final JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }


    @BeforeMethod
    public void login() throws IOException {
        LoginPage loginPage = new LoginPage();

        getDriver().navigate().refresh();
    }

    public void setItemInLocalStorage(String item, String value) {
        javascriptExecutor.executeScript(String.format(
                "window.localStorage.setItem('%s','%s');", item, value));

    }
}
