# Cucumber BDD Selenium Automation Framework

This is a **Hybrid Test Automation Framework** built using **Java, Selenium WebDriver, Cucumber BDD, and TestNG**.  
It is designed for end-to-end UI testing of web applications using Behavior Driven Development (BDD) approach.
---
## Project Overview

This framework automates the following workflow:

- User Login functionality
- Job search and selection
- Job application submission flow (WIP)

It is built with scalable design patterns like **Page Object Model (POM)** and supports **data-driven testing using Scenario Outline**.

## Tech Stack
- Java 17+
- Selenium WebDriver
- Cucumber BDD
- TestNG
- Maven
- WebDriverManager
- Extent Reports
## Project Structure

src
├── main/java
│    └── com.gdit.pages        # Page Object classes
│
├── test/java
│    ├── stepdefinitions       # Step Definition files
│    ├── hooks                 # Hooks (setup & teardown)
│    ├── runners               # TestNG runner
│    └── base                  # DriverFactory & base config
│
└── test/resources
└── features              # Feature files (BDD scenarios)


## How to Run the Tests

## Option 1: Using TestNG Runner
Run the test via:
src/test/java/runners/TestRunner.java

## Option 2: Using Maven
bash
mvn clean test

## Reporting

The framework generates:

* HTML Reports using Extent Reports
* Cucumber Reports (built-in)

Reports are available under:

/target

## Key Features

* ✔ Page Object Model (POM)
* ✔ BDD approach using Cucumber
* ✔ Data-driven testing (Scenario Outline)
* ✔ Selenium WebDriver automation
* ✔ WebDriverManager integration
* ✔ Screenshot capture on failure
* ✔ TestNG execution support
* ✔ Extent HTML reporting

##  Sample Scenario

gherkin
Feature: Apply for job

Scenario Outline: User submits a job application
  Given user is on login page
  When user logs in with email "<email>" and password "<password>"
  Then user should be on the search page
  When user searches for "<jobTitle>"
  And user selects a job from results
  And user clicks apply
  Then application form should open

Examples:
  | email                  | password  | jobTitle      |
  | test@mail.com         | Test@123  | Test Engineer  |

## Configuration

Update credentials or test data in:

Feature files or config properties (if applicable)

## Prerequisites

* Java 17+
* Maven installed
* Chrome Browser installed
* Internet connection (for WebDriverManager)

## Author

* Developed by: **Md Ali**
* Purpose: for resume  - Real-world Selenium Framework Design

## Notes

* This framework is continuously improved for scalability and interview readiness.
* Designed using real-world automation practices used in enterprise projects.
* Used GDIT Workday modern and dynamic website to automate job search and application process

