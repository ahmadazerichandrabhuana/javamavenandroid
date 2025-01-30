import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;
import java.util.Collections;

public class CommonAction {
    static AndroidDriver androidDriver;
    static JavascriptExecutor jsDriver;
    static int screenWidth;
    static int screenHeight;

    public enum SwipeDirection{
        SWIPE_RIGHT,
        SWIPE_LEFT,
        SWIPE_DOWN,
        SWIPE_UP
    }

    public CommonAction(AndroidDriver androidDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver, Duration.ofSeconds(5)), this);
        jsDriver = androidDriver;
        CommonAction.androidDriver = androidDriver;
        screenWidth = androidDriver.manage().window().getSize().getWidth();
        screenHeight = androidDriver.manage().window().getSize().getHeight();
    }

    /**
     * Swipe using <a href="https://appium.github.io/appium.io/docs/en/commands/interactions/actions/">Appium Action Command</a>
     */
    public void swipe(SwipeDirection direction){
        int startX, startY, endX, endY;
        switch (direction) {
            case SWIPE_RIGHT:
                startX = screenWidth / 4;
                startY = screenHeight / 2;
                endX = screenWidth * 3 / 4;
                endY = screenHeight / 2;
                break;
            case SWIPE_LEFT:
                startX = screenWidth * 3 / 4;
                startY = screenHeight / 2;
                endX = screenWidth / 4;
                endY = screenHeight / 2;
                break;
            case SWIPE_DOWN:
                startX = screenWidth / 2;
                startY = screenHeight / 4;
                endX = screenWidth / 2;
                endY = screenHeight * 3 / 4;
                break;
            case SWIPE_UP:
                startX = screenWidth / 2;
                startY = screenHeight * 3 / 4;
                endX = screenWidth / 2;
                endY = screenHeight / 4;
                break;
            default:
                throw new IllegalArgumentException("Invalid swipe direction: " + direction);
        }
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 0);
        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, endY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        androidDriver.perform(Collections.singletonList(scroll));
    }

    @Step("Do Swipe Screen Up")
    public void swipeUp(){
        swipe(SwipeDirection.SWIPE_UP);
    }

    @Step("Do Swipe Screen Down")
    public void swipeDown(){
        swipe(SwipeDirection.SWIPE_DOWN);
    }

    @Step("Do Swipe Screen Left")
    public void swipeLeft(){
        swipe(SwipeDirection.SWIPE_LEFT);
    }

    @Step("Do Swipe Screen Right")
    public void swipeRight(){
        swipe(SwipeDirection.SWIPE_RIGHT);
    }

    @Step("Hide Keyboard")
    public void hideKeyboard(){
        androidDriver.hideKeyboard();
    }
}
