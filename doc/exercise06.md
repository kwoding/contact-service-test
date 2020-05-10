# Exercise 6: Create reusable REST client

## Description
1. Create a contact REST client (take a look at the already created `LoginRestClient`)

2. This should contain a method called: `createContact(Map<String, String> contact)`

3. This method should take the `Map` as request body and only perform the POST operation on: `/api/contacts`

4. Use the `LoginRestClient` and this newly created `ContactRestClient` in a new test to create a contact.

5. Assert: status code (201) by using `.then()` in the test
