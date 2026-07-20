# Selenium TestNG Automation Framework

A beginner-to-intermediate Selenium WebDriver automation framework built with Java and TestNG, demonstrating core automation patterns including property-file-driven configuration, locator externalisation, and explicit wait strategies.

## Tech Stack

| Tool | Version | Purpose |
|------|---------|---------|
| Selenium WebDriver | 4.45.0 | Browser automation |
| Java | 11+ | Programming language |
| TestNG | 7.12.0 | Test execution and reporting |
| WebDriverManager | auto | Automatic driver management |
| Maven | 3.x | Build and dependency management |

## Project Structure

```
TestAutomationFramework/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── base/
│   │   │   │   └── BaseTest.java          # WebDriver setup/teardown, config loading
│   │   │   └── utilities/
│   │   │       └── ReadPropertyFile.java  # Property file utility
│   │   └── resources/
│   │       └── configfiles/
│   │           ├── config.properties      # Browser, URL, credentials (env-specific)
│   │           └── locators.properties    # All element locators externalised
│   └── test/
│       ├── java/
│       │   └── testcases/
│       │       └── MyFirstTestCase.java   # Login test scenario
│       └── resources/
│           └── TestRunner/
│               └── testng.xml            # TestNG suite configuration
└── pom.xml
```

## Key Design Patterns

- **Property-file-driven configuration** — browser, URL, and locators are all externalised from test code
- **BaseTest inheritance** — all test classes extend BaseTest for driver lifecycle management
- **WebDriverManager** — no manual ChromeDriver/GeckoDriver version management
- **Explicit waits** — `WebDriverWait` with `ExpectedConditions` throughout (no `Thread.sleep` in production code)

## Setup & Run

### Prerequisites
- Java 11 or higher
- Maven 3.x
- Chrome or Firefox browser

### Configuration
Update `src/main/resources/configfiles/config.properties`:
```properties
browser=Chrome
testurl=https://www.zoho.com/
useremail=your_email@example.com
userpassword=your_password_here
```

### Run Tests
```bash
# Run all tests
mvn clean test

# Run with specific TestNG suite
mvn clean test -DsuiteXmlFile=src/test/resources/TestRunner/testng.xml
```

## Current Test Coverage

| Test | Application | Scenario |
|------|-------------|---------|
| `MyFirstTestCase` | zoho.com | Login flow — navigate, enter credentials, submit |

## Roadmap

- [ ] Add Page Object Model layer
- [ ] Expand test scenarios (product search, form validation)
- [ ] Add Allure reporting
- [ ] Integrate with GitHub Actions CI/CD
- [ ] Add data-driven testing with Excel/JSON

## Author

**Anshuman Bhattacharjee**  
QA Lead | 13 Years | Selenium · Java · API Testing · CI/CD  
📧 anshuman15k@gmail.com  
🔗 [LinkedIn](https://www.linkedin.com/in/anshuman-bhattacharjee-439a3919/)
