package com.vivek.springBootApplication.controller;

import com.vivek.springBootApplication.entity.UserEntry;
import com.vivek.springBootApplication.service.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
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

    @PutMapping("/{userName}")
    public ResponseEntity<?> updateUser(@RequestBody UserEntry userEntry,@PathVariable String userName){
        UserEntry userInDB =  userEntryService.findByUserName(userName);
        if (userInDB != null){
            userInDB.setUserName(userEntry.getUserName());
            userInDB.setPassword(userEntry.getPassword());
            userEntryService.saveEntry(userInDB);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
