# Hepsiburada UI test automation practice

This project contains source code for Melda Karalar's Hepsiburada UI test automation practice

## Prerequisites

Make sure that you have 

- `java 11`
- `mvn`

## Installing 

1. Clone this repository

```shell script
https://github.com/mkaralar/hepsiburada.git
```
### Used Technologies
- Java 11
- Selenium
- TestNG

### Running tests
1- Install dependencies using
   ```shell script
   mvn clean install -DskipTests
   ```

2- Run Tests
- on Google Chrome

   ```shell script
   mvn clean test -Dbrowser=chrome
   ```
- on Mozilla Firefox

   ```shell script
   mvn clean test -Dbrowser=firefox
   ```


