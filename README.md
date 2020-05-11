# contact-service-test

This is an example test project for the [contact-service](https://hub.docker.com/r/kwoding/contact-service)

## Usage

1. Start the `contact-service` by:

```
docker run -p 8080:8080 kwoding/contact-service:latest
```

2. Run each test from your IDE or run `mvn clean test` to run the complete test suite.

## Explore front-end app

- To explore how the REST API `contact-service` is being used in practice, the front-end application can also be started.
- The front-end application that utilizes the `contact-service` can be started as follows.

1. Start both front-end and back-end applications:
```
docker-compose up
```
2. Navigate to `http://localhost:3000` in a browser.
