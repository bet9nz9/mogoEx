package Mongo.mongoEx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usr")
public class UserController {

    private final UserRepo userRepo;

    @Autowired
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @GetMapping
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @GetMapping("/one")
    public User getOne(@RequestParam("id") Long id) {
        return userRepo.findById(id).get();
    }

    @PostMapping
    public User create(@RequestParam("name") String name, @RequestParam("username") String userName,
                       @RequestParam("pass") String pass) {
        User user = new User(name, userName, pass);
        userRepo.save(user);
        return user;
    }

    @DeleteMapping
    public void delete(@RequestParam("id") Long id) {
        userRepo.delete(getOne(id));
    }

    @PutMapping
    public void update(@RequestParam("name") String name, @RequestParam("username") String userName,
                       @RequestParam("pass") String pass, @RequestParam("id") Long id) {
        User user = userRepo.findById(id).get();
        user.setName(name);
        user.setUsername(userName);
        user.setPassword(pass);
        userRepo.save(user);
    }

}
