# Test Automation for Android Apps using Appium on Java Maven
Sample Test Automation for Android Apps using Appium on Java Maven with TestNG and Allure Report

## Requirements 

1. Install Java, then setup the JAVA_HOME and MAVEN_HOME into your PATH file (Environment Variabels).
   References :
   - [Setup JAVA_HOME manually](https://medium.com/@zorozeri/setting-up-java-home-5abae0118bfe).
   - [Setup MAVEN_HOME manually](https://medium.com/@zorozeri/install-maven-by-setting-up-maven-home-abb4d158fcc6).
   - [Use SDKMAN!](https://medium.com/@zorozeri/manage-java-version-using-sdkman-including-maven-gradle-scala-kotlin-and-many-more-82532be9437e) to setup everything Java-related automatically.
2. Install [Android Studio](https://developer.android.com/studio/install), then install `**Android SDK**` using Android Studio, and setup ANDROID_HOME manually into your PATH file (Environment Variables) as well, you can use Step 1 above for reference.
3. Install [NodeJS](https://nodejs.org/en/download/prebuilt-installer). 
4. Install [Appium](https://appium.io/docs/en/2.2/quickstart/install/) and install appium driver `uiautomator2`.
5. Install and run [appium-doctor](https://www.npmjs.com/package/appium-doctor) to make sure all of your appium's dependencies are OK, trouble shoot if any red "x" appears (you need to google it yourself).
6. Install [ADB](https://www.xda-developers.com/install-adb-windows-macos-linux/), or add ADB installed from Android Studio into your PATH file.
7. Download and install this [Demo Apps](https://github.com/saucelabs/my-demo-app-rn/releases)(`.apk` file) into your Android Device (credit to [Wim Selles](https://github.com/wswebcreation)).
8. Install any IDE or Code Editor you're comfort with.
   Recommended :
   - IDE : [IntelliJ IDEA](https://www.jetbrains.com/idea/download), since this code is Java-based.
   - Code Editor : [VS Code](https://code.visualstudio.com/).
9. Install [Allure Report](https://allurereport.org/docs/install/). 
10. Download this code repository into your local machine.


## Device Connection

Connect your device to your computer, check it's udid : 
```
adb devices
```
Put it on file `config.yaml` line #1 : 
```
udid: {your device udid}
sample : 
udid: emulator-5554
```


## Run Tests 
* Run all tests : Open terminal and run this command
   ```
   mvn clean test -DtestSuites=testsuites/test.xml
   ```

* Run specific test : Open file `"/testsuites/test.xml"` and update line 6-8 (comment & un-comment) and run above command again.

## Open Report
*  Generate report file and open it :

   ```
   allure generate --clean && allure open
   ```
*  Open report without generating report file : 

   ```
   allure serve
   ```
*  Troubleshoot Allure not recognized on PowerShell Windows :
   - Use Command Prompt instead of PowerShell, or
   - Run this command on PowerShell : 
     ```
     npm install -g allure-commandline --save-dev
     ```
   
## Short Repository Explanation

This sample Test Automation consists of 2 main folders : 

* src
   ```
   Consists of 2 more folders :
   > main   : contains web elements and actions for each specific web pages (implementation of Page Object Model patterns)
   > test   : contains test cases
   ```
* testsuites
   ```
   Contains xml file for listing which test cases want to be executed
   ```

Apart from these 3 folders, this sample also using several files on the root folder :
   ```
   > pom.xml       : Maven's standard XML File for storing project's dependencies
   > config.yaml   : yaml file for storing any config-related data for this project
   ```

## Related Documentation for Appium
- Appium API Documentation (any Language)
  https://appium.github.io/appium.io/docs/en/about-appium/api/
- Appium for specific Java-Client
  https://github.com/appium/java-client
- Page Factory using Appium on Java-Client
  https://github.com/appium/java-client/blob/master/docs/Page-objects.md
- Appium Action Command (used for Swipe Action)
  https://appium.github.io/appium.io/docs/en/commands/interactions/actions/

## Related Documentation for TestNG on Java
- Assertion
  https://www.javadoc.io/doc/org.testng/testng/latest/org/testng/Assert.html
