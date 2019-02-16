package it.ding.contact.util;

import com.github.javafaker.Faker;
import java.util.HashMap;
import java.util.Map;

public class ContactTestUtil {

    private static Faker faker = new Faker();

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

}
