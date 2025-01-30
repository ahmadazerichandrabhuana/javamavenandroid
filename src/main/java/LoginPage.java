import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

public class LoginPage extends CommonAction {
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView")
    List<WebElement> textHeaderLogin;
    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"Username input field\"]")
    List<WebElement> inputUsername;
    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"Password input field\"]")
    List<WebElement> inputPassword;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Login button\"]")
    List<WebElement> buttonLogin;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"generic-error-message\"]/android.widget.TextView")
    List<WebElement> textErrorLogin;

    public LoginPage(AndroidDriver androidDriver) {
        super(androidDriver);
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver, Duration.ofSeconds(5)), this);
    }

    @Step("Input Username")
    public void inputUsernameField(String value){
        inputUsername.get(0).clear();
        inputUsername.get(0).sendKeys(value);
        hideKeyboard();
    }

    @Step("Input Password")
    public void inputPasswordField(String value){
        inputPassword.get(0).clear();
        inputPassword.get(0).sendKeys(value);
        hideKeyboard();
    }

    @Step("Click button Login")
    public void clickButtonLogin(){
        buttonLogin.get(0).click();
    }

    @Step("Verify Login Error Appear")
    public void verifyErrorAppear(String errorText){
        Assert.assertFalse(textErrorLogin.isEmpty());
        Assert.assertEquals(textErrorLogin.get(0).getText(), errorText);
    }
}
