package com.example.LibrarySimpleApp.Resources;
import com.example.LibrarySimpleApp.dto.User;
import java.util.List;

import com.example.LibrarySimpleApp.dto.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
public class UserResource {
    @Autowired
    private UserRepository repository;

    //Find
    @GetMapping("/users")
    List<User> findAll(){
        return repository.findAll();
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    User newBook(@RequestBody User newUser){
        return repository.save(newUser);
    }



}
