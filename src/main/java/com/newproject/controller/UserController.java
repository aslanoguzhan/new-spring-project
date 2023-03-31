package com.newproject.controller;

import com.newproject.entity.User;
import com.newproject.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/create")
    public ResponseEntity<User> createUser (@RequestBody User user){
        User resultUser =userService.createUser(user);
        return ResponseEntity.ok(resultUser);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getUsers (){
       List<User> users= userService.getUsers();
       return ResponseEntity.ok(users);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id){
        User user=userService.getUser(id);
        return ResponseEntity.ok(user);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id ,@RequestBody User user){
       User resultUser= userService.updateUser(id,user);
       return  ResponseEntity.ok(resultUser);
    }
   @DeleteMapping("/remove/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id){
        Boolean status=userService.deleteUser(id);
        return  ResponseEntity.ok(status);
   }

}
