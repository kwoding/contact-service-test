# Exercise 11: Create contact error scenarios

## Description
1. Create a contact without a `phoneNumber`

2. Assert status code (400)

3. Assert the error response body by:
`.extract().as(ErrorResponseBody.class)`
