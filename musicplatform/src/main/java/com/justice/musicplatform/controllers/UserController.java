package com.justice.musicplatform.controllers;

import com.justice.musicplatform.models.User;
import com.justice.musicplatform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller to handle user-related requests.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUsers(Model model) {
        // Fetches all users from the service layer
        List<User> users = userService.getAllUsers();
        // Adds the list of users to the model so they can be displayed in users.html
        model.addAttribute("users", users);
        // Returns the "users" template (users.html) to be rendered
        return "users";
    }

    @PostMapping
    public String createUser(@RequestParam String username, @RequestParam String email) {
        // Creates a new user using the provided username and email
        userService.createUser(username, email);
        return "redirect:/users";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
