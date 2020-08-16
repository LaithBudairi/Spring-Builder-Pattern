package exalt.builderpattern.models;

public class User {

    private String id;
    private String name;
    private String email;
    private Address address;

    static class Address {
        private String city;
        private String street;
        private String postCode;

        Address(String city, String street, String postCode) {
            this.city = city;
            this.street = street;
            this.postCode = postCode;
        }

        public String getCity() {
            return city;
        }

        public String getStreet() {
            return street;
        }

        public String getPostCode() {
            return postCode;
        }
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }
}
