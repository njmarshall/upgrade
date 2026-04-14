# Upgrade Loan App — Test Automation Framework

A dual-layer Java test automation framework covering both **REST API** and **Selenium UI** testing for the Upgrade/Credify personal loan application. Originally developed as a take-home engineering assignment (~2020), this project demonstrates a production-minded approach to test architecture within a constrained timeline.

![CI](https://github.com/njmarshall/upgrade/actions/workflows/ci.yml/badge.svg)

---

## What This Project Demonstrates

| Capability | Implementation |
|---|---|
| Layered framework design | `framework/` (reusable) vs `loanapp/` (app-specific) |
| API testing | RestAssured + JUnit 5, request abstraction via `RequestBase` |
| UI testing | Selenium 4, Page Object Model (7 page classes) |
| Test data management | `TestDataRetriever` with random + static data strategies |
| Response deserialization | Jackson POJOs with `equals()`/`hashCode()` for clean assertions |
| Config externalization | `ConfigManager` loads from properties files + env/system properties |
| Secrets management | No credentials in source; GitHub Actions uses repository secrets |
| CI/CD | GitHub Actions workflow runs API tests on every push/PR |

---

## Project Structure

```
├── .github/workflows/ci.yml         # GitHub Actions CI pipeline
├── pom.xml
└── src/test/
    ├── data/
    │   └── LoanAppResumptionInfoRequest.json   # Expected API response fixture
    ├── resources/
    │   ├── config.properties                   # Default config (committed)
    │   └── config.local.properties             # Local overrides (git-ignored)
    └── java/upgrade/test/
        ├── framework/                          # Reusable framework layer
        │   ├── api/        BaseApiTest, RequestBase, HttpUtils
        │   ├── core/       ConfigManager, Enums (HttpStatusCode)
        │   ├── models/     LoanAppInfo, Borrower, LoanOffer, ...
        │   ├── testdata/   TestDataRetriever, random word lists
        │   ├── ui/         BaseUITest, BasePage, SeleniumUtils
        │   └── utils/      AssertUtils, SystemUtils
        └── loanapp/                            # App-specific tests
            ├── api/        LoadAppApiTest, LoadAppRequest
            └── ui/         LoadAppLoginUITest, pages/ (7 page objects)
```

---

## Setup

### Prerequisites
- Java 17+
- Maven 3.6+
- Chrome browser (WebDriverManager handles the driver automatically)

### Configuration

Copy the template and fill in real values:
```bash
cp src/test/resources/config.properties src/test/resources/config.local.properties
# Edit config.local.properties with real UUIDs and URLs
```

`config.local.properties` is git-ignored and never committed.

---

## Running Tests

```bash
# Compile only
mvn clean compile test-compile

# Run all tests
mvn test

# Run API tests only
mvn -Dtest=LoadAppApiTest test

# Run UI tests only
mvn -Dtest=LoadAppLoginUITest test

# Run headless (e.g. for CI)
mvn -Dbrowser.headless=true test
```

---

## Test Cases

### API Tests (`LoadAppApiTest`)
| Test | Description |
|---|---|
| `loadAppInfoWithExistingIdTest` | POST with valid UUID → 200 + full payload assertion |
| `loadAppInfoWithBadIdTest` | POST with non-existent UUID → 404 |

### UI Tests (`LoadAppLoginUITest`)
| Test | Description |
|---|---|
| `fillOutPersonalLoanTest` | Full E2E: fill form → capture offer → sign out → sign in → assert offer persists |
| `formSubmitsWithValidDataTest` | Verifies form submission reaches the offer page with a valid monthly payment |

---

## Design Decisions

**Config over hardcoding** — All URLs, test IDs, and environment flags live in `config.properties` / `config.local.properties`. System properties override at runtime (`-Dbrowser.headless=true`), making the suite portable across environments.

**Two-strategy test data** — Random borrowers (`TestDataRetriever.getRandomBorrower()`) avoid collisions for UI flows; static fixtures (`LoanAppResumptionInfoRequest.json`) provide stable expected values for API contract assertions.

**Granular assertion fallback** — `AssertUtils` first does a fast top-level `equals()` check. If that fails, it runs field-by-field assertions with descriptive messages so failures pinpoint the exact diverging field.

**Page Object Model** — Each screen in the loan funnel has its own page class. Test logic in `LoadAppLoginUITest` is written in terms of workflow steps (`checkBorrowRate()`, `fillOutBorrowerInfo()`) not raw Selenium calls.

---

*Built by NJ Marshall — [github.com/njmarshall](https://github.com/njmarshall)*
