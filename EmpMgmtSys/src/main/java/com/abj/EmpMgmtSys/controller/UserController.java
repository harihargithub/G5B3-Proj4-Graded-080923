package com.abj.EmpMgmtSys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.abj.EmpMgmtSys.model.User;
import com.abj.EmpMgmtSys.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users/list-users";
    }

    @GetMapping("/form")
    public String showUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "users/user-form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        // Handle saving user here
        userService.saveUser(user);
        return "redirect:/users/list";
    }

    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable("id") Long id, Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "users/user-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/users/list";
    }
    
    // Other user-related controller methods
}

