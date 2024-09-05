package com.vivek.springBootApplication.controller;

import com.vivek.springBootApplication.entity.UserEntry;
import com.vivek.springBootApplication.service.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserEntryController {

    @Autowired
    private UserEntryService userEntryService;

    @GetMapping
    private List<UserEntry> getAllUser(){
        return userEntryService.getAll();
    }

    @PostMapping
    public void createUser(@RequestBody UserEntry userEntry){
        userEntryService.saveEntry(userEntry);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UserEntry userEntry){
        UserEntry userInDB =  userEntryService.findByUserName(userEntry.getUsername());
        if (userInDB != null){
            userInDB.setUsername(userEntry.getUsername());
            userInDB.setPassword(userEntry.getPassword());
            userEntryService.saveEntry(userInDB);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
