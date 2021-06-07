import com.google.gson.JsonObject;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class Tests extends TestBase{

    @Test
    public void verifyLogInFunctionality() {
        LoginPage loginPage = new DiscoverPage().clickOnLogInButton();
        loginPage.typeUsername("mnats.avagyan");
        loginPage.typePassword("253388pap");
        HomePage homePage = loginPage.clickOnLoginButton();
        assertTrue(homePage.isHomePageOpened(), "Home page isn't opened");
    }

    @Test
    public void logInViaLocalStorage() throws IOException {
        new DiscoverPage().clickOnLogInButton();
        JsonObject userData = ApiHelper.createUser();
        setItemInLocalStorage("token", userData.get("auth_token").getAsString());
        setItemInLocalStorage("userInfo", userData.getAsString());
        new DiscoverPage().clickOnLogInButton();
    }
}
