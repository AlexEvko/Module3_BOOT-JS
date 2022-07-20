package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class RestCRUDController {

//    private final UserService userService;
//    private final RoleService roleService;
//
//    @Autowired
//    public RestCRUDController(UserService userService, RoleService roleService) {
//        this.userService = userService;
//        this.roleService = roleService;
//    }
//    @GetMapping("/allUsers")
//    public ResponseEntity<List<User>> getAllUsers() {
//        List<User> users = userService.findAll();
//        return new ResponseEntity<>(users, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable long id) {
//        User user = userService.findById(id);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//    @GetMapping("/authorities")
//    public ResponseEntity<List<Role>> getAllRoles() {
//        List<Role> roles = roleService.findAll();
//        return new ResponseEntity<>(roles, HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<User> addNewUser(@RequestBody User user) {
//        userService.save(user);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//    @PutMapping
//    public ResponseEntity<User> updateUser(@RequestBody User user) {
//        userService.update(user);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<User> deleteUser(@PathVariable long id) {
//        userService.deleteById(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
    private final UserService userService;
    private final RoleService roleService;

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

    @PostMapping
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}