package exalt.builderpattern.repositories;

import exalt.builderpattern.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepo {
    private List<User> users = new ArrayList<>(Arrays.asList(
            new User.UserBuilder("1", "Ahmad", "test001@test.com", "Ramallah", "Oxford", "0001").build(),
            new User.UserBuilder("2", "Ali", "test002@test.com", "ramallah", "Baladiya", "0002").build(),
            new User.UserBuilder("3", "Saeed", "test003@test.com", "ramallah", "Irsal", "0003").build(),
            new User.UserBuilder("4", "Oday", "test004@test.com", "ramallah", "Nablus", "0004").build(),
            new User.UserBuilder("5", "Saleh", "test005@test.com", "ramallah", "Haifa", "0005").build(),
            new User.UserBuilder("6", "Abed", "test006@test.com", "ramallah", "Oxford", "0006").build(),
            new User.UserBuilder("7", "Sama", "test007@test.com", "ramallah", "Baladiya", "0007").build(),
            new User.UserBuilder("8", "Randa", "test008@test.com", "ramallah", "Oxford", "0008").build(),
            new User.UserBuilder("9", "Farah", "test009@test.com", "ramallah", "Irsal", "0009").build(),
            new User.UserBuilder("10", "Daoud", "test010@test.com", "ramallah", "Baladiya", "0010").build(),
            new User.UserBuilder("11", "Momen", "test011@test.com", "ramallah", "Oxford", "0011").build(),
            new User.UserBuilder("12", "Afnan", "test012@test.com", "ramallah", "Baladiya", "0012").build(),
            new User.UserBuilder("13", "Malak", "test013@test.com", "ramallah", "Irsal", "0013").build(),
            new User.UserBuilder("14", "Fatemah", "test014@test.com", "ramallah", "Oxford", "0014").build(),
            new User.UserBuilder("15", "Wisam", "test015@test.com", "ramallah", "Baladiya", "0015").build(),
            new User.UserBuilder("16", "Mahdi", "test016@test.com", "ramallah", "Irsal", "0016").build(),
            new User.UserBuilder("17", "Ibrahim", "test017@test.com", "ramallah", "Nablus", "0017").build(),
            new User.UserBuilder("18", "Mahmoud", "test018@test.com", "ramallah", "Oxford", "0018").build(),
            new User.UserBuilder("19", "Montasir", "test019@test.com", "ramallah", "Baladiya", "0019").build(),
            new User.UserBuilder("20", "Adam", "test020@test.com", "ramallah", "Irsal", "0020").build()
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

    public void updateUser(User.UserBuilder u, String id) {
        for(int i = 0; i < users.size(); i++) {
            User currentUser = users.get(i);
            if(currentUser.getId().equals(id)) {
                users.set(i, u.build());
                return;
            }
        }
    }

    public void deleteUser(String id) {
        users.removeIf(currentUser -> currentUser.getId().equals(id));
    }
}
