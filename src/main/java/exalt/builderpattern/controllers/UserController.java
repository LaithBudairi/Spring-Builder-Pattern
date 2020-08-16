package exalt.builderpattern.controllers;

import exalt.builderpattern.models.PersonBuilder;
import exalt.builderpattern.models.User;
import exalt.builderpattern.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

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

    @GetMapping(value = "")
    public Stream<User> getNUsers(@RequestParam("size") int size, @RequestParam("page") int page) {
        return user.getNUsers(size, page);
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable String id) {
        return user.getUser(id);
    }

    @PostMapping("/adduser")
    public void addUser(@RequestBody User u) {
        user.addUser(u);
    }

    @PutMapping("/{id}")
    public void updateUser(@RequestBody User u, @PathVariable String id) {
        user.updateUser(u, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        user.deleteUser(id);
    }
}
