# Mobile UI-tests based on java appium_lib 

### **Tech Stack**:
- Java (Programming language)
- Gradle Groovy (Dependencies manager and Build System)
- [TestNG](https://testng.org) (Testing Framework)
- [Appium Lib](https://github.com/appium/java-client) (Testing Framework)
- [Allure Report](https://allurereport.org/docs/testng/) (Test report)

### **System Requirements**:
- 16 GB RAM
- 40+ GB SSD
- 8+ core CPU
- macOS 14.5
- JDK Temurin 21+
- Gradle 8.5+
- Xcode 15+
- Android Studio 2024+ (optional)
- Android SDK and AVD
- NodeJS 22+
- Appium Server 2.11+
- Appium xcuitest driver 7.22.1+
- Appium uiautomator2 driver 2.45.1+
- Appium espresso driver 2.44.0+ (optional)
- Appium Doctor (optional)
- Appium Inspector 2024.6.1 (optional)
- Homebrew (optional)
- SDKMAN (optional)

### How to use (only Android, iOS in a TBD):

1.  Download source code and unzip android app from src/test/resources/app

2.  Install all dependencies and apps:
> brew install node
> 
> npm -g install appium
> 
> appium driver install xcuitest
> 
> appium driver install uiautomator2

3.  Add JAVA_HOME, ANDROID_HOME and etc to your shell (e.g. zshrc):
> export ANDROID_HOME="YOUR_PATH_TO_ANDROID_SDK/Android/sdk"
> 
> export JAVA_HOME="YOUR_PATH_TO_JDK/bin"
> 
> export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/tools/bin:$ANDROID_HOME/build-tools:$ANDROID_HOME/platform-tools:$ANDROID_HOME/cmdline-tools

4.  Create new Android Emulator (e.g. Pixel 8 API 33) with 4GB+ RAM and launch it

5.  Run all tests:
>  ./gradlew test

6.  Convert test results to allure report:
> allure generate allure-results -o allure-report --clean

7.  Open test report:
> allure open allure-report

### What can be improved
- Add CI scripts (e.g. Github Actions)
- Add integration with Allure TestOPS
- Add linter (e.g. SonarQube)
- Notification to messenger (e.g. Telegram) via Allure notifications
- Replace TestNG to JUnit 5, because Junit supported tags and more popular than TestNG
- Make launch iOS tests more stable
- Download actual last version of android app via curl/wget
- Improve ReadMe for Windows and Linux OS
- Add more annotations for Allure Reports
- Expand test coverage 
- Remove slf4j or log4j (use only one logger lib)
- Improve waits (remove static waits) in tests for more stability of test execution

### Prepare iOS app before run tests
Так как у нас нет исходников iOS приложения, то мы не сможем тестировать App Store версию приложения на iOS Simulator 
из-за другой архитектуры процессоров. Поэтому запуск приложения на реальном устройстве нетривиален и нестабилен, 
особенно то что касается очистки между прогонами тестов. Чтобы запустить тесты, нам нужно выполнить следующие действия:

- Подключить iPhone / iPad / iPod Touch к macOS с запущенным Xcode
- Дождаться когда Xcode переведет устройство в режим разработчика (на новых устройствах потребуется перезагрузка)
- Скачать актуальный билд приложения из App Store, чтобы он был подписан вашим Apple ID, билд сохранить в src/test/resources/app
- Собрать и установить на устройство WebDriverAgentRunner и IntegrationApp, которые подписаны вашим сертификатом
- На мобильном устройстве на экране VPN & Device Management из Settings.app разрешить запуск WebDriverAgentRunner и IntegrationApp
- В [desired capabilities](https://appium.io/docs/en/latest/guides/caps/) прописать корректные значения udid, updatedWDABundleId и usePreinstalledWDA
- На мобильном устройстве разрешить пермишен для UI Automation

### Useful Links and Tools
- IDE [Jetbrains Aqua](https://www.jetbrains.com/aqua/)
- iOS [Real Device Configuration](https://appium.github.io/appium-xcuitest-driver/latest/preparation/real-device-config/) for TA
- Linter [SonarQube](https://www.sonarsource.com/products/sonarqube/)
- To download the iOS application you will need [Apple Configurator](https://support.apple.com/apple-configurator) or another apps
- [Enabling Developer Mode on iOS](https://developer.apple.com/documentation/xcode/enabling-developer-mode-on-a-device)
- [Types of wait in Appium](https://medium.com/@0101.priyanshi/types-of-wait-in-appium-0350730c91cc)

