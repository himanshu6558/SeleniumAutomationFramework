# Selenium Test Automation Framework

## 🎯 Overview

A robust and scalable test automation framework built with Selenium WebDriver and Java, implementing both Page Object
Model and Page Factory patterns.

## 🔧 Tech Stack & Features

- **Core Technologies**
    - Java 8+
    - Selenium WebDriver 4.x
    - TestNG
    - Maven

- **Design Patterns & Architecture**
    - Page Object Model (POM)
    - Page Factory Pattern
    - Thread Local Support for parallel execution
    - Base Page and Test architecture

- **Reporting & Logging**
    - Allure Reports integration
    - Custom test execution reports
    - Screenshot capture for failures

- **Data Management**
    - Excel-driven testing (Data Provider)
    - Properties file configuration
    - Environment-specific test data management

- **CI/CD & Grid Support**
    - Selenoid integration for containerized test execution
    - Docker support
    - Maven profiles for different environments

## 📁 Project Structure

```
src
├── main/java/org/example
│   ├── base/                 # Base classes for Pages and Tests
│   ├── config/              # Configuration management
│   ├── constants/           # Application constants
│   ├── driver/             # WebDriver management
│   ├── pages/              # Page Objects
│   └── utils/              # Utility classes
└── test
    ├── java/               # Test classes
    └── resources/          # Test resources and config files
```

## 🚀 Getting Started

### Prerequisites

- Java JDK 8 or higher
- Maven 3.6 or higher
- Chrome/Firefox browser installed

### Installation

1. Clone the repository

```bash
git clone <repository-url>
```

2. Install dependencies

```bash
mvn clean install
```

### Running Tests

- Run all tests:

```bash
mvn test
```

- Run specific test suite:

```bash
mvn test -Dsurefire.suiteXmlFiles=src/test/resources/testng_suites/smoke.xml
```

## 🔄 Test Execution Options

### Local Execution

Tests can be executed on local machine with browser of choice:

```bash
mvn test -Dbrowser=chrome
```

### Grid Execution (Selenoid)

Tests can be executed on Selenoid Grid:

```bash
mvn test -Dexecution.type=remote -Dbrowser=chrome
```

## 📊 Reporting

- Allure reports are generated after test execution
- Screenshots are captured for failed tests
- Reports can be found in the `reports` directory

To view Allure reports:

```bash
allure serve allure-results
```

## 🔍 Framework Features

### 1. Thread Safety

- ThreadLocal implementation for WebDriver instances
- Parallel test execution support

### 2. Data Management

- Excel data driven testing
- Environment specific properties
- Configuration management

### 3. Utilities

- Custom wait conditions
- Screenshot capture
- Excel operations
- Browser actions

## 🤝 Contributing

Please read CONTRIBUTING.md for details on our code of conduct and the process for submitting pull requests.

## ✍️ Author

- **Himanshu Bhandari**

## 📝 License

This project is licensed under the MIT License - see the LICENSE.md file for details
