import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.yaml.snakeyaml.Yaml;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.*;

public class TestParent {
    private static final Logger log = LoggerFactory.getLogger(TestParent.class);
    static Yaml yaml;
    static InputStream inputStream;
    static Map<String, Object> yamlData;
    static AndroidDriver androidDriver;
    static AppiumDriverLocalService service;
    static String service_url;
    static DesiredCapabilities androidCapabilities;

    static CommonAction commonAction;
    static LoginPage loginPage;
    static MenuPage menuPage;
    static ProductsPage productsPage;
    // add your own more pages below here

    public void loadYaml() {
        yaml = new Yaml();
        try {
            inputStream = new FileInputStream("config.yaml");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        yamlData = yaml.load(inputStream);
    }

    public void loadAllPages(AndroidDriver androidDriver){
        commonAction = new CommonAction(androidDriver);
        loginPage = new LoginPage(androidDriver);
        menuPage = new MenuPage(androidDriver);
        productsPage = new ProductsPage(androidDriver);
        // when you add new pages, instantiate them as well below here
    }

    @BeforeSuite
    public void startDataPreparation() throws IOException {
        FileUtils.deleteDirectory(new File("allure-results"));
        loadYaml();
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        service_url = service.getUrl().toString();
        androidCapabilities = new DesiredCapabilities();
        androidCapabilities.setCapability("appium:automationName", "uiautomator2");
        androidCapabilities.setCapability("appium:udid", yamlData.get("udid").toString());
        androidCapabilities.setCapability("appium:appPackage", yamlData.get("appPackage").toString());
        androidCapabilities.setCapability("appium:appActivity",yamlData.get("appActivity").toString());
        androidCapabilities.setCapability("appium:autoGrantPermissions","true");
    }

    @BeforeMethod
    protected void startTestCase() {
        try {
            androidDriver = new AndroidDriver(new URL(service_url), androidCapabilities);
            loadAllPages(androidDriver);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void closeTestCase(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            TakesScreenshot scrShot = androidDriver;
            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
            Allure.addAttachment("Screenshot", Files.newInputStream(SrcFile.toPath()));
        }
        androidDriver.quit();
    }

    @AfterSuite
    public void addAllureInformation() {
        service.stop();
        Properties allure = new Properties();
        allure.setProperty("Platform", "Android (" + androidDriver.getCapabilities().getCapability("platformVersion").toString() + ")");
        allure.setProperty("Library", "Appium + TestNG (for Assertion)");
        allure.setProperty("Code by", "Ahmad Azeri Chandra Bhuana");
        try {
            File file = new File("./allure-results/environment.properties");
            FileOutputStream fileOut = new FileOutputStream(file);
            allure.store(fileOut, "Allure Report Environment");
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
