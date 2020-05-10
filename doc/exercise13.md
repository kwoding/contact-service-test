# Exercise 13: Assert list of contacts

## Description
1. Extend the `ContactRestClient` by adding a new method: `getContacts()`

2. Create a list of contact objects and POST each

3. Retrieve all contacts with this new method

4. Assert status code (200)

5. Assert response body by using:
`.extract().as(ContactListGetResponseBody.class)`
and sorting both the response body by id and the list from step 2

Tip: the contact id is in the response body when creating a contact
