import org.testng.annotations.Test;

public class TestLogin extends TestParent{

    @Test(description = "As an Android user, I should be able to see Error when input incorrect Username and Password")
    public void test001() {
        menuPage.selectMenuLogIn();
        loginPage.inputUsernameField("MyName");
        loginPage.inputPasswordField("Unknown");
        loginPage.clickButtonLogin();
        loginPage.verifyErrorAppear("Provided credentials do not match any user in this service.");
    }

    @Test(description = "As an Android user, I should be redirected to \"Products\" Page when input correct Username and Password")
    public void test002() {
        menuPage.selectMenuLogIn();
        loginPage.inputUsernameField("bob@example.com");
        loginPage.inputPasswordField("10203040");
        loginPage.clickButtonLogin();
        productsPage.verifyHeaderProductsAppear();
    }
}
