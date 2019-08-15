# allure-cucumber
Demo Allure Report Framework

- Docs: https://docs.qameta.io/allure/

Run unit test
- `mvn clean test`

Generate Report
- `mvn allure:report`

Serve Report
- `mvn allure:serve`

Run Unit Test and Generate Report
- `mvn clean test allure:report`

Run Unit Test, Integration Test and Generate Report
- `mvn clean verify allure:report`

All results and reports are created in `target/results`

Copy dependencies
- mvn dependency:copy-dependencies
