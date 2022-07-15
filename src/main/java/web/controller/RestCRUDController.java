package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class RestCRUDController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public RestCRUDController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/authorities")
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

//    @GetMapping("/new")
//    public String newUser(Model model) {
//        model.addAttribute("user", new User());
//        model.addAttribute("roles", roleService.findAll());
//        return "new";
//    }

//    @PostMapping("/add-user")
//    public String addUser(@ModelAttribute User user, @RequestParam(value = "checkBoxRoles") String[] checkBoxRoles) {
//        Set<Role> roleSet = new HashSet<>();
//        for (String role : checkBoxRoles) {
//            roleSet.add(roleService.findByName(role));
//        }
//        user.setRoles(roleSet);
//        userService.save(user);
//        return "redirect:/admin";
//    }
    @PostMapping
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//    @PostMapping("/edit/{id}")
//    public String editUser(@ModelAttribute User user, @RequestParam(value = "checkBoxRoles") String[] checkBoxRoles) {
//        Set<Role> roleSet = new HashSet<>();
//        for (String roles : checkBoxRoles) {
//            roleSet.add(roleService.findByName(roles));
//        }
//        user.setRoles(roleSet);
//        userService.update(user);
//        return "redirect:/admin";
//    }
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userService.update(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//    @PostMapping("/{id}/delete")
//    public String removeUser(@PathVariable("id") long id) {
//        userService.deleteById(id);
//        return "redirect:/admin";
//    }
    //    готово кроме /
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}