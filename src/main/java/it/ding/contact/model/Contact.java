package it.ding.contact.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

    private Long id;

    private String lastName;

    private String firstName;

    private String email;

    private String phone;

    private String addressLine1;

    private String addressLine2;

    private String zipCode;

    private String city;

    private String countrySubDivision;

    private String country;

}
