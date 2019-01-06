package it.ding.contact.util;

import static java.util.Comparator.comparing;

import com.github.javafaker.Faker;
import it.ding.contact.model.Contact;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactTestUtil {

    private static Faker faker = new Faker();

    public static Contact generateContactWithMandatoryFieldsFilled() {
        return Contact.builder()
            .lastName(faker.name().lastName())
            .firstName(faker.name().firstName())
            .email(faker.internet().emailAddress())
            .build();
    }

    public static Map<String, String> generateContactMapWithAllFieldsFilled() {
        Map<String, String> contactMap = new HashMap<>();

        contactMap.put("lastName", faker.name().lastName());
        contactMap.put("firstName", faker.name().firstName());
        contactMap.put("email", faker.internet().emailAddress());
        contactMap.put("phone", faker.phoneNumber().phoneNumber());
        contactMap.put("addressLine1", faker.address().streetAddress());
        contactMap.put("addressLine2", faker.address().streetAddress());
        contactMap.put("city", faker.address().city());
        contactMap.put("zipCode", faker.address().zipCode());
        contactMap.put("countrySubDivision", faker.address().state());
        contactMap.put("country", faker.address().country());

        return contactMap;
    }

    public static Contact generateContactWithAllFieldsFilled() {
        return Contact.builder()
            .lastName(faker.name().lastName())
            .firstName(faker.name().firstName())
            .email(faker.internet().emailAddress())
            .phone(faker.phoneNumber().phoneNumber())
            .addressLine1(faker.address().streetAddress())
            .addressLine2(faker.address().streetAddress())
            .city(faker.address().city())
            .zipCode(faker.address().zipCode())
            .countrySubDivision(faker.address().state())
            .country(faker.address().country())
            .build();
    }

    public static void sortContactsById(List<Contact> contactList) {
        contactList.sort(comparing(Contact::getId));
    }

}
