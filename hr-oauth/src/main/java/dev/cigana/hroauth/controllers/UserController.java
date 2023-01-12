package dev.cigana.hroauth.controllers;

import dev.cigana.hroauth.domain.User;
import dev.cigana.hroauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<User> findByEmail(@RequestParam String email){
        User user = userService.findByEmail(email);
        return ResponseEntity.ok(user);
    }

}
