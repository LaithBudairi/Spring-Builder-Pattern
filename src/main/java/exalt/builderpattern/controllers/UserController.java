package exalt.builderpattern.controllers;

import exalt.builderpattern.models.User;
import exalt.builderpattern.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value="/users")
@RestController
public class UserController {

    private UserRepo user;

    @Autowired
    public void setUser(UserRepo user) {
        this.user = user;
    }

    @GetMapping(value = "/")
    public List<User> getAllUsers() {
        return user.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable String id) {
        return user.getUser(id);
    }

    @PostMapping("/adduser")
    public void addUser(@RequestBody User.UserBuilder u) {
        user.addUser(u.build());
    }

    @PutMapping("/{id}")
    public void updateUser(@RequestBody User.UserBuilder u, @PathVariable String id) {
        user.updateUser(u, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        user.deleteUser(id);
    }
}
