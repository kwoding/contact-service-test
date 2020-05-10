# Exercise 15: Assert updated contact

## Description
1. Create a contact

2. Update this contact with different values

3. Assert status code (204)

4. Retrieve this single contact

5. Assert the response body with the same contact object that has been PUT by:
`.extract().as(Contact.class)`
