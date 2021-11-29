# Project Assignment

The assignment is a test automation in both front and back ends written in Java. Here is the directory structure:

```
├── pom.xml // 
└── src
    ├── main
    │   ├── java
    │   └── resources
    └── test
        ├── data
        │   ├── LoanAppResumptionInfoRequest.json // Expected data json against actual response
        └── java
            └── upgrade
                └── test
                    ├── framework // test automation framework for both UI and Api tests
                    │   ├── api 
                    │   │   ├── BaseApiTest.java // for API test 
                    │   │   ├── RequestBase.java // for api request
                    │   │   └── utils
                    │   │       └── HttpUtils.java // api utils
                    │   ├── core
                    │   │   ├── Enums.java // Contains a list of http codes
                    │   │   └── TestEnv.java // handy but not used
                    │   ├── models // deseralize data classes
                    │   │   ├── Account.java
                    │   │   ├── Borrower.java
                    │   │   ├── BorrowerResumptionInfo.java
                    │   │   ├── LoanAppInfo.java
                    │   │   ├── LoanAppResumptionInfo.java
                    │   │   ├── LoanInfo.java
                    │   │   └── LoanOffer.java
                    │   ├── testdata // test data management including static / random data
                    │   │   ├── RandomItemsArray.java
                    │   │   ├── TestDataRetriever.java
                    │   │   ├── TestEnvDefaults.java
                    │   │   └── words // Several lists used for random data generation
                    │   │       ├── BirthOfDates.java
                    │   │       ├── FirstNames.java
                    │   │       ├── HomeAddresses.java
                    │   │       └── LastNames.java
                    │   ├── ui 
                    │   │   ├── BasePage.java // for UI web page objects
                    │   │   ├── BaseUITest.java // for UI web tests
                    │   │   └── utils 
                    │   │       └── SeleniumUtils.java // selenium utils
                    │   └── utils // for both UI / API tests
                    │       ├── AssertUtils.java // Assert whole loan data
                    │       └── SystemUtils.java // Generated GUID UUID
                    └── loanapp
                        ├── api // RestAssured & JUnit 5
                        │   ├── LoadAppApiTest.java // 2 test cases
                        │   └── requests // 1 API request
                        │       └── LoadAppRequest.java
                        └── ui // Selenium & JUnit 5
                            ├── LoadAppLoginUITest.java // 1 long complicated test
                            └── pages // 7 Web page objects
                                ├── AccountInfoPage.java
                                ├── BorrowerInfoPage.java
                                ├── CheckYourRatePage.java
                                ├── FunderaOfferPage.java
                                ├── IncomeInfoPage.java
                                ├── OfferInfoPage.java
                                └── PortalLoginPage.java
```
## Build & Run Tests via maven command lines
Run build & compile
```
    mvn clean compile test-compile
```
Run both api & ui tests
```
    mvn test
```
Run api tests
```
    mvn -Dtest=LoadAppApiTest test
```
Run ui test
```
    mvn -Dtest=LoadAppLoginUITest test
```