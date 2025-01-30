# Test Automation for Android Apps using Appium on Java Maven
Sample Test Automation for Android Apps using Appium on Java Maven with TestNG and Allure Report

## Requirements 

1. Install Java, then setup the JAVA_HOME and MAVEN_HOME into your PATH file (Environment Variabels).
   References :
   - [Setup JAVA_HOME manually](https://medium.com/@zorozeri/setting-up-java-home-5abae0118bfe).
   - [Setup MAVEN_HOME manually](https://medium.com/@zorozeri/install-maven-by-setting-up-maven-home-abb4d158fcc6).
   - [Use SDKMAN!](https://medium.com/@zorozeri/manage-java-version-using-sdkman-including-maven-gradle-scala-kotlin-and-many-more-82532be9437e) to setup everything Java-related automatically.
2. Install any IDE or Code Editor you're comfort with.
   Recommended :
   - IDE : [IntelliJ IDEA](https://www.jetbrains.com/idea/download).
   - Code Editor : [VS Code](https://code.visualstudio.com/).
3. Install [Allure Report](https://allurereport.org/docs/install/). 
4. Download this code repository into your local machine.

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

## Related Documentation for Selenium on Java
- Actions (Interact with Elements)
  https://www.selenium.dev/documentation/webdriver/elements/interactions/
- Page Object Model Patterns
  https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/

## Related Documentation for TestNG on Java
- Assertion
  https://www.javadoc.io/doc/org.testng/testng/latest/org/testng/Assert.html
