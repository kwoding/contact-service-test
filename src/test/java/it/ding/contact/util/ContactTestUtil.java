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
        return new Contact()
            .withLastName(faker.name().lastName())
            .withFirstName(faker.name().firstName())
            .withEmail(faker.internet().emailAddress());
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
        return new Contact()
            .withLastName(faker.name().lastName())
            .withFirstName(faker.name().firstName())
            .withEmail(faker.internet().emailAddress())
            .withPhone(faker.phoneNumber().phoneNumber())
            .withAddressLine1(faker.address().streetAddress())
            .withAddressLine2(faker.address().streetAddress())
            .withCity(faker.address().city())
            .withZipCode(faker.address().zipCode())
            .withCountrySubDivision(faker.address().state())
            .withCountry(faker.address().country());
    }

}
