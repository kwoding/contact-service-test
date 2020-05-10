# Exercise 4: Assert response body

## Description
1. Extract id in response body (when contact created) by using: `.extract().jsonPath().getLong(“id”)`

2. Retrieve a single contact by id (from step 1) by performing a GET on `/api/contact/{contactId}`

3. Assert: status code (200)

4. Assert response body by using: `.body(“firstName”, isEqualTo(“James”))`

5. Assert response body by using: `.extract().jsonPath().getString(“firstName”)`
