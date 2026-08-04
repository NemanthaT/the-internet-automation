# The Internet — Selenium + TestNG + POM Automation

QA Automation take-home assignment. Target application: https://the-internet.herokuapp.com

## Prerequisites
- Java 17+
- Maven 3.8+
- Google Chrome installed (WebDriverManager downloads the matching driver automatically — no manual chromedriver setup needed)

## Project structure
```
src/main/java/
├── base/BaseTest.java        → WebDriver setup/teardown, screenshot-on-failure
├── pages/                    → Page Object classes (one per site feature)
│   ├── BasePage.java         → shared explicit-wait helpers
│   ├── LoginPage.java
│   ├── CheckboxesPage.java
│   ├── DropdownPage.java
│   └── DynamicLoadingPage.java
src/test/java/tests/          → TestNG test classes (one per scenario)
src/test/resources/
├── config.properties         → base URL, wait timeout
└── testng.xml                → suite definition
screenshots/                  → auto-captured on test failure
```

## Run the suite
```bash
mvn clean test
```

Runs headless Chrome by default. To watch it run, remove the
`--headless=new` line in `BaseTest.java`.

## Scenarios automated
1. Valid login → redirects to secure area
2. Invalid login → shows error, stays on login page
3. Checkbox toggle → state flips from unchecked to checked
4. Dropdown selection → selected option updates correctly
5. Dynamic loading → waits out spinner, reveals text

See the project report for requirement analysis, all 15+ manual test
scenarios, automation-decision justification, and the debugging challenge
writeup.
