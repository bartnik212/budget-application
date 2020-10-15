package com.jakub.bartnik.budgetapplication.controller;

import com.jakub.bartnik.budgetapplication.model.User;
import com.jakub.bartnik.budgetapplication.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add")
    public String getForm(Model model){
        model.addAttribute("newUser", new User());
        return "user_form";
    }
}
