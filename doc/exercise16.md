# Exercise 16: Update contact error scenarios

## Description
1. Create a contact

2. Update this contact with an invalid e-mail address

3. Assert status code (400)

4. Assert the error response body by:
.extract().as(ErrorResponseBody.class)

5. Retrieve the contact by using `getContact(contactId)`
   
6. Assert the response body with the original contact object used in step 1.
