package com.newproject.controller;

import com.newproject.dto.UserDto;
import com.newproject.entity.User;
import com.newproject.service.UserService;
import com.newproject.util.CustomPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
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
    public ResponseEntity<UserDto> createUser (@RequestBody UserDto user){
        UserDto resultUser =userService.createUser(user);
        return ResponseEntity.ok(resultUser);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getUsers (){
       List<UserDto> users= userService.getUsers();
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
   @GetMapping("/pagination")
   public ResponseEntity<Page<User>>  pagination(@RequestParam int currentPage,@RequestParam int pageSize){
    return ResponseEntity.ok(userService.pagination(currentPage,pageSize));
   }
    @GetMapping("/pagination/v1")
    public ResponseEntity<Page<User>>  pagination(Pageable pageable){
        return ResponseEntity.ok(userService.pagination(pageable));
    }

    @GetMapping("/pagination/v2")
    public ResponseEntity<Slice<User>>  slice(Pageable pageable){
        return ResponseEntity.ok(userService.slice(pageable));
    }
    @GetMapping("/pagination/v3")
    public ResponseEntity<CustomPage<UserDto>>  customPagination(Pageable pageable){
        return ResponseEntity.ok(userService.customPagination(pageable));
    }

}
