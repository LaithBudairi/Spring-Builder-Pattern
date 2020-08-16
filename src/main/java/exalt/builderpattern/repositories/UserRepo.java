package exalt.builderpattern.repositories;

import exalt.builderpattern.models.PersonBuilder;
import exalt.builderpattern.models.User;
import exalt.builderpattern.models.UserBuilder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Repository
public class UserRepo {


    private List<User> users = new ArrayList<>(Arrays.asList(
            new UserBuilder().createUser("1", "Ahmad", "test001@test.com", "masyoon", "Baladiya", "0001"),
            new UserBuilder().createUser("2", "Ali", "test002@test.com", "ramallah", "Baladiya", "0002"),
            new UserBuilder().createUser("3", "Saeed", "test003@test.com", "ramallah", "Irsal", "0003"),
            new UserBuilder().createUser("4", "Oday", "test004@test.com", "ramallah", "Nablus", "0004"),
            new UserBuilder().createUser("5", "Saleh", "test005@test.com", "ramallah", "Haifa", "0005"),
            new UserBuilder().createUser("6", "Abed", "test006@test.com", "ramallah", "Oxford", "0006"),
            new UserBuilder().createUser("7", "Sama", "test007@test.com", "ramallah", "Baladiya", "0007"),
            new UserBuilder().createUser("8", "Randa", "test008@test.com", "ramallah", "Oxford", "0008"),
            new UserBuilder().createUser("9", "Farah", "test009@test.com", "ramallah", "Irsal", "0009"),
            new UserBuilder().createUser("10", "Daoud", "test010@test.com", "ramallah", "Baladiya", "0010"),
            new UserBuilder().createUser("11", "Momen", "test011@test.com", "ramallah", "Oxford", "0011"),
            new UserBuilder().createUser("12", "Afnan", "test012@test.com", "ramallah", "Baladiya", "0012"),
            new UserBuilder().createUser("13", "Malak", "test013@test.com", "ramallah", "Irsal", "0013"),
            new UserBuilder().createUser("14", "Fatemah", "test014@test.com", "ramallah", "Oxford", "0014"),
            new UserBuilder().createUser("15", "Wisam", "test015@test.com", "ramallah", "Baladiya", "0015"),
            new UserBuilder().createUser("16", "Mahdi", "test016@test.com", "ramallah", "Irsal", "0016"),
            new UserBuilder().createUser("17", "Ibrahim", "test017@test.com", "ramallah", "Nablus", "0017"),
            new UserBuilder().createUser("18", "Mahmoud", "test018@test.com", "ramallah", "Oxford", "0018"),
            new UserBuilder().createUser("19", "Montasir", "test019@test.com", "ramallah", "Baladiya", "0019"),
            new UserBuilder().createUser("20", "Adam", "test020@test.com", "ramallah", "Irsal", "0020")
            ));

    public List<User> getAllUsers() {
        return users;
    }

    public void addUser(User u) {
        users.add(u);
    }

    public User getUser(String id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst().get();
    }

    public Stream<User> getNUsers(int size, int page) {
        if(page <= 0)
            page = 1;
        int offset = (page - 1) * size;

        return users.stream().skip(offset).limit(size);
    }


    public void updateUser(User u, String id) {
        for(int i = 0; i < users.size(); i++) {
            User currentUser = users.get(i);
            if(currentUser.getId().equals(id)) {
                users.set(i, u);
                return;
            }
        }
    }

    public void deleteUser(String id) {
        users.removeIf(currentUser -> currentUser.getId().equals(id));
    }
}
