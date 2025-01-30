import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;
import java.util.List;

public class MenuPage extends CommonAction {
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView")
    List<WebElement> iconHamburger;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView")
    List<WebElement> iconCart;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"menu item catalog\"]/android.widget.TextView")
    List<WebElement> textMenuCatalog;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"menu item log in\"]/android.widget.TextView")
    List<WebElement> textMenuLogin;

    public MenuPage(AndroidDriver androidDriver) {
        super(androidDriver);
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver, Duration.ofSeconds(5)), this);
    }

    @Step("Select Menu \"Catalog\"")
    public void selectMenuCatalog(){
        iconHamburger.get(0).click();
        textMenuCatalog.get(0).click();
    }

    @Step("Select Menu \"Log In\"")
    public void selectMenuLogIn(){
        iconHamburger.get(0).click();
        textMenuLogin.get(0).click();
    }
}
