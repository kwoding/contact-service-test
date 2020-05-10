# Exercise 8: Use DTOs for serialization

## Description
1 Extend the `ContactRestClient` by adding a new method: `createContact(Contact contact)`
Note: this Contact is the new `Contact` DTO

2. Use this new method to create a contact

3. Assert status code (201)

4. Extract the id from the response body by using: `.extract().as(ContactPostResponseBody.class)`
