package com.labredis.controller;

import com.labredis.model.User;
import com.labredis.model.UserRequest;
import com.labredis.usecase.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        log.info("Controller that return all users!");
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {
        log.info("Controller that return an user!");
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody UserRequest request) {
        log.info("Controller that save an user!");
        return new ResponseEntity<>(userService.save(request), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@PathVariable Long id,
                                       @RequestBody UserRequest request) {
        log.info("Controller that save an user!");
        return new ResponseEntity<>(userService.update(id, request), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        log.info("Controller that delete an user!");
        return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);
    }
}
