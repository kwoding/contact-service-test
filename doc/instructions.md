## Prerequisites

### Installed on your machine
- Maven 3.3.9+
- JDK version 1.8.0_51+
- Docker Desktop 2.0.0.3+
- IntelliJ (preferred) or other IDE with the JDK configured

## Verification of setup

1. Clone the following project.
```
git clone https://github.com/kwoding/contact-service-test.git
```

2. Verify you can run the test application by executing the following command:

Inside the root folder of the project, run:
```
docker-compose up
```

3. The logs (of Docker) should end as follows:
```
contact-frontend_1  | You can now view contact-frontend in the browser.
contact-frontend_1  | 
contact-frontend_1  |   Local:            http://localhost:3000/
contact-frontend_1  |   On Your Network:  http://172.21.0.3:3000/
contact-frontend_1  | 
```

4. Navigate in your Chrome browser to http://localhost:3000, you should see the following on your screen.

**Note:** If you are running Docker Toolbox (Windows) the default IP is `192.168.99.100` (you can check by running `docker-machine ip default`), so navigate in your browser to http://192.168.99.100:3000 instead.

![Login screen](./img/login-screen.png)

5. Run the following command in the root folder of the project (in a different terminal window) to ensure you have everything set up.

```
mvn clean test
```

**Note:** If you are running Docker Toolbox (Windows), run the command
```
mvn clean test -Dbase.uri=http://192.168.99.100:3000
```

Expected result is a successful build (partial log listed below as an example):
```
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running it.ding.contact.exercise1.LoginTest

(...)

[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.046 s - in it.ding.contact.exercise1.LoginTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
(...)
```
