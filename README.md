## A framework for automation

The traditional and most popular form of testing remains to be unit testing. Unit testing is focused on an individual module / component. We wish to test functionality in isolation, removing all external variables that may have an influence. Any dependencies / external services are "mocked", making it easy to set up, and even faster to run.

However, with complex systems, numerous microservices, and multiple business logic flows, we need a way to test as a whole. One approach can be integration testing, allowing us to incorporate entire use cases and flows together, programmatically.

**Perquisites** <br>
Any spring-boot java application, with `JUnit` and `spring-boot-starter-test` added as a dependency. <br>
Java 17 <br>
#### Framework
Our framework consists of 4 main phases :
- Generation 
- Execution 
- Assertion 
- Deletion 

**Generation**<br>
We focus on the creation of test cases, that we want to execute for a specific test. Our approach should be to systematically create test cases in a manner to cover all valid and invalid cases, for all possible combinations. Generation can be a computationally expensive operation, hence we structure our tests in a manner that those with the same use case trigger generation only once.

**Execution** <br>
Refers to the actual business logic being run. Can include certain computational processes, or calls to third party services, or any updates to database etc. One important thing to note is to keep the business logic as close as possible to our actual production logic. No services should be mocked at all, and data must flow through our applications and services.

**Assertion** <br>
Refers to checking the output of the execution phase. It can involve checking for a specific output, or the state of our system etc. During assertion phase, similar to generation, we want to include all possible test cases (both valid and invalid). We can also write the same test, but check for 6 different input / output states. If our actual output is not the same as our expected output, then our case is a fail.

**Deletion** <br>
In integration testing, we do not mock any third party services / calls to external API's. This may imply creation of test data on our repositories and databases. In order to avoid any hindrance for other developers / users of our systems, it's our responsibility to clean up our generated test data after assertion.

The exact implementation will change depending on the test cases, business logic and the differing use cases. However our goal here is to provide a generic framework that can be applied everywhere with minimal tweaking to code. 


---
### Code
![image](https://github.com/user-attachments/assets/3268d031-0f84-420f-852d-25fe1a6c2179)


run `mvn test` after cloning and loading the project, to see all executed tests.  <br>
The tests are written in location `src/test/java/com/example/IntegrationTestingFramework`, and logic is separated accordingly.
