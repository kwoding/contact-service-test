# Exercise 1: Create operation

## Model
- This is an example of a request body to create a Contact.
- The response body when retrieving a Contact is similar with the addition of an `id` field.

```
{
    "lastName": "Bond",
    "firstName": "James",
    "email": "james@bond.com",
    "phone": "02011111007",
    "addressLine1": "30 Wellington Square",
    "addressLine2": "Chelsea",
    "zipCode": "SW3 4NR”,
    "city": “London",
    "countrySubDivision": "England",
    "country": “United Kingdom”
}
```

## Description exercise

1. Create contacts by POSTing contacts using the already-created `ContactRestClient` in this project for:

- Contact with mandatory fields filled
- Contact with all fields filled
- Contact with some missing mandatory fields
- Contact with all fields filled but invalid e-mail address

2. Assert the status response code for each test
