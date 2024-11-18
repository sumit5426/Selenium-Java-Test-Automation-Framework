
# Selenium-Java-Test-Automation-Framework

This is a **Selenium Test Automation Framework** built using **Java 17**. The framework is a **hybrid framework** that combines **data-driven** and **modular testing approaches**. It leverages advanced design patterns and libraries to ensure high scalability, flexibility, and maintainability. 

The framework is integrated with cloud-based testing, parallel execution, and CI/CD pipelines.

## Features

1. **Framework Type**: Hybrid Framework (Data-Driven, TestNG and Modular).
2. **Design Patterns**:
   - Page Object Model (POM).
   - Singleton Design Pattern.
   - POJO for handling test data (JSON, Excel, CSV).
3. **Data Handling**:
   - Test data is sourced from **Excel**, **CSV**, **Properties** and **JSON** files.
   - Uses the **Faker library** for generating fake data dynamically.
4. **Execution**:
   - Supports **headless mode** for faster execution.
   - Enables **parallel execution** for efficiency.
   - Configurable via **Maven Surefire Plugin** with runtime parameters:
     - `isHeadless` - Run tests in headless mode.
     - `isLambdaTest` - Run tests on LambdaTest cloud.
     - `environment` - Specify environment (e.g., QA, staging, production).
     - `browserName` - Specify browser for execution.
5. **Cloud Integration**:
   - Integrated with **LambdaTest** for cloud-based execution.
6. **Reporting**:
   - Generates details test reports using **Extent Reports**.
   - Logs test execution using **Log4j**.
7. **Continuous Integration/Continuous Deployment (CI/CD)**:
   - Fully integrated with **GitHub Actions** for CI/CD workflows.

## Technologies Used
- Java 17
- TestNG
- OpenCSV
- Gson
- Apache POI
- Faker
- LambdaTest
- Log4j
- Extent Reports




## Authors

- [@sumit5426](https://www.github.com/sumit5426)
Email Address: sumitbarik5426@gmail.com


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/sumit5426)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](www.linkedin.com/in/sumit-qaengineer)


## 🚀 About Me
Hi, My Name is sumit sekhar barik and I have 2 years of experience in Manual and Automation Testing using technologies like Selenium Webdriver, RestAssured, postman, JMeter.

My major expertise is in Java Programming Language.

## Prerequisites
Before running this framework, ensure the following software is installed on your system:


- **Java 17** - Make sure Java is installed and the JAVA_HOME environment variable is set.
- **Maven** - Ensure Maven is installed and added to the system path.

- Fullscreen mode
- Cross platform


## Setup Instructions

Clone the Repository:

```bash
  https://github.com/sumit5426/Selenium-Java-Test-Automation-Framework.git
  cd Selenium-Java-Test-Automation-Framework
```

Running Tests on LambdaTest:

```bash
  mvn test  -Dbrowser=chrome -D -DisLambdaTest=true -DenvironmentName=QA -DisHeadless=false -X
  cd Selenium-Java-Test-Automation-Framework
```

Running Tests on Chrome browser on Local Machine in Headless Mode:

```bash
  mvn test  -Dbrowser=chrome -D -DisLambdaTest=true -DenvironmentName=QA -DisHeadless=false -X
  cd Selenium-Java-Test-Automation-Framework
```
## Reports & Logs
-Reports: After execution, a detailed HTML report will be generated at ./report.html.

The report contains information on test cases executed, passed, failed, and skipped, along with screenshots for failed tests.

## Logs:
Logs are created during the test execution and stored in the ./logs/ directory.

## Integrated the project Github Actions
This automation framework is integrated with github actions. The tests will be executed at 11:30PM IST every single day.

The reports will be archieved in gh-pages branch You can view the html reports at : https://sumit5426.github.io/Selenium-Java-Test-Automation-Framework/   
