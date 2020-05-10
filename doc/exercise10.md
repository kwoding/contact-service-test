# Exercise 10: Use DTOs for assertions

## Description
1. Create a contact

2. Assert status code (201)

3. Retrieve this single contact

4. Assert the response body with the same contact object that has been POSTed by:
.extract().as(Contact.class)
