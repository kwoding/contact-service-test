package it.ding.contact.model;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountrySubDivision() {
        return countrySubDivision;
    }

    public void setCountrySubDivision(String countrySubDivision) {
        this.countrySubDivision = countrySubDivision;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Contact withId(Long id) {
        this.id = id;
        return this;
    }

    public Contact withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Contact withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Contact withEmail(String email) {
        this.email = email;
        return this;
    }

    public Contact withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Contact withAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    public Contact withAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    public Contact withZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public Contact withCity(String city) {
        this.city = city;
        return this;
    }

    public Contact withCountrySubDivision(String countrySubDivision) {
        this.countrySubDivision = countrySubDivision;
        return this;
    }

    public Contact withCountry(String country) {
        this.country = country;
        return this;
    }
}
