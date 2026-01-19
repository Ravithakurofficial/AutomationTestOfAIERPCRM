```markdown
# 🚀 ERP CRM Automation Framework  
### Cucumber + Selenium + Java + Gradle + POM + TestRail + Extent Reports

![Java](https://img.shields.io/badge/Java-17-orange)
![Gradle](https://img.shields.io/badge/Gradle-8.2-blue)
![Selenium](https://img.shields.io/badge/Selenium-4.20-brightgreen)
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-23d96c)
![Chrome](https://img.shields.io/badge/Browser-Chrome-red)
![TestRail](https://img.shields.io/badge/TestRail-Integration-yellow)

---

# 📌 Overview

This repository contains a **production-grade Selenium Automation Framework** built on:

- **Cucumber BDD**
- **Java 17**
- **Gradle (build system)**
- **Selenium WebDriver 4**
- **Page Object Model (POM)**
- **Hooks for setup/teardown**
- **Extent HTML Reporting**
- **TestRail Result Integration**
- **Environment switching (dev/qa/prod)**

It follows an **advanced hybrid architecture**, making it scalable, maintainable, and ready for enterprise use.

---

# 🛠️ Features

✔ POM with reusable actions  
✔ Centralized WebDriver (Singleton)  
✔ Automatic driver setup  
✔ Custom waits (WaitUtils)  
✔ Configurable environment variables  
✔ Cucumber BDD + Tags  
✔ Extent Reports  
✔ Exception screenshots  
✔ TestRail Integration  
✔ Gradle Tasks for execution  
✔ CI/CD ready (GitHub Actions / Jenkins)  

---

# 📁 Project Structure (Gradle)

```

ERP-CRM-Automation/
│── build.gradle
│── settings.gradle
│── gradle.properties
│
│── src/
│   ├── test/java/
│   │   ├── com.ERP.CRM.StepDefinitions/
│   │   ├── com.ERP.CRM.PageObjectModels/
│   │   ├── com.ERP.CRM.Utils/
│   │   ├── com.ERP.CRM.Hooks/
│   │   ├── com.ERP.CRM.Listeners/
│   │   └── com.ERP.CRM.cucumberTestRunner/
│   │
│   ├── test/resources/
│   │   ├── features/
│   │   │    └── Login.feature
│   │   ├── config/
│   │   │    ├── qa.properties
│   │   │    ├── dev.properties
│   │   │    └── prod.properties
│   │   ├── extent-config.xml
│   │   └── cucumber.properties
│
│── test-output/
│     ├── ExtentReport.html
│     └── Screenshots/

````

---

# 🔧 Requirements

| Tool | Version |
|------|---------|
| Java | 17 (recommended) |
| Gradle | 7+ |
| Chrome | Latest |
| WebDriver | Automatically managed |

---

# ⚙️ Setup Instructions

### 1️⃣ Clone Repo
```bash
git clone https://github.com/yourrepo/ERP-CRM-Automation.git
cd ERP-CRM-Automation
````

---

### 2️⃣ Build project using Gradle

This downloads dependencies automatically:

```bash
./gradlew clean build
```

Windows:

```bash
gradlew clean build
```

---

### 3️⃣ Run Tests

#### ➤ Run all scenarios

```bash
./gradlew test
```

#### ➤ Run by tag

```bash
./gradlew test -Dcucumber.filter.tags="@C38"
```

#### ➤ Run with environment

```bash
./gradlew test -Denv=qa
```

Framework will load:

```
src/test/resources/config/qa.properties
```

---

# 🌍 Environment Configuration

Example: **qa.properties**

```
url=http://localhost:8080/
browser=chrome
timeout=10
```

You can switch like:

```
gradlew test -Denv=dev
gradlew test -Denv=prod
```

---

# 🤖 How the Framework Works (Flow)

### 1️⃣ Runner triggers Cucumber

`CucumberTestRunner.java`

### 2️⃣ Hooks run Before/After each scenario

`ApplicationHooks.java`

* Start WebDriver
* Open URL
* Setup reporting
* Cleanup

### 3️⃣ Steps call POM

Example:

```java
login.enterId("email@example.com");
```

### 4️⃣ POM interacts with UI using Selenium

`LoginPom.java`

### 5️⃣ Assertions are validated

`assertEquals(expected, actual);`

### 6️⃣ On Failure

* Screenshot captured
* Added to Extent Report
* TestRail updates automatically

---

# 📊 Reports

After test execution, open:

### 📁 **Extent HTML Report**

```
test-output/ExtentReport.html
```

### 📁 Cucumber HTML

```
build/reports/tests/test/index.html
```

### 📁 Cucumber JSON

```
build/cucumber.json
```

---

# 🔗 TestRail Integration

Tags such as:

```
@C38
```

Automatically update TestRail case **38** with:

* PASS
* FAIL
* Error message
* (Optionally) screenshot

Implemented in:

```
com.ERP.CRM.Listeners.TestRailListener
```

---

# 🔄 Execution Flow Diagram

```
                 +-----------------------------+
                 |     Gradle Test Runner      |
                 +-----------------------------+
                              |
                              v
                     +------------------+
                     | Cucumber Runner  |
                     +------------------+
                              |
                              v
                    +---------------------+
                    | Application Hooks   |
                    |  - Start Driver     |
                    |  - Read config      |
                    |  - Open URL         |
                    +---------------------+
                              |
                              v
            +--------------------------------------+
            |     Step Definitions (BDD → Java)    |
            +--------------------------------------+
                              |
                              v
         +------------------------------------------+
         |                POM Layer                 |
         |  (Locators + Selenium actions + Waits)   |
         +------------------------------------------+
                              |
                              v
                     +------------------+
                     |  Assertions       |
                     +------------------+
                              |
                              v
                   +-------------------------+
                   | Application Hooks (After)
                   | - Screenshot on Fail
                   | - TestRail Update
                   | - Extent flush
                   | - Quit driver
                   +-------------------------+
```

---

# 🧪 Run in CI (GitHub Actions)

Add this file:

`.github/workflows/automation.yml`

```yaml
name: Automation Tests

on: [push, pull_request]

jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - name: Checkout Code
        uses: actions/checkout@v3

      - name: Setup JDK
        uses: actions/setup-java@v3
        with:
          java-version: 17
          distribution: temurin

      - name: Run Tests
        run: ./gradlew test -Denv=qa
```



