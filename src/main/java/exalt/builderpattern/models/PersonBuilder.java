package exalt.builderpattern.models;

public abstract class PersonBuilder {
    protected User user;

    public User getUser() {
        return this.user;
    }

    public abstract User createUser(String id, String name, String email, String city, String street, String postCode);

    public abstract void buildId(String id);
    public abstract void buildName(String name);
    public abstract void buildEmail(String email);
    public abstract void buildAddress(User.Address address);

}
