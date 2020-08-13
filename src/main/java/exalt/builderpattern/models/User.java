package exalt.builderpattern.models;

public class User {

    private String id;
    private String name;
    private String email;
    private Address address;

    private static class Address {
        private String city;
        private String street;
        private String postCode;

        private Address(String city, String street, String postCode) {
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

    public static class UserBuilder {
        private String id;
        private String name;
        private String email;
        private Address address;

        public UserBuilder(String id, String name, String email, String city, String street, String postCode) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.address = new Address(city, street, postCode);
        }

        public UserBuilder setId(String id){
            this.id = id;
            return UserBuilder.this;
        }

        public UserBuilder setName(String name){
            this.name = name;
            return UserBuilder.this;
        }

        public UserBuilder setEmail(String email){
            this.email = email;
            return UserBuilder.this;
        }

        public UserBuilder setAddress(Address address){
            this.address = address;
            return UserBuilder.this;
        }

        public User build() {
            return new User(this);
        }

    }

    private User(UserBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.address = builder.address;
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

    public void doSomething() {
        // do something
    }

}
