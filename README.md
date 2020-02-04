# Continuous Integration of Jira

Automated testing and Continuous Integration of https://jira.codecool.codecanvas.hu/ Jira website and its Glass plugin.

## Goals of this project:

* Automated testing of Jira
* Preparing the project for CI
* Execute automated tests parallelly on Selenium Grid
* Make the project configurable with environment variables (environments, browsers, etc.)
* Integrate the project into Jenkins Pipeline
* Build and test automatically whenever a new commit is made
* Generate a report about the results

## Built With

* Java
* [Maven](https://maven.apache.org/) - Dependency management
* [Selenium WebDriver](https://selenium.dev/documentation/en/webdriver/) - Webdriver for test automation
* [Selenium Grid](https://selenium.dev/documentation/en/grid/) - Run tests in parallel on multiple machines
* [Jenkins Pipeline](https://jenkins.io/) - Automation server and CI / CD tool
* [JUnit 5](https://junit.org/junit5/) - Testing framework for Java
* [Jira](https://www.atlassian.com/software/jira) - Software development tool for agile teams

## My responsibilities in the team

* Manual testing of SUT
* Desining and recording manual test cases
* Setting up project environment for test automation
* Planning Page Object Model
* Creating Utility class for cleaner and more maintainable code base
* Creating BaseTest class with setup and cleanup phases
* Automation of 'Login' test cases
* Automation of 'Create issue' test cases
* Automation of 'Available issue types' test cases 
* Automation of 'Create sub-tasks' test cases
* Automation of 'Browse issue' test cases
* Automation of 'Issue types with Glass' test cases
* Refactoring
* Setting up Maven Surefire
* Configure project to run tests on Selenium Grid
* Setting up Jenkins Pipeline and writing Jenkins script 
* Making the project configurable with environment variables
* Setting Github webhook - for automatic build on new commits
* Preparing presentation
