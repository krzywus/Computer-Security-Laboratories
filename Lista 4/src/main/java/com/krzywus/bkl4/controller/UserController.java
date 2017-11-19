package com.krzywus.bkl4.controller;

import com.krzywus.bkl4.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor(onConstructor = @_(@Autowired))
@RequestMapping("login")
public class UserController {

    UserService userService;

    @PostMapping(path = "/register", produces = "application/json")
    public boolean registerNewUserAccount(@RequestParam String username,
                                          @RequestParam String password){
        return this.userService.registerNewUserAccount(username, password);
    }


    @PostMapping(produces = "application/json")
    public boolean login(@RequestParam String username,
                         @RequestParam String password){
        return this.userService.login(username, password);
    }
}
