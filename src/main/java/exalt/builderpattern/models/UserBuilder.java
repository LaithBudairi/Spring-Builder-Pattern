package exalt.builderpattern.models;

public class UserBuilder extends PersonBuilder {

    @Override
    public User createUser(String id, String name, String email, String city, String street, String postCode) {
        this.user = new User();
        buildId(id);
        buildName(name);
        buildEmail(email);
        buildAddress(new User.Address(city, street, email));
        return this.user;
    }

    @Override
    public void buildId(String id) {
        user.setId(id);
    }

    @Override
    public void buildName(String name) {
        user.setName(name);
    }

    @Override
    public void buildEmail(String email) {
        user.setEmail(email);
    }

    @Override
    public void buildAddress(User.Address address) {
        user.setAddress(address);
    }
}
